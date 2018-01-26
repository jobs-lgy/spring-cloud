package com.example.demo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 * @author leongfeng created on 2018-01-25.
 */
@Component
public class ExceptionFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("This is a pre filter, it will throw a RuntimeException");
//        throwsError();
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulFilter filter = (ZuulFilter)ctx.get("filted.filter");
        if (filter != null && filter.filterType().equals("post")) {
            return true;
        }
        return false;
    }

    private void throwsError() {
        throw new RuntimeException("pre exception....");
    }
}

