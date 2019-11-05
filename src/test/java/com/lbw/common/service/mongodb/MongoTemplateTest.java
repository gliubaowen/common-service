/**
 * 
 */
package com.lbw.common.service.mongodb;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.lbw.common.service.entity.User;

/**
 * @author LiuBaoWen
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTemplateTest {

	@Autowired
	private MongoTemplate MongoTemplate;

	@Test
	public void testSave() {
		User user = new User("LiuBaoWen", "passwd");
		user.setId(4l);
		MongoTemplate.save(user);
	}

	@Test
	public void testFindAll() {
		List<User> findAll = MongoTemplate.findAll(User.class);
		System.out.println(JSON.toJSONString(findAll));
	}
}
