package com.example.logisticprogram.service.security;

import com.example.logisticprogram.service.domain.UserDomainService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = HttpHeaders.AUTHORIZATION;

    @Value("${jwt.properties.tokenPrefix}")
    private String prefix;

    private final UserDomainService userDomainService;
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        var authHeader = request.getHeader(AUTHORIZATION_HEADER);


        if (authHeader == null || authHeader.isEmpty() || !authHeader.startsWith(prefix)) {
            filterChain.doFilter(request, response);
            return;
        }

        var jwtToken = authHeader.substring(prefix.length()).trim();


        var username = jwtService.extractUsername(jwtToken);

        if (!username.isEmpty() && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDomainService.getUserByLogin(username);

            if (jwtService.isTokenValid(jwtToken, userDetails)) {

                SecurityContext context = SecurityContextHolder.createEmptyContext();

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDomainService.getUserRoles(username)
                                        .stream()
                                        .map(ur -> new SimpleGrantedAuthority(ur.getRole().getName()))
                                        .toList()
                        );

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                context.setAuthentication(authToken);
                SecurityContextHolder.setContext(context);
            }

            filterChain.doFilter(request, response);
        }
    }
}
