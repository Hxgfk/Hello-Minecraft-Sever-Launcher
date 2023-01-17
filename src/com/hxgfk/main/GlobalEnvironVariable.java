package com.hxgfk.main;

import com.hxgfk.util.Config;

public interface GlobalEnvironVariable {
    // 默认配置文件名字
    String DefaultConfigFileName = "hml.config";
    // 数据文件夹
    String HomeDirectoryPath = Config.readValue(DefaultConfigFileName, "home");
    // 服务器支持的版本
    String[] ActiveSeverVersions = {
            "1.16",
            "1.16.5",
            "1.16.4",
            "1.18",
            "1.17",
            "1.12",
            "1.7.10",
            "1.12.2",
            "1.12.1"
    };
    // 客户端支持的版本
    String[] ActiveClientVersions = {};

    // urls file
    String Urls = "urls.config";

    // now language
    String LANG = Config.readValue(DefaultConfigFileName, "lang");

    // langs
    String SEVER_LANG_WINDOW_PATH = HomeDirectoryPath+"\\lang\\sever\\"+LANG+"\\window.config";
    String SEVER_LANG_ALERT_PATH = HomeDirectoryPath+"\\lang\\sever\\"+LANG+"\\alert.config";

    String MAIN_LANG_WINDOW_PATH = HomeDirectoryPath+"\\lang\\main\\"+LANG+"\\window.config";

    String MAIN_LANG_ALERT_PATH = HomeDirectoryPath+"\\lang\\main\\"+LANG+"\\alert.config";

    // public
    String LANG_PUBLIC_PATH = HomeDirectoryPath+"\\lang\\main\\"+LANG+"\\public.config";
}
