/**
 * 
 */
package com.lbw.common.service.webservices.impl;

import javax.jws.WebService;

import com.lbw.common.service.webservices.WeatherInterface;

/**
 * SEI Impl Demo
 * 
 * @author LiuBaoWen
 *
 */
@WebService
public class WeatherInterfaceImpl implements WeatherInterface {

	/**
	 *
	 * @author LiuBaoWen
	 * @see com.lbw.common.service.webservices.WeatherInterface#queryWeather(java.lang.String)
	 * @param cityName
	 * @return
	 */
	@Override
	public String queryWeather(String cityName) {
		System.out.println("城市名" + cityName);
		String weather = "晴天";
		return weather;
	}

}
