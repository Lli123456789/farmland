package Main_Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Function {
    //功能窗口
    private JFrame function;
    private JButton add;
    private JButton addm;
    private JButton addt;
    private JButton delete;
    private JButton deletem;
    private JButton deletet;
    private JButton query;
    private JButton querym;
    private JButton queryt;
    private JButton update;
    private JButton updatem;
    private JButton updatet;
    private JButton census;//多维度统计按钮
    private JButton censusm;
    private JButton censust;
    private JLabel l1;
    private JLabel bg;

    public Function() {
        function = new JFrame("耕地信息管理系统");
        function.setBounds(200, 15, 1200, 800);

        l1=new JLabel("请点击以下按钮实现对应功能");
        l1.setFont(new Font("隶书",Font.BOLD,35));
        l1.setForeground(Color.RED);
        l1.setBounds(300,100,500,30);
        function.add(l1);

        add = new JButton("增加耕地信息");
        delete = new JButton("删除耕地信息");
        query = new JButton("查询耕地信息");
        update = new JButton("更改耕地信息");
        census = new JButton("多维度统计耕地信息");

        addm=new JButton("增加管理员信息");
        deletem=new JButton("删除管理员信息");
        querym=new JButton("查询管理员信息");
        updatem=new JButton("更改管理员信息");
        censusm=new JButton("统计管理员信息");

        addt=new JButton("增加商户信息");
        deletet=new JButton("删除商户信息");
        queryt=new JButton("查询商户信息");
        updatet=new JButton("更改商户信息");
        censust=new JButton("商户与耕地信息统计");

        add.setBounds(400, 200, 200, 30);
        delete.setBounds(400, 300, 200, 30);
        query.setBounds(400, 400, 200, 30);
        update.setBounds(400, 500, 200, 30);
        census.setBounds(400, 600, 200, 30);

        addm.setBounds(100,200,200,30);
        deletem.setBounds(100,300,200,30);
        querym.setBounds(100,400,200,30);
        updatem.setBounds(100,500,200,30);
        censusm.setBounds(100,600,200,30);

        addt.setBounds(700, 200, 200, 30);
        deletet.setBounds(700, 300, 200, 30);
        queryt.setBounds(700, 400, 200, 30);
        updatet.setBounds(700, 500, 200, 30);
        censust.setBounds(700, 600, 200, 30);

        add.setForeground(Color.RED);
        delete.setForeground(Color.RED);
        query.setForeground(Color.RED);
        update.setForeground(Color.RED);
        census.setForeground(Color.RED);

        addm.setForeground(Color.RED);
        deletem.setForeground(Color.RED);
        querym.setForeground(Color.RED);
        updatem.setForeground(Color.RED);
        censusm.setForeground(Color.RED);

        addt.setForeground(Color.RED);
        deletet.setForeground(Color.RED);
        queryt.setForeground(Color.RED);
        updatet.setForeground(Color.RED);
        censust.setForeground(Color.RED);

        function.add(add);
        function.add(delete);
        function.add(query);
        function.add(update);
        function.add(census);

        function.add(addm);
        function.add(deletem);
        function.add(querym);
        function.add(updatem);
        function.add(censusm);

        function.add(addt);
        function.add(deletet);
        function.add(queryt);
        function.add(updatet);
        function.add(censust);
        /*
        census1 = new JTextField(10);
        census2 = new JTextField(10);
        census1.setBounds(900, 150, 150, 35);
        census2.setBounds(900, 250, 150, 35);
        census1.setFont(new Font("隶书", Font.BOLD, 20));
        census2.setFont(new Font("隶书", Font.BOLD, 20));


        function.add(census1);
        function.add(census2);


        String c1 = census1.getText();
        String c2 = census2.getText();
         */

        //事件监听器类
        class FunCheck implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == add) {//增加耕地信息
                    new Add_Window();
                } else if (e.getSource() == delete) {//删除耕地信息
                    new Delete_Window();
                } else if (e.getSource() == query) {//查询耕地信息
                    new Query_Window();
                } else if (e.getSource() == update) {//更改耕地信息
                    new Update_Window();
                } else if (e.getSource() == census) {//多维度统计耕地信息
                    try {
                        new Census_Window();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (e.getSource() == addm) {//增加管理员信息
                    new Madd_Window();
                } else if (e.getSource() == deletem) {//删除管理员信息
                    new Mdelete_Window();
                } else if (e.getSource() == querym) {//查询管理员信息
                    new Mquery_Window();
                } else if (e.getSource() == updatem) {//更改管理员信息
                    new Mupdate_Window();
                } else if (e.getSource() == censusm) {//统计管理员信息
                    try {
                        new Mcensus_Window();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }else if(e.getSource()==addt){//增加商户信息
                    new Tadd_Window();
                }else if(e.getSource()==deletet){//删除商户信息
                    new Tdelete_Window();
                }else if(e.getSource()==queryt){//查询商户信息
                    new Tquery_Window();
                }else if(e.getSource()==updatet){//更改商户信息
                    new Tupdate_Window();
                }else if(e.getSource()==censust){//统计商户信息
                    try {
                        new Tcensus_Window();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }

        add.addActionListener(new FunCheck());
        delete.addActionListener(new FunCheck());
        query.addActionListener(new FunCheck());
        update.addActionListener(new FunCheck());
        census.addActionListener(new FunCheck());

        addm.addActionListener(new FunCheck());
        deletem.addActionListener(new FunCheck());
        querym.addActionListener(new FunCheck());
        updatem.addActionListener(new FunCheck());
        censusm.addActionListener(new FunCheck());

        addt.addActionListener(new FunCheck());
        deletet.addActionListener(new FunCheck());
        queryt.addActionListener(new FunCheck());
        updatet.addActionListener(new FunCheck());
        censust.addActionListener(new FunCheck());

        bg = new JLabel(new ImageIcon("D:\\Farmland\\farmland\\image\\Function_bg.png"));
        bg.setBounds(0, 0, 1200, 800);
        function.add(bg);
        function.setLayout(null);
        function.setResizable(false);
        function.setVisible(true);
    }
}
