package org.litespring.service.v3;

import org.litespring.dao.v3.AccountDao;
import org.litespring.dao.v3.ItemDao;

/**
 * [Class description.  The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 07/07/2018 3:34 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/
public class PetStoreService {

	private AccountDao accountDao;
	private ItemDao itemDao;
	private int version;

	public PetStoreService(AccountDao accountDao, ItemDao itemDao){
		this.accountDao = accountDao;
		this.itemDao = itemDao;
		this.version = -1;
	}
	public PetStoreService(AccountDao accountDao, ItemDao itemDao,int version){
		this.accountDao = accountDao;
		this.itemDao = itemDao;
		this.version = version;
	}
	public int getVersion() {
		return version;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}


}