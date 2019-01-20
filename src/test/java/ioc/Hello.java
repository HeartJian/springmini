package ioc;

public class Hello implements HelloInterface{
    private String world="这是初始world";
    private Hello hello;
    public void sayHello(){
        System.out.print(this.hello.world);
    }

    public  void say(){
        System.out.print(world);
    }
    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public Hello() {
    }
}
