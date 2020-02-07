package com.bit.config;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyListener2 implements HttpSessionAttributeListener {
//	public class MyListener2 implements HttpSessionActivationListener {
// 세션생성과 소멸
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("addAttr()");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("removeAttr()");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("editAttr()");
	}
	

}
