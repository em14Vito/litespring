package org.litespring.service.v4;

import org.litespring.beans.factory.annotation.Autowired;
import org.litespring.dao.v4.AccountDao;
import org.litespring.dao.v4.ItemDao;
import org.litespring.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 16/07/2018 8:57 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

@Component(value="petStore")
public class PetStoreService {
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private ItemDao itemDao;

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}


}
