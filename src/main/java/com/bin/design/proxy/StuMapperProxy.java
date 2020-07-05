package com.bin.design.proxy;

import com.bin.pojo.StuDO;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * JDK 动态代理模式的核心就是实现 InvocationHandler 接口
 * JDK InvocationHandler 接口的内容就是 Proxy 代理接口的具体业务处理逻辑；
 */
public class StuMapperProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        StuDO stu = new StuDO() {{
                setId(133); setName("lwj"); setAge(18); setSex(0); setAddr("平桥重华");
                setBirthday(LocalDate.of(1998, 4, 1));
            }};
        if (name.startsWith("list")) {
            return new ArrayList<StuDO>(){{add(stu);}};
        } else if (name.startsWith("count")) {
            return 133L;
        } else if (name.startsWith("get")) {
            return stu;
        }
        return null;
    }
}
