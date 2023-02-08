package com.example.Admin.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.Admin.security.AdminLoginService;
import com.example.Admin.security.Adminlogindetails;

@Component

public class Filters extends OncePerRequestFilter
{
	
	@Autowired
	public Utils util;
	
	@Autowired
	public AdminLoginService service;
	


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String header = request.getHeader("Authentication");
		String token=null;
		String user= null;
		
		if(header!= null && header.startsWith("Bearer")) {
			token= header.substring(6);
			user = util.getAdminUsername(token);
		}
		
		if(user!=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			Adminlogindetails currentuser=  (Adminlogindetails) service.loadUserByUsername(user);
			
			if(util.validateToken(token, currentuser)) {
				
			UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(currentuser,
					null,currentuser.getAuthorities());
			userToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(userToken);
			
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
