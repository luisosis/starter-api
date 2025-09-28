package com.starter.api.starterapi.util;

import java.time.LocalDateTime;

public class MethodsUtil {

    public static LocalDateTime getDateByDefault() {
        return LocalDateTime.now();
    }

    public static boolean getActiveUser() {
        return true;
    }

}
