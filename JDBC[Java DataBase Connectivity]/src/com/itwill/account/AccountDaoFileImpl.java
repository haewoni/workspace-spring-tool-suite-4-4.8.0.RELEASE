package com.itwill.account;
/*
Dao(Data Access Object)
 - 계좌객체들의 데이터를 저장하고있는 파일(테이블)에
   CRUD(Create, Read, Update, Delete) 작업을 할수있는
   단위메쏘드를 가지고있는 클래스

 - AccountService객체 의 요청(메쏘드호출)을 받아서 
   Data Access(File, DB)에 관련된 단위기능(CRUD)을
   수행하는 객체
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class AccountDaoFileImpl implements AccountDao {
	
	/*
	 * Account데이타소스(메모리,파일,테이블)
	 */
	private File accountsFile;
	public AccountDaoFileImpl() throws Exception{
		accountsFile=new File("accounts.ser");
		if(!accountsFile.exists()) {
			System.out.println("파일생성[accounts.ser]");
			ObjectOutputStream oos
				=new ObjectOutputStream(new FileOutputStream(accountsFile));
			oos.writeObject(new ArrayList<Account>());
		}
	}
	/**********************************************/
	private ArrayList<Account> readFile() throws Exception{
		ObjectInputStream ois=
				new ObjectInputStream(
						new FileInputStream(accountsFile));
		ArrayList<Account> accountList=(ArrayList<Account>)ois.readObject();
		ois.close();
		return accountList;
	}
	private void writeFile(ArrayList<Account> accountList) throws Exception{
		ObjectOutputStream oos=
				new ObjectOutputStream(
						new FileOutputStream(accountsFile));
		oos.writeObject(accountList);
		oos.close();
	}
	/**********************************************/
	/*
	 * Create
	 */
	@Override
	public boolean create(Account account) throws Exception{
		if(!this.isDuplicateNo(account.getNo())) {
			ArrayList<Account> accountList=this.readFile();
			accountList.add(account);
			this.writeFile(accountList);
			return true;
		}else {
			return false;
		}
		
		
	}
	private boolean isDuplicateNo(int no) throws Exception{
		boolean isDuplicate=false;
		ArrayList<Account> accountList = this.readFile();
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
		ArrayList<Account> accountList = this.readFile();
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
		ArrayList<Account> accountList = this.readFile();
		return accountList;
	}
	@Override
	public ArrayList<Account> readByOwner(String ownerStr) throws Exception{
		ArrayList<Account> accountList=this.readFile();
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
		ArrayList<Account> accountList=this.readFile();
		for (Account account : accountList) {
			if(account.getNo()==updateAccount.getNo()) {
				account.setOwner(updateAccount.getOwner());
				account.setBalance(updateAccount.getBalance());
				account.setIyul(updateAccount.getIyul());
				break;
			}
		}
		this.writeFile(accountList);
	}
	 */
	@Override
	public void update(Account updateAccount) throws Exception {
		ArrayList<Account> accountList=this.readFile();
		for (int i = 0; i < accountList.size(); i++) {
			if(accountList.get(i).getNo()==updateAccount.getNo()) {
				accountList.set(i, updateAccount);
				break;
			}
		}
		this.writeFile(accountList);
	}
	@Override
	public void update(int no,String owner,int balalnce,double iyul) throws Exception {
		ArrayList<Account> accountList=this.readFile();
		for (int i = 0; i < accountList.size(); i++) {
			if(accountList.get(i).getNo()==no) {
				accountList.get(i).setOwner(owner);
				accountList.get(i).setBalance(balalnce);
				accountList.get(i).setIyul(iyul);
			}
		}
		this.writeFile(accountList);
	}
	/*
	 * Delete
	 */
	@Override
	public void delete(int no) throws Exception{
		ArrayList<Account> accountList=this.readFile();
		for (int i=0;i<accountList.size();i++) {
			if(accountList.get(i).getNo()==no) {
				accountList.remove(i);
				break;
			}
		}
		this.writeFile(accountList);
		
	}
	
	
	
}













