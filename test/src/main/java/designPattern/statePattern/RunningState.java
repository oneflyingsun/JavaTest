package designPattern.statePattern;


public class RunningState extends LiftState {
    //电梯门关闭？这是肯定了
    @Override
    public void close() {
        System.out.println("State:RunningState,Mas:电梯门关闭？这是肯定了");
        //do nothing
    }
    //运行的时候开电梯门？你疯了！电梯不会给你开的
    @Override
    public void open() {
        System.out.println("State:RunningState,Mas:运行的时候开电梯门？你疯了！电梯不会给你开的");
        //do nothing
    }
    //这是在运行状态下要实现的方法
    @Override
    public void run() {
        System.out.println("State:RunningState,Mas:电梯正在跑...");
    }
    //这个事绝对是合理的，光运行不停止还有谁敢做这个电梯？！估计只有上帝了
    @Override
    public void stop() {
        System.out.println("State:RunningState,Mas:这个事绝对是合理的，光运行不停止还有谁敢做这个电梯？！估计只有上帝了.");
        super.context.setLiftState(Context.stoppingState); //环境设置为停止状态；
        super.context.getLiftState().stop();
    }
}