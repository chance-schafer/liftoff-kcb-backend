package org.launchcode.liftoff_kcb_backend.security;

import java.time.temporal.ChronoUnit;

public class SecurityConstant {
    public static final long JWT_EXPIRATION = ChronoUnit.HOURS.getDuration().toMillis();    // 1 hour
    public static final String JWT_SECRET = "secret";
}
