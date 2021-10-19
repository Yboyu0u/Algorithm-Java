package Base;

public class Base {

    public static int gcd(int a, int b){
        return a%b == 0 ? b : gcd(b, a%b);
    }

    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }

    // 10진수 -> n진수


    // n진수 -> 10진수

    public static void main(String[] args){

        System.out.println(gcd(30,12));
        System.out.println(lcm(30,12));
    }

}
