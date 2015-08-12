
//Elisha David Ugela, 35016

package bankaccount;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Menu {
    private static Scanner input = new Scanner(System.in); 
    private  ArrayList<Loan> loans = new ArrayList<Loan>();     
    private  ArrayList<BaseAccount> accounts = new ArrayList<BaseAccount>();  
    private int acc_num;     
    private int acc_number;     
    private double amount; 
    private String name;
    private int penaltiesAccountNumber;
    private int penaltiesCustomerId;
    private ScheduledExecutorService scheduler;
 
    public Menu() {         
        scheduler = Executors.newScheduledThreadPool(3);
        Interest interest = new Interest();
        interest.setMenu(this);
        scheduler.scheduleAtFixedRate(interest, 0, 365, TimeUnit.DAYS);
        penaltiesCustomerId = 999;
        main_menu(); 
        
    } 
    
        
    private void openPenaltiesAccount() {
        BaseAccount pAccount = new CurrentAccount("Penalties Account", acc_num, penaltiesCustomerId);
        pAccount.deposit(10000.00);
        acc_num++;
        penaltiesAccountNumber = pAccount.getAccountNum();
        accounts.add(pAccount);
    }
    
    public void main_menu() { 
 
        System.out.println("Press Esc to enter menu"); 
         try { 
            System.in.read(); 
        } catch (Exception e) { 
            System.out.println(e); 
        } 
 
        System.out.println("1. Create Current Account");         
        System.out.println("2. Deposit"); 
        System.out.println("3. Display Balance"); 
        System.out.println("4. Withdraw"); 
        System.out.println("5. Transfer Money"); 
        System.out.println("6. Pay Interest"); 
        System.out.println("7. Add Account Holder"); 
        System.out.println("8. Show all accounts Held by a customer"); 
        System.out.println("9. View Transactions"); 
        System.out.println("10. Take out Loan");
        System.out.println("Select option: "); 
 
        int option = Integer.parseInt(input.nextLine()); 
 
        switch (option) { 
             case 1: 
                 System.out.println("1. Current Account\r\n");         
                 System.out.println("2. Savings Account\r\n"); 
                 System.out.println("3. Student Account\r\n"); 
                 System.out.println("4. Business Account\r\n"); 
                 System.out.println("5. SMB Account\r\n");
                 System.out.println("6. IR Account\r\n");         
                 int option2 = Integer.parseInt(input.nextLine());
                 System.out.println("Enter Customer first and Last Name");                 
                 name = input.nextLine();
                 System.out.println("Enter Customer ID");                 
                 int id = Integer.parseInt(input.nextLine());
                acc_num++;
                 switch(option2){
                     case 1:
                          accounts.add(new CurrentAccount(name, acc_num, id));  
                         break;
                     case 2:
                         accounts.add(new SavingsAccount(name, acc_num, id));
                         break;
                     case 3:
                         accounts.add(new StudentAccount(name, acc_num, id));
                         break;
                     case 4:
                         accounts.add(new BusinessAccount(name, acc_num, id));
                         break;
                     case 5:
                         accounts.add(new SMBAccount(name, acc_num, id));
                         break;
                     case 6:
                          accounts.add(new IRAccount(name, acc_num, id));
                         break;
                 }
                           
                break; 
             case 2: 
                //Write the instruction to the user 
                System.out.println("Enter account Number: ");                 
                //Convert the string the user enters to an int                 
                acc_number = Integer.parseInt(input.nextLine()); 
                //Write instruction to the user 
                System.out.println("Enter deposit amount: ");                 
                //Convert the string entered by the user to a double                 
                amount = Double.parseDouble(input.nextLine());                 
                for (int i = 0; i < accounts.size(); i++) { 
                    if (accounts.get(i).getAccountNum() == acc_number) 
                    {                         
                        accounts.get(i).deposit(amount);
                        accounts.get(i).addTransaction(new Date(), "Deposit", amount);
                        break; 
                    }                 
                }                 
                break; 
             case 3: 
                //Write the instruction to the user 
                System.out.println("Enter account Number: ");                 
//Convert the string the user enters to an int                 
                acc_number = Integer.parseInt(input.nextLine());                 
                for (int i = 0; i < accounts.size(); i++) { 
                    if (accounts.get(i).getAccountNum() == acc_number) 
                    {                        
                        System.out.println((accounts.get(i).get_balance()));
                        accounts.get(i).addTransaction(new Date(), "View Balance", amount);
                        break; 
                    }                 
                }                 
                break; 
             case 4: 
                //Write the instruction to the user 
                System.out.println("Enter account Number: ");                 
//Convert the string the user enters to an int                 
                acc_number = Integer.parseInt(input.nextLine()); 
                //Write instruction to the user 
                System.out.println("Enter withdraw amount: ");                 
//Convert the string entered by the user to a double                 
                amount = Double.parseDouble(input.nextLine()); 
                 
                 for (int i = 0; i < accounts.size(); i++) {
                     //find the account
                     if(accounts.get(i).getAccountNum() == acc_number) {
                         //check it is under their withdrawal limit
                        if ( amount <= accounts.get(i).getWithdrawalLimit() ){
                           accounts.get(i).withdraw(amount);
                           accounts.get(i).addTransaction(new Date(), "Withdrawal", amount);
                        } 
                     }
                    }                
                                 
                 break; 
             case 5:                 
                //Write the instruction to the user 
                System.out.println("Enter account Number to transfer money FROM:"); 
                //Convert the string the user enters to an int                 
                acc_number = Integer.parseInt(input.nextLine()); 
                //Write instruction to the user 
                System.out.println("Enter transfer amount: ");                 
                //Convert the string entered by the user to a double                 
                amount = Double.parseDouble(input.nextLine());                 
                
                for (int i = 0; i < accounts.size(); i++) { 
                    if (accounts.get(i).getAccountNum() == acc_number) { 
                         
                        if(accounts.get(i).get_balance() >= amount) 
                        {                             
                            accounts.get(i).withdraw(amount); 
                            accounts.get(i).addTransaction(new Date(), "Transfer", amount);
                            break; 
                        } 
                        else 
                        { 
                            System.out.println("There are insufficient funds to make this transfer"); 
                            break; 
                        } 
                    } 
                } 
                 
                System.out.println("Enter account Number to transfer money TO: "); 
                //Convert the string the user enters to an int                 
                double acc_number_second = Integer.parseInt(input.nextLine());
                boolean exists = false;
                for (int i = 0; i < accounts.size(); i++) 
                { 
                    if (accounts.get(i).getAccountNum() == acc_number_second) 
                    {                         
                        exists = true;
                        accounts.get(i).deposit(amount);
                        accounts.get(i).addTransaction(new Date(), "Transfer", amount);
                        break; 
                    }
                }     
                 
                if (!exists) {
                    for (int i = 0; i < accounts.size(); i++) {
                        if(accounts.get(i).getAccountNum() == acc_number) {
                            accounts.get(i).deposit(amount);
                            accounts.get(i).addTransaction(new Date(), "Failed Transfer", amount);
                        }
                    }
                    System.out.println("Destination account not found");
                } else {
                    System.out.println("Payment has been successfully transferred"); 
                
                }
                 
                                 
               break;     
                   
            case 6: 
                payInterest();
                 
             
            case 7: 
                System.out.println("Enter Account Number");                 
                acc_num = Integer.parseInt(input.nextLine()); 
                System.out.println("Enter Customer first and Last Name");                 
                name = input.nextLine(); 
                for (int i = 0; i < accounts.size(); i++) 
                { 
                    if (accounts.get(i).getAccountNum() == acc_number) 
                    {                         
                        accounts.get(i).AddAccHolder(name, acc_num);                         
                        break; 
                    } 
                }                   
                break;              
             case 8: 
                System.out.println("Enter Account Number");                 
                int _id = Integer.parseInt(input.nextLine());
                for (int i = 0; i < accounts.size(); i++) 
                { 
                    if (accounts.get(i).getID()== acc_number) 
                    {                         
                        System.out.println(accounts.get(i).get_acc_type()+" "+accounts.get(i).getHolderName()+" "+accounts.get(i).get_balance());                         
                         
                    } 
                }                   
                break; 
             case 9:
                 System.out.println("Enter Account Number");                 
                acc_num = Integer.parseInt(input.nextLine());
                int j=0;
                for (int i = 0; i < accounts.size(); i++) 
                { 
                    if (accounts.get(i).getAccountNum()== acc_number) 
                    {      
                        while(j<accounts.get(i).getTransactions().size())
                        {
                            System.out.println(accounts.get(i).getTransactions().get(j).getType()+" "+accounts.get(i).getTransactions().get(j).getDate()+" "+accounts.get(i).getTransactions().get(j).getAmount());
                            j++;
                        }
                         
                    } 
                }             
                 break;
                 
                 case 10:
                    System.out.println("Please enter the amount being borrowed");
                    amount = Double.parseDouble(input.nextLine());
                    System.out.println("Please enter the interest rate");
                    double ir = Double.parseDouble(input.nextLine());
                    loans.add(new Loan(amount, ir));
                    
                    System.out.println("Loan has been granted");
                    break;

                 
                 
        } 
 
        main_menu(); 
 
    }
    
    public void payInterest() {
        for (int i = 0; i < accounts.size(); i++) {                     
            accounts.get(i).interest_rate(); 
        }
    }
}
