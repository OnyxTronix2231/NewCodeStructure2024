package frc.robot.logging.benPOC;

public class Test {

    String name;

    public Test(String name) {
        this.name = name;
    }

    @OnyxLog
    public void printName(){
        System.out.println(this.name);
    }
}
