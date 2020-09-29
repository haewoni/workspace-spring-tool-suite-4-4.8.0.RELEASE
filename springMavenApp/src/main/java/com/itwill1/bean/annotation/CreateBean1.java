package com.itwill1.bean.annotation;

import org.springframework.stereotype.Component;

@Component("CreateBean1")
public class CreateBean1 {
	public CreateBean1() {
		System.out.println("### CreateBean1() 기본 생성자");
	}
	public void method1() {
		System.out.println("### CreateBean1().method1()메소드 호출");
		
	}
}
