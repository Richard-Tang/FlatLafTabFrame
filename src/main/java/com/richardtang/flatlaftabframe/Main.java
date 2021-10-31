package com.richardtang.flatlaftabframe;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.icons.FlatClearIcon;

import javax.swing.*;
import java.awt.*;

public class Main {

    static {
        FlatLightLaf.setup();
    }

    public static void main(String[] args) {
        JTextArea jTextArea   = new JTextArea();
        JButton   cleanButton = new JButton(new FlatClearIcon());
        TabFrameItem tabFrameItem = new TabFrameItem(
                new JToggleButton("日志", new FlatSVGIcon("log.svg", 20, 20)),
                new JTextArea(),
                cleanButton
        );
        TabFrameItem tabFrameItem2 = new TabFrameItem(
                new JToggleButton("信息", new FlatSVGIcon("about.svg", 20, 20)),
                new JLabel("Author RichardTang")
        );
        TabFramePanel tabFramePanel = new TabFramePanel(tabFrameItem, tabFrameItem2);

        cleanButton.addActionListener(e -> {
            jTextArea.append("关闭按钮触发\n");
        });

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jTextArea, BorderLayout.CENTER);
        jPanel.add(tabFramePanel, BorderLayout.SOUTH);

        JFrame jFrame = new JFrame();
        jFrame.setSize(600, 800);
        jFrame.setVisible(true);
        jFrame.setContentPane(jPanel);
    }
}
