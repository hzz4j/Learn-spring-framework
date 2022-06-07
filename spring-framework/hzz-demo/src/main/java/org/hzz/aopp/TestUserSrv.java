package org.hzz.aopp;

import org.springframework.stereotype.Service;

@Service
public class TestUserSrv implements IService{
	public void test(){
		System.out.println("user say hello");
	}
}
