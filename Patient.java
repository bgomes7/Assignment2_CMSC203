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

public class Patient
{
    private String firstName;
    private String middleName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String phone;
    private String emergencyName;
    private String emergencyPhone;
 
    /**
     * No-arg constructor. Every field starts as an empty string so the
     * build methods never print "null".
     */
    public Patient()
    {
        this("", "", "", "", "", "", "", "", "", "");
    }
 
    /**
     * Creates a patient with only a name. All other fields start empty.
     *
     * @param firstName  the first name
     * @param middleName the middle name
     * @param lastName   the last name
     */
    public Patient(String firstName, String middleName, String lastName)
    {
        this(firstName, middleName, lastName, "", "", "", "", "", "", "");
    }
 
    /**
     * Creates a patient with every attribute supplied.
     *
     * @param firstName      the first name
     * @param middleName     the middle name
     * @param lastName       the last name
     * @param street         the street address
     * @param city           the city
     * @param state          the state
     * @param zipcode        the ZIP code
     * @param phone          the phone number, expected as ###-###-####
     * @param emergencyName  the emergency contact's name
     * @param emergencyPhone the emergency contact's phone, ###-###-####
     */
    public Patient(String firstName, String middleName, String lastName,
                   String street, String city, String state, String zipcode,
                   String phone, String emergencyName, String emergencyPhone)
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
        this.emergencyName = emergencyName;
        this.emergencyPhone = emergencyPhone;
    }
 
    // Accessors and mutators
 
    /** @return the first name */
    public String getFirstName() { return firstName; }
 
    /** @param firstName the new first name */
    public void setFirstName(String firstName) { this.firstName = firstName; }
 
    /** @return the middle name */
    public String getMiddleName() { return middleName; }
 
    /** @param middleName the new middle name */
    public void setMiddleName(String middleName) { this.middleName = middleName; }
 
    /** @return the last name */
    public String getLastName() { return lastName; }
 
    /** @param lastName the new last name */
    public void setLastName(String lastName) { this.lastName = lastName; }
 
    /** @return the street address */
    public String getStreet() { return street; }
 
    /** @param street the new street address */
    public void setStreet(String street) { this.street = street; }
 
    /** @return the city */
    public String getCity() { return city; }
 
    /** @param city the new city */
    public void setCity(String city) { this.city = city; }
 
    /** @return the state */
    public String getState() { return state; }
 
    /** @param state the new state */
    public void setState(String state) { this.state = state; }
 
    /** @return the ZIP code */
    public String getZipcode() { return zipcode; }
 
    /** @param zipcode the new ZIP code */
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }
 
    /** @return the phone number */
    public String getPhone() { return phone; }
 
    /** @param phone the new phone number */
    public void setPhone(String phone) { this.phone = phone; }
 
    /** @return the emergency contact's name */
    public String getEmergencyName() { return emergencyName; }
 
    /** @param emergencyName the new emergency contact name */
    public void setEmergencyName(String emergencyName) { this.emergencyName = emergencyName; }
 
    /** @return the emergency contact's phone number */
    public String getEmergencyPhone() { return emergencyPhone; }
 
    /** @param emergencyPhone the new emergency contact phone number */
    public void setEmergencyPhone(String emergencyPhone) { this.emergencyPhone = emergencyPhone; }
 
    // Build methods
 
    /**
     * Joins the name parts into "First Middle Last". If the middle name is
     * empty, it is skipped so there is no double space.
     *
     * @return the full name
     */
    public String buildFullName()
    {
        if (middleName == null || middleName.trim().isEmpty())
        {
            return firstName + " " + lastName;
        }
        return firstName + " " + middleName + " " + lastName;
    }
 
    /**
     * Joins the address parts into "Street City State ZIP".
     *
     * @return the full address on one line
     */
    public String buildAddress()
    {
        return street + ", " + city + ", " + state + " " + zipcode;
    }
 
    /**
     * Joins the emergency contact into "EmergencyName EmergencyPhone".
     *
     * @return the emergency contact on one line
     */
    public String buildEmergencyContact()
    {
        return emergencyName + " " + emergencyPhone;
    }
 
    /**
     * Builds a multi line description of the patient using the three
     * build methods.
     *
     * @return the patient information as text
     */
    @Override
    public String toString()
    {
        return "Name: " + buildFullName() + "\n"
             + "Address: " + buildAddress() + "\n"
             + "Phone Number: " + phone + "\n"
             + "Emergency Contact: " + buildEmergencyContact();
    }
 
    // Additional methods
 
    /**
     * Checks a phone number against the pattern ###-###-####
     *
     * @param number the text to check
     * @return true if the text matches the pattern
     */
    private static boolean matchesPhonePattern(String number)
    {
        return number != null && number.matches("\\d{3}-\\d{3}-\\d{4}");
    }
 
    /**
     * Checks whether the patient's phone number is in ###-###-#### format.
     *
     * @return true if the phone number is valid
     */
    public boolean isValidPhoneNumber()
    {
        return matchesPhonePattern(phone);
    }
 
    /**
     * Checks whether the emergency contact's phone number is in
     * ###-###-#### format.
     *
     * @return true if the emergency phone number is valid
     */
    public boolean isValidEmergencyPhoneNumber()
    {
        return matchesPhonePattern(emergencyPhone);
    }
 
    /**
     * Builds the name in "Last, First Middle" order.
     *
     * @return the name with the last name first
     */
    public String getLastFirstMiddle()
    {
        if (middleName == null || middleName.trim().isEmpty())
        {
            return lastName + ", " + firstName;
        }
        return lastName + ", " + firstName + " " + middleName;
    }
 
    /**
     * Compares the patient's city and state to the given values ignoring
     * upper and lower case.
     *
     * @param city  the city to compare
     * @param state the state to compare
     * @return true if both the city and state match
     */
    public boolean hasSameCityState(String city, String state)
    {
        return this.city.equalsIgnoreCase(city)
            && this.state.equalsIgnoreCase(state);
    }
 
    /**
     * Replaces the whole address in one call.
     *
     * @param street  the new street
     * @param city    the new city
     * @param state   the new state
     * @param zipcode the new ZIP code
     */
    public void updateAddress(String street, String city, String state,
                              String zipcode)
    {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
 
    /**
     * Builds a formatted summary of the patient and emergency contact.
     *
     * @return a multi-line contact summary
     */
    public String getContactSummary()
    {
        return "Patient: " + getLastFirstMiddle() + "\n"
             + "Phone: " + phone + "\n"
             + "Emergency Contact: " + emergencyName + "\n"
             + "Emergency Phone: " + emergencyPhone;
    }
}