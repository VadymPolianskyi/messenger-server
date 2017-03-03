package com.softgroup.frontend.test.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Author: vadym
 * Date: 01.03.17
 * Time: 17:47
 */

@Configuration
@ComponentScan(basePackages = {
        "com.softgroup"})
public class RestApplicationConfiguration {
}
