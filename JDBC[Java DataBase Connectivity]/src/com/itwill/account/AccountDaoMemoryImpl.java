package com.itwill.account;

import java.util.ArrayList;





public class AccountDaoMemoryImpl implements AccountDao{
	private ArrayList<Account> accountList;
	public AccountDaoMemoryImpl() {
		accountList=new ArrayList<Account>();
		accountList.add(new Account(1111, "KIM", 89000, 1.3));
		accountList.add(new Account(2222, "AIM", 45000, 2.7));
		accountList.add(new Account(3333, "FIM", 23000, 4.7));
		accountList.add(new Account(4444, "XIM", 34000, 6.7));
		accountList.add(new Account(5555, "HIM", 78000, 3.7));
		accountList.add(new Account(6666, "AIM", 99000, 5.7));
		accountList.add(new Account(7777, "PIM", 89000, 4.7));
		accountList.add(new Account(8888, "QIM", 91000, 1.7));
		accountList.add(new Account(9999, "MIM", 12000, 0.7));
	}
	
	@Override
	public boolean create(Account account) throws Exception{
		if(!this.isDuplicateNo(account.getNo())) {
			accountList.add(account);
			return true;
		}else {
			return false;
		}
		
		
	}
	private boolean isDuplicateNo(int no) throws Exception{
		boolean isDuplicate=false;
		
		for (Account account : accountList) {
			if(account.getNo()==no) {
				isDuplicate=true;
				break;
			}
		}
		return isDuplicate;
	}
	/*
	 * ReadOne
	 * ReadAll
	 */
	@Override
	public Account readOne(int no) throws Exception {
		
		Account findAccount=null;
		for (Account account : accountList) {
			if(account.getNo()==no) {
				findAccount=account;
			}
		}
		return findAccount;
	}
	@Override
	public ArrayList<Account> readAll() throws Exception{
		
		return accountList;
	}
	@Override
	public ArrayList<Account> readByOwner(String ownerStr) throws Exception{
		
		ArrayList<Account> findAccounts=new ArrayList<Account>();
		for (Account account : accountList) {
			if(account.getOwner().equals(ownerStr)) {
				findAccounts.add(account);
			}
		}
		return findAccounts;
	}
	
	/*
	 * Update
	/*
	public void update(Account updateAccount) throws Exception {
		
		for (Account account : accountList) {
			if(account.getNo()==updateAccount.getNo()) {
				account.setOwner(updateAccount.getOwner());
				account.setBalance(updateAccount.getBalance());
				account.setIyul(updateAccount.getIyul());
				break;
			}
		}
		
	}
	 */
	@Override
	public void update(Account updateAccount) throws Exception {
		
		for (int i = 0; i < accountList.size(); i++) {
			if(accountList.get(i).getNo()==updateAccount.getNo()) {
				accountList.set(i, updateAccount);
				break;
			}
		}
		
	}
	@Override
	public void update(int no,String owner,int balalnce,double iyul) throws Exception {
		
		for (int i = 0; i < accountList.size(); i++) {
			if(accountList.get(i).getNo()==no) {
				accountList.get(i).setOwner(owner);
				accountList.get(i).setBalance(balalnce);
				accountList.get(i).setIyul(iyul);
			}
		}
		
	}
	/*
	 * Delete
	 */
	@Override
	public void delete(int no) throws Exception{
		
		for (int i=0;i<accountList.size();i++) {
			if(accountList.get(i).getNo()==no) {
				accountList.remove(i);
				break;
			}
		}
		
		
	}
}
