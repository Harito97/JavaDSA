package Hw3_21002139_PhamNgocHai.ex4;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        // Thêm phần tử vào đầu danh sách
        if (n == 0) {
            top = new Node();
            top.data = data;
            bot = top;
        } else {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = top;
            top = newNode;
        }
        n++;
    }

    public void addBot(T data) {
        // Thêm phần tử vào cuối danh sách
        if (n == 0) {
            add(data);
        } else {
            Node newNode = new Node();
            newNode.data = data;
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    public void display() {    
        //Node current will point to head    
        Node current = top;    
            
        if(top == null) {    
            System.out.println("List is empty: \n[ ]");    
            return;    
        }    
        System.out.println("Nodes of singly linked list: ");  
        System.out.print("[ ");  
        while(current != null) {    
            // Prints each node by incrementing pointer    
            System.out.print(current.data + " ");    
            current = current.next;    
        }    
        System.out.println("]");    
    } 

    public T get(int i) {
        // Lấy phần tử ở vị trí thứ i
        if (i < 0) {
            return null;
        }
        Node current = top;
        int index = 0;
        if (index == i) {
            return current.data;
        }
        while (current.next != null) {
            index++;
            current = current.next;
            if (index == i) {
                return current.data;
            }
        }
        return null;
    }

    public void set(int i, T data){
        // Gán giá trị ở vị trí i bằng data
        if (i < 0) {
            return;
        }
        Node temp = top;
        for (int index = 0; index <= i; i++){
            if (index == i) {
                temp.data = data;
            }
            if (temp.next == null) {
                return;
            }
            temp = temp.next;
        }
    }

    public boolean isContain(T data) {
        // Kiểm tra trong danh sách có chứa phần tử data hay không?
        if (top.data == data) {
            return true;
        }
        Node temp = top;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.data == data) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        // Kiểm tra danh sách có rỗng hay không?
        return n == 0;
    }

    public T removeTop() {
        // Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó
        T temp = top.data;
        top = top.next;
        n--;
        return temp;
    }

    public T removeBot() {
        // Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            T x = top.data;
            top = null;
            n--;
            return x;
        }
        T temp = bot.data;
        Node x = top;
        for (int index = 0; index < n - 1; index++){
            if (index == n - 2) {
                x.next = null;
                bot = x;
            }
            x = x.next;
        }
        n--;
        return temp;
    }

    public void remove(T data) {
        // Xóa tất cả các phần tử có giá trị bằng data
        // Store top node
        Node temp = top, prev = null;
  
        // If top node itself holds the key
        // or multiple occurrences of key
        while (temp != null && temp.data == data) {
            top = temp.next; // Changed top
            temp = top; // Change Temp
            n--;
        }
  
        // Delete occurrences other than top
        while (temp != null) {
            // Search for the key to be deleted,
            // keep track of the previous node
            // as we need to change 'prev->next'
            while (temp != null && temp.data != data) {
                prev = temp;
                temp = temp.next;
            }
  
            // If key was not present in linked list
            if (temp == null)
                return;
  
            // Unlink the node from linked list
            prev.next = temp.next;
  
            // Update Temp for next iteration of outer loop
            temp = prev.next;
            n--;
        }
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<Integer>();
        System.out.println("isEmpty: " + simpleLinkedList.isEmpty());       
        // true
        // []
        // => Test isEmpty() successful

        simpleLinkedList.add(0);
        // [0]
        simpleLinkedList.add(1);
        // [1 0]
        simpleLinkedList.addBot(2);
        // [1 0 2]
        // => Test add(), addBot() successful

        System.out.println("After add 3 items.");
        System.out.println("Size: " + simpleLinkedList.size());    //3
        // => Test size() successful

        System.out.println(simpleLinkedList.get(0));            //1
        System.out.println(simpleLinkedList.get(1));            //0
        System.out.println(simpleLinkedList.get(2));            //2
        simpleLinkedList.display();
        // => Test get() successful

        System.out.println("isContain 2: " + simpleLinkedList.isContain(2));    //true
        System.out.println("isContain 1: " + simpleLinkedList.isContain(1));    //true
        System.out.println("isContain -98: " + simpleLinkedList.isContain(-98));      //false
        simpleLinkedList.add(1);
        simpleLinkedList.add(1);
        simpleLinkedList.addBot(0);
        // [1 1 1 0 2 0]
        simpleLinkedList.display();
        // => Test isContain() successful

        simpleLinkedList.removeBot();
        // [1 1 1 0 2]
        simpleLinkedList.display();

        simpleLinkedList.removeTop();
        // [1 1 0 2]
        simpleLinkedList.display();

        simpleLinkedList.remove(2);
        // [1 1 0]
        simpleLinkedList.display();

        simpleLinkedList.remove(1);
        // [0]
        simpleLinkedList.display();

        simpleLinkedList.remove(0);
        // []
        simpleLinkedList.display();

        System.out.println("isEmpty after delete all items: " + simpleLinkedList.isEmpty());
        // => Test removeBot(), removeTop(), remove(data) successful

        // => All APIs tested successful
    }
}