/*
 * Class: CMSC203 CRN 23011
 * Instructor: Huseyin Aygun
 * Description: Patient Application 
 * Due: 09/28/2026
 * Platform/compiler: Windows 11, Eclipse IDE, Java JDK
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Brian Gomes
*/

public class Procedure {
	/** Charges at or above this amount count as expensive. */
    private static final double EXPENSIVE_LIMIT = 1000.00;
 
    /** Charges below this amount are in the "Low" category. */
    private static final double LOW_LIMIT = 500.00;
 
    private String procName;
    private String procDate;
    private String pracName;
    private double charges;
 
    /**
     * No-arg constructor
     */
    public Procedure()
    {
        this("", "", "", 0.0);
    }
 
    /**
     * Creates a procedure with a name and date. The practitioner is empty
     * and the charge is 0 until they are set.
     *
     * @param procName the procedure name
     * @param procDate the date: MM/DD/YYYY
     */
    public Procedure(String procName, String procDate)
    {
        this(procName, procDate, "", 0.0);
    }
 
    /**
     * Creates a procedure with every attribute supplied.
     *
     * @param procName the procedure name
     * @param procDate the date 
     * @param pracName the practitioner's name
     * @param charges  the charge in dollars
     */
    public Procedure(String procName, String procDate, String pracName,
                     double charges)
    {
        this.procName = procName;
        this.procDate = procDate;
        this.pracName = pracName;
        this.charges = charges;
    }
 
    // Accessors and mutators
 
    /** @return the procedure name */
    public String getProcName() { return procName; }
 
    /** @param procName the new procedure name */
    public void setProcName(String procName) { this.procName = procName; }
 
    /** @return the procedure date */
    public String getProcDate() { return procDate; }
 
    /** @param procDate the new procedure date */
    public void setProcDate(String procDate) { this.procDate = procDate; }
 
    /** @return the practitioner's name */
    public String getPracName() { return pracName; }
 
    /** @param pracName the new practitioner name */
    public void setPracName(String pracName) { this.pracName = pracName; }
 
    /** @return the charge in dollars */
    public double getCharges() { return charges; }
 
    /** @param charges the new charge in dollars */
    public void setCharges(double charges) { this.charges = charges; }
 
    // Additional methods
 
    /**
     * Builds a multi line description of the procedure.
     *
     * @return the procedure information as text
     */
    @Override
    public String toString()
    {
        return "Procedure: " + procName + "\n"
             + "Procedure Date: " + procDate + "\n"
             + "Practitioner: " + pracName + "\n"
             + "Charge: " + getFormattedCharge();
    }
 
    /**
     * Checks whether the charge is at least $1,000.00.
     *
     * @return true if the procedure is expensive
     */
    public boolean isExpensiveProcedure()
    {
        return charges >= EXPENSIVE_LIMIT;
    }
 
    /**
     * Lowers the charge by a percentage. Only values from 0 to 100 are
     * accepted. Anything else leaves the charge unchanged.
     *
     * @param percent the discount percentage, from 0 to 100
     */
    public void applyDiscount(double percent)
    {
        if (percent >= 0 && percent <= 100)
        {
            charges = charges - (charges * percent / 100.0);
        }
    }
 
    /**
     * Places the charge in a category: "Low" is under $500, "Medium" is
     * $500 up to (but not including) $1,000, and "High" is $1,000 or more.
     *
     * @return "Low", "Medium", or "High"
     */
    public String getChargeCategory()
    {
        if (charges < LOW_LIMIT)
        {
            return "Low";
        }
        else if (charges < EXPENSIVE_LIMIT)
        {
            return "Medium";
        }
        return "High";
    }
 
    /**
     * Checks whether a given practitioner performed this procedure,
     * ignoring upper and lower case.
     *
     * @param pracName the practitioner name to look for
     * @return true if the names match
     */
    public boolean isPerformedBy(String pracName)
    {
        return this.pracName.equalsIgnoreCase(pracName);
    }
 
    /**
     * Formats the charge with a dollar sign, commas, and two decimals ($0,000.00)
     *
     * @return the formatted charge
     */
    public String getFormattedCharge()
    {
        return String.format("$%,.2f", charges);
    }
}
