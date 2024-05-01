public class BasePlusCommissionEmployee extends CommissionEmployee { 
   private double baseSalary; // base salary per week

   // 9 argument constructor
   public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, 
   int month, int day, int year, double grossSales, double commissionRate, double baseSalary) { 
      super(firstName, lastName, socialSecurityNumber, month, day, year, grossSales, commissionRate);

      if (baseSalary < 0.0) { // if baseSalary is invalid throw exception
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }
      this.baseSalary = baseSalary;                
   }

   public void setBaseSalary(double baseSalary) { // set baseSalary
      if (baseSalary < 0.0) { // validate baseSalary                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }
      this.baseSalary = baseSalary;                
   } 

   public double getBaseSalary() {return baseSalary;} // return base salary

   // calculate earnings; override method earnings in CommissionEmployee
   @Override                                                            
   public double earnings() {return getBaseSalary() + super.earnings();}

   // return String representation of BasePlusCommissionEmployee object
   @Override                                                           
   public String toString() {                                            
      return String.format("%s%s%n %s%.2f",                       
         "Base-Salary + ", super.toString(),                            
         "Base Salary: $", getBaseSalary());                             
   } 
}

