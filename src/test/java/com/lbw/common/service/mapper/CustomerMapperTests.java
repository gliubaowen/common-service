/**
 * 
 */
package com.lbw.common.service.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lbw.common.service.entity.Customer;
import com.lbw.common.service.repository.mapper.CustomerRepositoryMapper;

/**
 * @author LiuBaoWen
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerMapperTests {

	@Autowired
	private CustomerRepositoryMapper customerMapper;

	@Test
	public void test() {
		Iterable<Customer> findAll = customerMapper.findAll();
		System.out.println(findAll);
	}

}
