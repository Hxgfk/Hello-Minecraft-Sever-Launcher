package com.hxgfk.sever.main;


import com.alee.laf.WebLookAndFeel;
import com.hxgfk.main.Creator;
import com.hxgfk.sever.window.Window;

import javax.swing.*;


public class SeverMain {
    public void run(){
        // Run Main Window
        SwingUtilities.invokeLater(() -> {
            WebLookAndFeel.install();
            new Window().setVisible(true);
        });
    }

    public static void create(){
        Creator c = new Creator();
        c.createUrlsFile();
        c.createHomeDirectory();
        c.createConfigFile();
    }

    // Debug
    public static void main(String[] args) {
        create();
        new SeverMain().run();
    }
}
