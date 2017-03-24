package com.softgroup.authorization.impl.handler.key;

import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Author: vadym
 * Date: 18.03.17
 * Time: 16:15
 */
@Component
public class KeysGenerator {
    public String generateKey() {
        String digestB64 = "";
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
            SecretKey key = keyGen.generateKey();

            Mac mac = Mac.getInstance(key.getAlgorithm());
            mac.init(key);

            String str = "authorization_code";

            byte[] utf8 = str.getBytes("UTF8");
            byte[] digest = mac.doFinal(utf8);

            digestB64 = new sun.misc.BASE64Encoder().encode(digest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return digestB64;
    }
}
