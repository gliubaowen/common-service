/**
 * 
 */
package com.lbw.common.service.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * 项目启动后运行
 * 
 * @author LiuBaoWen
 *
 */
public class CustomerApplicationRunner implements ApplicationRunner {

	/**
	 *
	 * @author LiuBaoWen
	 * @see org.springframework.boot.ApplicationRunner#run(org.springframework.boot.ApplicationArguments)
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("通过实现ApplicationRunner接口，在spring boot项目启动后打印参数");
		String[] sourceArgs = args.getSourceArgs();
		for (String arg : sourceArgs) {
			System.out.print(arg + " ");
		}
	}

}
