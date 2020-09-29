package com.itwill1.bean.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singletonBean")
@Scope(value="singleton")
public class SingletonScopeBean {
	public SingletonScopeBean() {
		System.out.println("SingletonBean() 기본 생성자:"+this);
	}
}
