package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController 
public class CurrenyCalculatorController {
	
	@GetMapping("/curreny-calculate/from/{from}/to/{to}/quantity/{quantity}")
	public CurrenyBean calculateCurrency
		(@PathVariable String from, @PathVariable String to, @PathVariable Integer quantity) {
		Map<String, String> valueMap = new HashMap<String, String>();
		valueMap.put("from", from);
		valueMap.put("to", to);
		ResponseEntity<CurrenyBean> response = new RestTemplate().getForEntity(
										"http://localhost:8000/curreny-exchange/from/{from}/to/{to}", 
										CurrenyBean.class, 
										valueMap);
		CurrenyBean currenyBean = response.getBody();
		currenyBean.setQuantity(quantity);
		currenyBean.setCalculatedAmount(quantity * currenyBean.getConversionMultiply());
		return currenyBean;
	} 
	
	@Autowired
	CurrenyExchangeProxy currenyExchangeProxy;
	
	@GetMapping("/curreny-calculate-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrenyBean calculateCurrencyFeign
		(@PathVariable String from, @PathVariable String to, @PathVariable Integer quantity) {
		CurrenyBean currenyBean = currenyExchangeProxy.getExchangeValue(from, to);
		currenyBean.setQuantity(quantity);
		currenyBean.setCalculatedAmount(quantity * currenyBean.getConversionMultiply()*2);
		return currenyBean;
	}
}
