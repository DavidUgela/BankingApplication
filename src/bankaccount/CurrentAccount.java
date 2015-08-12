/*
Elisha David Ugela
35016
 */
package bankaccount;

class CurrentAccount extends BaseAccount{ 
 
   public CurrentAccount(String owner, int acc_num, int _id) 
    { 
        super(owner, acc_num, AccountTypes.Current, _id, 300); 
    } 
 
} 
