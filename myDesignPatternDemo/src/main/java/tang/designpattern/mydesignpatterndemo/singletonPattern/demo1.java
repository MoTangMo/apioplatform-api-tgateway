package tang.designpattern.mydesignpatterndemo.singletonPattern;

/*
*唯一皇帝类
* */
class Emperor{
    private static final Emperor emperor = new Emperor();//先初始化一个皇帝
    private Emperor() {} //私有化构造函数，禁止外部使用构造函数进行对象创建

    public static Emperor getInstance(){
        return emperor; //提供外部获取这个唯一的皇帝
    }

    //皇帝发话
    public static void say(){
        System.out.println("爱卿们平身！");
    }
}
//臣子类
class Minister{

    //臣子上朝
    public void gotoCourt(){
        System.out.println("皇上万岁万万岁！");
    }
}
public class demo1 {
    //上朝三天
    public static void main(String[] args) {
        Minister minister1 = new Minister();
        Minister minister2 = new Minister();
        Minister minister3 = new Minister();
        System.out.println(minister1 == minister2);
        System.out.println(minister2 == minister3);
        System.out.println(minister1 == minister3);
        Emperor emperor = Emperor.getInstance();
        Emperor emperor2 = Emperor.getInstance();

        for (int i = 0 ; i < 3 ; i ++){
            System.out.println("第"+(i+1)+"天朝拜");
            //无法new 一个皇帝，皇帝只有一个，只能通过皇帝内部方法获取单例皇帝
            minister1.gotoCourt();
            minister2.gotoCourt();
            minister3.gotoCourt();
            System.out.println("两个皇帝是同一人嘛？"+(emperor==emperor2));
            Emperor.say();
        }
    }

}
