// Name: Connor Sterbenz
// Date: 4/30/24
// Class: CS 145 F-F 9:30 AM
// Assignment: Lab 4 Polymorphism
// Purpose: Demonstrates polymorphism with hard coded data using multiple classes to display different pay types and employee data. 
// Citation: Deitel / Deitel, W3Schools
// Note: I rewrote the given programs slightly as they were easier for me to understand this way. 

import java.util.Scanner;

public class CSLab_4 {
    public static void main(String[] args) { // create subclass objects
        CommissionEmployee commissionEmployee = new CommissionEmployee(
            "John", "Commission", "111-11-1111", 9, 8, 1954, 10000, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(
            "Bob", "Base", "222-22-2222", 3, 2, 1965, 5000, .04, 300);
        SalariedEmployee salariedEmployee = new SalariedEmployee(
            "Sally", "Salary", "333-33-3333", 6, 15, 1944, 800);
        HourlyEmployee hourlyEmployee = new HourlyEmployee(
            "Austin", "Hourly", "444-44-4444", 12, 9, 1960, 16.75, 40);

        System.out.println("Processed Individually:\n"); // title section 1

        System.out.printf("%s%n %s%.2f %n%n", 
            commissionEmployee, "Earned: $", commissionEmployee.earnings()); // display individual commissionEmployee earnings
        System.out.printf("%s%n %s%.2f %n%n", 
            basePlusCommissionEmployee, "Earned: $", basePlusCommissionEmployee.earnings()); // display individual basePlusCommissionEmployee earnings
        System.out.printf("%s%n %s%.2f %n%n", 
            salariedEmployee, "Earned: $", salariedEmployee.earnings()); // display individual salariedEmployee earnings
        System.out.printf("%s%n %s%.2f %n%n",
            hourlyEmployee, "Earned: $", hourlyEmployee.earnings()); // display individual hourlyEmployee earnings

        Employee[] employees = new Employee[4]; // create four-element Employee array
        employees[0] = commissionEmployee; // initialize array with Employees
        employees[1] = basePlusCommissionEmployee;
        employees[2] = salariedEmployee; 
        employees[3] = hourlyEmployee;

        Scanner input = new Scanner(System.in); // to get current month
        int currentMonth;

        // get and validate current month
        do {
            System.out.print("Enter the current month (1 - 12): ");
            currentMonth = input.nextInt(); // prompt user
            System.out.println();
        } while ((currentMonth < 1) || (currentMonth > 12));
        input.close(); // close scanner object

        System.out.println("Processed Polymorphically:\n"); // title section 2

        for (Employee currentEmployee : employees) { // not completely sure how an enhanced for loop works, but it does!
            System.out.println(currentEmployee);
        
            // determine whether element is a BasePlusCommissionEmployee
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                // downcast Employee reference to BasePlusCommissionEmployee reference
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
                double oldBaseSalary = employee.getBaseSalary();
                employee.setBaseSalary(1.10 * oldBaseSalary);
                System.out.printf("%s%.2f%n", 
                " New Base Salary (with 10% increase) = $", employee.getBaseSalary());
            }

            // if month of employee's birthday, add $100 to salary
            if (currentMonth == currentEmployee.getBirthDate().getMonth()) {
                System.out.printf("%s%.2f %s %s %n%n", 
                " Earned $", currentEmployee.earnings(), "+", "$100.00 Birthday Bonus!");
            } else {
                System.out.printf("%s%.2f %n%n",
                " Earned: $", currentEmployee.earnings());
            }
        }

        // display which employee type/name is from which element in array
        for (int j = 0; j < employees.length; j++) {
            System.out.printf("%s %d %s %s%n",
            "Employee", j, "is a", employees[j].getClass().getName()); 
        }

    }    
}
