package Object_Class;

//商户类
public class Trader {
    String id;
    String name;
    String gender;
    public Trader(){};
    public Trader(String id,String name,String gender){
        this.id=id;
        this.name=name;
        this.gender=gender;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender){
        this.gender=gender;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getGender(){
        return gender;
    }

    @Override
    public String toString() {
        return "商户编号:"+this.id+",商户名称:"+this.name+",商户性别:"+this.gender+"\n";
    }
}

