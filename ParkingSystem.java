import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class randomnumber {
    private final 
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVQXYZ";
private final 
        char [] RANDOM;

    public randomnumber() {
        this.RANDOM = (LETTERS +"0123456789").toCharArray();
    }
public String generateRandomAlphanumeric(int length)   
{
    StringBuilder result = new StringBuilder();
    for (int i=0 ; i<length;i++)
    {
        result.append(RANDOM[new Random().nextInt(RANDOM.length)]);
    }
    return result.toString();
}

}
public class ParkingSystem {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static void main(String[] args) {
        Scanner myinp = new Scanner (System.in);
        int ctr=1,choice,ch = 1,ch1,ch2,ch3,tph = 0,ph1=1,to = 0,tom;
        double tpf = 0;

        String [] random;
        random = new String[1000];
        randomnumber ran = new randomnumber();      
        random[ctr] = ran.generateRandomAlphanumeric(5);    
        
        String name [] = new String[500];
        String lname [] = new String[500];
        String pnum [] = new String[500];
        LocalDate [] localDate = new LocalDate[500];
        int type [] = new int [500];
        int wallet [] = new int [500];
        int hrs1 [] = new int [500];
        int hrs2 [] = new int [500];
        int min1 [] = new int [500];
        int min2 [] = new int [500];
        String ampm [] = new String[500];
        String ampm1 [] = new String[500];
        int park [] = new int [500];
        int ch4 [] = new int [500];

        
        do 
        {
            System.out.print("\n\t  ============================== Welcome to KALM Parking Lot ==============================");
            System.out.print("\n\n\t\t\t\t\t[1] Customer\t[2] Operator\n\t\t\t\t\t[3] Exit\n\n\t\t\t\t\t Choice : ");
            choice = myinp.nextInt();
            //Customer
            if (ch == 1)
            {
                do
                {
                    System.out.print("\n\t\t\t\t  ========== [ Customer ] =========="); 
                    System.out.print("\n\n\t\t\t\t\t[1] Register\t[2] Log - In\n\t\t\t\t\t[3] Back\n\n\t\t\t\t\t Choice : "); 
                    ch1 = myinp.nextInt();
                    //Register
                    if (ch1 == 1)
                    {
                       System.out.print("\n\t\t\t\t  ========== [ Register ] ==========");  
                       myinp.nextLine();
                       System.out.print("\n\n\t\t\t\t\t First Name : "); 
                       name [ctr]= myinp.nextLine();
                       System.out.print("\n\t\t\t\t\t Last Name : "); 
                       lname [ctr]= myinp.nextLine();                        
                       System.out.print("\n\t\t\t\t\t Date Of Registration : ");
                       localDate [ctr] = LocalDate.now();
                       System.out.print(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate[ctr]));
                       System.out.print("\n\t\t\t\t\t Plate Number : "); 
                       pnum [ctr] = myinp.nextLine();
                       //Vehicle Type
                       do
                       {
                           System.out.print("\n\t\t\t\t========== [ Vehicle Type ] ==========\n\t\t\t\t\t[1] Type A(Sedan | Hatch Back | Coupe)\n\t\t\t\t\t[2] Type B(SUV | Mini Van | Pick Up | Van)\n\t\t\t\t\t[3] Type C(Truck | Bus | Coaster)\n\n\t\t\t\t\t Choice :"); 
                           type [ctr] = myinp.nextInt();
                           //Type A
                           if(type[ctr] == 1)
                           {
                               System.out.print("\n\n\t\t\t\t\t Type A : 50.00 php /hour");
                           }
                           //Type B
                           else if (type[ctr] == 2)
                           {
                               System.out.print("\n\n\t\t\t\t\t Type B : 75.00 php /hour");
                           }
                           //Type C
                           else if (type[ctr] == 3)
                           {
                               System.out.print("\n\n\t\t\t\t\t Type C : 100.00 php /hour");
                           }                 
                       }while (type[ctr] !=3 && type[ctr] !=2 && type[ctr] !=1);
                       
                       random[ctr] = ran.generateRandomAlphanumeric(5);   
                       System.out.print("\n\t\t\t\t\t Customer Code : "+random[ctr]+"\n"); 
                       System.out.print(" ");  
                       //Load Wallet
                       do
                       {
                            System.out.println("\n\t\t\t\t========== [ KALM Wallet ] ==========");
                            System.out.print("\n\t\t\t\t\t  Add Cash ( Minimum of 500 Php) : ");
                            System.out.print("\n\t\t\t\t\t  Amount : ");
                            wallet[ctr] = myinp.nextInt();
                            if (wallet[ctr] < 500 )
                            {
                                System.out.print("\n\t\t\t\t\t Amount should be [ Minimum of 500 Php ] ");
                            }
                            if (wallet[ctr] > 500) {
                               System.out.print("\n\t\t\t\t\t You Added "+wallet[ctr]+" Php to Your Account\n");
                            }
                            
                        } while (wallet[ctr] < 500);
                                                      
                    ctr++;    
                    }
                    //Log - in
                    else if (ch1 == 2)
                    {   
                        System.out.println("\n\t\t\t\t========== [ Log - In ] ==========");
                        System.out.print("\n\t\t\t\t\tEnter Your Customer Code : ");
                        String search = myinp.next();
                        for (int a=1;a<ctr;a++)
                        {
                            if(random[a] != null && search.equals(random[a]))
                            {
                                do {
                                   System.out.println("\n\t\t\t\t========== [ Log - In ] ==========");
                                   System.out.println("\t\t\t\t Welcome : "+name[a].toUpperCase()+" "+lname[a].toUpperCase());
                                   System.out.print("\n\t\t\t\t\t[1] Check - In\t[2] Check - Out\n\t\t\t\t\t[3] View Transactions\n\t\t\t\t\t[4] View Personal Information\n\t\t\t\t\t[5] KALM Wallet\n\t\t\t\t\t[6] Back\n\t\t\t\t\t Choice : "); 
                                   ch3 = myinp.nextInt();
                                   //check in
                                   if (ch3 == 1) 
                                   {
                                       System.out.println("\n\t\t\t\t========== [ Check - In ] ==========");
                                       System.out.print("\n\t\t\t\t\t Date : ");
                                       localDate [ctr] = LocalDate.now();
                                       System.out.print(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate[ctr]));
                                       System.out.println("\n\t\t\t\t\t[ Time - in ]");  
		         	
                                       System.out.print("\n\t\t\t\t\tHours : "); 
                                       hrs1[ctr] = myinp.nextInt();
                                       
                                       System.out.print("\t\t\t\t\tMinutes : "); 
                                       min1[ctr] = myinp.nextInt();
                                       
                                       System.out.print("\t\t\t\t\tam/pm : ");
                                       ampm[ctr] = myinp.next(); 
                                        //Parking Level
                                       do 
                                       {
                                            System.out.print("\n\t\t\t\t\t[ Choose Storey Level ]\n\t\t\t\t\t[1] Level 1\t[2] Level 2\n\t\t\t\t\t[3] Level 3\t[4] Level 4\n\t\t\t\t\t Choice :");
                                            park [ctr] = myinp.nextInt();
                                            if (park[ctr] == 1) 
                                            {
                                                System.out.println("\n\t\t\t\t\tLevel 1 : You Recieved 0% Discount");
                                            }
                                            else if (park[ctr] == 2) 
                                            {
                                                System.out.println("\n\t\t\t\t\tLevel 2 : You Recieved 6% Discount");
                                            }
                                            else if (park[ctr] == 3) 
                                            {
                                                System.out.println("\n\t\t\t\t\tLevel 3 : You Recieved 9% Discount");
                                            }
                                            else if (park[ctr] == 4) 
                                            {
                                                System.out.println("\n\t\t\t\t\tLevel 4 : You Recieved 12% Discount");
                                            }
                                       } while (park[ctr] != 1 && park[ctr] != 2 && park[ctr] != 3 && park[ctr] != 4);
                                       System.out.print("\n\n\t\t\t\t\tYou Entered at : " + hrs1[ctr] + ":" + min1[ctr] + ampm[ctr] + "\n\t\t\t\t\tYou're Already Checked-IN!\n\n");
                                       
                                   }
                                   //check-out
                                   else if (ch3 == 2) 
                                   {
                                       do 
                                       {
                                            System.out.println("\n\t\t\t\t========== [ Check - Out ] ==========");
                                            System.out.println("\n\t\t\t\t>> Are you sure you want to Check - Out?");
                                            System.out.println("\n\t\t\t\t[1] Yes\t [2] Back\n\t\t\t\t\t Choice : ");
                                            ch4[ctr] = myinp.nextInt();
                                            if (ch4[ctr] == 1) 
                                            {
                                                System.out.println("\n\t\t\t\t========== [ Check - Out ] ==========");
                                                System.out.println("\n\t\t\t\t\t[ Time - Out ] ");                                       
                                
                                                System.out.print("\n\t\t\t\t\tHours : "); 
                                                hrs2[ctr] = myinp.nextInt();
                                                
                                                System.out.print("\t\t\t\t\tMinutes : "); 
                                                min2[ctr] = myinp.nextInt();
                                                
                                                System.out.print("\t\t\t\t\tam/pm : ");
                                                ampm1[ctr] = myinp.next(); 

                                                
                                                
                                                   System.out.println("\n\t\t\t\t========== [ Reciept ] ==========");

                                                    int [] mil;
                                                    mil = new int [] {13,14,15,16,17,18,19,20,21,22,23};
                                                    
                                                    int [] norm;
                                                    norm = new int [] {1,2,3,4,5,6,7,8,9,10,11};
                                                
                                                    if (ampm[a].equals("pm") || ampm[a].equals("PM") || ampm1[ctr].equals("pm") || ampm1[ctr].equals("PM") || ampm[a].equals("Pm") || ampm1[ctr].equals("Pm") || ampm[a].equals("pM") || ampm1[ctr].equals("pM"))
                                                    
                                                        if 
                                                            (hrs1[a]==norm[0])
                                                                hrs1[a]=mil[0];
                                                    
                                                        else if 
                                                            (hrs2[ctr]==norm[0])
                                                                hrs2[ctr]=mil[0];
                                                        else if 
                                                            (hrs2[ctr]==norm[0])
                                                                hrs2[ctr]=mil[0];
                                                        
                                                        else if 
                                                            (hrs1[a]==norm[1])
                                                                hrs1[a]=mil[1];
                                                        else if 
                                                            (hrs2[ctr]==norm[1])
                                                                hrs2[ctr]=mil[1];
                                                        
                                                        else if 
                                                            (hrs1[a]==norm[2])
                                                                hrs1[a]=mil[2];
                                                        else if 
                                                            (hrs2[ctr]==norm[2])
                                                                hrs2[ctr]=mil[2];
                                                        
                                                        else if 
                                                            (hrs1[a]==norm[3])
                                                                hrs1[a]=mil[3];
                                                        else if 
                                                            (hrs2[ctr]==norm[3])
                                                                hrs2[ctr]=mil[3];
                                                        
                                                        else if 
                                                            (hrs1[a]==norm[4])
                                                                hrs1[a]=mil[4];
                                                        else if 
                                                            (hrs2[ctr]==norm[4])
                                                                hrs2[ctr]=mil[4];
                                                        
                                                        else if 
                                                            (hrs1[a]==norm[5])
                                                                hrs1[a]=mil[5];
                                                        else if 
                                                            (hrs2[ctr]==norm[5])
                                                                hrs2[ctr]=mil[5];
                                                        
                                                        else if 
                                                            (hrs1[a]==norm[6])
                                                                hrs1[a]=mil[6];
                                                        else if 
                                                            (hrs2[ctr]==norm[6])
                                                                hrs2[ctr]=mil[6];
                                                        
                                                        else if 
                                                            (hrs1[a]==norm[7])
                                                                hrs1[a]=mil[7];
                                                        else if 
                                                            (hrs2[ctr]==norm[7])
                                                                hrs2[ctr]=mil[7];
                                                        
                                                        else if 
                                                            (hrs1[a]==norm[8])
                                                                hrs1[a]=mil[8];
                                                        else if 
                                                            (hrs2[ctr]==norm[8])
                                                                hrs2[ctr]=mil[8];
                                                        
                                                        else if 
                                                            (hrs1[a]==norm[9])
                                                                hrs1[a]=mil[9];
                                                        else if 
                                                            (hrs2[ctr]==norm[9])
                                                                hrs2[ctr]=mil[9];
                                                        
                                                        else if 
                                                            (hrs1[a]==norm[10])
                                                                hrs1[a]=mil[10];
                                                        else if 
                                                            (hrs2[ctr]==norm[10])
                                                                hrs2[ctr]=mil[10];
                                                        
                                                        else if 
                                                            (hrs1[a]==norm[11])
                                                                hrs1[a]=mil[11];
                                                        else if 
                                                            (hrs2[ctr]==norm[11])
                                                                hrs2[ctr]=mil[11];
                                                
                                                    //Hours Parked  
                                                        if (min2[ctr] > min1[a])
                                                        tom = min2[ctr] - min1[a];
                                                                    
                                                        else if (min1[a]>min2[ctr])
                                                        tom = 60 - (min1[a]-min2[ctr]);  
                                                            
                                                        else
                                                        tom = 00;
                                                    //time- out formula
                                                        if (hrs1[a] < hrs2[ctr] && ampm[a].equals(ampm1[ctr]))
                                                        to = hrs2[ctr]-hrs1[a]; 

                                                        else if (hrs1[a] > hrs2[ctr] && ampm[a].equals(ampm1[ctr]))
                                                        to = 24-(hrs1[a]-hrs2[ctr]);

                                                        else if (hrs1[a] < hrs2[ctr] && !ampm[a].equals(ampm1[ctr]))
                                                        to = hrs2[ctr]-hrs1[a]; 

                                                        else if (hrs1[a] > hrs2[ctr] && !ampm[a].equals(ampm1[ctr]))
                                                        to = 24-(hrs1[a]-hrs2[ctr]);

                                                        else if ((hrs1[a] == hrs2[ctr] && min2[ctr]==min1[a]) && ampm[a].equals(ampm1[ctr]))
                                                        to = 24;

                                                        else if ((hrs1[a] == hrs2[ctr] && min2[ctr]== min1[a]) && !ampm[a].equals(ampm1[ctr]))
                                                        to = 12 ;

                                                        else if ((hrs1[a] == hrs2[ctr] && min2[ctr] < min1[a]) && ampm[a].equals(ampm1[ctr]))
                                                        to = 23;

                                                        else if ((hrs1[a] == hrs2[ctr] && min2[ctr] > min1[a]) && ampm[a].equals(ampm1[ctr]))
                                                        to = 0;

                                                        else if ((hrs1[a] == hrs2[ctr] && min2[ctr] < min1[a]) && !ampm[a].equals(ampm1[ctr]))
                                                        to = 11;

                                                        else if ((hrs1[a] == hrs2[ctr] && min2[ctr] > min1[a]) && !ampm[a].equals(ampm1[ctr]))
                                                        to = 12;

                                                    //Total Payable Hours
                                                        if (min2[ctr]==min1[a])
                                                            tph=to;
                                                            
                                                        else if (min2[ctr]!=min1[a])  
                                                            tph=(to)+1;      
                                                                                                    
                                                //Price per hour    
                                                    int ph [] = {50, 75, 100};  
                                                        if (type[a]== 1)
                                                        ph1 = ph[0];
                                                        if (type[a]== 2)
                                                        ph1 = ph[1];	
                                                        if (type[a]== 3)
                                                        ph1 = ph[2];
                                                                                
                                                //Total Parking Fee
                                                        if (park[a]==1)
                                                            tpf =(ph1*tph);
                                                                                            
                                                        else if (park[a]==2)
                                                            tpf =((ph1*tph)*(.91));
                                                                                            
                                                        else if (park[a]==3)
                                                            tpf =((ph1*tph)*(0.85));
                                                                                            
                                                        else if (park[a]==4)
                                                            tpf =((ph1*tph)*(0.75));
                                                        
                                                        double tf = ph1*tph;
                                                        
                                                        String [] typ;
                                                        typ = new String [] {" ","Type A","Type B","Type C"};                      
                                                        String type1 = typ[a];    
                                                        
                                                        if (type[a]== 1)
                                                            type1 = typ[1];
                                                        if (type[a]== 2)
                                                            type1 = typ[2];	
                                                        if (type[a]== 3)
                                                            type1 = typ[3];

                                                            double balance = 0;                                                       
                                                            balance = wallet[a] - tpf;

                                                        System.out.println("\n\t\t\t\t\tDriver's Name : "+name[a].toUpperCase()+ " " +lname[a].toUpperCase());
                                                        System.out.println("\t\t\t\t\tPlatenumber : "+pnum[a].toUpperCase());
                                                        System.out.println("\t\t\t\t\tHours Parked : "+to+"(hours) : "+tom+"(minutes)");  
                                                        System.out.println("\t\t\t\t\tParking Level : "+park[a]);
                                                        System.out.println("\t\t\t\t\tVehicle Type : "+type1);
                                                        System.out.println("\t\t\t\t\tPrice per Hour : "+ph1);                          
                                                        System.out.println("\t\t\t\t\tTotal Payable Hours  : "+tph);
                                                        System.out.println("\t\t\t\t\tOriginal Parking Fee  :Php "+tf);
                                                        System.out.println("\t\t\t\t\tTotal Parking Fee  :Php "+tpf); 
                                                                                                               
                                                        if (balance <=0) 
                                                            System.out.println("\n\t\t\t\t\tINSUFFICIENT FUND!!!"); 
                                                        
                                                        else if (balance > 0)                                                        
                                                                System.out.println("\t\t\t\t\tAccount Balance :Php " + balance);       
                                                
                                                                                                       
                                                               
                                             }
                                            
                                       } while (ch4[ctr] != 2);
                                        
                                   }
                                   //view transactions
                                   else if (ch3 == 3) 
                                   {
                                       
                                   }
                                   //view personal info
                                   else if (ch3 == 4) 
                                   {
                                       
                                   }
                                   //Kalm Wallet
                                   else if (ch3 == 5) 
                                   {
                                       
                                   }
                                } while (ch3 != 6);
                                 

                            }
                           
                        }
                    }
                }while(ch1 != 3);
                
            }
            // Operator
            else if (ch == 2)
            {
                
            }
        }while(choice != 3);
        
        
        
        
    }
    
}
