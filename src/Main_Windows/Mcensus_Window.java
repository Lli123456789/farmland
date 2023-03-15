package Main_Windows;

import Object_Class.D_B;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mcensus_Window {
    private JFrame cw;
    private JLabel bg;
    private DefaultTableModel dtm;
    JTable table;
    JScrollPane sp;
    public Mcensus_Window() throws SQLException {
        cw = new JFrame("统计管理员信息");
        cw.setBounds(200, 15, 1200, 800);
        dtm = new DefaultTableModel();
        String[] head = {"管理员账号", "管理员密码", "管理员姓名"};
        for (int i = 0; i < head.length; i++) {
            dtm.addColumn(head[i]);
        }
        String sql = "select * from managers";
        ResultSet rs = D_B.DB.search("db", sql);
        while (rs.next()) {
            dtm.addRow(new Object[]{rs.getString("id"), rs.getString("password"), rs.getString("name")});
        }

        table = new JTable(dtm);
        table.setForeground(Color.RED);
        table.setBackground(Color.CYAN);
        sp = new JScrollPane(table);
        sp.setBounds(300, 50, 600, 650);
        cw.add(sp);

        bg = new JLabel(new ImageIcon("D:\\Farmland\\farmland\\image\\Cw_bg.png"));
        bg.setBounds(10, 0, 1200, 800);
        cw.add(bg);

        cw.setLayout(null);
        cw.setResizable(false);
        cw.setVisible(true);

    }
}
