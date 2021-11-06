package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalArgumentException {
	
	private final static String MSG = "Yuo aren't the right holder of this account";
	public String toString() {
		return MSG;
	}
}
