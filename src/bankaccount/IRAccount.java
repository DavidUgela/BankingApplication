/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

class IRAccount extends BaseAccount{ 
 
    public IRAccount(String owner, int acc_num, int _id) 
    { 
        super(owner, acc_num, AccountTypes.IR, _id, 500); 
    } 
 
} 
