package com.hxgfk.sever.window;

import com.hxgfk.util.alerts.Warn;
import com.hxgfk.util.Config;
import com.hxgfk.main.GlobalEnvironVariable;
import com.hxgfk.util.downloader.SeverDownloader;

import javax.swing.*;
import java.util.Objects;

public class  Window extends JFrame {
	public Window() {
		setTitle(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "window-title"));
		setSize(1000,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);


		// 修改按钮
		JButton manager = new JButton(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "button-modify"));
		manager.setBounds(40, 38, 150, 50);
		manager.addActionListener(e -> new ManagerWindow().setVisible(true));
		getContentPane().add(manager);

		// 下载按钮
		JButton download = new JButton(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "button-download"));
		download.setBounds(184, 38, 150, 50);
		download.addActionListener(e -> DownloadWindowInstance.setVisible(true));
		getContentPane().add(download);

		// 下载Forge按钮
		JButton downloadForge = new JButton(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "button-download-forge"));
		downloadForge.setBounds(326, 38, 150, 50);
		getContentPane().add(downloadForge);

		// 启动按钮
		JButton run = new JButton(Config.readValue(GlobalEnvironVariable.SEVER_LANG_WINDOW_PATH, "button-run"));
		run.setBounds(490, 38, 93, 50);
		run.addActionListener(e -> new RunWindow().setVisible(true));
		getContentPane().add(run);
	}

	// 下载窗口
	public final static DownloadWindow DownloadWindowInstance = new DownloadWindow();

	// 启动下载器
	public void runDownload(){
		String version = Objects.requireNonNull(DownloadWindowInstance.Version.getSelectedItem()).toString();
		String name = DownloadWindowInstance.SeverName.getText();
		if (Objects.equals(name, "")){
			new Warn(Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-download-void-title"), Config.readValue(GlobalEnvironVariable.SEVER_LANG_ALERT_PATH, "run-download-void"));
		}else {
			new SeverDownloader().startDownloadSever(name, version);
		}
	}
}
