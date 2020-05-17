package com.bin.spring.cglib;

import com.bin.pojo.StuDO;
import com.bin.service.StuService;
import com.bin.service.StuServiceImpl;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.*;

/**
 * 学习与 cglib 中的 callback 的用法；
 */
public class LearnCglibCallback {
    public static void main(String[] args) {
        // 设置打印 class
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code\\java\\learning");

        Callback callback = getNoOp();
//        Callback callback = getMethodInterceptor();
//        Callback callback = getDispatcher();
//        Callback callback = getFixedValue();
//        Callback callback = getInvocationHandler();
//        Callback callback = getLazyLoader();
//        Callback callback = getProxyRefDispatcher();
        StuService stuService = (StuService) Enhancer.create(StuServiceImpl.class, callback);
        System.out.println("getStu: " + stuService.getStu(12));
        System.out.println("listStus: " + stuService.listStus(34));
    }

    private static Callback getNoOp() {
        return NoOp.INSTANCE;
    }

    private static Callback getMethodInterceptor() {
        return (MethodInterceptor) (obj, method, args, methodProxy) -> {
            /*
                return var10000 != null ? (List)var10000.intercept(this,
                CGLIB$listStus$1$Method, new Ob ject[]{new Integer(var1)}, CGLIB$listStus$1$Proxy)
                 : super.listStus(var1);
             */
            System.out.println("与 JDK 动态代理类似，不同的是这里我们除了 methodProxy 还能拿到 this.method");
            System.out.println("Before " + method.getName() + ".....");
            Object invoke = methodProxy.invoke(new StuServiceImpl(), args);
            System.out.println("After " + method.getName() + ".....");
            return invoke;
        };
    }

    private static Callback getDispatcher() {
        return (Dispatcher) () -> {
            System.out.println("dispatcher 返回值 object，为具体的代理对象！" +
                    "同时，每次执行代理对象的方法，都会执行这里的方法！");
            return new StuServiceImpl();
        };
    }

    private static Callback getFixedValue() {
        return (FixedValue) () -> {
            System.out.println("FixedValue 不会执行代理类的方法，而是直接调用 FixedValue.loaderObject 然后将结果直接返回；");
            System.out.println("比如下面的返回 StuDO，如果Service 调用的 listStus()，就会抛出" +
                    "StuDO 无法转换成 list 的异常；");
            return new StuDO();
        };
    }

    private static Callback getInvocationHandler() {
        return (InvocationHandler) (obj, method, args) -> {
            // (List)var10000.invoke(this, CGLIB$listStus$0, new Object[]{new Integer(var1)});
            System.out.println("InvocationHandler 与 JDK 的动态代理类似；");
            System.out.println("Before " + method.getName() + ".....");
            Object invoke = method.invoke(new StuServiceImpl(), args);
            System.out.println("After " + method.getName() + ".....");
            return invoke;
        };
    }

    private static Callback getLazyLoader() {
        return (LazyLoader) () -> {
            /*
            CGLIB$LOAD_PRIVATE_0:
                var10000 = this.CGLIB$LAZY_LOADER_0 = var10001.loadObject();
            return var10000;

            ((StuServiceImpl)this.CGLIB$LOAD_PRIVATE_0()).listStus(var1);
             */
            System.out.println("LazyLoader 代理对象会在第一次调用方法的时候，执行 loadObject 方法，并" +
                    "返回一个代理对象，然后调用代理对象的相关方法， loadObject 只会执行一次；");
            return new StuServiceImpl();
        };
    }

    private static Callback getProxyRefDispatcher() {
        return (ProxyRefDispatcher) obj -> {
            // ((StuServiceImpl)var10000.loadObject(this)).listStus(var1);
            System.out.println("代理映射到调度器，既传入的对象为当前代理对象，拿到代理对象之后，我们会像 dispatcher " +
                    "一样，返回一个新的被代理对象 B，然后 B 再去调用相关方法");
            return new StuServiceImpl();
        };
    }
}
