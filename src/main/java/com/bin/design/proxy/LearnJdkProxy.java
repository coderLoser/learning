package com.bin.design.proxy;

import java.lang.reflect.Proxy;

public class LearnJdkProxy {
    public static void main(String[] args) {
        //生成$Proxy0的class文件 System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        /**
         * 利用 JDK Proxy 模拟 mybaits mapper 模式
         * 如果要生成具体的class 文件，
         * 设置参数 System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
         * 具体参看 ProxyGenerator 的 saveGeneratedFiles
         */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Class<?>[] interfaces = {StuMapper.class};
        StuMapper stuMapper = (StuMapper) Proxy.newProxyInstance(LearnJdkProxy.class.getClassLoader(),
                interfaces, new StuMapperProxy());
        System.out.println(stuMapper.countStu());
        System.out.println(stuMapper.listStuByAge(13));
    }
}
