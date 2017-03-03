package com.softgroup.frontend.test.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Author: vadym
 * Date: 01.03.17
 * Time: 17:54
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "com.softgroup"})
public class WebConfiguration extends WebMvcConfigurerAdapter{
}
