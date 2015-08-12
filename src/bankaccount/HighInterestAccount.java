/*
Elisha David Ugela
35016
 */
package bankaccount;

/**
 *
 * @author jackm_000
 */
public class HighInterestAccount extends BaseAccount {
    public HighInterestAccount(String owner, int acc_num, int _id) 
    { 
        super(owner, acc_num, AccountTypes.HighInterest, _id, 300); 
    }  
}
