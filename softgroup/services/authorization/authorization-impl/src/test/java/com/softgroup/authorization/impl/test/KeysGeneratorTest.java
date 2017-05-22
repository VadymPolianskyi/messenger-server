package com.softgroup.authorization.impl.test;

import com.softgroup.authorization.impl.handler.key.KeysGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Author: vadym_polyanski
 * Date: 21.05.17
 * Time: 0:03
 */
@RunWith(MockitoJUnitRunner.class)
public class KeysGeneratorTest {
    @InjectMocks
    private KeysGenerator keysGenerator;

    @Test
    public void testGenerateKey() {
        assertThat(keysGenerator.generateKey(), notNullValue());
    }

    @Test
    public void testEquasKeys() {
        String firstKey = keysGenerator.generateKey();
        String secondKey = keysGenerator.generateKey();
        assertThat(firstKey.equals(secondKey), is(false));
    }
}
