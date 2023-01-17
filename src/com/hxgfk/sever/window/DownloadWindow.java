package com.hxgfk.sever.window;

import com.hxgfk.util.Config;
import com.hxgfk.main.GlobalEnvironVariable;

import javax.swing.*;

public class DownloadWindow extends JFrame {
    public final JComboBox<String> Version;
    public final JTextField SeverName;

    public DownloadWindow(){
        setTitle(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "download-title"));
        setSize(500,100);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel panel = new JPanel();

        // 开始按钮
        JButton start = new JButton(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "download-start"));
        start.setBounds(38, 40, 105, 50);
        start.addActionListener(e -> new Window().runDownload());
        panel.add(start);

        JLabel versionText = new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "download-version"));
        panel.add(versionText);

        // 版本输入框
        JComboBox<String> version = new JComboBox<>();
        version.setSize(105, 25);
        for (String v : GlobalEnvironVariable.ActiveSeverVersions){
            version.addItem(v);
        }
        this.Version = version;
        panel.add(version);

        JLabel nameText = new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "download-name"));
        panel.add(nameText);

        // 名字
        JTextField name = new JTextField(20);
        name.setSize(105, 25);
        this.SeverName = name;
        panel.add(name);

        setContentPane(panel);
    }
}
