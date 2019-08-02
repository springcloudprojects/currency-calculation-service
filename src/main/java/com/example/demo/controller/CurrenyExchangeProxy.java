package com.example.demo.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000/")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "API-Gateway")
@RibbonClient(name = "currency-exchange-service")
public interface CurrenyExchangeProxy{

	@GetMapping("/currency-exchange-service/curreny-exchange/from/{from}/to/{to}")
	public CurrenyBean getExchangeValue(@PathVariable String from, @PathVariable String to);
}
