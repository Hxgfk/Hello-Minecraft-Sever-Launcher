package com.hxgfk.main;

import com.hxgfk.util.Config;
import com.hxgfk.util.interfaces.Running;

import java.io.File;
import java.util.Objects;

public class Checker {
    public Checker(Running running, Creator creator){
        if (!this.checkConfig()){
            // 调用创建函数
            creator.createConfigFile();
        }else {
            if (!this.checkHome()){
                // 调用创建函数
                creator.createHomeDirectory();
            }else {
                if (!this.checkUrls()){
                    // 调用创建函数
                    creator.createUrlsFile();
                }else {
                    if (!this.checkLang()){
                        creator.createLangsFile();
                    }else {
                        running.run();
                    }
                }
            }
        }
    }

    // 检查数据文件夹
    private boolean checkHome(){
        File dir = new File(Objects.requireNonNull(Config.readValue(GlobalEnvironVariable.DefaultConfigFileName, "home")));
        if (dir.exists()){
            return dir.isDirectory();
        }else {
            return false;
        }
    }

    // 检查配置文件
    private boolean checkConfig(){
        return new File(GlobalEnvironVariable.DefaultConfigFileName).exists();
    }

    private boolean checkUrls(){
        return new File(GlobalEnvironVariable.Urls).exists();
    }

    private boolean checkLang(){
        boolean[] bools = new boolean[]{
                new File(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH).exists(),
                new File(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH).exists(),
                new File(GlobalEnvironVariable.MAIN_LANG_WINDOW_PATH).exists(),
                new File(GlobalEnvironVariable.MAIN_LANG_ALERT_PATH).exists(),
                new File(GlobalEnvironVariable.LANG_PUBLIC_PATH).exists()
        };
        boolean bool = true;
        for (boolean b : bools){
            if (!b){
                bool = false;
                break;
            }
        }
        return bool;
    }
}
