package com.ibm.common.service.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTest {

	@Test
	public void test() {
		System.out.println("Hello Spring Boot");
	}

}
