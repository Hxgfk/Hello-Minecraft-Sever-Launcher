package com.hxgfk.main;

import com.hxgfk.util.Config;

import java.io.File;
import java.io.IOException;

public class Creator {
    // 创建配置文件
    public void createConfigFile(){
        File file = new File(GlobalEnvironVariable.DefaultConfigFileName);
        try {
            file.createNewFile();
            // 写入数据
            Config.writeProperties(GlobalEnvironVariable.DefaultConfigFileName, "home", ".hml");
            Config.writeProperties(GlobalEnvironVariable.DefaultConfigFileName, "lang", "zh_cn");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // 配置文件创建器
    private static class CreateConfig {
        public void sever(){
            File file = new File(GlobalEnvironVariable.Urls);
            try {
                file.createNewFile();
                // Download Url
                Config.writeProperties(GlobalEnvironVariable.Urls, "SEV_V1.16", "https://launcher.mojang.com/v1/objects/a0d03225615ba897619220e256a266cb33a44b6b/server.jar");
                Config.writeProperties(GlobalEnvironVariable.Urls, "SEV_V1.16.5", "https://launcher.mojang.com/v1/objects/1b557e7b033b583cd9f66746b7a9ab1ec1673ced/server.jar");
                Config.writeProperties(GlobalEnvironVariable.Urls, "SEV_V1.16.4", "https://launcher.mojang.com/v1/objects/35139deedbd5182953cf1caa23835da59ca3d7cd/server.jar");
                Config.writeProperties(GlobalEnvironVariable.Urls, "SEV_V1.18", "https://launcher.mojang.com/v1/objects/3cf24a8694aca6267883b17d934efacc5e44440d/server.jar");
                Config.writeProperties(GlobalEnvironVariable.Urls, "SEV_V1.17", "https://launcher.mojang.com/v1/objects/0a269b5f2c5b93b1712d0f5dc43b6182b9ab254e/server.jar");
                Config.writeProperties(GlobalEnvironVariable.Urls, "SEV_V1.12", "https://launcher.mojang.com/v1/objects/8494e844e911ea0d63878f64da9dcc21f53a3463/server.jar");
                Config.writeProperties(GlobalEnvironVariable.Urls, "SEV_V1.7.10", "https://launcher.mojang.com/v1/objects/952438ac4e01b4d115c5fc38f891710c4941df29/server.jar");
                Config.writeProperties(GlobalEnvironVariable.Urls, "SEV_V1.12.2", "https://launcher.mojang.com/v1/objects/886945bfb2b978778c3a0288fd7fab09d315b25f/server.jar");
                Config.writeProperties(GlobalEnvironVariable.Urls, "SEV_V1.12.1", "https://launcher.mojang.com/v1/objects/561c7b2d54bae80cc06b05d950633a9ac95da816/server.jar");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public void client(){
            File file = new File(GlobalEnvironVariable.Urls);
            try {
                file.createNewFile();
                // Download Url
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public static class Langs{
            public void langZH(){
                try {
                    // Sever Alert
                    new File(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH).createNewFile();
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-download-void-title", "警告");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-download-void", "名称不可以为空");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-error", "启动失败");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-ip", "IP地址: ");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-port", "端口: ");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-pvp", "是否PVP");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-difficulty", "游戏难度: ");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-data-title", "服务器数据");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-data-say", "服务器属性数据");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-error-title", "错误");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "downloader-sever-success", "下载完成");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "downloader-sever-faild", "未知原因导致下载失败");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "downloader-download-faild", "一个错误导致下载失败");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "downloader-alert", "提示");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "downloader-downloading", "正在下载中...");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "downloader-success", "下载完成");
                    // Sever Window
                    new File(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH).createNewFile();
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "window-title", "服务器");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "button-modify", "修改数据");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "button-download", "下载原版服务器");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "button-download-forge", "下载Forge服务器");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "button-run", "运行服务器");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "run-window", "运行服务器");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "run-window-start", "运行");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "run-window-name", "服务器名称: ");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-title", "下载原版服务器");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-active", "应用");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-sever-name", "服务器名：");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-ip", "IP: ");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-port", "端口：");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-default-game-mode", "游戏模式：");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-game-mode-creative", "创造模式");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-game-mode-survival", "生存模式");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-game-mode-adventure", "冒险模式");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-game-mode-spectator", "旁观者模式");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-allow-nether", "允许玩家进入下界：");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "download-title", "下载原版服务器");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "download-start", "开始下载");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "download-version", "版本：");
                    Config.writeProperties(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "download-name", "名字：");
                    // Main Alert
                    new File(GlobalEnvironVariable.MAIN_LANG_ALERT_PATH).createNewFile();
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_ALERT_PATH, "create-success", "配置文件创建完成，请重启");
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_ALERT_PATH, "create-success-title", "创建完成");
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_ALERT_PATH, "creator-config-faild-title", "一个错误导致配置文件创建失败");
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_ALERT_PATH, "init-faild", "程序初始化失败");
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_ALERT_PATH, "init-log-create-faild", "日志文件创建失败");
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_ALERT_PATH, "init-config-create-error-faild", "因为一个错误配置文件创建失败");
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_ALERT_PATH, "init-config-create-error-faild-title", "错误");
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_ALERT_PATH, "init-config-create-success", "配置文件创建成功，请重启");
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_ALERT_PATH, "init-config-create-success-title", "完成");
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_ALERT_PATH, "init-data-create-success", "数据文件夹创建成功，请重启");
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_ALERT_PATH, "init-data-create-success-title", "完成");
                    // Main Window
                    new File(GlobalEnvironVariable.MAIN_LANG_WINDOW_PATH).createNewFile();
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_WINDOW_PATH, "main-title", "Hello Minecraft Launcher");
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_WINDOW_PATH, "main-text-menu", "菜单");
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_WINDOW_PATH, "main-button-client", "客户端");
                    Config.writeProperties(GlobalEnvironVariable.MAIN_LANG_WINDOW_PATH, "main-button-sever","服务器");
                    // Public
                    new File(GlobalEnvironVariable.LANG_PUBLIC_PATH).createNewFile();
                    Config.writeProperties(GlobalEnvironVariable.LANG_PUBLIC_PATH, "application-name", "Hello Minecraft Launcher");
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private final CreateConfig conf = new CreateConfig();

    public void createUrlsFile(){
        conf.sever();
        conf.client();
    }

    public void createLangsFile(){
        new CreateConfig.Langs().langZH();
    }

    public void createHomeDirectory(){
        // 创建数据文件夹
        new File(".hml").mkdir();
        new File(".hml\\config").mkdir();
        new File(".hml\\severs").mkdir();
        new File(".hml\\lang").mkdir();
        new File(".hml\\lang\\main").mkdir();
        new File(".hml\\lang\\main\\zh_cn").mkdir();
        new File(".hml\\lang\\main\\en_us").mkdir();
        new File(".hml\\lang\\sever").mkdir();
        new File(".hml\\lang\\sever\\zh_cn").mkdir();
        new File(".hml\\lang\\sever\\en_us").mkdir();
        new File(".hml\\lang\\client").mkdir();
        new File(".hml\\lang\\client\\zh_cn").mkdir();
        new File(".hml\\lang\\client\\en_us").mkdir();
    }
}
