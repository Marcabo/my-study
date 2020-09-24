package com.herion.gctest;

/**
 * GC日志分析
 * 作者：月伴飞鱼
 *     链接：https://juejin.im/post/6875632328345911303
 *     来源：掘金
 *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @auther wubo25320
 * @create 2020-09-24 10:29
 */
public class GCAnalysisTest {

    public static void main(String[] args) {
        byte[] array1 = new byte[4 * 1024 * 1024];
        array1 = null;

        byte[] array2 = new byte[2 * 1024 * 1024];
        byte[] array3 = new byte[2 * 1024 * 1024];
        byte[] array4 = new byte[2 * 1024 * 1024];
        byte[] array5 = new byte[128 * 1024];

        byte[] array6 = new byte[2 * 1024 * 1024];
    }


}
