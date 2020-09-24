package org.herion;


import java.lang.instrument.Instrumentation;

/**
 * 代理类,把自定义的类修改器添加到 instrumentation 中
 *
 * @auther wubo25320
 * @create 2020-09-17 20:42
 */
public class UdAgent {
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        instrumentation.addTransformer(new LogTransformer());
    }
}
