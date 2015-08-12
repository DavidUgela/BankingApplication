/*
Elisha David Ugela
35016
*/
package bankaccount;

import java.util.ArrayList;
import java.util.Date;

public class Loan {
	private double amountLoaned;
	private double paybackAmount;
	private ArrayList<Transaction> paymentHistory;
        private  ArrayList<Loan> loans = new ArrayList<Loan>();   
        
	
	public Loan(double loan, double ir ) {
		amountLoaned = loan;
		paybackAmount = (loan * ir);
		paymentHistory = new ArrayList<>();
	}
	
	public void makeRepayment(double paymentAmount) {
		paymentHistory.add(new Transaction(new Date(), "Loan Repayment", paybackAmount) );
	}

}
