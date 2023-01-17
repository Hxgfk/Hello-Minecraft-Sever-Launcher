package com.hxgfk.util.downloader;


import com.hxgfk.util.Config;
import com.hxgfk.util.Download;
import com.hxgfk.util.alerts.Error;
import com.hxgfk.util.alerts.Succes;
import com.hxgfk.main.GlobalEnvironVariable;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class SeverDownloader {
    public void start(String Saved, String url){
        Download download = new Download(Saved, url);
        try {
            if (download.run()){
                new Succes(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "downloader-sever-success"));
            }else {
                new Succes(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "downloader-sever-faild"));
            }
        } catch (IOException e){
            new Error(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "downloader-download-faild"), e.getMessage());
            e.printStackTrace();
        }
    }

    public void startDownloadSever(String name, String version){
        class DownloadThread implements Runnable{

            @Override
            public void run() {
                try {
                    String link = Config.readValue(GlobalEnvironVariable.Urls, "SEV_V"+version);
                    SeverDownloader dl = new SeverDownloader();
                    new File(GlobalEnvironVariable.HomeDirectoryPath+"\\severs\\"+name).mkdir();
                    String path = GlobalEnvironVariable.HomeDirectoryPath+"\\severs\\"+name+"\\main.jar";
                    dl.start(path, link);
                    new File(GlobalEnvironVariable.HomeDirectoryPath+"\\severs\\"+name+"\\data.config").createNewFile();
                    Config.writeProperties(GlobalEnvironVariable.HomeDirectoryPath+"\\severs\\"+name+"\\data.config", "version", version);
                }catch (IOException e){
                    new Error(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "downloader-download-faild"), e.getMessage());
                }
            }
        }

        // 启动下载线程
        Thread thread = new Thread(new DownloadThread());
        thread.start();
        class startingWindow extends JFrame {
            public startingWindow(){
                setTitle(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "downloader-alert"));
                setBounds(500, 500, 250, 100);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                JPanel panel = new JPanel();
                panel.add(new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "downloader-downloading")));
                setContentPane(panel);
                setVisible(true);
                requestFocusInWindow();
            }
        }
        startingWindow StartingWindow = new startingWindow();
        if (!thread.isAlive()){
            StartingWindow.setVisible(false);
            new Succes(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "downloader-success"));
        }
    }
}
