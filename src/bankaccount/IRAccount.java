/*
Elisha David Ugela 
35016
 */
package bankaccount;

class IRAccount extends BaseAccount{ 
 
    public IRAccount(String owner, int acc_num, int _id) 
    { 
        super(owner, acc_num, AccountTypes.IR, _id, 500); 
    } 
 
} 
