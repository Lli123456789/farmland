package Object_Class;

import java.io.Serializable;

//耕地类
public class Farmland implements Serializable {
    private String id;//耕地编号
    private String type;//耕地类型
    private String location;//耕地位置
    private String area;//耕地面积
    public Farmland(){
        super();
    }
    public Farmland(String id,String type,String location,String area){
        this.id=id;
        this.type=type;
        this.location=location;
        this.area=area;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getId(){
        return id;
    }

    public String getType(){
        return type;
    }

    public String getLocation(){
        return location;
    }

    public String getArea(){
        return area;
    }

    @Override
    public String toString() {
        return "耕地编号:"+this.id+"，耕地类型:"+this.type+"，耕地位置:"+this.location+"，耕地面积:"+this.area+"\n";
    }
}
