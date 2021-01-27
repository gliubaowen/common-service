/**
 * 
 */
package com.lbw.common.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lbw.common.core.ftp.FtpClientService;
import com.lbw.common.core.ssh.SftpClientService;
import com.lbw.common.service.runner.CustomerApplicationRunner;

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

	/**
	 * ApplicationRunner
	 * 
	 * @author LiuBaoWen
	 * @return
	 */
	@Bean
	public CustomerApplicationRunner customerApplicationRunner() {
		return new CustomerApplicationRunner();
	}

}
