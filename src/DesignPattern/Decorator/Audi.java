package DesignPattern.Decorator;

public class Audi implements ICar{

    private int cost;

    public Audi(int cost) {
        this.cost = cost;
    }

    @Override
    public int getPrice() {
        return cost;
    }

    @Override
    public void showPrice() {
        System.out.println("audi의 가격은"+this.cost+"원 입니다.");
    }
}
