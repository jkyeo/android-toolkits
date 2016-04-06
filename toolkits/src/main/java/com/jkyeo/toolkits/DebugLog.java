package com.jkyeo.toolkits;

import android.util.Log;

/**
 * <b>类名称：</b> DebugLog <br/>
 * <b>类描述：</b> Log输出调试信息<br/>
 * <b>创建人：</b> 林肯 <br/>
 * <b>修改人：</b> 编辑人 <br/>
 * <b>修改时间：</b> 2015年07月29日 上午11:25 <br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class DebugLog {
    private static String className;
    private static String methodName;
    private static int lineNumber;
    private static boolean isDebuggable = true;

    private DebugLog() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 判断是否Debug模式
     *
     * @return Debug模式 true Release模式 false
     */
    private static boolean isDebug() {
        return !isDebuggable;
    }

    public static void closeDebug() {
        isDebuggable = false;
    }

    private static String createLog(String log) {

        return "[" + methodName + ":" + lineNumber + "]" + log;
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    /**
     * 打印错误信息
     *
     * @param message
     */
    public static void e(String message) {
        if (isDebug())
            return;

        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.e(className, createLog(message));
    }

    /**
     * 打印信息
     *
     * @param message
     */
    public static void i(String message) {
        if (isDebug())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.i(className, createLog(message));
    }

    /**
     * 打印调试信息
     *
     * @param message
     */
    public static void d(String message) {
        if (isDebug())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.d(className, createLog(message));
    }

    /**
     * 打印观察信息
     *
     * @param message
     */
    public static void v(String message) {
        if (isDebug())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.v(className, createLog(message));
    }

    /**
     * 打印警告信息
     *
     * @param message
     */
    public static void w(String message) {
        if (isDebug())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.w(className, createLog(message));
    }

    /**
     * What's Fuck……
     *
     * @param message
     */
    public static void wtf(String message) {
        if (isDebug())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(className, createLog(message));
    }
}
