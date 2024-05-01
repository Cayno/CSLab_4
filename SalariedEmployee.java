public class SalariedEmployee extends Employee  {
   private double weeklySalary;

   // 7 argument constructor
   public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, 
   int month, int day, int year, double weeklySalary) {
      super(firstName, lastName, socialSecurityNumber, month, day, year); 

      if (weeklySalary < 0.0) {
         throw new IllegalArgumentException("Weekly salary must be >= 0.0");
      }
      this.weeklySalary = weeklySalary;
   } 

   // set salary
   public void setWeeklySalary(double weeklySalary) {
      if (weeklySalary < 0.0) {
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");
      }
      this.weeklySalary = weeklySalary;
   } 

   public double getWeeklySalary() {return weeklySalary;} // return salary 

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings() {return getWeeklySalary();}                                             

   // return String representation of SalariedEmployee object   
   @Override                                                    
   public String toString() {                                     
      return String.format("%s%s%n %s%.2f",                       
         "Salaried Employee: ", super.toString(),                            
         "Weekly Salary: $", getWeeklySalary());  
   } 
}
