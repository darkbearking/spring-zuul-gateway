package org.dark.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.FilterType;

import com.netflix.zuul.ZuulFilter;

/**
 * 由於zuul裡面有各種過濾器的機制，因此，我們在這裡搞一個自定義的過濾器，來理解一下zuul中的過濾器的邏輯
 * 參照資料就是“架構圖2”中的那三類zuul自帶的過濾器。
 * @author liwei
 *
 */
public class MyFilter extends ZuulFilter {

	@Override
	public Object run() {
		System.out.println("執行MyFilter 過濾器");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// 這裡的true或false表示是否執行了當前過濾器本身（MyFilter），當前設為總是執行
		return true;
	}

	@Override
	public String filterType() {
		//架構圖2中包括三類過濾器 pre過濾器、routing過濾器、post過濾器
		//這裡表示把當前過濾器設置為在“路由階段”執行，即作為一個“routing過濾器”
		return FilterConstants.ROUTE_TYPE;
	}

	@Override
	public int filterOrder() {
		// 因為當前過濾器是“routing過濾器”，由架構圖2可知，這個階段的三種默認過濾器的優先級分別為10、100、500
		//那麼我們要想讓當前過濾器的執行優先級最高，那麼只要是一個小於10的數字即可。所以我們設為5
		return 5;
	}

}
