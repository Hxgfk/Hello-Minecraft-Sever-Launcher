package com.hxgfk.util.alerts;

import javax.swing.*;

public class Warn{
    public Warn(String title, String say){
        JOptionPane.showMessageDialog(null, say, title, JOptionPane.WARNING_MESSAGE);
    }
}
