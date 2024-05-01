public class CommissionEmployee extends Employee { // class that adds 2 attributes for employees that receive commission pay type
   private double grossSales; // gross weekly sales       
   private double commissionRate; // commission percentage

   // 8 argument constructor
   public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, 
   int month, int day, int year, double grossSales, double commissionRate) { 
       super(firstName, lastName, socialSecurityNumber, month, day, year); // carry over constructor from Employee superclass
       
       if (grossSales < 0.0) { // if grossSales is invalid throw exception
           throw new IllegalArgumentException("Gross sales must be >= 0.0");
       }

       if (commissionRate <= 0.0 || commissionRate >= 1.0) { // if commissionRate is invalid throw exception
           throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
       }
       this.grossSales = grossSales;
       this.commissionRate = commissionRate;
   }

   // set methods
   public void setGrossSales(double grossSales) { // set gross sales amount
       if (grossSales < 0.0) {
           throw new IllegalArgumentException("Gross sales must be >= 0.0");
       }
       this.grossSales = grossSales;
   } 
   
   public void setCommissionRate(double commissionRate) { // set commission rate
       if (commissionRate <= 0.0 || commissionRate >= 1.0) {
           throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
       }
       this.commissionRate = commissionRate;
   } 
   
   // get methods
   public double getGrossSales() {return grossSales;} // return gross sales amount
   public double getCommissionRate() {return commissionRate;} // return commission rate

   @Override
   public double earnings() {return getCommissionRate() * getGrossSales();} // calculate and return earnings                                     
                                           
   // return string representation of commission pay
   @Override  
   public String toString() {                  
      return String.format("%s%s%n %s%.2f%n %s%.2f",    
         "Commission Pay: ", super.toString(),              
         "Gross Sales: $", getGrossSales(),                       
         "Commission Rate: ", getCommissionRate());             
   } 
}