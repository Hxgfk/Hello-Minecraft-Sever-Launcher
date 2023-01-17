package com.hxgfk.sever.main;

import com.hxgfk.util.alerts.Error;
import com.hxgfk.util.alerts.Info2;
import com.hxgfk.util.Config;
import com.hxgfk.main.GlobalEnvironVariable;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class SeverRunner {
    private final String name;

    public SeverRunner(String name){
        this.name = name;
    }

    public static void replace(String oldString,String newString,String path) {
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<String> strings = new ArrayList<>();
            String s;
            while ((s = br.readLine()) != null) {
                if (s.contains(oldString)) {
                    s = s.replace(oldString, newString);
                }
                strings.add(s);
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String string : strings) {
                bw.write(string);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
            new Error(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-error-title"), e.getMessage());
        }
    }

    public void run(){
        class SeverThread implements Runnable{
            private final SeverMain main = new SeverMain();
            private final String name;
            public SeverThread(String name){
                this.name = name;
            }

            @Override
            public void run() {
                String path = GlobalEnvironVariable.HomeDirectoryPath+"\\severs\\"+this.name+"\\";
                String command = "java -jar "+path+"main.jar";
                try {
                    System.setProperty("user.dir", path);
                    if (new File("eula.txt").exists()){
                        replace("false", "true", "eula.txt");
                        Runtime.getRuntime().exec(command);
                        Info2 data = new Info2(500, 500, 500, 100, Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "rum-data-title"), Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-data-say"));
                        data.setVisible(false);
                        data.panel.add(new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-ip")+": "+Config.readValue("server.properties", "server-ip")+" "));
                        data.panel.add(new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-port")+": "+Config.readValue("server.properties", "server-port")+" "));
                        data.panel.add(new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-pvp")+": "+Config.readValue("server.properties", "pvp")+" "));
                        data.panel.add(new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-difficulty")+": "+Config.readValue("server.properties", "difficulty")+" "));
                        data.panel.add(new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-version")+": "+Config.readValue("data.config", "version")));
                        data.setVisible(true);
                    }else {
                        Runtime.getRuntime().exec(command);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    new Error(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-error-title"), e.getMessage());
                }
            }
        }
        Thread thread = new Thread(new SeverThread(this.name));
        thread.start();
    }
}
