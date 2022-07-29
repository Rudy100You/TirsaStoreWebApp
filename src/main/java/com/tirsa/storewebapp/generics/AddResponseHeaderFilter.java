package com.tirsa.storewebapp.generics;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/filter-response-header/*")
public class AddResponseHeaderFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
    FilterChain chain) throws IOException, ServletException {
      HttpServletResponse httpServletResponse = (HttpServletResponse) response;
      httpServletResponse.setHeader(
        "transactionid", "Value-Filter");
      chain.doFilter(request, response);
  }
    
}
