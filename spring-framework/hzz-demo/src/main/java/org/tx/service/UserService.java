package org.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.tx.sync.TransactionsynchronizationImpl;

@Service
public class UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UserService userService;

	@Transactional
	public void test(){
		TransactionSynchronizationManager.registerSynchronization(
				new TransactionsynchronizationImpl("test()"));
		System.out.println("--------------test start----------------------");
		String sql = "INSERT into `user`(id,`name`) VALUES(2,'hzz2')";
		jdbcTemplate.execute(sql);
		try{
			userService.a();
		}catch(Exception e){}

		System.out.println("--------------test finished-------------------");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void a(){
		TransactionSynchronizationManager.registerSynchronization(
				new TransactionsynchronizationImpl("a()"));
		System.out.println("--------------a start-------------------------");
		String sql = "INSERT into `user`(id,`name`) VALUES(3,'hzz3')";
		jdbcTemplate.execute(sql);

		System.out.println("--------------a finished----------------------");
		throw new NullPointerException();
	}
}
