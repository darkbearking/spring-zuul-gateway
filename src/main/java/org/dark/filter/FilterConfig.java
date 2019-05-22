package org.dark.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

	@Bean
	public MyFilter myfilter() {
		return new MyFilter();
	}
}
