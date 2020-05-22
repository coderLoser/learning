package com.bin.spring.cglib;

import com.bin.pojo.StuDO;
import com.bin.pojo.StuPhoto;
import com.bin.service.StuService;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.LazyLoader;

import java.time.LocalDate;

public class CglibLazyLoader {
    public static void main(String[] args) {
        /**
         * 模仿 mybatis, 假设我们查询 stu 的时候，会关联查询 stu 的 photo
         * 但是我们大多数的场景下，都不会用到 stu 的 photo 属性，因此，
         * 为了减少数据量，这里很显然是需要将 stu 的 photo 设置为延迟加载
         */
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code\\java\\learning");
        StuService stuService = (StuService) Enhancer.create(StuService.class,
                (InvocationHandler) (obj, method, arg) -> getStu((int) arg[0]));
        StuDO stu = stuService.getStu(12);
        System.out.println(stu.getStuPhoto().getName());
        System.out.println(stu.getStuPhoto().getFile());
    }

    private static StuDO getStu(int stuId) {
        StuDO stu = new StuDO();
        stu.setId(stuId);
        stu.setName("静静");
        stu.setAge(18);
        stu.setSex(0);
        stu.setAddr("不知道住哪里");
        stu.setBirthday(LocalDate.of(2000, 12,12));
        // 将
        stu.setStuPhoto((StuPhoto) Enhancer.create(StuPhoto.class, (LazyLoader) () -> {
            System.out.println("....");
            StuPhoto stuPhoto = new StuPhoto();
            stuPhoto.setId(124);
            stuPhoto.setName("静静吃饭");
            stuPhoto.setSize(102400);
            stuPhoto.setFile(new byte[]{12, 23, 45, 12, 75});
            return stuPhoto;
        }));
        return stu;
    }
}
