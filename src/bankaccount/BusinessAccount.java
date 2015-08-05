/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;
class BusinessAccount extends BaseAccount{ 
 
   public BusinessAccount(String owner, int acc_num, int _id) 
    { 
        super(owner, acc_num, AccountTypes.Business, _id, 300); 
    } 
 
 
} 
