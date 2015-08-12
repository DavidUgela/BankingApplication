/* Student Name Elisha David ugle
 * Student ID 35016
 */
package bankaccount;

import java.util.ArrayList;
import java.util.Date;

class BaseAccount implements Account { 
 
    public double balance; 
    ArrayList<String> holders = new ArrayList<String>();   
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();   
    protected double interestRate;     
    protected int acc_number; 
    public AccountTypes account_type;
    private double overdraftLimit;
    private boolean hasOverdraft;
    private double withdrawalLimit;
    int id;
 
    //Set up a new account 
    public BaseAccount(String acc_owner, int acc_num, AccountTypes types, int _id, double limit) 
    { 
        holders.add(acc_owner);         
        acc_number = acc_num; 
        account_type = types;
        withdrawalLimit = limit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }
    
 
    //Add account holder 
    public void AddAccHolder(String acc_owner, int acc_num) 
    { 
        holders.add(acc_owner); 
        acc_number = acc_num; 
    } 
     public String getHolderName()
     {
         return holders.get(0);
     }
     public int getID()
     {
         return id;
     }
    public int getAccountNum() 
    { 
        return acc_number; 
    } 
 
    public void withdraw(double amount) 
    { 
        balance -= amount; 
    } 
 
    public void deposit(double amount) 
    { 
        balance += amount; 
    } 
 
    public double get_balance() 
    { 
        return balance; 
    } 
 
    public AccountTypes get_acc_type() 
    { 
        return account_type; 
    } 
     
     
    public void interest_rate() 
    { 
        balance += interestRate * balance; 
    } 
    public void addTransaction(Date d, String trans_Type, double amount)
    {
        transactions.add(new Transaction(d,trans_Type, amount));
    }
    public ArrayList<Transaction> getTransactions()
    {
        return transactions;
    }
    
    public void grantOverdraft() {
        this.hasOverdraft = true;
    }
    public void revokeOverdraft() {
        this.hasOverdraft = false;
    }
    
    public void changeOverdraft(double limit) {
        this.overdraftLimit = limit;
    }
    
    
} 
    

