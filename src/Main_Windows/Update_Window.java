package Main_Windows;


import Object_Class.D_B;
import Object_Class.Land_List_File;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class Update_Window {//更改窗口
    private JFrame uw;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private JLabel bg;
    private JButton update;
    private JTextField update1;
    private JTextField update2;
    private JTextField update3;
    private JTextField update4;
    private JTextField update5;
    public Update_Window(){
        uw=new JFrame("更改耕地信息");
        uw.setBounds(200, 15, 1200, 800);

        update = new JButton("更改耕地信息");
        update.setBounds(500, 100, 150, 30);
        update.setForeground(Color.RED);
        uw.add(update);

        update1 = new JTextField(10);
        update2 = new JTextField(10);
        update3 = new JTextField(10);
        update4 = new JTextField(10);
        update5=new JTextField(10);
        update1.setBounds(500, 200, 150, 35);
        update2.setBounds(500, 300, 150, 35);
        update3.setBounds(500, 400, 150, 35);
        update4.setBounds(500, 500, 150, 35);
        update5.setBounds(500,600,150,35);
        update1.setFont(new Font("隶书", Font.BOLD, 20));
        update2.setFont(new Font("隶书", Font.BOLD, 20));
        update3.setFont(new Font("隶书", Font.BOLD, 20));
        update4.setFont(new Font("隶书", Font.BOLD, 20));
        update5.setFont(new Font("隶书",Font.BOLD,20));
        uw.add(update1);
        uw.add(update2);
        uw.add(update3);
        uw.add(update4);
        uw.add(update5);

        l1 = new JLabel("请输入要更改耕地的编号:");
        l2=new JLabel("更改耕地编号为:");
        l3 = new JLabel("更改耕地类型为:");
        l4 = new JLabel("更改耕地位置为:");
        l5 = new JLabel("更改耕地面积为:");
        l1.setFont(new Font("隶书", Font.BOLD, 25));
        l2.setFont(new Font("隶书", Font.BOLD, 25));
        l3.setFont(new Font("隶书",Font.BOLD,25));
        l4.setFont(new Font("隶书",Font.BOLD,25));
        l5.setFont(new Font("隶书",Font.BOLD,25));
        l1.setForeground(Color.RED);
        l2.setForeground(Color.RED);
        l3.setForeground(Color.RED);
        l4.setForeground(Color.RED);
        l5.setForeground(Color.RED);
        l1.setBounds(200, 200, 300, 30);
        l2.setBounds(300, 300, 250, 30);
        l3.setBounds(300,400,250,30);
        l4.setBounds(300,500,250,30);
        l5.setBounds(300,600,250,30);

        uw.add(l1);
        uw.add(l2);
        uw.add(l3);
        uw.add(l4);
        uw.add(l5);

        bg = new JLabel(new ImageIcon("D:\\Farmland\\farmland\\image\\Uw_bg.png"));
        bg.setBounds(0, 0, 1200, 800);
        uw.add(bg);

        uw.setLayout(null);
        uw.setResizable(false);
        uw.setVisible(true);

        //注册监听器对象
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String u1 = update1.getText();
                String u2 = update2.getText();
                String u3 = update3.getText();
                String u4 = update4.getText();
                String u5=update5.getText();
                String[] sql=new String[4];
                sql[0]="update farmland set id='"+u2+"' where id='"+u1+"'";
                sql[1]="update farmland set type='"+u3+"' where id='"+u1+"'";
                sql[2]="update farmland set location='"+u4+"' where id='"+u1+"'";
                sql[3]="update farmland set area='"+u5+"' where id='"+u1+"'";
                //StringBuffer sb=new StringBuffer();
                for(int i=0;i<4;i++) {
                    D_B.DB.operator("db",sql[i]);
                }
                JOptionPane.showMessageDialog(uw,"更改成功");
                update1.setText("");
                update2.setText("");
                update3.setText("");
                update4.setText("");
                update5.setText("");
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
