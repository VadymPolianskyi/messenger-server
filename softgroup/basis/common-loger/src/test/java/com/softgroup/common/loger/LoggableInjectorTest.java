package com.softgroup.common.loger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

import static org.junit.Assert.assertThat;

/**
 * Author: vadym_polyanski
 * Date: 21.05.17
 * Time: 0:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={LoggerConfig.class})
public class LoggableInjectorTest {

    @Loggable
    private Logger logger;

    @Test
    public void testNulableLogger() {
        assertThat(logger, notNullValue());

    }

    @Test
    public void testInstanceLogger() {
        assertThat(logger, instanceOf(Logger.class));
    }
}
