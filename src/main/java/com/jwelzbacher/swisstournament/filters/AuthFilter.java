package com.jwelzbacher.swisstournament.filters;

import com.jwelzbacher.swisstournament.Constants;
import com.jwelzbacher.swisstournament.exceptions.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        System.out.println("here at start of filter");

        String authHeader = httpRequest.getHeader("Authorization");
        System.out.println(authHeader);
        if (authHeader != null) {
            String[] authHeaderArr = authHeader.split("Bearer");
            if (authHeaderArr.length > 1 && authHeaderArr[1] != null) {
                String token = authHeaderArr[1];
                try {
                    System.out.println("here inside the try");
                    Claims claims = Jwts.parser().setSigningKey((Constants.API_SECRET_KEY)).parseClaimsJws(token).getBody();
                    System.out.println("here after jwt parse");
                    httpRequest.setAttribute("username", claims.get("username").toString());
                    System.out.println("here after set username");
                    httpRequest.setAttribute("id", claims.get("id"));
                    System.out.println("here" + httpRequest.getAttribute("username").toString());
                } catch (Exception e) {
                    System.out.println("here inside the catch");
                    httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Invalid/expired token");
                    throw new UnauthorizedException("Invalid/expired token");
                }
            } else {
                httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be: Bearer [token]");
            }
        } else {
            httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be provided");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
