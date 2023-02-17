package tang.designpattern.mydesignpatterndemo.singletonPattern;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 *
 *
 * */
class Emperors{
    private static final int maxofEmperors = 2;//定义最大数量的多例
    static ArrayList<String> emperorName = new ArrayList<>();//与单例不同，单例一直只有一个对象，所以不需要指定名称
    static ArrayList<Emperors> emperors = new ArrayList<>(maxofEmperors);//容纳对象
    private static  int EmperorId = 0;
    static {
        for (int i = 0 ; i < maxofEmperors ; i ++){
            emperors.add(new Emperors("皇帝"+i));
        }
    }//静态代码块，当类被加载时执行且只执行一次
    private Emperors(String name ){
        emperorName.add(name);
    }
    //获取实例对象
    public static Emperors getInstance(){
        Random random = new Random();
        EmperorId = random.nextInt(maxofEmperors);
        return emperors.get(EmperorId);
    }

    public void say(){
        System.out.println(emperorName.get(EmperorId)+"说：众生平等！");
    }
}

class Ministers{
    public static void say(){
        System.out.println("皇上万岁万万岁！");
    }
}
public class demo2 {
    //5天朝拜
    public static void main(String[] args) {
        Ministers ministers =new Ministers();
        for (int i = 0;i < 5;i++){
            Emperors emperors = Emperors.getInstance();
            ministers.say();
            emperors.say();
        }
    }
}
