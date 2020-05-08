package com.bin.design.adapter;

/**
 * 说英文的美国人
 */
public class AmericaAdaptee {

    public String useEnglishTalk(String input) {
        if (input == null) return "What ? I didn't hear !";
        if (!input.matches("^[\\x00-\\xff]+$")) return "I only speak English!";
        return "yes, you are right !";
    }
}
