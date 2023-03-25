package tang.designpattern.mydesignpatterndemo.BuilderMode;

import javax.swing.*;
import java.awt.*;

//抽象的建造者模式
public class demo2 {



}

//抽象的人类创造者
abstract class PersonBuilder{

    protected Graphics graphics;
    public PersonBuilder(Graphics graphics){
        this.graphics = graphics;
    }

    public abstract void buildBody();//创造身体
    public abstract void buildHead();//创造头
    public abstract void buildArmLeft();//创造左手
    public abstract void buildArmRight();//创造右手
    public abstract void buildLegLeft();//创造左腿
    public abstract void buildLegRight();//创造右腿
}

class PersonThinBuilder extends PersonBuilder{


    public PersonThinBuilder(Graphics graphics) {
        super(graphics);
    }

    @Override
    public void buildBody() {
        graphics.drawRect(160,150,10,50);
    }

    @Override
    public void buildHead() {
        graphics.drawOval(150,120,30,30);
    }

    @Override
    public void buildArmLeft() {
        graphics.drawLine(160,150,140,200);
    }

    @Override
    public void buildArmRight() {
        graphics.drawLine(170,150,190,200);
    }

    @Override
    public void buildLegLeft() {
        graphics.drawLine(160,200,145,250);
    }

    @Override
    public void buildLegRight() {
        graphics.drawLine(170,200,185,250);
    }
}

//建造指挥者，即直接使用这个类就可以创建小人儿了
class PersonDirector {
    private PersonBuilder personBuilder;

    public PersonDirector(PersonBuilder personBuilder ){
        this.personBuilder = personBuilder;
    }

    public void CreatePerson(){
        personBuilder.buildArmLeft();
        personBuilder.buildHead();
        personBuilder.buildArmRight();
        personBuilder.buildLegLeft();
        personBuilder.buildLegRight();
        personBuilder.buildBody();
    }
}

class personClient extends JFrame {
    public personClient(){
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g){
        PersonBuilder gThin = new PersonThinBuilder(g);
        PersonDirector personDirector = new PersonDirector(gThin);
        personDirector.CreatePerson();
    }


    public static void main(String[] args) {
        new personClient();
    }
}