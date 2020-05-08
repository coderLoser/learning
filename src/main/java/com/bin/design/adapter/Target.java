package com.bin.design.adapter;

/**
 * 客户期望使用的接口，或者本系统自定义的系统
 * 中英文翻译官的为例：
 *  假设 Target 为中国人，他只会中文
 *  系统中存在一个只会英语的美国人，此时，中国人需要与美国人进行交流
 */
public interface Target {
    /**
     * 使用中文进行交流
     */
    String useCNTalk(String input);
}
