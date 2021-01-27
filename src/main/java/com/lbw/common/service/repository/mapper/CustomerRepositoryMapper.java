/**
 * 
 */
package com.lbw.common.service.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.CrudRepository;

import com.lbw.common.service.entity.Customer;

/**
 * CustomerRepositoryMapper
 * 
 * @author LiuBaoWen
 *
 */
@Mapper
public interface CustomerRepositoryMapper extends CrudRepository<Customer, Long> {

	@Select("SELECT * FROM CUSTOMER WHERE id = #{id}")
	@Results({ @Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name") })
	Customer findById(@Param("id") String id);

	@Select("SELECT count(*) FROM customer")
	long count();

	List<Customer> findByLastName(String lastName);
	
//	@Select("SELECT count(*) FROM customer")
//	long test();
	
}
