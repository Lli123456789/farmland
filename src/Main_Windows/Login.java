package Main_Windows;

import Object_Class.D_B;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login {
    //登录窗口
    private JFrame login;
    //设置账户标签，密码标签，背景图片，logo，欢迎
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;

    private JLabel bg;
    //账号文本框,密码文本框,管理员登录按钮
    private JTextField account;
    private JTextField password;
    private JButton btn1;
    private JButton btn2;//注册按钮

    public Login() {
        //初始化组件
        login = new JFrame("耕地信息管理系统登录");
        l1 = new JLabel("账号：");
        l2 = new JLabel("密码：");
        l3 = new JLabel("请登录");
        l4=new JLabel("第一次登录请点击注册账号");

        //设置标签字体，大小，位置
        l1.setFont(new Font("隶书", Font.BOLD, 30));
        l2.setFont(new Font("隶书", Font.BOLD, 30));
        l3.setFont(new Font("隶书",Font.BOLD,50));
        l4.setFont(new Font("隶书",Font.BOLD,50));
        l1.setForeground(Color.RED);
        l2.setForeground(Color.RED);
        l3.setForeground(Color.RED);
        l4.setForeground(Color.RED);
        l1.setBounds(220, 260, 180, 30);
        l2.setBounds(220, 310, 180, 30);
        l3.setBounds(500,100,180,30);
        l4.setBounds(300,550,700,30);
        //组装
        login.add(l1);
        login.add(l2);
        login.add(l3);
        login.add(l4);

        //初始化文本框
        account = new JTextField(10);
        password = new JTextField(10);
        //设置大小，字体
        account.setBounds(310, 260, 200, 40);
        password.setBounds(310, 310, 200, 40);
        account.setFont(new Font("隶书", Font.BOLD, 20));
        password.setFont(new Font("隶书", Font.BOLD, 20));
        //组装
        login.add(account);
        login.add(password);

        //初始化登录按钮
        btn1 = new JButton("管理员登录");
        btn2 = new JButton("注册账号");
        btn1.setBounds(460, 450, 150, 30);
        btn2.setBounds(200, 450, 150, 25);
        //组装
        login.add(btn1);
        login.add(btn2);

        //设置窗口背景，
        login.setBounds(200, 15, 1200, 800);
        bg = new JLabel(new ImageIcon("D:\\Farmland\\farmland\\image\\Login_bg.png"));
        bg.setBounds(0, 0, 1200, 800);
        login.add(bg);

        //设置窗口
        login.setLayout(null);
        login.setResizable(false);
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //实例化监听器，对按钮增加监听器
        btn1.addActionListener(new LoginCheck());
        btn2.addActionListener(new LoginCheck());
    }

    //创建事件监听类
    class LoginCheck implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //从文本框中取得账户，密码
            String Account = account.getText();
            String Password = password.getText();

            //sql语句
            String sql = null;

            if (e.getSource() == btn2) {//创建账号
                //管理员名称
                String new_name;
                //账号
                String new_id;
                //密码
                String new_p;
                //提示创建一个账号
                new_id = JOptionPane.showInputDialog(login, "输入一个账号", "**创建账号", JOptionPane.INFORMATION_MESSAGE);
                if (new_id != null) {
                    //创建账号密码
                    new_p = JOptionPane.showInputDialog(login, "设置密码(最好是特殊符号,英文,数字组合)：", "设置密码", JOptionPane.INFORMATION_MESSAGE);
                    if (new_p != null) {
                        new_name=JOptionPane.showInputDialog(login,"输入管理员名:","设置管理员名",JOptionPane.INFORMATION_MESSAGE);
                        if(new_name!=null){
                            sql = "insert into managers values('" + new_id + "','" + new_p + "','"+new_name+"')";
                            System.out.println(sql);
                            D_B.DB.operator("db", sql);
                            JOptionPane.showMessageDialog(login, "您的账户信息如下：\n账号：" + new_id + "\n密码：" + new_p+"\n名字："+new_name, "**账户信息", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                return;
            } else if (e.getSource() == btn1) {
                //创建sql语句
                sql = "select * from managers where id = '" + Account + "' and " + "password = " + "'" + Password + "'";
            }

            //从数据库中匹配信息
            ResultSet resultSet = D_B.DB.search("db", sql);
            //账户与密码
            String id = null;
            String ps = null;
            //遍历结果集合，结果集合非常类似于迭代器
            try {
                while (resultSet.next()) {
                    id = resultSet.getString("id");
                    System.out.println(id);
                    ps = resultSet.getString("password");
                    System.out.println(ps);
                }
            } catch (Exception f) {
                System.out.println("登录失败");
            }
            //如果匹配成功
            if (Account.equals(id)&&Password.equals(ps)) {
                //login.dispose();
                new Function();
                account.setText("");
                password.setText("");
            } else {
                //如果匹配失败,弹出提示框，文本框清空
                JOptionPane.showMessageDialog(login, "账号或密码错误!", "**登录失败", JOptionPane.INFORMATION_MESSAGE);
                account.setText("");
                password.setText("");
            }
        }
    }

}


