package DataStructure;


interface IQueue{
    public void enQueue(String data);
    public String deQueue();
    public void printAll();
}

public class Queue extends LinkedList implements IQueue {

    Node front;
    Node rear;

    public Queue(){
        front = null;
        rear = null;
    }

    @Override
    public void enQueue(String data) {
        Node newNode;
        if(isEmpty()){
            newNode = addElement(data);
            rear=newNode;
        }
    }

    @Override
    public String deQueue() {
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        String data = front.getData();
        front = front.next;
        if(front == null){
            rear = null;
        }
        return data;
    }

    @Override
    public void printAll() {
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        Node temp = front;
        while(temp!=null){
            System.out.println(temp.getData());
            temp=temp.next;
        }
    }
}
