/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;
class BusinessAccount extends BaseAccount{ 
 
    public BusinessAccount(String business_name, int acc_num, int _id) 
    { 
        super(business_name, acc_num, AccountTypes.Business,_id); 
    } 
 
 
} 