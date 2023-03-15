package Object_Class;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//数据库连接类
public class D_B {

    //唯一对象
    public static final D_B DB = new D_B();
    private PreparedStatement statement;
    Connection connection;

    //私有化构造方法
    private D_B() {
    }

    //连接数据库
    public boolean connect(String DBName) {
        //创建一个数据源对象
        MysqlDataSource dataSource = new MysqlDataSource();
        //把数据库位置信息添加到DataSource
        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/" + DBName + "?characterEncoding=utf8&useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("123456");

        //从数据源取得连接
        try {
            connection = dataSource.getConnection();
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    //查找并返回ResultSet集合
    public ResultSet search(String DBName, String sql) {

        ResultSet resultSet = null;

        if (connect(DBName)) {
            System.out.println("连接成功");
            try {
                statement = connection.prepareStatement(sql);
                //执行SQL
                resultSet = statement.executeQuery();//执行并且返回执行结果
            } catch (Exception e) {
                System.out.println("操作失败！");
            }
        } else {
            System.out.println("连接失败！");
        }
        return resultSet;
    }



    //插入sql语句
    public void operator(String DBName, String sql) {
        if (connect(DBName)) {
            System.out.println("连接成功");
            try {
                statement = connection.prepareStatement(sql);
                int rs= statement.executeUpdate();
                if (rs > 0) {
                    System.out.println("操作成功！");
                }
                //执行完 SQL 之后，回收资源
                statement.close();
                // 客户端与服务器的连接
                connection.close();
            } catch (Exception e) {
                System.out.println("插入失败！");
            }
        } else {
            System.out.println("连接失败！");
        }
    }

    //===============================================================
    public void close(){
        try {
            statement.close();
            connection.close();
            System.out.println("连接关闭成功！");
        }catch (Exception e){
            System.out.println("连接关闭异常！");
        }
    }

}


