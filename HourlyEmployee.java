public class HourlyEmployee extends Employee {
   private double wage; // wage per hour
   private double hours; // hours worked for week

   // 8 argument constructor
   public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, 
   int month, int day, int year, double wage, double hours) {
      super(firstName, lastName, socialSecurityNumber, month, day, year);

      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Hourly wage must be >= 0.0");
      }

      if ((hours < 0.0) || (hours > 168.0)) { // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");
      }
      this.wage = wage;
      this.hours = hours;
   } 

   // set wage
   public void setWage(double wage) {
      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException(
            "Hourly wage must be >= 0.0");
      }
      this.wage = wage;
   } 

   // set hours worked
   public void setHours(double hours) {
      if ((hours < 0.0) || (hours > 168.0)) { // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");
      }
      this.hours = hours;
   } 

   public double getWage() {return wage;} // return wage
   public double getHours() {return hours;} // return hours worked

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings() {                                            
      if (getHours() <= 40) { // no overtime                           
         return getWage() * getHours();   
      }
      else {                                                             
         return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
      }
   }                                          

   // return String representation of HourlyEmployee object              
   @Override                                                             
   public String toString() {                                              
      return String.format("%s%s%n %s%.2f%n %s%.2f",                       
         "Hourly Employee: ", super.toString(),                        
         "Hourly Wage: $", getWage(),
         "Hours Worked: ", getHours());                           
   }                                    
}
