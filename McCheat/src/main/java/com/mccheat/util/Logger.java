package com.mccheat.util;
import org.slf4j.LoggerFactory;
public class Logger {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger("McCheat");
    public static void info(String msg)  { log.info(msg); }
    public static void warn(String msg)  { log.warn(msg); }
    public static void error(String msg) { log.error(msg); }
}
