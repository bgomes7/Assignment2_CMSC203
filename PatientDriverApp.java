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

import java.util.Scanner;
 
/**
 * Driver class for the Patient application
 *
 * @author Brian Gomes
 */
public class PatientDriverApp
{
    /**
     * Prompts for each patient field, reads the answers, and builds a
     * Patient with the all-attributes constructor.
     *
     * @param input the Scanner reading from the keyboard
     * @return the new Patient
     */
    public static Patient inputPatient(Scanner input)
    {
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter middle name: ");
        String middleName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter street address: ");
        String street = input.nextLine();
        System.out.print("Enter city: ");
        String city = input.nextLine();
        System.out.print("Enter state: ");
        String state = input.nextLine();
        System.out.print("Enter zip: ");
        String zipcode = input.nextLine();
        System.out.print("Enter phone number (###-###-####): ");
        String phone = input.nextLine();
        System.out.print("Enter emergency contact name: ");
        String emergencyName = input.nextLine();
        System.out.print("Enter emergency contact phone (###-###-####): ");
        String emergencyPhone = input.nextLine();
 
        return new Patient(firstName, middleName, lastName, street, city,
                           state, zipcode, phone, emergencyName,
                           emergencyPhone);
    }
 
    /**
     * Builds the first procedure with the no-arg constructor, then fills
     * in every attribute with the mutators.
     *
     * @return the first procedure
     */
    public static Procedure createProcedure1()
    {
        Procedure procedure = new Procedure();
        procedure.setProcName("Physical Exam");
        procedure.setProcDate("07/20/2026");
        procedure.setPracName("Dr. Irvine");
        procedure.setCharges(250.00);
        return procedure;
    }
 
    /**
     * Builds the second procedure with the name-and-date constructor, then
     * sets the practitioner and charge with the mutators.
     *
     * @return the second procedure
     */
    public static Procedure createProcedure2()
    {
        Procedure procedure = new Procedure("X-ray", "07/20/2026");
        procedure.setPracName("Dr. Jamison");
        procedure.setCharges(550.43);
        return procedure;
    }
 
    /**
     * Builds the third procedure with the all-attributes constructor.
     *
     * @return the third procedure
     */
    public static Procedure createProcedure3()
    {
        return new Procedure("Blood Test", "07/20/2026", "Dr. Smith", 1400.75);
    }
 
    /**
     * Prints the patient information block, including whether each phone
     * number is valid.
     *
     * @param patient the patient to display
     */
    public static void displayPatient(Patient patient)
    {
        System.out.println("Patient Information");
        System.out.println("-------------------");
        System.out.println(patient);
        System.out.println("Phone Valid: " + patient.isValidPhoneNumber());
        System.out.println("Emergency Phone Valid: "
                           + patient.isValidEmergencyPhoneNumber());
    }
 
    /**
     * Prints one procedure as a single aligned table row: name, date,
     * practitioner, formatted charge, and charge category.
     *
     * @param procedure the procedure to display
     */
    public static void displayProcedure(Procedure procedure)
    {
        System.out.printf("%-20s%-13s%-20s%-16s%s%n",
                          procedure.getProcName(),
                          procedure.getProcDate(),
                          procedure.getPracName(),
                          procedure.getFormattedCharge(),
                          procedure.getChargeCategory());
    }
 
    /**
     * Prints the three procedures in an aligned table with a header row.
     *
     * @param p1 the first procedure
     * @param p2 the second procedure
     * @param p3 the third procedure
     */
    public static void displayProcedureTable(Procedure p1, Procedure p2,
                                             Procedure p3)
    {
        System.out.printf("%-20s%-13s%-20s%-16s%s%n",
                          "Procedure", "Date", "Practitioner", "Charge",
                          "Category");
        System.out.println("------------------------------------------------"
                         + "------------------------");
        displayProcedure(p1);
        displayProcedure(p2);
        displayProcedure(p3);
    }
 
    /**
     * Adds up the charges of the three procedures.
     *
     * @param p1 the first procedure
     * @param p2 the second procedure
     * @param p3 the third procedure
     * @return the total of all three charges
     */
    public static double calculateTotalCharges(Procedure p1, Procedure p2,
                                               Procedure p3)
    {
        return p1.getCharges() + p2.getCharges() + p3.getCharges();
    }
 
    /**
     * Finds the average charge of the three procedures.
     *
     * @param p1 the first procedure
     * @param p2 the second procedure
     * @param p3 the third procedure
     * @return the average charge
     */
    public static double calculateAverageCharge(Procedure p1, Procedure p2,
                                                Procedure p3)
    {
        return calculateTotalCharges(p1, p2, p3) / 3.0;
    }
 
    /**
     * Finds the procedure with the largest charge. If there is a tie, the
     * earlier procedure is returned.
     *
     * @param p1 the first procedure
     * @param p2 the second procedure
     * @param p3 the third procedure
     * @return the procedure with the highest charge
     */
    public static Procedure findHighestChargeProcedure(Procedure p1,
                                                       Procedure p2,
                                                       Procedure p3)
    {
        Procedure highest = p1;
        if (p2.getCharges() > highest.getCharges())
        {
            highest = p2;
        }
        if (p3.getCharges() > highest.getCharges())
        {
            highest = p3;
        }
        return highest;
    }
 
    /**
     * Counts how many of the three procedures are expensive.
     *
     * @param p1 the first procedure
     * @param p2 the second procedure
     * @param p3 the third procedure
     * @return a count from 0 to 3
     */
    public static int countExpensiveProcedures(Procedure p1, Procedure p2,
                                               Procedure p3)
    {
        int count = 0;
        if (p1.isExpensiveProcedure())
        {
            count++;
        }
        if (p2.isExpensiveProcedure())
        {
            count++;
        }
        if (p3.isExpensiveProcedure())
        {
            count++;
        }
        return count;
    }
 
    /**
     * Prints the total, average, highest-charge procedure, and expensive
     * procedure count.
     *
     * @param p1 the first procedure
     * @param p2 the second procedure
     * @param p3 the third procedure
     */
    public static void displaySummary(Procedure p1, Procedure p2,
                                      Procedure p3)
    {
        double total = calculateTotalCharges(p1, p2, p3);
        double average = calculateAverageCharge(p1, p2, p3);
        Procedure highest = findHighestChargeProcedure(p1, p2, p3);
        int expensive = countExpensiveProcedures(p1, p2, p3);
 
        System.out.printf("Total Charges: $%,.2f%n", total);
        System.out.printf("Average Charge: $%,.2f%n", average);
        System.out.println("Highest Charge Procedure: "
                           + highest.getProcName());
        System.out.println("Number of Expensive Procedures: " + expensive);
    }
 
    /**
     * Runs the program: reads the patient, builds the procedures, prints
     * everything, and ends with the programmer credit line.
     *
     * @param args not used
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
 
        Patient patient = inputPatient(input);
        Procedure p1 = createProcedure1();
        Procedure p2 = createProcedure2();
        Procedure p3 = createProcedure3();
 
        System.out.println();
        displayPatient(patient);
        System.out.println();
        displayProcedureTable(p1, p2, p3);
        System.out.println();
        displaySummary(p1, p2, p3);
        System.out.println();
        System.out.println("The program was developed by a Student: "
                           + "Brian Gomes 09/28/26");
 
        input.close();
    }
}