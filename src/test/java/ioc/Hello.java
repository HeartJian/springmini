package ioc;

public class Hello {
    private String world;
    private Hello hello;
    public void sayHello(){
        System.out.print(this.hello.world);
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
