package com.itwill1.bean.annotation;

import org.springframework.stereotype.Component;

@Component("CreateBean2")
public class CreateBean2 {
	public CreateBean2() {
		System.out.println("### CreateBean2() 기본 생성자");
	}
	public void method1() {
		System.out.println("### CreateBean2().method1()메소드 호출");
		
	}
}
