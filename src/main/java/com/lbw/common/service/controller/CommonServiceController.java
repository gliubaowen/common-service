/**
 * 
 */
package com.lbw.common.service.controller;

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
@RequestMapping("service")
public class CommonServiceController {

	@GetMapping("")
	public String index() {
		return "Hello Index !";
	}

	@GetMapping("helloworld")
	public String helloWorld() {
		return "Hello Common Service!";
	}

}
