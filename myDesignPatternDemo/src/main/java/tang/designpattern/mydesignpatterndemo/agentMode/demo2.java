package tang.designpattern.mydesignpatterndemo.agentMode;


//定义一个接口来规定我们日常游戏的行为抽象
interface IGamePlayerDuress{
    //登录游戏
    public void login(String username,String password);

    //杀怪，打装备
    public void killBoss();

    //升级
    public void upgrade();

    //寻找代理
    public IGamePlayerDuress getProxy() throws Exception;
}

//实现游戏者,形成一个具体
class GamePlayerDuress implements IGamePlayerDuress{

    String name = "";

    GamePlayerProxyDuress gamePlayerProxy = null;

    public GamePlayerDuress(String name){
        this.name = name;
    }

    public GamePlayerDuress(String name,IGamePlayer gamePlayer) throws Exception {
        if (gamePlayer == null){
            throw new Exception("不允许创建真实角色");
        }else {
            this.name = name;
        }
    }

    @Override
    public void login(String username, String password) {
        if (this.isProxy()){
            System.out.println(name+"登录成功!"+"用户名为"+username);
        }else{
            System.out.println("请指定代理");
        }
    }

    @Override
    public void killBoss() {
        if (this.isProxy()){
            System.out.println("遇到一个大Boss，你秒了！");
        }else{
            System.out.println("请指定代理");
        }
    }

    @Override
    public void upgrade() {
        if (isProxy()){
            System.out.println("你完成升级，生活就像海洋，只有意志坚强的人才能到达彼岸！");
        }else{
            System.out.println("请指定代理");
        }
    }

    @Override
    public IGamePlayerDuress getProxy() throws Exception {
        gamePlayerProxy = new GamePlayerProxyDuress(name);
        return gamePlayerProxy;
    }

    //检验是否是代理访问
    private boolean isProxy(){
        if (this.gamePlayerProxy == null) {
            return false;
        }else{
            return true;
        }
    }
}

class GamePlayerProxyDuress implements IGamePlayerDuress{
    //替谁代练
    private IGamePlayerDuress gamePlayer = null;

    public GamePlayerProxyDuress(String name) throws Exception {
        gamePlayer = new GamePlayerDuress(name);
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

    @Override
    public IGamePlayerDuress getProxy() throws Exception {
        return this;
    }


}

public class demo2 {

    public static void main(String[] args) throws Exception {

        //直接玩家游戏
        IGamePlayerDuress gamePlayer = new GamePlayerDuress("Tomshen");
        IGamePlayerDuress proxy = gamePlayer.getProxy();
        gamePlayer.login("tomshen","123");
        gamePlayer.killBoss();
        gamePlayer.upgrade();

    }

}
