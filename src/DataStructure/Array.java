package DataStructure;

public class Array {

    int[] arr; //int array
    int count; //개수

    public  int ARRAY_SIZE;
    public static final int ERROR_NUM = - 999999999;

    public Array(){
        count = 0;
        ARRAY_SIZE = 10;
        arr = new int[ARRAY_SIZE];
    }

    public Array(int size){
        count = 0;
        ARRAY_SIZE = size;
        arr= new int[size];
    }

    public void add(int num){
        if(count>ARRAY_SIZE-1){
            System.out.println("not enough memory");
            return;
        }else{
            arr[count] = num;
            count++;
        }
    }

    public void insert(int pos, int num){
        if(count>ARRAY_SIZE-1){
            System.out.println("not enough memory");
            return;
        }
        if(pos<0 || pos > count){
            System.out.println("insert Error");
            return;
        }
        for(int i= count-1; i>=pos;i--){
            arr[i+1] = arr[i];
        }
        arr[pos]=num;
        count++;

    }

    public void remove(int pos){
        if(isEmpty()){
            System.out.println("Ther is no element");
            return;
        }
        if(pos<0 || pos>count-1){
            System.out.println("index Error");
            return;
        }
        for(int i=pos; i<count-1; i++){
            arr[i]=arr[i+1];
        }
        count--;
    }

    public int getSize(){
        return count;
    }

    public boolean isEmpty(){
        if(count == 0){
            return true;
        }else{
            return false;
        }
    }

    public int getElement(int position){

        if(position < 0 || position > count-1){
            return ERROR_NUM;
        }else{
            return arr[position];
        }
    }

    public void printAll(){
        if(count == 0){
            return;
        }else{
            for(int num: arr){
                System.out.println(num);
            }
        }
    }

    public void removeAll(){
        for(int i=0; i<count; i++){
            arr[i]=0;
        }
        count = 0;
    }

}
