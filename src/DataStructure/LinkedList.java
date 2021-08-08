package DataStructure;

class Node{
    private String data; //자료
    public Node next; //다음 노드를 가리키는 링크

    public Node(){
        data= null;
        next = null;
    }

    public Node(String data){
        this.data = data;
        this.next = null;
    }

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }

    public String getData(){
        return data;
    }
}


public class LinkedList {
    private Node head;
    int count;

    public LinkedList(){
        head = null;
        count = 0;
    }

    public Node addElement(String data){
        Node newNode = new Node(data);
        if(head == null){ //맨 처음일 때
            head =newNode;
        }else{
            Node temp = head;
            while(temp.next!=null)
                temp=temp.next;
            temp.next = newNode;
        }
        count++;
        return newNode;
    }

    public Node insertElement(int pos, String data){
        Node tempNode = head;
        Node newNode = new Node(data);
        if(pos<0 || pos>count){
            return null;
        }
        if(pos==0){
            newNode.next = head;
            head = newNode;
        }else{
            Node preNode = null;
            for(int i=0; i<pos; i++){
                preNode = tempNode;
                tempNode=tempNode.next;
            }
            preNode.next = newNode;
            newNode.next = preNode.next;
        }
        count ++;
        return newNode;
    }

    public Node removeElement(int pos){
        Node tempNode = head;
        if(pos >= count){
            System.out.println("position Error");
            return null;
        }
        if(pos == 0){
            head = tempNode.next;
        }else{
            Node preNode = null;
            for(int i=0; i<pos; i++){
                preNode = tempNode;
                tempNode=tempNode.next;
            }
            preNode.next=tempNode.next;
            count--;
        }
        return tempNode;

    }

    public String getElement(int pos){
        Node tempNode = head;
        if(pos<0 || pos>=count){
            System.out.println("position Error");
            return null;
        }
        if(pos == 0){
            return head.getData();
        }else{
            for(int i=0; i<pos; i++){
                tempNode=tempNode.next;
            }
        }
        return tempNode.getData();

    }

    public Node getNode(int pos){
        Node tempNode = head;
        if(pos<0 || pos>=count){
            System.out.println("position Error");
            return null;
        }
        if(pos == 0){
            return head;
        }else{
            for(int i=0; i<pos; i++){
                tempNode=tempNode.next;
            }
        }
        return tempNode;
    }

    public void removeAll(){
        count = 0;
        head = null;
    }

    public void printAll(){
        if(count == 0){
            System.out.println("No data");
            return;
        }
        Node tempNode = head;
        for(int i=0; i<count; i++){
            System.out.print(tempNode.getData());
            tempNode=tempNode.next;
            System.out.print("->");
        }
    }

    public boolean isEmpty(){
        if(head == null) return true;
        else return false;
    }
}
