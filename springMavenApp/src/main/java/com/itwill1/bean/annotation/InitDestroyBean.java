package com.itwill1.bean.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component(value="initDestroyBean")
public class InitDestroyBean {
	public InitDestroyBean() {
		System.out.println("### InitDestroyBean() 기본 생성자");
	}
	@PostConstruct
	public void myInit() {
		System.out.println("### InitDestroyBean.myInit() 메소드 호출");
	}
	@PreDestroy
	public void myDestroy() {
		System.out.println("### InitDestroyBean.myDestroy() 메소드 호출");
	}
	
}
