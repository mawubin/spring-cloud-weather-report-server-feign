package com.wuyuan.spring.cloud.weather.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wuyuan.spring.cloud.weather.service.CityDataService;
import com.wuyuan.spring.cloud.weather.service.WeatherReportService;
import com.wuyuan.spring.cloud.weather.vo.City;
import com.wuyuan.spring.cloud.weather.vo.Weather;
import com.wuyuan.spring.cloud.weather.vo.WeatherResponse;
/**
 * Weather Report Controller.
 * 
 * @since 1.0.0 2017年11月24日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
	private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);  

	@Autowired
	private WeatherReportService weatherReportService;
	@Autowired
	private CityDataService citydataservice;
	
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		// 获取城市ID列表
		// TODO 改为由城市数据API微服务来提供数据
		List<City> cityList = null;
		
		try {
			
			// TODO 改为由城市数据API微服务提供数据
			cityList=citydataservice.listCity();
			
		} catch (Exception e) {
			logger.error("Exception!", e);
		}
		
		model.addAttribute("title", "天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		Weather wea=weatherReportService.getDataByCityId(cityId).getData();
		model.addAttribute("weatherdata", wea);
		return new ModelAndView("weather/temp/report", "reportModel", model);
	}

}
