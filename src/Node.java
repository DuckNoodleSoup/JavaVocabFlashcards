public class Node {
    public Word storage; //The word object: word and definition stored
    public String key; //Just the vocab word of the Word object, for hashing/BST

    //For chained hashing
    public Node next;
    public Node previous;

    //For Binary Search Trees
    Node parent;
    Node leftChild;
    Node rightChild;

    public Node(){}

    public Node(Word word){
        storage = word;
        key = word.vocabWord;
    }


}
