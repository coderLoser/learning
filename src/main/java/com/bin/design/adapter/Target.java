package com.bin.design.adapter;

/**
 * scene:
 *  假设我们系统要使用一套缓存框架来缓存数据，但是缓存框架很多，即便现在选好了，将来也会存在替换的风险；
 *  基于这样的场景，为了避免将来切换框架或框架升级引起的大量改动，一般来说，我们就可以在当前系统中定义一套更适合当前使用的接口
 *  然后在将具体的第三方框架使用封装到该接口使用中；
 *  这就是一种典型的 adapter 模式；
 */
public interface Target {
    /**
     * 使用中文进行交流
     */
    String useCNTalk(String input);
}
