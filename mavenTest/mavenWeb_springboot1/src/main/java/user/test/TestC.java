package user.test;

public class TestC implements TestP {
    @Override
    public String methodOne(String name) {
        return name + "method one";
    }

    @Override
    public void methodTwo() {

        System.out.println("method two");
    }
}
