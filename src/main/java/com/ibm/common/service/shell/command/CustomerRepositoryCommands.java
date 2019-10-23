/**
 * 
 */
package com.ibm.common.service.shell.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.alibaba.fastjson.JSON;
import com.ibm.common.service.entity.Customer;
import com.ibm.common.service.repository.CustomerRepository;

/**
 * @author LiuBaoWen
 *
 */
@ShellComponent
public class CustomerRepositoryCommands {

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * 
	 * @author LiuBaoWen
	 * @return
	 */
	@ShellMethod(value = "CustomerRepository count.", key = "count")
	public long count() {
		return customerRepository.count();
	}

	/**
	 * 
	 * @author LiuBaoWen
	 * @param param
	 * @return
	 */
	@ShellMethod(value = "CustomerRepository findById.", key = "findById")
	public String findById(long param) {
		Customer customer = customerRepository.findById(param).get();
		return JSON.toJSONString(customer);
	}

	/**
	 * 
	 * @author LiuBaoWen
	 * @param firstName
	 * @param lastName
	 */
	@ShellMethod(value = "CustomerRepository save.", key = "save")
	public void save(String firstName, String lastName) {
		Customer entity = new Customer(firstName, lastName);
		customerRepository.save(entity);
	}

}
