package com.itwill.account.ui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itwill.account.Account;
import com.itwill.account.AccountService;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AccountPanel extends JPanel {
	/*************************************/
	private AccountService accountService;
	/*
	private MemberService memberService;
	private ProductService productService;
	private OrderService orderService;
	private CartService cartService;
	*/
	/**********************************/
	
	private JTabbedPane accountTP;
	private JTextField noTF;
	private JTextField ownerTF;
	private JTextField balanceTF;
	private JComboBox iyulCB;
	private JTextArea accountListTA;
	private JTextField searchTF;
	private JComboBox searchTypeCB;

	/**
	 * Create the panel.
	 */
	public AccountPanel() {
		setBackground(Color.PINK);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("계좌추가");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountTP.setSelectedIndex(0);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("계좌리스트");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountTP.setSelectedIndex(1);
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("계좌찾기");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountTP.setSelectedIndex(2);
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("입금");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountTP.setSelectedIndex(3);
			}
		});
		panel.add(btnNewButton_3);
		
		accountTP = new JTabbedPane(JTabbedPane.TOP);
		add(accountTP, BorderLayout.CENTER);
		
		JPanel addP = new JPanel();
		addP.setBackground(Color.PINK);
		accountTP.addTab("계좌추가", null, addP, null);
		addP.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("번호");
		lblNewLabel.setBounds(80, 38, 57, 15);
		addP.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setBounds(80, 79, 57, 15);
		addP.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("잔고");
		lblNewLabel_2.setBounds(80, 118, 57, 15);
		addP.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("이율");
		lblNewLabel_3.setBounds(80, 161, 57, 15);
		addP.add(lblNewLabel_3);
		
		noTF = new JTextField();
		noTF.setBounds(149, 35, 116, 21);
		addP.add(noTF);
		noTF.setColumns(10);
		
		ownerTF = new JTextField();
		ownerTF.setBounds(149, 76, 116, 21);
		addP.add(ownerTF);
		ownerTF.setColumns(10);
		
		balanceTF = new JTextField();
		balanceTF.setBounds(149, 115, 116, 21);
		addP.add(balanceTF);
		balanceTF.setColumns(10);
		
		iyulCB = new JComboBox();
		iyulCB.setModel(new DefaultComboBoxModel(new String[] {"0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8"}));
		iyulCB.setBounds(149, 158, 116, 21);
		addP.add(iyulCB);
		
		JButton btnNewButton_4 = new JButton("추가");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					accountAdd();
			}
		});
		btnNewButton_4.setBounds(86, 205, 97, 23);
		addP.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("취소");
		btnNewButton_5.setBounds(195, 205, 97, 23);
		addP.add(btnNewButton_5);
		
		JPanel listP = new JPanel();
		listP.setBackground(Color.ORANGE);
		accountTP.addTab("계좌리스트", null, listP, null);
		listP.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 43, 487, 242);
		listP.add(scrollPane);
		
		accountListTA = new JTextArea();
		scrollPane.setViewportView(accountListTA);
		
		searchTypeCB = new JComboBox();
		searchTypeCB.setModel(new DefaultComboBoxModel(new String[] {"전체", "번호", "이름", "잔고", "이율"}));
		searchTypeCB.setBounds(52, 11, 77, 21);
		listP.add(searchTypeCB);
		
		searchTF = new JTextField();
		searchTF.setBounds(141, 10, 50, 23);
		listP.add(searchTF);
		searchTF.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("검색");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountSearch();
			}
		});
		btnNewButton_7.setBounds(214, 10, 70, 23);
		listP.add(btnNewButton_7);
		
		JPanel searchP = new JPanel();
		searchP.setBackground(Color.YELLOW);
		accountTP.addTab("계좌찾기", null, searchP, null);
		searchP.setLayout(null);
		
		JPanel depositP = new JPanel();
		depositP.setBackground(Color.GREEN);
		accountTP.addTab("입금", null, depositP, null);
		depositP.setLayout(null);

		accountTP.setSelectedIndex(0);
		myServiceInit();
	}
	/***********서비스객체들생성***********************/
	private void myServiceInit(){
		try {
			accountService=new AccountService();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**********계좌추가**************/
	public void accountAdd() {
		String noStr=noTF.getText();
		String ownerStr=ownerTF.getText();
		String balanceStr=balanceTF.getText();
		String iyulStr=(String)iyulCB.getSelectedItem();
		if(noStr.equals("")||ownerStr.equals("")||
		   balanceStr.equals("")||iyulStr.equals("")) {
			JOptionPane.showMessageDialog(null, "입력하세요!!!");
			noTF.requestFocus();
			return;
		}
		try {
			int no = Integer.parseInt(noStr);
			int balance=Integer.parseInt(balanceStr);
			double iyul=Double.parseDouble(iyulStr);
			Account newAccount=new Account(no,ownerStr,balance,iyul);
			if(accountService.addAccount(newAccount)) {
				//추가성공
				noTF.setText("");
				ownerTF.setText("");
				balanceTF.setText("");
				iyulCB.setSelectedIndex(0);
				accountTP.setSelectedIndex(1);
				
			}else {
				//추가실패
				JOptionPane.showMessageDialog(null, "계좌번호중복입니다.");
				noTF.requestFocus();
				noTF.setSelectionStart(0);
				noTF.setSelectionEnd(noStr.length());
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "애러발생");
			e.printStackTrace();
		}
	
	}
	/**********계좌검색************/
	public void accountSearch() {
		try {
			String searchType =(String)searchTypeCB.getSelectedItem();
			ArrayList<Account> accountList=new ArrayList<Account>();
			switch (searchType) {
			case "전체":
				accountList = accountService.findByAll();
				break;
			case "번호":
				String noStr=searchTF.getText();
				if(noStr.equals("")) {
					JOptionPane.showMessageDialog(null, "번호를 입력하세요!!");
					searchTF.requestFocus();
					return;
				}
				Account findAccount=
						accountService.findAccountByNo(Integer.parseInt(noStr));
				if(findAccount!=null) {
					accountList.add(findAccount);
				}
				break;
			case "이름":
				String ownerStr=searchTF.getText();
				if(ownerStr.equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요!!");
					searchTF.requestFocus();
					return;
				}
				accountList = accountService.findAccountByOwner(ownerStr);
				break;
			case "잔고":
				
				break;
			case "이율":
				
				break;
			}
			String accountListStr="";
			for (Account account : accountList) {
				accountListStr+=account.toString()+"\n";
			}
			accountListTA.setText(accountListStr);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
















