package com.kiwilss.buglyone.provider;

import java.security.Provider;

/**
 * @author : Lss kiwilss
 * @FileName: BuglyFileProvider
 * @e-mail : kiwilss@163.com
 * @time : 2019/1/14
 * @desc : {DESCRIPTION}
 */
public class BuglyFileProvider extends Provider {
    protected BuglyFileProvider(String name, double version, String info) {
        super(name, version, info);
    }
}
