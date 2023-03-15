package Object_Class;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//耕地集合文件操作类
public class Land_List_File {
    public Land_List_File(){
        super();
    }
    public void writeFarmland(String fileName, String sql) throws IOException, SQLException {
        ArrayList<Farmland> list=new ArrayList<>();
        //ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName));
        FileWriter fw=new FileWriter(fileName);
        ResultSet rs=D_B.DB.search("db",sql);
        while(rs.next()){
            String id=rs.getString("id");
            String type=rs.getString("type");
            String location=rs.getString("location");
            String area=rs.getString("area");
            Farmland fl1=new Farmland();
            fl1.setId(id);
            fl1.setType(type);
            fl1.setLocation(location);
            fl1.setArea(area);
            list.add(fl1);
        }
        for(Farmland fl2:list){
            fw.write(fl2.toString());
        }
        fw.close();
    }

}
