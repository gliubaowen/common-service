/**
 * 
 */
package com.lbw.common.service.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lbw.common.service.CommonServiceApplication;
import com.lbw.common.service.entity.Customer;
import com.lbw.common.service.repository.CustomerRepository;

/**
 * @author LiuBaoWen
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(CommonServiceApplication.class);

	@Autowired
	private CustomerRepository repository;

	@Test
	public void testDemo() {
		// save a few customers
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));

		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
		}
		log.info("");

		// fetch an individual customer by ID
		Customer customer = repository.findById(1L).get();
		log.info("Customer found with findById(1L):");
		log.info("--------------------------------");
		log.info(customer.toString());
		log.info("");

		// fetch customers by last name
		log.info("Customer found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		repository.findByLastName("Bauer").forEach(bauer -> {
			log.info(bauer.toString());
		});
		// for (Customer bauer : repository.findByLastName("Bauer")) {
		// log.info(bauer.toString());
		// }
		log.info("");

		log.info("Customer found with count('Bauer'):");
		log.info("--------------------------------------------");
		long count = repository.count();
		log.info("{}", count);
		log.info("");
	}

}
