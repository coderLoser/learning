package com.bin.design.adapter;

/**
 * 适配器，一般来说，我们可以使用 继承 或者 聚合 的形式，来达到使用 AmericaAdaptee API 的目的
 */
public class TranslationAdapter extends AmericaAdaptee implements Target{
    public String useCNTalk(String input) {
        System.out.println("将 " + input + " 翻译成英文");
        String eg = useEnglishTalk("english message!");
        System.out.println("老外的回复：" + eg);
        return "将老外的回复翻译成中文！";
    }
}
