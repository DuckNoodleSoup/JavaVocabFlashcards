public class FlashCardsStack {
    HashList stack;
    Node top;
    Node bottom;
    int count = 0;

    public void push(Node p){
        if(count==0){
            top=bottom=p;
        }else{
            p.previous = top;
            top.next = p;
            top=p;
        }
        count++;
    }

    public Node remove() {
        Node current = null;
        if (count <= 0) {
            return null;
        }else if(count==1){
             current = top;
             top=bottom=null;
        }else {
            current = top;
            top = top.previous;
        }
        count--;
        return current;
    }
}
