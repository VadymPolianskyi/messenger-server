package com.softgroup.common.loger;

import java.lang.annotation.*;

/**
 * Author: vadym_polyanski
 * Date: 19.05.17
 * Time: 12:57
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Loggable {
}
