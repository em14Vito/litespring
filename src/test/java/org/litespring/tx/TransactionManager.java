package org.litespring.tx;

import org.litespring.util.MessageTracker;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 29/07/2018 9:45 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/


public class TransactionManager {

	public void start(){
		System.out.println("start tx");
		MessageTracker.addMsg("start tx");
	}
	public void commit(){
		System.out.println("commit tx");
		MessageTracker.addMsg("commit tx");
	}
	public void rollback(){
		System.out.println("rollback tx");
		MessageTracker.addMsg("rollback tx");
	}
}
