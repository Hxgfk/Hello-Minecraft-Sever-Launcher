package com.hxgfk.main;

import com.alee.laf.WebLookAndFeel;
import com.hxgfk.window.MainWindow;

import javax.swing.*;

public class Main{
    public static void main(String[] args) {
        new Init(() -> {
            SwingUtilities.invokeLater(WebLookAndFeel::install);
            new MainWindow().setVisible(true);
        }).init();
    }
}
