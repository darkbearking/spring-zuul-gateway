package org.dark;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;

@SpringBootApplication
@EnableZuulProxy
public class GateWayApp {

	/**
	 * 只要我們的代碼中，有這樣一段存在，那麼我們就可以在不必重啟的情況下，任意添加或減少groovy格式的過濾器文件
	 * 同時也會自動生效的。
	 */
	@PostConstruct
	public void zuulInit() {
		FilterLoader.getInstance().setCompiler(new GroovyCompiler());
		//讀取配置，獲取本級目錄
		String scriptRoot = System.getProperty("zuul.filter.root", "groovy/filters");
		//獲取刷新間隙
		String refreshInterval = System.getProperty("zuul.filter.refreshInterval", "5");
		if(scriptRoot.length() > 0) {
			scriptRoot = scriptRoot + File.separator;
		}
		try {
			FilterFileManager.setFilenameFilter(new com.netflix.zuul.groovy.GroovyFileFilter());
			FilterFileManager.init(Integer.parseInt(refreshInterval), scriptRoot + "pre",
					scriptRoot + "route", scriptRoot + "post");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(GateWayApp.class).web(true).run(args);
	}

}
