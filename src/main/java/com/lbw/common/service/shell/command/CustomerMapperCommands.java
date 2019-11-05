/**
 * 
 */
package com.lbw.common.service.shell.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.alibaba.fastjson.JSON;
import com.lbw.common.service.entity.Customer;
import com.lbw.common.service.mapper.CustomerMapper;

/**
 * @author LiuBaoWen
 *
 */
@ShellComponent
public class CustomerMapperCommands {

	@Autowired
	private CustomerMapper customerMapper;

	/**
	 * 
	 * @author LiuBaoWen
	 * @return
	 */
	@ShellMethod(value = "CustomerMapper count.", key = "mfindById")
	public String mfindById(String id) {
		Customer findById = customerMapper.findById(id);
		return JSON.toJSONString(findById);
	}

	@ShellMethod(value = "CustomerMapper mcount.", key = "mcount")
	public int count() {
		int count = customerMapper.count();
		return count;
	}

}
