/*
Elisha David Ugela
35016
 */
package bankaccount;

/**
 *
 * @author jackm_000
 */
public class LowCreditRatingAccount extends BaseAccount{
     public LowCreditRatingAccount(String owner, int acc_num, int _id) 
    { 
        super(owner, acc_num, AccountTypes.LowCredit, _id ,500); 
    } 
    
     @Override
     public void grantOverdraft() {
         //Low credit account should not have an overdraft
         // do nothing
     }
}
