package com.itwill1.bean.annotation;

import org.springframework.stereotype.Component;

@Component("CreateBean3")
public class CreateBean3 {
	public CreateBean3() {
		System.out.println("### CreateBean3() 기본 생성자");
	}
	public void method1() {
		System.out.println("### CreateBean3().method1()메소드 호출");
		
	}
}
