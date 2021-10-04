package DesignPattern.Decorator;

public class main {

    public static void main(String[] args){
        ICar audi = new Audi(1000);
        audi.showPrice();

        // a3
        ICar audi3 = new A3(audi,"A3");
        audi3.showPrice();

        // a4
        ICar audi5 = new A4(audi,"A4");
        audi3.showPrice();
    }
}
