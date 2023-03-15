package Main_Windows;

import Object_Class.D_B;
import Object_Class.Land_List_File;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class Add_Window {//增加窗口
    private JFrame aw;
    private JButton add;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel bg;
    private JTextField add1;
    private JTextField add2;
    private JTextField add3;
    private JTextField add4;
    public Add_Window(){
        aw=new JFrame("增加耕地信息");
        aw.setBounds(200, 15, 1200, 800);

        add = new JButton("增加耕地信息");
        add.setBounds(500, 100, 150, 30);
        add.setForeground(Color.RED);
        aw.add(add);

        add1 = new JTextField(10);
        add2 = new JTextField(10);
        add3 = new JTextField(10);
        add4 = new JTextField(10);
        add1.setBounds(500, 200, 150, 35);
        add2.setBounds(500, 300, 150, 35);
        add3.setBounds(500, 400, 150, 35);
        add4.setBounds(500, 500, 150, 35);
        add1.setFont(new Font("隶书", Font.BOLD, 20));
        add2.setFont(new Font("隶书", Font.BOLD, 20));
        add3.setFont(new Font("隶书", Font.BOLD, 20));
        add4.setFont(new Font("隶书", Font.BOLD, 20));
        aw.add(add1);
        aw.add(add2);
        aw.add(add3);
        aw.add(add4);

        l1 = new JLabel("耕地编号:");
        l2 = new JLabel("耕地类型:");
        l3 = new JLabel("耕地位置:");
        l4 = new JLabel("耕地面积:");
        //设置标签字体，大小，位置
        l1.setFont(new Font("隶书", Font.BOLD, 25));
        l2.setFont(new Font("隶书", Font.BOLD, 25));
        l3.setFont(new Font("隶书",Font.BOLD,25));
        l4.setFont(new Font("隶书",Font.BOLD,25));
        l1.setForeground(Color.RED);
        l2.setForeground(Color.RED);
        l3.setForeground(Color.RED);
        l4.setForeground(Color.RED);
        l1.setBounds(300, 200, 180, 30);
        l2.setBounds(300, 300, 180, 30);
        l3.setBounds(300,400,180,30);
        l4.setBounds(300,500,180,30);
        //组装
        aw.add(l1);
        aw.add(l2);
        aw.add(l3);
        aw.add(l4);

        bg = new JLabel(new ImageIcon("D:\\Farmland\\farmland\\image\\Aw_bg.png"));
        bg.setBounds(0, 0, 1200, 800);
        aw.add(bg);

        //设置窗口
        aw.setLayout(null);
        aw.setResizable(false);
        aw.setVisible(true);

        //注册监听器对象
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String ad1 = add1.getText();
                    String ad2 = add2.getText();
                    String ad3 = add3.getText();
                    String ad4 = add4.getText();
                    String sql = "insert into farmland values('" + ad1 + "','" + ad2 + "','" + ad3 + "','" + ad4 + "')";
                    D_B.DB.operator("db", sql);
                    JOptionPane.showMessageDialog(aw, "插入成功！");
                    //增加信息后清空文本框
                    add1.setText("");
                    add2.setText("");
                    add3.setText("");
                    add4.setText("");
                String sql1="select * from farmland";
                try {
                    new Land_List_File().writeFarmland("D:\\Farmland\\farmland\\file\\Farmland.txt",sql1);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                }
        });
    }
}
