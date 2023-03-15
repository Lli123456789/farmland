package Main_Windows;

import Object_Class.D_B;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tquery_Window {
    private JFrame qw;
    private JLabel l1;
    private JLabel l2;
    private JLabel bg;
    private JButton query;
    private JTextField query1;
    private JTextArea qrs;
    private JScrollPane sp;
    public Tquery_Window(){
        qw=new JFrame("查询商户信息");
        qw.setBounds(200, 15, 1200, 800);

        query = new JButton("查询商户信息");
        query.setBounds(500, 100, 150, 35);
        query.setForeground(Color.RED);
        qw.add(query);

        query1 = new JTextField(10);
        query1.setBounds(500, 200, 150, 35);
        query1.setFont(new Font("隶书", Font.BOLD, 20));
        qw.add(query1);

        qrs=new JTextArea();
        //qrs.setBounds(400,300,600,400);
        qrs.setFont(new Font("隶书",Font.BOLD,20));
        //qw.add(qrs);
        sp=new JScrollPane(qrs);
        sp.setBounds(400,300,600,300);
        qw.add(sp);

        l1 = new JLabel("请输入要查询的信息:");
        l1.setFont(new Font("隶书", Font.BOLD, 25));
        l1.setForeground(Color.RED);
        l1.setBounds(200, 200, 300, 30);
        l2=new JLabel("查询的信息为:");
        l2.setFont(new Font("隶书",Font.BOLD,25));
        l2.setForeground(Color.RED);
        l2.setBounds(200,300,200,30);
        qw.add(l1);
        qw.add(l2);

        bg = new JLabel(new ImageIcon("D:\\Farmland\\farmland\\image\\Mqw_bg.png"));
        bg.setBounds(0, 0, 1200, 800);
        qw.add(bg);

        qw.setLayout(null);
        qw.setResizable(false);
        qw.setVisible(true);

        //注册监听器对象
        query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q1 = query1.getText();
                StringBuffer sb = new StringBuffer();
                String sql = "select * from trader where id='" + q1 + "' or name='" + q1 + "' or gender='" + q1 + "'";
                ResultSet rs = D_B.DB.search("db", sql);
                try{
                    while(rs.next()){
                        sb.append("id:");
                        sb.append(rs.getString("id"));
                        sb.append(",name:");
                        sb.append(rs.getString("name"));
                        sb.append(",gender:");
                        sb.append(rs.getString("gender"));
                        sb.append("\n");
                    }
                }catch (SQLException s){
                    s.printStackTrace();
                }
                if(sb.length()==0){
                    JOptionPane.showMessageDialog(qw,"查询失败");
                    query1.setText("");
                }else{
                    JOptionPane.showMessageDialog(qw,"查询成功");
                    qrs.setText(sb.toString());
                    query1.setText("");
                }
            }
        });
    }
}
