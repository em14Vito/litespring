package org.litespring.util;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 29/07/2018 9:51 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/
public class MessageTracker {

	private static volatile List<String> MESSAGES = new ArrayList<String>();

	public static void addMsg(String msg){
		MESSAGES.add(msg);
	}
	public static void clearMsgs(){
		MESSAGES.clear();
	}
	public static List<String> getMsgs(){
		return MESSAGES;
	}
}
