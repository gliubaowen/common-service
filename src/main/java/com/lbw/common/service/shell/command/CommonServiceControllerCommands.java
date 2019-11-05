/**
 * 
 */
package com.lbw.common.service.shell.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.lbw.common.service.controller.CommonServiceController;

/**
 * @author LiuBaoWen
 *
 */
@ShellComponent
public class CommonServiceControllerCommands {

	@Autowired
	private CommonServiceController commonServiceController;

	/**
	 * 
	 * @author LiuBaoWen
	 * @param a
	 * @param b
	 * @return
	 */
	@ShellMethod(value = "Controller helloWorld.", key = "helloworld")
	public String helloWorld() {
		return commonServiceController.helloWorld();
	}

}
