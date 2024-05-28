package com.example.logisticprogram.service.security;

import com.example.logisticprogram.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.properties.validationDuration}")
    private Long validationDuration;

    @Value("${jwt.properties.secretKey}")
    private String secretKey;

    public boolean isTokenValid(String token, UserDetails userDetails){
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && extractExpiration(token).after(new Date());
    }

    public String generateToken(UserDetails userDetails) {

        Map<String, Object> claims = new HashMap<>();

        if (userDetails instanceof User user) {
            claims.put("id", user.getId());
            claims.put("email", user.getEmail());
        }

        return generateToken(claims, userDetails);
    }


    private String generateToken(Map<String, Object> claims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + validationDuration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }


    private Claims extractClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
    }

    private <T> T parseClaims(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractClaims(token);
        return claimsResolvers.apply(claims);
    }

    private Date extractExpiration(String token) {
        return parseClaims(token, Claims::getExpiration);
    }

    public String extractUsername(String token) {
        return parseClaims(token, Claims::getSubject);
    }




}
