package com.playtomic.tests.wallet;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
@ComponentScan(basePackages = {"com.playtomic.tests.wallet"})
public class WalletConfiguration {

	RestTemplate spyRestTemplate = Mockito.spy(new RestTemplate());
	
	@Bean
	public RestTemplate restTemplate() {
		return  spyRestTemplate;
	}
	
	@Bean
	public RestTemplateBuilder restTemplateBuilder() {
		RestTemplateBuilder rtb = Mockito.spy(new RestTemplateBuilder());
		Mockito.doReturn(rtb).when(rtb).errorHandler(Mockito.any());
		Mockito.doReturn(restTemplate()).when(rtb).build();
		return rtb;
	}
}
