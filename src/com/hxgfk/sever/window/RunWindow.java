package com.hxgfk.sever.window;

import com.hxgfk.sever.main.SeverRunner;
import com.hxgfk.util.Config;
import com.hxgfk.main.GlobalEnvironVariable;

import javax.swing.*;
import java.io.File;
import java.util.Objects;

public class RunWindow extends JFrame {
    private final JComboBox<String> list = new JComboBox<>();
    public RunWindow(){
        setTitle(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "run-window"));
        setSize(500,100);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        setResizable(false);

        // 启动按钮
        JButton RunSever = new JButton(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "run-window-start"));
        RunSever.setBounds(40, 38, 105, 50);
        RunSever.addActionListener(e -> {
            SeverRunner runner = new SeverRunner(Objects.requireNonNull(list.getSelectedItem()).toString());
            runner.run();
        });
        panel.add(RunSever);

        // 文字
        JLabel text = new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "run-window-name"));
        panel.add(text);

        // 服务器列表
        String[] l = Objects.requireNonNull(new File(GlobalEnvironVariable.HomeDirectoryPath+"\\severs\\").list());
        for (String s : l){
            list.addItem(s);
        }
        panel.add(list);

        // 设置面板
        setContentPane(panel);
    }
}
