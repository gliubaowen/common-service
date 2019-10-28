/**
 * 
 */
package com.ibm.common.service.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
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
public class StringRedisTemplateTest {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Test
	public void testDemo() {
		String string = redisTemplate.opsForValue().get("mykey");
		System.out.println(string);
	}

}
