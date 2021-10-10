package DataStructure;

import java.util.PriorityQueue;

class Restaurant implements  Comparable<Restaurant>{
    int grade;
    int distance;

    public Restaurant(int grade, int distance) {
        this.grade = grade;
        this.distance = distance;
    }

    public String toString(){
        return "grade: "+ this.grade +"ans distance: "+this.distance;
    }

    @Override
    public int compareTo(Restaurant o) {
        if(this.grade == o.grade){
            return this. distance <= o.distance ? -1:1;
        }else{
            return this.grade <= o.grade ? -1:1;
        }
    }
}

public class Heap {

    public static void main(String[] args){
        PriorityQueue<Restaurant> minHeap = new PriorityQueue<>();
        minHeap.add(new Restaurant(1, 5));
        minHeap.add(new Restaurant(1, 4));
        minHeap.add(new Restaurant(2, 5));
        minHeap.add(new Restaurant(4, 3));
        minHeap.add(new Restaurant(4, 5));
        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.poll().toString());
        }
    }
}
