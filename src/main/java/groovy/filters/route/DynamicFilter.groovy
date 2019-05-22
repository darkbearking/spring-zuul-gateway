package groovy.filters.route;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;

class DynamicFilter extends ZuulFilter{

	public Object run() {
		System.out.println("========這是一個動態加載的過濾器：DynamicFilter");
		return null;
	}

	public boolean shouldFilter() {
		return true;
	}

	public String filterType() {
		return FilterConstants.ROUTE_TYPE;
	}

	public int filterOrder() {
		return 3;
	}
}