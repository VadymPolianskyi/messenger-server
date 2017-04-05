package com.softgroup.common.jwt.impl.service;

import com.softgroup.common.jwt.api.exception.DeviceTokenException;
import com.softgroup.common.jwt.api.exception.SessionTokenException;
import com.softgroup.common.jwt.api.exception.TokenException;
import com.softgroup.common.jwt.api.service.TokenType;
import com.softgroup.common.jwt.api.service.UniversalTokenService;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Author: vadym
 * Date: 17.03.17
 * Time: 18:26
 */
@Component
public class TokenService implements UniversalTokenService {
    private final String KEY = "g94wri5j3j653jih3og";
    private final TokenType SESSION_TOKEN = TokenType.SESSION_TOKEN;
    private final TokenType DEVICE_TOKEN = TokenType.DEVICE_TOKEN;
    private final Long YEAR_UNIX_TMS = 31536000000L;
    private final Long TEN_MINUTES_UNIX_TMS = 600000L;

    static Logger log = LoggerFactory.getLogger(TokenService.class);

    @Override
    public void validateDeviceToken(String token) throws DeviceTokenException {
        try{
            Jwts.parser()
                    .require("type", DEVICE_TOKEN.toString())
                    .setSigningKey(KEY)
                    .parseClaimsJws(token);
        } catch (JwtException jwtException){
            throw new DeviceTokenException(jwtException.getMessage());
        }
//        validateToken(, token);
    }

    @Override
    public String generateDeviceToken(String profileID, String deviceID) throws DeviceTokenException {

        return  Jwts.builder()
                .claim("profileID", profileID)
                .claim("deviceID", deviceID)
                .claim("type", DEVICE_TOKEN)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TEN_MINUTES_UNIX_TMS))
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
    }

    @Override
    public void validateSessionToken(String token) throws SessionTokenException {
        try{
            Jwts.parser()
                    .require("type", SESSION_TOKEN.toString())
                    .setSigningKey(KEY)
                    .parseClaimsJws(token);
        } catch (JwtException jwtException){
            throw new DeviceTokenException(jwtException.getMessage());
        }
//       validateToken(, token);
    }

    @Override
    public String generateSessionToken(String profileID, String deviceID) throws SessionTokenException{
        return  Jwts.builder()
                .claim("profileID", profileID)
                .claim("deviceID", deviceID)
                .claim("type", SESSION_TOKEN)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + YEAR_UNIX_TMS))
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
    }

    @Override
    public Long getTimeOfCreation(String token) throws TokenException {
        try {
            return Jwts.parser()
                    .setSigningKey(KEY)
                    .parseClaimsJws(token)
                    .getBody().getIssuedAt().getTime();
        } catch (JwtException jwtException){
            throw new TokenException(jwtException.getMessage());
        }
    }

    @Override
    public TokenType getTokenType(String token) throws TokenException {
        try {
            return (TokenType) getParameter(token, "type");
        } catch (JwtException jwtException){
            throw new TokenException(jwtException.getMessage());
        }
    }

    @Override
    public String getDeviceID(String token) throws TokenException {
        try {
            return (String) getParameter(token, "deviceID");
        } catch (JwtException jwtException){
            throw new TokenException(jwtException.getMessage());
        }
    }

    @Override
    public String getProfileID(String token) throws TokenException {
        try {
            return (String) getParameter(token, "profileID");
        } catch (JwtException jwtException){
            throw new TokenException(jwtException.getMessage());
        }
    }

    public Object getParameter(String token, String key) throws TokenException {
        return  Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token)
                .getBody()
                .get(key);
    }

    private void validateToken(TokenType tokenType, String token) {

    }
}
