package tang.designpattern.mydesignpatterndemo.FactoryMode;

//定义一个接口表述人类
interface human{

    //人种颜色
    public void getColor();

    //人种语种
    public void talk();

}

class BlackHuman implements human{

    @Override
    public void getColor() {
        System.out.println("我是黑色皮肤的");
    }

    @Override
    public void talk() {
        System.out.println("黑人会说话！");
    }
}

class WhiteHuman implements human{

    @Override
    public void getColor() {
        System.out.println("我是白皮");
    }

    @Override
    public void talk() {
        System.out.println("白人会说话！");
    }
}

class YellowHuman implements human{

    @Override
    public void getColor() {
        System.out.println("我是黄皮的！");
    }

    @Override
    public void talk() {
        System.out.println("黄人超会说话！");
    }
}
//工厂类（八卦炉）
abstract class AbstractHumanFactory{
    public abstract <T extends human>  T create(Class<T> c) throws ClassNotFoundException, InstantiationException, IllegalAccessException;

}

class HumanFactory extends AbstractHumanFactory{

    @Override
    public <T extends human> T create(Class<T> c){
        human human = null;
        try {
            human = (human) Class.forName(c.getName()).newInstance();
        } catch(Exception e){
            System.out.println("生产错误！");
        }
        return (T)human;
    }
}
public class demo1 {

    public static void main(String[] args) {
        AbstractHumanFactory humanFactory = new HumanFactory();
        try {
            //生产白人
            WhiteHuman whiteHuman = humanFactory.create(WhiteHuman.class);
            whiteHuman.getColor();
            whiteHuman.talk();
            //生产黑人
            BlackHuman blackHuman = humanFactory.create(BlackHuman.class);
            blackHuman.getColor();
            blackHuman.talk();
            //生产黄人
            YellowHuman yellowHuman = humanFactory.create(YellowHuman.class);
            yellowHuman.getColor();
            yellowHuman.talk();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
