//Elisha David Ugela
package bankaccount;
class SavingsAccount extends BaseAccount{ 
 
    public SavingsAccount(String owner, int acc_num, int _id) 
    { 
        super(owner, acc_num, AccountTypes.Savings, _id, 300); 
    } 
 
} 
