package Main_Windows;

import Object_Class.D_B;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Census_Window {//统计窗口
    private JFrame cw;

    private JLabel bg;

    //操作表格的行与列
    private DefaultTableModel dtm;//耕地数据表
    private DefaultTableModel dtm1; //耕地类型占比表
    private DefaultTableModel dtm2;//耕地面积占比表
    private DefaultTableModel dtm3;//耕地类型数量表
    private DefaultTableModel dtm4;//耕地面积数量表
    JTable table;
    JTable table1;
    JTable table2;
    JTable table3;
    JTable table4;
    JScrollPane sp;
    JScrollPane sp1;
    JScrollPane sp2;
    JScrollPane sp3;
    JScrollPane sp4;

    public Census_Window() throws SQLException {
        cw = new JFrame("统计耕地信息");
        cw.setBounds(200, 15, 1200, 800);

        dtm = new DefaultTableModel();
        dtm1 = new DefaultTableModel();
        dtm2 = new DefaultTableModel();
        dtm3=new DefaultTableModel();
        dtm4=new DefaultTableModel();
        String[] head = {"耕地编号", "耕地类型", "耕地位置", "耕地面积"};
        String[] head1 = {"水田占比", "旱地占比", "梯田占比"};
        String[] head2 = {"50-100平米耕地占比", "100平米以上耕地占比"};
        String[] head3={"水田数","旱地数","梯田数"};
        String[] head4={"50-100平米耕地数","100平米以上耕地数"};

        //水田，旱地，梯田
        double water = 0, dry = 0, land = 0, count = 0;
        //50-100平米和100平米以上耕地数
        double a1 = 0, a2 = 0;
        for (int i = 0; i < head.length; i++) {
            dtm.addColumn(head[i]);
        }
        for (int j = 0; j < head1.length; j++) {
            dtm1.addColumn(head1[j]);
        }
        for (int k = 0; k < head2.length; k++) {
            dtm2.addColumn(head2[k]);
        }
        for(int x=0;x<head3.length;x++){
            dtm3.addColumn(head3[x]);
        }
        for (int y=0;y<head4.length;y++){
            dtm4.addColumn(head4[y]);
        }
        String sql = "select * from farmland";
        ResultSet rs = D_B.DB.search("db", sql);
        while (rs.next()) {
            double d = Double.parseDouble(rs.getString("area"));
            if (rs.getString("type").equals("水田"))
                water++;
            else if (rs.getString("type").equals("旱地"))
                dry++;
            else if (rs.getString("type").equals("梯田"))
                land++;
            if (d>=50&&d<100)
                a1++;
            else if (d>=100)
                a2++;
            //耕地数据表
            dtm.addRow(new Object[]{rs.getString("id"), rs.getString("type"), rs.getString("location"), rs.getString("area")});
            count++;
        }
        //水田 旱地 梯田的占比
        double r1 = water / count;
        double r2 = dry / count;
        double r3 = land / count;
        //50-100平米和100平米以上耕地占比
        double r4 = a1 / count;
        double r5 = a2 / count;
        //保留两位小数
        String s1 = String.format("%.2f", r1 * 100);
        String s2 = String.format("%.2f", r2 * 100);
        String s3 = String.format("%.2f", r3 * 100);
        String s4 = String.format("%.2f", r4 * 100);
        String s5 = String.format("%.2f", r5 * 100);
        String water1=String.format("%.0f",water);
        String dry1=String.format("%.0f",dry);
        String land1=String.format("%.0f",land);
        String as1=String.format("%.0f",a1);
        String as2=String.format("%.0f",a2);
        //化为百分比
        String sr1 = s1.concat("%");
        String sr2 = s2.concat("%");
        String sr3 = s3.concat("%");
        String sr4 = s4.concat("%");
        String sr5 = s5.concat("%");

        //double a = 0.22;
        //String S = String.valueOf(a * 100 + "%");
        //System.out.println(S);

        //耕地数据表
        table = new JTable(dtm);
        table.setForeground(Color.RED);
        table.setBackground(Color.CYAN);
        sp = new JScrollPane(table);
        sp.setBounds(50, 50, 600,650);

        //耕地类型占比表
        dtm1.addRow(new Object[]{sr1, sr2, sr3});
        table1 = new JTable(dtm1);
        table1.setForeground(Color.RED);
        table1.setBackground(Color.CYAN);
        sp1 = new JScrollPane(table1);
        sp1.setBounds(700, 250, 400, 50);

        //耕地面积占比表
        dtm2.addRow(new Object[]{sr4, sr5});
        table2 = new JTable(dtm2);
        table2.setForeground(Color.RED);
        table2.setBackground(Color.CYAN);
        sp2 = new JScrollPane(table2);
        sp2.setBounds(700, 550, 400, 50);

        //耕地类型数量表
        dtm3.addRow(new Object[]{water1,dry1,land1});
        table3=new JTable(dtm3);
        table3.setForeground(Color.RED);
        table3.setBackground(Color.CYAN);
        sp3=new JScrollPane(table3);
        sp3.setBounds(700,100,400,50);

        //耕地面积数量表
        dtm4.addRow(new Object[]{as1,as2});
        table4=new JTable(dtm4);
        table4.setForeground(Color.RED);
        table4.setBackground(Color.CYAN);
        sp4=new JScrollPane(table4);
        sp4.setBounds(700,400,400,50);

        cw.add(sp);
        cw.add(sp1);
        cw.add(sp2);
        cw.add(sp3);
        cw.add(sp4);

        bg = new JLabel(new ImageIcon("D:\\Farmland\\farmland\\image\\Cw_bg.png"));
        bg.setBounds(10, 0, 1200, 800);
        cw.add(bg);

        cw.setLayout(null);
        cw.setResizable(false);
        cw.setVisible(true);
    }
}
