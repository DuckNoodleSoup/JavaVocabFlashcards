public class HashList {
    private Node first;
    private Node last;
    private int count;

    public HashList(){
        first = null;
        last = null;
        count = 0;
    }

    public void add(Word toAdd){
        String addedVocabWord = toAdd.vocabWord;
        Node addedNode = new Node(toAdd);

        if(count==0){
            first = last = addedNode;
        } else {
            last.next = addedNode;
            addedNode.previous = last;
            last = addedNode;
        }
        count++;
    }

    public Node find(String toFind){
        Node current = first;
        while(current!=null){
            if(current.key.equals(toFind)){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Word remove(String toRemove){
        if(count == 1){
            Word r = first.storage;
            first = null;
            last = null;
            count--;
            return r;
        }else if(first.key.equals(toRemove)){
            Word r = first.storage;
            first = first.next;
            first.previous = null;
            count--;
            return r;
        }else if(last.key.equals(toRemove)){
            Word r = last.storage;
            last = last.previous;
            last.next = null;
            count--;
            return r;
        }else{
            Node current = find(toRemove);
            Word r = current.storage;
            Node prevNode = current.previous;
            Node nextNode = current.next;

            prevNode.next = nextNode;
            nextNode.previous = prevNode;
            count--;
            return r;
        }
    }

    public Word remove(){
        if(count == 1){
            Word r = first.storage;
            first = null;
            last = null;
            count--;
            return r;
        }else {
            Word r = first.storage;
            first = first.next;
            first.previous = null;
            count--;
            return r;
        }
    }

    public boolean isEmpty(){
        if(count==0){
            return true;
        }
        return false;
    }
}
