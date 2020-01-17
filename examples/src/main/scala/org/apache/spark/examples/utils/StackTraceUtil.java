package org.apache.spark.examples.utils;

/**
 * @author :  jqwu
 * Comment :
 */

public class StackTraceUtil {
    /**
     * 在任意方法中打印方法调用链路
     */
    public static void printMethodUseStackTrace(){
        Throwable ex = new Throwable();
        StackTraceElement[] stackElements = ex.getStackTrace();
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                // //返回类的完全限定名，该类包含由该堆栈跟踪元素所表示的执行点。
                // System.out.println(stackElements[i].getClassName());
                // //返回源文件名，该文件包含由该堆栈跟踪元素所表示的执行点。
                // System.out.println(stackElements[i].getFileName());
                // //返回源行的行号，该行包含由该堆栈该跟踪元素所表示的执行点。
                // System.out.println(stackElements[i].getLineNumber());
                // //返回方法名，此方法包含由该堆栈跟踪元素所表示的执行点。
                // System.out.println(stackElements[i].getMethodName());
                // System.out.println("-------------第"+i+"级调用-------------------");

                System.err.println(stackElements[i].getClassName() +
                        "." + stackElements[i].getMethodName() +
                        "(" + stackElements[i].getFileName() +
                        ":" + stackElements[i].getLineNumber() +
                        ")");
            }
        }
    }

}
