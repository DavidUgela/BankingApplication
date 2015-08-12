//Elisha David Ugela
package bankaccount;

import java.util.Date;

class Transaction
    {
        protected Date time;
        String transactionType;
        protected double amount;
        public Transaction(Date _time, String _transactionType, double _amount)
        {
            time = _time;
            transactionType = _transactionType;
            amount = _amount;

        }
        public Date getDate()
        {
            return time;
        }
        public String getType()
        {
            return transactionType;
        }
        public double getAmount()
        {
            return amount;
        }

    }

