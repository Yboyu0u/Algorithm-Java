package Base.decorator;

public class CoffeeTest {

    public static void main(String[] args){

        Coffee coffee = new EtiopiaCoffee();
        coffee.brewing();

        System.out.println();
        Coffee latte = new Latte(coffee);
        latte.brewing();

        System.out.println();
        Coffee mocha = new Mocha(coffee);
        mocha.brewing();
    }
}
