package Main_Windows;

import Object_Class.D_B;
import Object_Class.M_List_File;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class Mupdate_Window {
    private JFrame uw;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel bg;
    private JButton update;
    private JTextField update1;
    private JTextField update2;
    private JTextField update3;
    private JTextField update4;
    public Mupdate_Window(){
        uw=new JFrame("更改管理员信息");
        uw.setBounds(200, 15, 1200, 800);

        update = new JButton("更改管理员信息");
        update.setBounds(500, 100, 150, 30);
        update.setForeground(Color.RED);
        uw.add(update);

        update1 = new JTextField(10);
        update2 = new JTextField(10);
        update3 = new JTextField(10);
        update4=new JTextField(10);
        update1.setBounds(500, 200, 150, 35);
        update2.setBounds(500, 300, 150, 35);
        update3.setBounds(500, 400, 150, 35);
        update4.setBounds(500,500,150,35);
        update1.setFont(new Font("隶书", Font.BOLD, 20));
        update2.setFont(new Font("隶书", Font.BOLD, 20));
        update3.setFont(new Font("隶书", Font.BOLD, 20));
        update4.setFont(new Font("隶书",Font.BOLD,20));
        uw.add(update1);
        uw.add(update2);
        uw.add(update3);
        uw.add(update4);

        l1 = new JLabel("请输入要更改管理员的账号:");
        l2 = new JLabel("更改管理员账号为:");
        l3 = new JLabel("更改管理员密码为:");
        l4=new JLabel("更改管理员名字为:");
        l1.setFont(new Font("隶书", Font.BOLD, 25));
        l2.setFont(new Font("隶书", Font.BOLD, 25));
        l3.setFont(new Font("隶书",Font.BOLD,25));
        l4.setFont(new Font("隶书",Font.BOLD,25));
        l1.setForeground(Color.RED);
        l2.setForeground(Color.RED);
        l3.setForeground(Color.RED);
        l4.setForeground(Color.RED);
        l1.setBounds(150, 200, 600, 30);
        l2.setBounds(250, 300, 500, 30);
        l3.setBounds(250,400,500,30);
        l4.setBounds(250,500,500,30);

        uw.add(l1);
        uw.add(l2);
        uw.add(l3);
        uw.add(l4);

        bg = new JLabel(new ImageIcon("D:\\Farmland\\farmland\\image\\Muw_bg.png"));
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
                String u4=update4.getText();
                String[] sql=new String[3];
                sql[0]="update managers set id='"+u2+"' where id='"+u1+"'";
                sql[1]="update managers set password='"+u3+"' where id='"+u1+"'";
                sql[2]="update managers set name='"+u4+"' where id='"+u1+"'";
                //StringBuffer sb=new StringBuffer();
                for(int i=0;i<3;i++) {
                    D_B.DB.operator("db",sql[i]);
                }
                JOptionPane.showMessageDialog(uw,"更改成功");
                update1.setText("");
                update2.setText("");
                update3.setText("");
                update4.setText("");
                String sql1="select * from managers";
                try {
                    new M_List_File().writeManager("D:\\Farmland\\farmland\\file\\Managers.txt",sql1);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
