/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

class CurrentAccount extends BaseAccount{ 
 
    public CurrentAccount(String owner, int acc_num, int _id) 
    { 
        super(owner, acc_num, AccountTypes.Current,_id); 
    } 
 
} 