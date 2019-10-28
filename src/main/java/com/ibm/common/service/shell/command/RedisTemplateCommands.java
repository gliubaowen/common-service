/**
 * 
 */
package com.ibm.common.service.shell.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author LiuBaoWen
 *
 */
@ShellComponent
public class RedisTemplateCommands {

	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * RedisTemplate get
	 * 
	 * @author LiuBaoWen
	 * @return
	 */
	@ShellMethod(value = "RedisTemplate get.", key = "get")
	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * RedisTemplate set
	 * 
	 * @author LiuBaoWen
	 * @param key
	 * @param value
	 */
	@ShellMethod(value = "RedisTemplate set.", key = "set")
	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

}
