package org.litespring.service.v5;

import org.litespring.beans.factory.annotation.Autowired;
import org.litespring.dao.v5.AccountDao;
import org.litespring.dao.v5.ItemDao;
import org.litespring.stereotype.Component;
import org.litespring.util.MessageTracker;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 05/08/2018 12:02 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

@Component(value="petStore")
public class PetStoreService {
	@Autowired
	AccountDao accountDao;
	@Autowired
	ItemDao itemDao;

	public PetStoreService() {

	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void placeOrder(){
		System.out.println("place order");
		MessageTracker.addMsg("place order");

	}
}

