package Main_Windows;

import Object_Class.D_B;
import Object_Class.Farmland;
import Object_Class.Trader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tcensus_Window {
    private Map<Trader, Farmland> map;
    private JFrame cw;
    private JLabel bg;
    private DefaultTableModel dtm;
    JTable table;
    JScrollPane sp;
    public Tcensus_Window() throws SQLException {
        map=new HashMap<>();

        cw = new JFrame("统计商户与耕地信息");
        cw.setBounds(200, 15, 1200, 800);

        dtm = new DefaultTableModel();
        String[] head={"商户编号","商户名称","商户性别","耕地编号","耕地类型","耕地位置","耕地面积"};
        for(int i=0;i<7;i++){
            dtm.addColumn(head[i]);
        }

        String sql1="select * from farmland ";
        String sql2="select * from trader";
        ResultSet rs1= D_B.DB.search("db",sql1);
        ResultSet rs2=D_B.DB.search("db",sql2);

        //从数据库中取出相对应的商户与耕地信息存入图中
        while(rs1.next()&&rs2.next()){

            String fid=rs1.getString("id");
            String type=rs1.getString("type");
            String location=rs1.getString("location");
            String area=rs1.getString("area");

            String tid=rs2.getString("id");
            String name=rs2.getString("name");
            String gender=rs2.getString("gender");
            if(fid.equals(tid)){
                Farmland fl=new Farmland(fid,type,location,area);
                Trader trader=new Trader(tid,name,gender);
                map.put(trader,fl);
            }
        }
        //遍历map集合
        Set<Map.Entry<Trader,Farmland>> entrySet=map.entrySet();
        for(Map.Entry<Trader,Farmland> me:entrySet){
            Trader trader=me.getKey();
            Farmland fl=me.getValue();
            dtm.addRow(new Object[]{trader.getId(),trader.getName(),trader.getGender(),fl.getId(),fl.getType(),fl.getLocation(),fl.getArea()});
        }

        table = new JTable(dtm);
        table.setForeground(Color.RED);
        table.setBackground(Color.CYAN);
        sp = new JScrollPane(table);
        sp.setBounds(100, 50, 700, 650);
        cw.add(sp);

        bg = new JLabel(new ImageIcon("D:\\Farmland\\farmland\\image\\Cw_bg.png"));
        bg.setBounds(10, 0, 1200, 800);
        cw.add(bg);

        cw.setLayout(null);
        cw.setResizable(false);
        cw.setVisible(true);
    }
}

