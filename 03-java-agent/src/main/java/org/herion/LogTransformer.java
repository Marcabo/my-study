package org.herion;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * 类转换器实现
 *
 * @auther wubo25320
 * @create 2020-09-17 20:44
 */
public class LogTransformer implements ClassFileTransformer {

    /**
     * 会在类被加载时调用
     * @param loader
     * @param className
     * @param classBeingRedefined
     * @param protectionDomain
     * @param classfileBuffer
     * @return
     * @throws IllegalClassFormatException
     */
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        try {
            ClassReader cr = new ClassReader(className);
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            TimeCountAdapter timeCountAdapter = new TimeCountAdapter(cw);

            cr.accept(timeCountAdapter, ClassReader.EXPAND_FRAMES);

            return cw.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
