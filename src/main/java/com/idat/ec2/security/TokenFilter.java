package com.idat.ec2.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.idat.ec2.security.JWTUtil;
import com.idat.ec2.security.UserDetailService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class TokenFilter extends OncePerRequestFilter{
	@Autowired
	private UserDetailsService service;
	
	@Autowired
	private JWTUtil util;	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String tokenHeader = request.getHeader("Authorization");
		String token=null ;
		String username=null;
		
		if(tokenHeader!=null && tokenHeader.startsWith("Bearer ")) {
			token=tokenHeader.substring(7);
			try {
				username=util.getUsernameFromToken(token);
			} catch (IllegalArgumentException e) {
				// TODO: handle exception
				logger.warn("Token con campo invalido");
			} catch (ExpiredJwtException e) {
				// TODO: handle exception
				logger.warn("Token expirado");
			}
		}else {
			logger.warn("Token invalido");
		}
		
		if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails user=this.service.loadUserByUsername(username);
			
			if(util.validateToken(token, user)) {
				
			}
		}
	}
}
