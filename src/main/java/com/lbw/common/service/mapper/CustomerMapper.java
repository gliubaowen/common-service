/**
 * 
 */
package com.lbw.common.service.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.lbw.common.service.entity.Customer;

/**
 * CustomerMapper
 * 
 * @author LiuBaoWen
 *
 */
@Mapper
public interface CustomerMapper {

	@Select("SELECT * FROM CUSTOMER WHERE id = #{id}")
	@Results({ @Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name") })
	Customer findById(@Param("id") String id);

	@Select("SELECT count(*) FROM customer")
	int count();

}
