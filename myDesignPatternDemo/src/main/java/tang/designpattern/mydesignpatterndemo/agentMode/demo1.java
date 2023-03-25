package tang.designpattern.mydesignpatterndemo.agentMode;

//定义一个接口来规定我们日常游戏的行为抽象
interface IGamePlayer{
    //登录游戏
    public void login(String username,String password);

    //杀怪，打装备
    public void killBoss();

    //升级
    public void upgrade();

    //寻找代理
//    public IGamePlayer getProxy() throws Exception;
}

//实现游戏者,形成一个具体
class GamePlayer implements IGamePlayer{

    String name = "";

    IGamePlayer gamePlayerProxy = null;

    public GamePlayer(String name){
        this.name = name;
    }

    public GamePlayer(String name,IGamePlayer gamePlayer) throws Exception {
        if (gamePlayer == null){
            throw new Exception("不允许创建真实角色");
        }else {
            this.name = name;
        }
    }

    @Override
    public void login(String username, String password) {
        System.out.println(name+"登录成功!"+"用户名为"+username);
    }

    @Override
    public void killBoss() {
        System.out.println("遇到一个大Boss，你秒了！");
    }

    @Override
    public void upgrade() {
        System.out.println("你完成升级，生活就像海洋，只有意志坚强的人才能到达彼岸！");
    }

//    @Override
//    public IGamePlayer getProxy() throws Exception {
//        gamePlayerProxy = new GamePlayerProxy(name);
//        return gamePlayerProxy;
//    }

    //检验是否是代理访问
    private boolean isProxy(){
        if (this.gamePlayerProxy == null) {
            return false;
        }else{
            return true;
        }
    }
}

class GamePlayerProxy implements IGamePlayer{
    //替谁代练
    private IGamePlayer gamePlayer;

    public GamePlayerProxy(String name) throws Exception {
        gamePlayer = new GamePlayer(name);
    }

    @Override
    public void login(String username, String password) {
            this.gamePlayer.login(username,password);
    }

    @Override
    public void killBoss() {
            this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }


}

public class demo1 {

    public static void main(String[] args) throws Exception {

        //定义一个代练
        IGamePlayer gamePlayerProxy = new GamePlayerProxy("Tomshen");
        IGamePlayer gamePlayer = new GamePlayer("Tomshen", gamePlayerProxy);

        System.out.println("------游戏启动--------");
        System.out.println("------游戏登录--------");
        gamePlayerProxy.login("tangshen","666");
        System.out.println("------登陆成功--------");
        gamePlayerProxy.killBoss();
        gamePlayerProxy.upgrade();
    }

}
