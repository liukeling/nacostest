package com.lkl.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class TestRouteFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterType.ROUTE.getType();
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("==============test routing filter execute=====");
        return null;
    }
}
