/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

class StudentAccount extends BaseAccount{ 
 
    public StudentAccount(String owner, int acc_num, int _id) 
    { 
        super(owner, acc_num, AccountTypes.Student, _id); 
    } 
 
} 