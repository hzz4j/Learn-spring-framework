package org.tx.sync;

import org.springframework.transaction.support.TransactionSynchronization;

public class TransactionsynchronizationImpl implements TransactionSynchronization {
	private String name;
	public TransactionsynchronizationImpl(String methodName){
		this.name = methodName;
	}

	@Override
	public void suspend() {
		System.out.println(this.name+" suspend");
	}

	@Override
	public void resume() {
		System.out.println(this.name+" resume");
	}

	@Override
	public void beforeCommit(boolean readOnly) {
		System.out.println(this.name+" beforeCommit");
	}

	@Override
	public void beforeCompletion() {
		System.out.println(this.name+" beforeCompletion");
	}

	@Override
	public void afterCommit() {
		System.out.println(this.name+" afterCommit");
	}

	@Override
	public void afterCompletion(int status) {
		System.out.println(this.name+" afterCompletion");
	}
}
