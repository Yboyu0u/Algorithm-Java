package Base.innerClass;

class Outer2{

    int outNum = 100;
    static int sNum = 200;

    Runnable getRunnable(final int i){
        return new Runnable(){

            int localNum = 1000;

            @Override
            public void run() {

            }
        };

    }

    Runnable runnable = new Runnable() {

        @Override
        public void run() {

        }
    };

}

public class AnnonymousInnerTest {

    public static void main(String[] args){
        Outer2 out = new Outer2();
        Runnable runner = out.getRunnable(100);

        runner.run();

        out.runnable.run();
    }
}
