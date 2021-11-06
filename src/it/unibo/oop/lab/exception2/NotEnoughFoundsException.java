package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends IllegalStateException {

	private final static String MSG = "Not enough money";
	public String toString() {
		return MSG;
	}
}
