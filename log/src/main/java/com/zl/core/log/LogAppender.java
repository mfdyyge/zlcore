package com.zl.core.log;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

/**
 * Created by Administrator on 2017/9/1. <br/>
 * 日志按级别输出到文件. <br/>
 * Log4j 必须重写[isAsSevereAsThreshold(Priority priority)]这个方法. <br/>
 *
 */
public class LogAppender extends DailyRollingFileAppender {

    @Override
    public boolean isAsSevereAsThreshold(Priority priority) {
        //只判断是否相等，而不判断优先级
        return this.getThreshold().equals(priority);
    }
}