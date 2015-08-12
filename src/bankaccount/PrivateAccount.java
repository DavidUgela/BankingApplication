//Elisha David Ugeal 35016
package bankaccount;

/**
 *
 * @author jackm_000
 */
public class PrivateAccount extends BaseAccount{
     public PrivateAccount(String owner, int acc_num, int _id) 
    { 
        super(owner, acc_num, AccountTypes.Private, _id, 500); 
    } 
}
