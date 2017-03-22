package com.softgroup.frontend.test.security;

import com.google.common.io.CharStreams;
import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.service.DeviceService;
import com.softgroup.common.dao.impl.service.ProfileService;
import com.softgroup.common.jwt.impl.service.TokenService;
import com.softgroup.common.protocol.RoutingData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vadym_polyanski on 20.03.17.
 */
@Component
public class Filter extends UsernamePasswordAuthenticationFilter {
    static Logger log = LoggerFactory.getLogger(Filter.class);

    @Autowired
    TokenAuthentication tokenAuthentication;

    @Autowired
    TokenService tokenService;

    @Autowired
    DeviceService deviceService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        log.info("SecurityFilter is working with request");
        HttpServletRequest request = (HttpServletRequest) req;
        String token = request.getHeader("x-token");
        String deviceId = tokenService.getDeviceID(token);

        DeviceEntity deviceEntity = deviceService.findDeviceEntityById(deviceId);


        if (deviceEntity.getUpdateDateTime().equals(tokenService.getTimeOfCreation(token)) ) {
            request.getSession().setAttribute("routing_data", createRoutingData(
                    request.getHeader("x-token")));
            SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
            chain.doFilter(req, res);
            log.info("Request status: OK");
        } else {
            ((HttpServletResponse) res).sendError(403);
            log.error("Request status: ERROR 403");
        }
    }

    private RoutingData createRoutingData(String token) {
        return new RoutingData(tokenService.getProfileID(token), tokenService.getDeviceID(token));
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
}
