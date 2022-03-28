import java.util.LinkedList;

public class Stack {
    LinkedList<Object>ll1 = new LinkedList<>();

    public Stack(LinkedList ll2){
        ll1 = ll2;
    }

    public void pop(){
        ll1.removeFirst();
    }

    public void push(Object o){
        ll1.add(o);
    }

    public Object peek(){
        return ll1.get(0);
    }

    public Integer size(){
        return ll1.size();
    }

}
