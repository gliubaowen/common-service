/**
 * 
 */
package com.ibm.common.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibm.common.core.ftp.FtpClientService;
import com.ibm.common.core.ssh.SftpClientService;

/**
 * 配置类
 * 
 * @author LiuBaoWen
 *
 */
@Configuration
public class CommonServiceConfig {

	/**
	 * 开启sftp客户端服务
	 * 
	 * @author LiuBaoWen
	 * @return
	 */
	@Bean
	public SftpClientService sftpService() {
		return new SftpClientService();
	}

	/**
	 * 开启ftp客户端服务
	 * 
	 * @author LiuBaoWen
	 * @return
	 */
	@Bean
	public FtpClientService ftpClientService() {
		return new FtpClientService();
	}

}
