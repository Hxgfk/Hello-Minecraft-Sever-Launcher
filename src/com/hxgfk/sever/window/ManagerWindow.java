package com.hxgfk.sever.window;

import com.hxgfk.util.Config;
import com.hxgfk.util.VerticalLayoutManager;
import com.hxgfk.main.GlobalEnvironVariable;

import javax.swing.*;
import java.io.File;
import java.util.Objects;

public class ManagerWindow extends JFrame {
    // button distance
    public final int posX = 144;
    // Sever Name
    private final JComboBox<String> list = new JComboBox<>();
    // IP
    private final JTextField ip = new JTextField(12);
    // port
    // max value 65535
    private final JTextField port = new JTextField(5);
    // default game mode
    // creative=1,surival=0,adventure=2
    private final JComboBox<String> DefaultGameMode = new JComboBox<>();
    // allow player go to nether
    private final JComboBox<Boolean> AllowNether = new JComboBox<>();

    public ManagerWindow(){
        setTitle(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-title"));
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new VerticalLayoutManager());
        // 加载服务器列表
        String[] l = Objects.requireNonNull(new File(GlobalEnvironVariable.HomeDirectoryPath+"\\severs\\").list());
        for (String s : l){
            list.addItem(s);
        }
        list.addActionListener(e -> this.load());

        // 应用按钮
        JButton finish = new JButton(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-active"));
        finish.setBounds(40, 38, 93, 50);
        panel.add(finish);

        // 文字
        JLabel text = new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-sever-name"));
        text.setBounds(40+posX, 38, 100, 30);
        panel.add(text);

        // 服务器列表
        list.setBounds(40+posX*2, 38, 35, 15);
        panel.add(list);

        // text
        text = new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-ip"));
        text.setLocation(40+posX*3, 38);
        panel.add(text);

        // IP
        ip.setLocation(40+posX*4, 38);
        panel.add(ip);

        // text
        text = new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-port"));
        text.setLocation(40+posX*5, 38);
        panel.add(text);

        // 端口
        port.setLocation(40+posX*6, 38);
        panel.add(port);

        // text
        text = new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-default-game-mode"));
        text.setLocation(40+posX*7, 38);
        panel.add(text);

        // 游戏模式
        DefaultGameMode.setLocation(40+posX*8, 38);
        DefaultGameMode.addItem(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-game-mode-creative"));
        DefaultGameMode.addItem(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-game-mode-survival"));
        DefaultGameMode.addItem(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-game-mode-adventure"));
        DefaultGameMode.addItem(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-game-mode-spectator"));
        panel.add(DefaultGameMode);

        // text
        text = new JLabel(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "manager-allow-nether"));
        text.setLocation(40+posX*9, 38);
        panel.add(text);

        // 允许玩家进入下界
        AllowNether.setLocation(40+posX*10, 38);
        AllowNether.addItem(true);
        AllowNether.addItem(false);
        panel.add(AllowNether);

        // 添加组件
        setContentPane(panel);
    }

    public void load(){
        String path = GlobalEnvironVariable.HomeDirectoryPath+"\\severs\\"+ Objects.requireNonNull(list.getSelectedItem())+"\\server.properties";
        this.ip.setText(Config.readValue(path, "server-ip"));
        this.port.setText(Config.readValue(path, "server-port"));
        this.DefaultGameMode.setSelectedItem(this.GameModeEncoder(Objects.requireNonNull(Config.readValue(path, "gamemode"))));
    }

    // int
    public String GameModeEncoder(String mode){
        String encoded = null;
        switch (mode){
            case "0":
                encoded = "生存模式";
                break;
            case "1":
                encoded = "创造模式";
                break;
            case "2":
                encoded = "冒险模式";
                break;
            case "3":
                encoded = "旁观者模式";
                break;
        }
        return encoded;
    }
}
