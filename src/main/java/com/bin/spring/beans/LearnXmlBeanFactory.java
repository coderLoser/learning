package com.bin.spring.beans;


import com.bin.service.StuService;
import com.bin.service.StuServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 *
 */
public class LearnXmlBeanFactory {
    public static void main(String[] args) {
        /**
         * XmlBeanFactory 当前以及被遗弃了，它继承了 DefaultListableBeanFactory,
         * 然后通过 XmlBeanDefinitionReader 进行 bean 的初始化；
         * classpath 不能再 src 目录下
         */
        Resource resource = new FileSystemResource("D:\\code\\java\\learning\\src\\main\\java\\com\\bin\\spring\\beans\\beans.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
        StuService stuService = (StuService) xmlBeanFactory.getBean("stuService");
        System.out.println(stuService.listStus(2));
        System.out.println(".......................");

        /*
         这里可以看到 XmlBeanFactory 已经废弃了，
         但是spring 并没有说明为什么被废弃，只是说了更有利于 DefaultListableBeanFactory 和 XmlBeanDefinitionReader
         新的 BeanFactory 创建方式：
         */
        XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(new DefaultListableBeanFactory());
        xbdr.loadBeanDefinitions(resource);
        BeanDefinitionRegistry beanDefinitionRegistry = xbdr.getBeanFactory();
        if (beanDefinitionRegistry instanceof BeanFactory) {
            BeanFactory beanFactory = (BeanFactory) beanDefinitionRegistry;
            System.out.println(beanFactory.containsBean("stuService"));
        }

        StuServiceImpl ssi = BeanUtils.instantiateClass(StuServiceImpl.class);
        System.out.println(ssi.getStu(12));
    }
}
