package University.Java_Using_Project.Experiment3;


import java.util.Scanner;

abstract class Account {
    double interestRate;
    double amount;

    Account(double amount){
        this.amount = amount;
        this.interestRate = 0.0;
    }
    abstract double calculateInterest();


}

class FDAccount extends  Account{
    int  noOfDays;
    int ageOfACHolder;

    public FDAccount(double amount, int noOfDays,int ageOfACHolder ) {
        super(amount);
        this.noOfDays = noOfDays;
        this.ageOfACHolder = ageOfACHolder;
    }



    @Override
      double  calculateInterest() {
        if(amount<1000000){
            if(7<= noOfDays && noOfDays<=14){
                interestRate = (ageOfACHolder<60)?4.50 : 5.0;
            } else if (15<= noOfDays && noOfDays<=29) {
                interestRate = (ageOfACHolder<60)? 4.75 : 5.25;
            }
            else if (30<= noOfDays && noOfDays<=45) {
                interestRate = (ageOfACHolder<60)? 5.50 : 6.00;
            }
            else if (46<= noOfDays && noOfDays<=60) {
                interestRate = (ageOfACHolder<60)? 7.00 : 7.50;
            }
            else if (61<= noOfDays && noOfDays<=184) {
                interestRate = (ageOfACHolder<60)? 7.50 : 8.00;
            }
            else if (185<= noOfDays) {
                interestRate = (ageOfACHolder<60)? 8.00 : 8.50;
            }else{
                interestRate = 0.0;
            }
        }else{
            if(7<= noOfDays && noOfDays<=14){
                interestRate = 6.50;
            } else if (15<= noOfDays && noOfDays<=29) {
                interestRate = 6.75;
            }
            else if (30<= noOfDays && noOfDays<=45) {
                interestRate = 7.50;
            }
            else if (46<= noOfDays && noOfDays<=60) {
                interestRate = 8.00;
            }
            else if (61<= noOfDays && noOfDays<=184) {
                interestRate = 8.50;
            }
            else if (185<= noOfDays) {
                interestRate = 10.00;
            }else{
                interestRate = 0.0;
            }
        }
        
        return (amount*interestRate*noOfDays)/(365*100);
    }
}

class  RDAccount extends  Account{

     int noOfMonths;
     int ageOfACHolder;

    RDAccount(double amount, int noOfMonths, int ageOfACHolder){
        super(amount);
        this.noOfMonths = noOfMonths;
        this.ageOfACHolder = ageOfACHolder;
    }

    @Override
    double calculateInterest() {

        if(noOfMonths<=6){
            interestRate = (ageOfACHolder<60)? 7.50 : 8.00;
        }else if(noOfMonths<=9){
            interestRate = (ageOfACHolder<60)? 7.75 : 8.25;
        }else if( noOfMonths<=12){
            interestRate = (ageOfACHolder<60)? 8.00 : 8.50;
        }else if(noOfMonths<=15){
            interestRate = (ageOfACHolder<60)? 8.25 : 8.75;
        }else if(noOfMonths<=18){
            interestRate = (ageOfACHolder<60)? 8.50 : 9.00;
        }else if(noOfMonths<=21){
            interestRate = (ageOfACHolder<60)? 8.75 : 9.25;
        }else{
            interestRate = 10.0;
        }


        return (amount*interestRate*noOfMonths)/(12*1000);

    }

}

class SBAccount extends Account{

    String accountType;
    SBAccount(double amount,String accountType ){
        super(amount);
        this.accountType  =accountType;
    }

    @Override
    double calculateInterest() {
        if(accountType.equals("Normal")){
            return (amount*4)/100;
        }
        else if(accountType.equals("NRI")){
            return (amount*6)/100;
        }else{
            System.out.println("Invalid account type");
        }
        return 0;
    }
}

public class Main {

    static void run(Scanner in){
       while(true){
           System.out.println("\nSelect the option:");
           System.out.println("1. Interest Calculator –SB");
           System.out.println("2. Interest Calculator –FD");
           System.out.println("3. Interest Calculator –RD");
           System.out.println("4. Exit\n");

           int choice = in.nextInt();
           switch (choice){
               case 1:{
                   System.out.println("Enter the amount");
                   double amount  = in.nextDouble();
                   if(amount>0){
                       System.out.println("Enter the account type");
                       String type = null;
                       System.out.println("--Enter 1 for Normal account--\n--Enter 2 for NRI account--");
                       int val = in.nextInt();
                       if(val ==1){
                           type = "Normal";
                       }else if(val == 2){
                           type = "NRI";
                       }
                       else{
                           System.out.println("Wrong input");
                       }
                       SBAccount sb = new SBAccount(amount,type);
                       System.out.println("Interest gained: Rs. "+ Math.round(sb.calculateInterest()));
                   }
                   else{
                       System.out.println("Invalid amount");
                   }
               }break;
               case 2:{
                   System.out.println("Enter the FD amount");
                   double amount = in.nextDouble();
                   if(amount>0){
                       System.out.println("Enter the number of days");
                       int day = in.nextInt();
                       System.out.println("Enter the account Holder age");
                       int age = in.nextInt();
                       FDAccount fd = new FDAccount(amount,day,age);
                       System.out.println("Interest gained: Rs. "+Math.round(fd.calculateInterest()));
                   }else{
                       System.out.println("Invalid amount");
                   }
               }
               break;
               case 3:{
                   System.out.println("Enter the amount");
                   double amount = in.nextDouble();
                   if(amount>0){
                       System.out.println("Enter the number of months");
                       int months = in.nextInt();
                       System.out.println("Enter the age of account holder");
                       int age = in.nextInt();
                       RDAccount rd = new RDAccount(amount,months,age);
                       System.out.println("Interest gained: Rs. "+Math.round(rd.calculateInterest()));
                   }else{
                       System.out.println("Invalid amount");
                   }
               }break;
               case 4:{
                   System.out.println("Exiting....");
                   System.exit(0);
               }break;
               default:{
                   System.out.println("Invalid choice");
               }
           }
       }
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        run(in);
    }

}
