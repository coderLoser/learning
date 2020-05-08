package com.bin.design.adapter;

public class TranslationAdapter extends AmericaAdaptee implements Target{
    @Override
    public String useCNTalk(String input) {
        System.out.println("将 " + input + " 翻译成英文");
        String eg = useEnglishTalk("english message!");
        System.out.println("老外的回复：" + eg);
        return "将老外的回复翻译成中文！";
    }
}
