/**
 * 
 */
package com.ibm.common.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Common-Controller
 * 
 * @author LiuBaoWen
 *
 */
@RestController
//@RequestMapping("service")
public class CommonServiceController {

	@RequestMapping("/")
	public String index() {

		return "Hello Index !";
	}

	@RequestMapping("helloworld")
	public String helloWorld() {

		return "Hello World";
	}

	@GetMapping("test")
	public String test() {
		return "Hello test";
	}

}
