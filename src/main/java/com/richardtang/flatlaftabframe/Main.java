package com.richardtang.flatlaftabframe;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.icons.FlatClearIcon;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Main {

    static {
        FlatLightLaf.setup();
    }

    public static void main(String[] args) {
        JTextArea jTextArea = new JTextArea();
        JButton cleanButton = new JButton(new FlatClearIcon());
        cleanButton.addActionListener(e -> {
            jTextArea.append("关闭按钮触发\n");
        });

        // 创建日志按钮选项
        TabFrameItem tabFrameItem = new TabFrameItem(
                new JToggleButton("日志", new FlatSVGIcon("log.svg", 20, 20)),
                new JTextArea(),
                cleanButton
        );
        // 创建信息按钮选项
        TabFrameItem tabFrameItem2 = new TabFrameItem(
                new JToggleButton("信息", new FlatSVGIcon("about.svg", 20, 20)),
                new JLabel("Author RichardTang")
        );
        // 将两个选项添加至面板中
        TabFramePanel tabFramePanel = new TabFramePanel(tabFrameItem, tabFrameItem2);

        // 在面板右下角添加一个进度条
        JProgressBar jProgressBar = new JProgressBar();
        jProgressBar.setMinimum(0);
        jProgressBar.setMaximum(100);
        jProgressBar.setStringPainted(true);
        JPanel jProgressBarPanel = new JPanel();
        jProgressBarPanel.add(jProgressBar);
        tabFramePanel.getTabFrameBar().addBarRightItem(jProgressBarPanel);

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
