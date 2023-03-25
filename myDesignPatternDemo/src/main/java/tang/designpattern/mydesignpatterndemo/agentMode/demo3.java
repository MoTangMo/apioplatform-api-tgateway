package tang.designpattern.mydesignpatterndemo.agentMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class demo3 {

    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("汤神");
        //定义一个handler
        InvocationHandler handler = new GamePlayDynamicProxy(player);
        //获取类的class loader
        ClassLoader loader = player.getClass().getClassLoader();
        //动态产生一个代理者
        IGamePlayer proxy = (IGamePlayer)Proxy.newProxyInstance(loader, new Class[]{IGamePlayer.class}, handler);
        //代打开始
        System.out.println("------------------------------代打开始--------------------------");
        proxy.login("汤神","666");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("----------------------------------代打结束------------------------------------");
    }



}
//动态代理类
class GamePlayDynamicProxy implements InvocationHandler {

    //被代理者
    Class cls = null;
    //被代理的实例
    Object object = null;

    public GamePlayDynamicProxy(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("login")){
            System.out.println("我看看汤神有没有上线！");
        }
        //这是方法的实现，即其实如果我们想面向切面编程，这就是一个切点
        Object result = method.invoke(object, args);//这就相当于执行的方法
        if(method.getName().equals("login")){
            System.out.println("汤神已上线！");
        }
        return result;
    }
}