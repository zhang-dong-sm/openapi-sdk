package com.baas.openapi.common.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create Time:2020/8/31
 * User: luchao
 * Email: luc@shinemo.com
 */
public class LogFactory {

    private static Logger LOG = LoggerFactory.getLogger("info.log");

    public static void setLOG(Logger logger) {
        LogFactory.LOG = logger;
    }

    public static void info(String msg, Object... args) {
        LOG.info(msg, args);
    }

    public static void error(String msg, Object... args) {
        LOG.error(msg, args);
    }

}
