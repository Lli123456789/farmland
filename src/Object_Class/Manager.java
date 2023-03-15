package Object_Class;

import java.io.Serializable;

//管理员类
public class Manager implements Serializable {
    private String id;
    private String password;
    private String name;
    public Manager(){
        super();
    }
    public Manager(String id,String password,String name){
        this.id=id;
        this.password=password;
        this.name=name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "账号:"+this.id+",密码:"+this.password+",名字:"+this.name+"\n";
    }
}
