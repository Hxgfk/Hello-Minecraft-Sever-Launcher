package com.hxgfk.window;


import com.hxgfk.util.Config;
import com.hxgfk.main.GlobalEnvironVariable;
import com.hxgfk.util.VerticalLayoutManager;
import com.hxgfk.sever.main.SeverMain;

import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow(){
        setTitle(Config.readValue(GlobalEnvironVariable.MAIN_LANG_WINDOW_PATH, "main-title"));
        setResizable(false);
        setSize(250, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new VerticalLayoutManager());

        // Text
        JLabel label = new JLabel(Config.readValue(GlobalEnvironVariable.MAIN_LANG_WINDOW_PATH, "main-text-menu"));
        panel.add(label);

        // Client
        JButton client = new JButton(Config.readValue(GlobalEnvironVariable.MAIN_LANG_WINDOW_PATH, "main-button-client"));
        client.setSize(250, 50);
        panel.add(client);

        // Sever
        JButton sever = new JButton(Config.readValue(GlobalEnvironVariable.MAIN_LANG_WINDOW_PATH, "main-button-sever"));
        sever.setSize(250, 50);
        sever.addActionListener(e -> new SeverMain());
        panel.add(sever);

        // 添加组件
        setContentPane(panel);
    }
}
