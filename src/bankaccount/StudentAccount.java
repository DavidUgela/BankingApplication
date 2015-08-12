/*Elisha David Ugela 35016*/
package bankaccount;

class StudentAccount extends BaseAccount{ 
 
   public StudentAccount(String owner, int acc_num, int _id) 
    { 
        super(owner, acc_num, AccountTypes.Student, _id, 300); 
    } 
 
} 
