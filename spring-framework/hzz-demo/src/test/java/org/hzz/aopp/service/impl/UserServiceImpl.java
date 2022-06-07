package org.hzz.aopp.service.impl;

import org.hzz.aopp.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Override
	public void test() {
		System.out.println("userservice test");
//		throw new NullPointerException();
	}

	@Override
	public void testABC(String name,int num) {
		System.out.println("userservice testABC");
	}
}
