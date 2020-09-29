package com.itwill.account.test;

import java.util.ArrayList;

import com.itwill.account.Account;
import com.itwill.account.AccountService;

public class AccountServiceTestMain {

	public static void main(String[] args) throws Exception{
		AccountService accountService = new AccountService();
		/*
		 * 계좌개설
		 */
		accountService.addAccount(new Account(1000, "백백백", 0, 6.7));
		accountService.addAccount(new Account(2000, "이백백", 43534, 6.7));
		accountService.addAccount(new Account(3000, "삼백백", 56756, 6.7));
		accountService.addAccount(new Account(4000, "사백백", 56756, 6.7));
		
		
		/*
		 * 계좌전체검색후 반환
		 */
		System.out.println("----계좌전체검색후 반환----");
		System.out.println(accountService.findByAll());
		/*
		 * 계좌번호로 1개검색후 반환
		 */
		System.out.println("-----계좌번호로 1개검색후 반환-----");
		System.out.println(accountService.findAccountByNo(4000));
		/*
		 * 계좌입금
		 */
		System.out.println("-----계좌입금-----");
		accountService.ipGum(2000, 56000);
		/*
		 * 계좌출금
		 */
		System.out.println("-----계좌출금-----");
		//accountService.ipGum(3, 9000000);
		accountService.chulGum(3000, 3333);
		System.out.println("-----계좌삭제-----");
		System.out.println(accountService.close(1000));
		System.out.println(accountService.close(2000));
		
		System.out.println(accountService.findByAll());
	}

}
