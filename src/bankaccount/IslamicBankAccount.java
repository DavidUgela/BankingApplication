/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
