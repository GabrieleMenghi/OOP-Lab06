package it.unibo.oop.lab.exception2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
	private final static int INIT_AMOUNT = 10_000;
	private final static int INIT_TRANS = 10;

	final AccountHolder u1 = new AccountHolder("Marco", "Bianchi", 1);
	final AccountHolder u2 = new AccountHolder("Paolo", "Rossi", 2);
	final StrictBankAccount a1 = new StrictBankAccount(u1.getUserID(), INIT_AMOUNT, INIT_TRANS);
	final StrictBankAccount a2 = new StrictBankAccount(u2.getUserID(), INIT_AMOUNT, INIT_TRANS);
	
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * */
        /**
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	System.out.println("Transactions count : " + a2.getTransactionCount());
    	
    	try {
    		a2.withdraw(u2.getUserID(), 11000);
    	} catch (NotEnoughFoundsException e) {
    		//assertNotNull(e);
    		System.out.println(e);
    	}
    	
    	System.out.println("Transactions count : " + a2.getTransactionCount());
    	
    	for (int i = 0; i < 10; i++) {
            try {
                a2.depositFromATM(u2.getUserID(), 2);
                //System.out.println("Transactions count : " + a2.getTransactionCount());
            } catch (TransactionsOverQuotaException | WrongAccountHolderException e) {
                fail("Not exceeded yet max # transactions!");
            	System.out.println(e);
            }
        }
    	System.out.println("Amount of a2 : " + a2.getBalance());
    	
    	 try {
             a2.depositFromATM(u1.getUserID(), 1);
             fail("Should raise the exception signaling that we exceeded max # transactions!");
         } catch (TransactionsOverQuotaException | WrongAccountHolderException e) {
             assertNotNull(e);
         }
    	 System.out.println("Amount of a2 : " + a2.getBalance());
    	 System.out.println("Transactions count a2 : " + a2.getTransactionCount());
    	 System.out.println();
    	 
    	 try {
    		 a1.computeManagementFees(u1.getUserID());
    	 } catch (TransactionsOverQuotaException e) {
    		 assertNull(e);
    	 }
    	 System.out.println("Amount of a1 : " + a1.getBalance());
    	 System.out.println("Transactions count a1 : " + a1.getTransactionCount());
    	 
    	 try {
    		 a1.withdraw(u2.getUserID(), 5000);
    	 } catch (WrongAccountHolderException e) {
    		 assertNotNull(e);
    	 }
    	 System.out.println("Amount of a1 : " + a1.getBalance());
    	 System.out.println("Transactions count a1 : " + a1.getTransactionCount());
    }
}
