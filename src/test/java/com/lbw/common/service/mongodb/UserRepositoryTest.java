/**
 * 
 */
package com.lbw.common.service.mongodb;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.lbw.common.service.entity.User;
import com.lbw.common.service.repository.mongodb.UserRepository;

/**
 * @author LiuBaoWen
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testSave() {
		User user = new User("LiuBaoWen", "passwd");
		user.setId(5l);
		User save = userRepository.save(user);
		System.out.println(JSON.toJSONString(save));
	}

	@Test
	public void testFindAll() {
		List<User> findAll = userRepository.findAll();
		System.out.println(JSON.toJSONString(findAll));
	}

}
