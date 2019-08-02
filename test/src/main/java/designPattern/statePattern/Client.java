package designPattern.statePattern;



public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        System.out.println("----------------");
        context.close();
        System.out.println("----------------");
        context.close();
        System.out.println("----------------");
        context.run();
        System.out.println("----------------");
        context.open();
        System.out.println("----------------");
        context.stop();
    }
}