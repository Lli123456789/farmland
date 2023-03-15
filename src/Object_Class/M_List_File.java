package Object_Class;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//管理员集合文件操作类
public class M_List_File {
    public M_List_File(){
        super();
    }

    public void writeManager(String fileName, String sql) throws IOException, SQLException {
        ArrayList<Manager> list=new ArrayList<>();
        //ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName));
        FileWriter fw=new FileWriter(fileName);
        ResultSet rs=D_B.DB.search("db",sql);
        while(rs.next()){
            String id=rs.getString("id");
            String password=rs.getString("password");
            String name=rs.getString("name");
            Manager m1=new Manager();
            m1.setId(id);
            m1.setPassword(password);
            m1.setName(name);
            list.add(m1);
        }
        for(Manager m2:list){
            fw.write(m2.toString());
        }
        fw.close();
    }
}
