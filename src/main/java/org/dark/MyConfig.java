package org.dark;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通過正則表達式的方式來實現路由和跳轉
 * @author liwei
 *
 */
@Configuration
public class MyConfig {

	/**
	 * 訪問網關的 /xxxxx/**.將會被路由到spring-zuul-xxxxx服務進行處理。
	 * @return
	 */
	@Bean
	public PatternServiceRouteMapper patternServiceRouteMapper() {
		//正則表達式
		//對應到這裡，就是所有針對/sale/**的請求都會被路由到spring-zuul-sale中。其中sale是對應module可變的那部分
		//當這裡做了配置之後，我們就可以刪除掉application.yml中
		//sale: 
		//  path: /sale/** 
		//  serviceId: spring-zuul-sale這部分的內容了。
	      
	      
		return new PatternServiceRouteMapper("(spring)-(zuul)-(?<module>.+)", "${module}/**");
	}
}
