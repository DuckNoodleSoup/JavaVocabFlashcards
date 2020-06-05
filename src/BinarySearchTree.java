import java.util.ArrayList;

public class BinarySearchTree implements Storage{

    Node root=null;

    int count = 0;

    public void add(Word w) {
        if (count == 0) { //Add to root
            root = new Node(w);
            count++;
            System.out.println("Added "+w.vocabWord+" to root");
            return;
        } else { //Use searchEnd to find end, and then place in left or right child
            Node current = root;
            Node previous = null;
            current = searchEnd(w);
            int comparison = current.storage.vocabWord.compareTo(w.vocabWord);
            if(comparison>0){
                current.leftChild = new Node(w);
                current.leftChild.parent = current;
                System.out.println("Added "+w.vocabWord);
            }else{
                current.rightChild = new Node(w);
                current.rightChild.parent = current;
                System.out.println("Added "+w.vocabWord);
            }
        }
        count++;
    }

    public Node searchEnd(Word w){
        Node current = root;
        Node previous = null;
        while(current!=null){
            previous = current;
            String currentString = current.storage.vocabWord;
            String wordString = w.vocabWord;
            int comparison = currentString.compareTo(wordString);
            if(comparison<0){        //word is alphabetically after current
                current=current.rightChild;
            }else if(comparison>0){  //current is alphabetically before current
                current = current.leftChild;
            }else if(comparison==0){ //End found
                return current;
            }
        }
        return previous;
    }

    public Node find(String s){
        Node current = root;
        Node previous = null;

        while(current!=null) {
            previous = current;
            String currentString = current.storage.vocabWord;
            int comparison = currentString.compareTo(s);

            if(comparison > 0){
                current = current.leftChild;
            }else if (comparison < 0) {
                current = current.rightChild;
            }else if (comparison == 0){
                return current;
            }
        }
        return null;
    }

    public Word remove(String s){
        //Node doesn't exist, return null
        if(find(s)==null) {
            return null;
        }

        Node removal = find(s);

        if(removal==root){
            Node successor = findSuccessor(removal);
            Word successorStorage = successor.storage;
            Word removalStorage = removal.storage;
            root.storage = successorStorage;
            root.key = successorStorage.vocabWord;

            Node parent = successor.parent;

            if(parent==null){
               // root=successor.leftChild;
            }else {
                if (parent.rightChild != null) {
                    if (successor.parent.rightChild == successor) {
                        successor.parent.rightChild = null;
                    }
                }
                if (parent.leftChild != null) {
                    if (successor.parent.leftChild == successor) {
                        successor.parent.leftChild = null;
                    }
                }
            }
            if(successor.parent!=null) {
                if (successor.parent.rightChild == successor) {
                    successor.parent.rightChild = null;
                }
            }
            if(successor.parent!=null) {
                if (successor.parent.leftChild == successor) {
                    successor.parent.leftChild = null;
                }
            }

            count--;
            return removalStorage;
        }

        Node parent = removal.parent;
        int direction=0; //0: current, 1: rightChild, 2: leftChild

        //Remove left or right child?
        if(parent.rightChild==null){
            direction=2; //left
        }else if(parent.leftChild==null){
            direction=1; //right
        }else if(parent.rightChild.storage==removal.storage) {
            direction = 1; //right
        }else if(parent.leftChild.storage==removal.storage){
            direction=2; //left
        }

        //if no children, delete
        if(removal.rightChild==null&&removal.leftChild==null){
            if(direction==1){
                parent.rightChild=null;
                removal.parent=null;
            }else if(direction==2){
                parent.leftChild=null;
                removal.parent=null;
            }
            count--;
            return removal.storage;
        }

        //if one child, replace with child
        if(removal.rightChild==null&&removal.leftChild!=null){
            if(direction==1){
                parent.rightChild=removal.leftChild;
                removal.rightChild.parent = parent;
            }else if(direction==2){
                parent.leftChild = removal.leftChild;
                removal.rightChild.parent=parent;
            }
            count--;
            return removal.storage;
        }else if(removal.leftChild==null&&removal.rightChild!=null){
            if(direction==1){
                parent.rightChild=removal.rightChild;
                removal.rightChild.parent = parent;
            }else if(direction==2){
                parent.leftChild = removal.rightChild;
                removal.rightChild.parent=parent;
            }
            count--;
            return removal.storage;
        }

        //if two children
        Word removed = removal.storage;
        Node successor = findSuccessor(removal);
        removal.storage = successor.storage;
        Node successorParent = successor.parent;
        if(successorParent.leftChild!=null&&successorParent.leftChild==successor){
            successorParent.leftChild = null;
        }else if(successorParent.rightChild!=null&&successorParent.rightChild ==successor){
            successorParent.rightChild=null;
        }
        successor.parent=null;
        successor.storage=null;
        successor=null;

        count--;
        return removed;
    }

    public Node findSuccessor(Node u) {
        Node current;
        if (u.rightChild == null) {
            current = u;
        } else{
            current = u.rightChild;
        }

        if(current.leftChild==null){
            return current;
        }
        while(current.leftChild!=null){
            current=current.leftChild;
        }
        return current;
    }

    public Word removeNext(){
        String r = root.storage.vocabWord;
        Word removed= remove(r);
        return removed;
    }
    public boolean isEmpty(){
        if(count<1){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList shuffle(){
        ArrayList shuffled = new ArrayList();
        while(!this.isEmpty()){
            shuffled.add(removeNext());
        }
        return shuffled;
    }
}
