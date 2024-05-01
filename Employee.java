public abstract class Employee  { // abstract superclass
   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;
   private final Date birthDate;

   // 6 argument constructor
   public Employee(String firstName, String lastName, 
      String socialSecurityNumber, int month, int day, int year) {
      birthDate = new Date(month, day, year); // create object

      this.firstName = firstName;                                    
      this.lastName = lastName;                                    
      this.socialSecurityNumber = socialSecurityNumber;       
   } 

   // get methods
   public String getFirstName() {return firstName;} // return first name
   public String getLastName() {return lastName;} // return last name 
   public String getSocialSecurityNumber() {return socialSecurityNumber;} // return SSN
   public Date getBirthDate() {return birthDate;} // return birth date

   // return String representation of Employee object
   @Override
   public String toString() {
      return String.format("%s%s%s%n %s%s%n %s%s", 
         getFirstName(), " ", getLastName(), 
         "SSN: ", getSocialSecurityNumber(), 
         "Birth Date: ", getBirthDate());
   } 

   // abstract method must be overridden by concrete subclasses
   public abstract double earnings(); // no implementation here
} 
