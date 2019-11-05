/**
 * 
 */
package com.lbw.common.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lbw.common.service.entity.Customer;

/**
 * 客户查询Repository
 * 
 * @author LiuBaoWen
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

}
