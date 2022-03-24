package ru.lab.lab1.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JWTProvider {
    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.sessionTime}")
    private Long sessionTime;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        String commaSeparatedListOfAuthorities=  userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        claims.put("authorities", commaSeparatedListOfAuthorities);
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String login) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(login)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + sessionTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String extractLogin(String token) {
        return extractClaims(token).getSubject();
    }

    public String extractAuthorities(String token) {
        return (String) extractClaims(token).get("authorities");
    }

    private Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

}
