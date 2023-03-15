package Main_Windows;

import Object_Class.D_B;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query_Window {//查询窗口
    private JFrame qw;
    private JLabel l1;
    private JLabel l2;
    private JLabel bg;
    private JButton query;
    private JTextField query1;
    private JTextArea qrs;
    private JScrollPane sp;
    public Query_Window(){
        qw=new JFrame("查询耕地信息");
        qw.setBounds(200, 15, 1200, 800);

        query = new JButton("查询耕地信息");
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

        sp = new JScrollPane(qrs);
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

        bg = new JLabel(new ImageIcon("D:\\Farmland\\farmland\\image\\Qw_bg.png"));
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
                String sql = "select * from farmland where id='" + q1 + "' or type='" + q1 + "' or location='" + q1 + "' or area='" + q1 + "'";
                ResultSet rs = D_B.DB.search("db", sql);
                /*String sql1 = "select * from farmland";
                try {
                    new Land_List_File().writeFarmland("D:\\桌面\\farmland\\farmland_File\\Farmland.txt", sql1);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                ArrayList<Farmland> list;
                try {
                    list = new Land_List_File().readFarmland("D:\\桌面\\farmland\\farmland_File\\Farmland.txt");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                Iterator it = list.iterator();
                while(it.hasNext()){
                    sb.append(it.next());
                }
                if(sb.length()==0){
                    JOptionPane.showMessageDialog(qw,"查询失败");
                    query1.setText("");
                }else {
                    JOptionPane.showMessageDialog(qw, "查询成功");
                    qrs.setText(sb.toString());
                    query1.setText("");
                }

                 */

                try{
                    while(rs.next()){
                        sb.append("id:");
                        sb.append(rs.getString("id"));
                        sb.append(",type:");
                        sb.append(rs.getString("type"));
                        sb.append(",location:");
                        sb.append(rs.getString("location"));
                        sb.append(",area:");
                        sb.append(rs.getString("area"));
                        sb.append("\n");
                    }
                }catch (SQLException s){
                    s.printStackTrace();
                }
                if(sb.length()==0){
                    JOptionPane.showMessageDialog(qw,"查询的信息不存在，请重新查询");
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
