package dao.address.third;

import java.util.ArrayList;

import dao.address.Address;

/*
이름      널?       유형            
------- -------- ------------- 
NO      NOT NULL NUMBER(4)     
ID               VARCHAR2(20)  
NAME             VARCHAR2(50)  
PHONE            VARCHAR2(50)  
ADDRESS          VARCHAR2(100) 
 */
public class AddressDao3TestMain {

	public static void main(String[] args) throws Exception{
		AddressDao3 addressDao3=new AddressDao3();
		
		System.out.println("-----------1.create-----------");
		int insertRowCount =
				addressDao3.create(new Address("yyyy","JACKIE","917-774-9652","NY"));
		insertRowCount = addressDao3.create(new Address("nnnn","TACKIE","917-777-9999","LA"));
		System.out.println("create:"+insertRowCount);
		
		
		
		System.out.println("-----------2.update-----------------");
		int updateRowCount =
				addressDao3.update(new Address(16,"yyyy","RACKIE","999-888-7777","CA"));
		System.out.println("update:"+updateRowCount);
		
		
		
		System.out.println("------------3.delete---------------------");
		System.out.println("delete:"+addressDao3.delete(21));
		
		
		
		System.out.println("------------4.selectByNo----------------");
		Address findAddress=addressDao3.selectByNo(9);
		System.out.println(findAddress);
		
		
		System.out.println("------------5.selectAll--------------------");
		ArrayList<Address> findAddressList=addressDao3.selectAll();
		for (Address address : findAddressList) {
			System.out.println(findAddressList);			
		}
		
	}

}
