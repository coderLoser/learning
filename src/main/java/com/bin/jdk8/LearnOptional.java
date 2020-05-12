package com.bin.jdk8;

import java.util.Optional;

/**
 * optional 类
 * 什么时候使用 optional 呢？
 *  一般来说，optional 是用来包装返回值的，也就是说当返回的结果可能存在 null时，我们最好使用
 *  optional 来代替，因为直接返回null很大程度会引起空指针，不用 optional 会很容易导致使用者忽略 null 的场景；
 */
public class LearnOptional {
    public static void main(String[] args) {
        /**
         * create Optional
         * optional 有两种create 方式，一种是 Optional.of(value)，一种是 Optional.ofNullable(value)
         * 如果value为空，of(value) 会报 NPE
         */
        String value = "lwj";
        Optional<String> o = Optional.ofNullable(value);

        // 判断 value 是否为null
        System.out.println("value isn't null ? " + o.isPresent());
        o.ifPresent(s -> {
            // 如果 value 不为null，则执行当前逻辑
            System.out.println("value is not null;");
        });

        Optional<String> o2 = o.filter(s -> "lwj".equals(s));
        System.out.println(o2);

        Optional<String> u = o.map((t) -> {
            if ("lwj".equals(t)) return "binbin";
            else return null;
        });

        // 如果value 为null，则使用一个新的对象来代替
        value = o.orElse("null");
        System.out.println(value);
    }
}
