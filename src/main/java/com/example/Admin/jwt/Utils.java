package com.example.Admin.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.Admin.security.Adminlogindetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class Utils implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final long time=72*24*60*60*1000;
	
	private String SECRET_KEY = "Yp3s6v9y$B?E(H+MbQeThWmZq4t7w!z%";
	
	 public String generateToken(Adminlogindetails userDetails) {
	        Map<String, Object> claims = new HashMap<>();
	        return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
	        		.setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + time ))
	                .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
	    }
	 
	 private Claims extractClaims(String token) {
	        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	    }

    public  String getAdminUsername(String token) {
        return  extractClaims(token).getSubject();
    }


    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getAdminUsername(token);
        Boolean isTokenExpired=extractClaims(token).getExpiration().before(new Date());
        return (username.equals(userDetails.getUsername()) && !isTokenExpired);
    }

}















