
class Firm{
  
   public static void main (String[] args){
      Staff francis = new Staff();

      francis.payday();
   }
}



class Staff{
   StaffMember[] staffList;

   public Staff (){
      staffList = new StaffMember[8];

      staffList[0] = new Executive ("Priscilla Sarkodie", "Tafo", "020080056", "123-45-6789", 7742.18);

      staffList[1] = new Employee ("Karen Owusu", "Ahwiaa", "0548915487", "987-65-4321", 4547.11);
      
      staffList[2] = new Employee ("Esther Addo", "Pankrono", "0243345703", "010-20-3040", 1414.00);

      staffList[3] = new Hourly ("Benedicta Frimpong", "Mamponteng", "0240050000", "958-47-3625", 4787.74);

      staffList[4] = new Volunteer ("Jochebed Adjei", "Fawoade", "0246448846");
      
      staffList[5] = new Volunteer ("Riverson Graham", "Suame", "0245318196");
      
      staffList[6] = new Commission ("Junior Akuffo", "Batama", "0504635821", "023-32-3232", 6.25, 0.2);
      
      staffList[7] = new Commission ("Remix Opoku", "Kasoa", "0240887766", "076-23-4232", 9.75, 0.15);
      
      ((Executive)staffList[0]).awardBonus (800.00);
      
     
      ((Hourly)staffList[3]).addHours (40);
      ((Commission)staffList[6]).addHours (40);
      ((Commission)staffList[7]).addHours (35);
      ((Commission)staffList[6]).addSales (400);
      ((Commission)staffList[7]).addSales (950);

    
   }

 
   public void payday (){
      double amount;

      for (int x = 0; x < staffList.length; x++)
      {
         System.out.println (staffList[x]);

         amount = staffList[x].pay(); 

         if (amount == 0.0) {
            System.out.println ("Bravo!");
         }else {
            System.out.println ("Paid: " + amount);
            
            System.out.println ("**************************************************");
        }  
      }
   }
}


abstract class StaffMember{
   protected String name;
   protected String address;
   protected String phone;
 
   public StaffMember(String name, String address, String phone){
	super();
	this.name = name;
	this.address = address;
	this.phone = phone;
}
   
   public String toString(){
	   System.out.println ("**************************************************");
	  
	   return "\nName: " +name + "\nAddress: " + address+ "\nPhone: " +phone;
   }

   public abstract double pay();
}



class Volunteer extends StaffMember{
  
   public Volunteer (String Name, String Address, String Phone)
   {
      super (Name, Address, Phone);
   }

  
   public double pay(){
      return 0.0;
   }
}



class Employee extends StaffMember{
  protected String socialSecurityNumber;
  protected double payRate;
  
  public Employee(String name, String address, String phone, String socialSecurityNumber, double payRate){
		super(name, address, phone);
		this.socialSecurityNumber = socialSecurityNumber;
		this.payRate = payRate;
	}
  
  public String toString(){
	  return super.toString() + "\nSocial Security Number: " +socialSecurityNumber+ " \nPayrate: " + payRate;
  }

  public double pay(){
     return payRate;
  }
}



class Executive extends Employee{
   private double bonus;

   public Executive (String Name, String Address, String Phone,
                     String socialSecurityNumber, double payRate){
      super (Name, Address, Phone, socialSecurityNumber, payRate);
 
   }

   public void awardBonus (double execBonus){
      bonus = execBonus;
   }

   public double pay(){
  
      return  super.pay() + bonus;
   }
}



class Hourly extends Employee{
   private int hoursWorked;

   public Hourly (String Name, String Address, String Phone,
                  String socialSecurityNumber, double payRate){
      super (Name, Address, Phone, socialSecurityNumber, payRate);

   }

   public void addHours (int moreHours){
      hoursWorked += moreHours;
   }

   public double pay(){
     
      return payRate * hoursWorked;
   }

   public String toString(){
	   return super.toString() + "\nNumber of hours: " + hoursWorked;
   }
}


class Commission extends Hourly{
	 double totalSales;
	 double commissionRate;
 
	public Commission (String Name, String Address, String Phone,
            String socialSecurityNumber, double payRate, double commissionRate)
	{
		super(Name, Address, Phone, socialSecurityNumber, payRate);
		
		this.commissionRate = commissionRate;
		
}
	public double addSales (double totalSales){
		
		this.totalSales = totalSales;
		 return totalSales;
}
	
	public double pay(){
	 
		return  super.pay() +  (totalSales*commissionRate);
	}
	
	public String toString(){ 
		
		return super.toString() + "\nCommission rate: " + commissionRate;
	}
	
	
}

