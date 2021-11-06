package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException {

	private final static String MSG = "Too much operations";
	public String toString() {
		return MSG;
	}
}
