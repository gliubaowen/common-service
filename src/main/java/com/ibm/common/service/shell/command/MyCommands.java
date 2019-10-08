/**
 * 
 */
package com.ibm.common.service.shell.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author LiuBaoWen
 *
 */
@ShellComponent
public class MyCommands {

	/**
	 * 加法命令
	 * 
	 * @author LiuBaoWen
	 * @param a
	 * @param b
	 * @return
	 */
	@ShellMethod(value = "Add numbers.", key = "sum")
	public int add(int a, int b) {
		return a + b;
	}
}
