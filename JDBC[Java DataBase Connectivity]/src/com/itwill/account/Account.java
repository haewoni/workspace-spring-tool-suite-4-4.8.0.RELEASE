package com.itwill.account;

import java.io.Serializable;

/*
은행계좌객체를 추상화한클래스
VO(Value Object),DTO(Data Transfer Object)
 	- 계좌관리를 위하여 필요한 도메인클래스(VO,DTO)
  	- 계좌객체 한개의 데이타를가지고있다.(VO)
  	- 계좌객체 한개의 데이타를 저장하기위한멤버변수를 가지고있다
 */
public class Account implements Serializable{
	/*
	 * 속성(멤버변수)
	 */
	private int no;//계좌번호
	private String owner;//계좌주
	private int balance;//잔고
	private double iyul;//이율
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Account(int no, String owner, int balance, double iyul) {
		this.no = no;
		this.owner = owner;
		this.balance = balance;
		this.iyul = iyul;
	}


	/*
	 * 행위(멤버메쏘드)
	 * 
	 * 입금
	 * 출금
	 * 계좌정보출력
	 */
	public void setAccountData(int no,String owner,int balance,double iyul) {
		this.no=no;
		this.owner=owner;
		this.balance=balance;
		this.setIyul(iyul);
	}
	
	public void deposit(int m) {
		this.balance = this.balance + m;
	}
	public void withdraw(int m){
		if(this.balance-m < 0) {
			return;
		}
		this.balance=this.balance-m;
		return;
	}
	public static void headerPrint() {
		System.out.println("---------------------------------------");
		System.out.println("번호\t이름\t잔고\t이율");
		System.out.println("---------------------------------------");
	}
	public void print() {
		System.out.println(
				this.no+"\t"+this.owner+"\t"+this.balance+"\t"+this.iyul);
	}
	public void printNameFormat() {
		/*
		 1.첫글자 대문자
		 2.5자리로출력
		 3.첫글자이외에는****(4개)
		---------------------------------------
		번호	이름	 잔고	 이율
		---------------------------------------
		1111	K****	 89000	 1.3
		2222	A****	 45000	 2.7
		3333	F****	 23000	 4.7
		4444	X****	 34000	 6.7
		5555	H****	 78000	 3.7
		6666	K****	 99000	 5.7
		7777	K****	 89000	 4.7
		8888	Q****    91000	 1.7
		9999	M****    12000	 0.7
		*/	
		System.out.println(
				this.no+"\t"+this.owner+"\t"+this.balance+"\t"+this.iyul);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.no+"\t"+this.owner+"\t"+this.balance+"\t"+this.iyul+"\n";
	}
	
	//getter,setter
	/*
	 * alt + shift + s
	 */
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public double getIyul() {
		return iyul;
	}
	public void setIyul(double iyul) {
		this.iyul = iyul;
	}
	
}
