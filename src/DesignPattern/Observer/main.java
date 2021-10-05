package DesignPattern.Observer;

import DesignPattern.Decorator.A3;
import DesignPattern.Decorator.A4;
import DesignPattern.Decorator.Audi;
import DesignPattern.Decorator.ICar;

public class main {

    public static void main(String[] args) {
        Button button = new Button("버튼");

        button.addListener(new IButtonListener() {
            @Override
            public void ClickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메세지 전달: click 1");
        button.click("메세지 전달: click 2");

    }
}
