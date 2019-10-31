/**
 * 
 */
package com.ibm.common.service.redis;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiuBaoWen
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.JVM)
public class StringRedisTemplateTest {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Test
	public void testSet() {
		redisTemplate.opsForValue().set("key", "value");
	}

	@Test
	public void testGet() {
		String value = redisTemplate.opsForValue().get("key");
		assert "value".equals(value);
	}

	@Test
	public void testDelete() {
		assert redisTemplate.delete("key");
	}

}
