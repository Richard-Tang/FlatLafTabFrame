# FlatLafTabFrame

## 介绍

如果你正在使用Swing + [FLatLaf](https://github.com/JFormDesigner/FlatLaf)来制作GUI程序，那么你可能会需要以下效果。像IntelliJ里的面板那样

这是一个精简的效果，它只能放在Bottom的方向进行使用，他只依赖FLatLaf，在Java8和Java11上都可以正常运行。

![show](https://user-images.githubusercontent.com/30547741/139590200-0c6a5d97-fb22-4d30-9a11-e30e21a6cfb7.gif)

<img width="948" alt="image" src="https://user-images.githubusercontent.com/30547741/198232994-b01d1910-f986-473e-aa41-63233f909514.png">

## Demo

另外这个项目不会打包成Jar包，因为他只有仅仅的五个类，你可以直接copy到自己项目中直接进行使用，方便进行调整。下边的代码对应了上边gif图片的案例

```java
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
```

## 其他

如果你想实现复杂的布局的话，可参考以下的资料，下边的资料中其实都已经实现了这些效果。但是他们依赖的东西太多或者太过陈旧。

* https://github.com/hedingwei/GUIPack-IntelliJ
* https://github.com/weisJ/darklaf/wiki/Components#jtabframe
* https://github.com/bobbylight/FifeCommon
