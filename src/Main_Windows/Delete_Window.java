package Main_Windows;

import Object_Class.D_B;
import Object_Class.Land_List_File;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class Delete_Window {//删除窗口
    private JFrame dw;
    private JLabel l1;
    private JLabel bg;
    private JButton delete;
    private JTextField delete1;
    public Delete_Window(){
        dw=new JFrame("删除耕地信息");
        dw.setBounds(200, 15, 1200, 800);

        delete = new JButton("删除耕地信息");
        delete.setBounds(500, 200, 150, 35);
        delete.setForeground(Color.RED);
        dw.add(delete);

        delete1 = new JTextField(10);
        delete1.setBounds(500, 300, 150, 35);
        delete1.setFont(new Font("隶书", Font.BOLD, 20));
        dw.add(delete1);

        l1 = new JLabel("请输入要删除的信息:");
        l1.setFont(new Font("隶书", Font.BOLD, 25));
        l1.setForeground(Color.RED);
        l1.setBounds(200, 300, 300, 30);
        dw.add(l1);

        bg = new JLabel(new ImageIcon("D:\\Farmland\\farmland\\image\\Dw_bg.png"));
        bg.setBounds(0, 0, 1200, 800);
        dw.add(bg);

        dw.setLayout(null);
        dw.setResizable(false);
        dw.setVisible(true);

        //注册监听器对象
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String d1 = delete1.getText();
                String sql="delete from farmland where id='"+d1+"' or type='"+d1+"' or location='"+d1+"' or area='"+d1+"'";
                D_B.DB.operator("db",sql);
                JOptionPane.showMessageDialog(dw,"删除成功！");
                delete1.setText("");
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
