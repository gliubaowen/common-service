/**
 * 
 */
package com.ibm.common.service.ssh;

import java.util.Vector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.ibm.common.core.ssh.SftpService;
import com.jcraft.jsch.SftpException;

/**
 * @author LiuBaoWen
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SftpServiceTest {

	@Autowired
	private SftpService sftpService;

	@Test
	public void testListFiles() {

		sftpService.login();
		String directory = null;
		try {
			Vector<?> listFiles = sftpService.listFiles(directory);
			System.out.println(JSON.toJSONString(listFiles));
		} catch (SftpException e) {
			e.printStackTrace();
		}
		System.out.println("Hello");
	}

}
