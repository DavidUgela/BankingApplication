/*
 Elisha David Ugela
35016
 */
package bankaccount;

/**
 *
 * @author jackm_000
 */
public class IslamicBankAccount extends BaseAccount{
    public IslamicBankAccount(String owner, int acc_num, int _id) 
    { 
        super(owner, acc_num, AccountTypes.Islamic, _id, 300); 
    } 
     
     @Override
     public void interest_rate(){
         //Islamic account should not be able to accrue interest
         // do nothing
     }
    
}
