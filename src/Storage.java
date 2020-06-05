import java.util.ArrayList;

public interface Storage{ //Interface for data structure used to store data
    public void add(Word w);
    public Node find(String s);
    public Word remove(String s);

    public Word removeNext();
    public boolean isEmpty();

    public ArrayList shuffle();
    //Takes storage, shuffles it, and returns HashList (linkedList)
}