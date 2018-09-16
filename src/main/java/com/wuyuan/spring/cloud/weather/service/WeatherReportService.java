package com.wuyuan.spring.cloud.weather.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wuyuan.spring.cloud.weather.vo.Weather;
import com.wuyuan.spring.cloud.weather.vo.WeatherResponse;

/**
 * Weather Report Service.
 * 
 * @since 1.0.0 2017年11月24日
 * @author Ma 
 */

@FeignClient("weather-data-server-eureka")
public interface WeatherReportService {

	/**
	 * 根据城市ID查询天气信息
	 * @param cityId
	 * @return
	 */
	@GetMapping("/weather/cityId/{cityId}")
	WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
	
	@GetMapping("/cityName/{cityName}")
	Weather getDataByCityName(@PathVariable("cityName") String cityName);
}
