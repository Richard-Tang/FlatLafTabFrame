package com.richardtang.flatlaftabframe;

import com.formdev.flatlaf.util.UIScale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * 工具条，TabFrame最底下的功能条目。
 *
 * @author RichardTang
 */
public class TabFrameBar extends JPanel {

    private JToolBar toolBar = new JToolBar();

    // 存储ToolBar中的按钮
    private ArrayList<JToggleButton> toolBarItems = new ArrayList<>();

    /**
     * 创建一个TabFramePanel中的ToolBar
     *
     * @param barItems 需要添加到ToolBar中的按钮
     */
    public TabFrameBar(JToggleButton... barItems) {
        initializeToolBar(barItems);

        setLayout(new BorderLayout());
        add(toolBar, BorderLayout.WEST);
        setBorder(new MLineBorder(1, false, false, true, true));
    }

    /**
     * 初始化ToolBar，主要将用户自定义的ToggleButton添加到ToolBar中，以及定义一些样式。
     *
     * @param barItems 用户自定义按钮
     */
    private void initializeToolBar(JToggleButton... barItems) {
        toolBar.setRollover(true);
        toolBar.setFloatable(false);
        toolBar.setBorder(new MLineBorder(-1, false, false, false, false));

        // 将用户自定义的按钮添加到ToolBar上
        for (JToggleButton item : barItems) {
            item.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
            item.setBorder(new EmptyBorder(UIScale.scale(4), UIScale.scale(10), UIScale.scale(4), UIScale.scale(10)));
            toolBar.add(item);
            this.toolBarItems.add(item);
        }
    }

    /**
     * 获取ToolBar中存储的所有JToggleButton按钮
     *
     * @return 存储toolBar中按钮的集合
     */
    public ArrayList<JToggleButton> getToolBarItems() {
        return toolBarItems;
    }
}
