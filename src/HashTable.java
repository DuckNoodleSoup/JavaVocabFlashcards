import java.util.ArrayList;

public class HashTable implements Storage {
    //Hash table with 3001 slots, chained hashing
    //I chose 3001 slots, because there's about 8000 words in a vocab reference book I have, and
    // 3001 is prime.
    private HashList[] table;

    public HashTable(){
        table = new HashList[3001];
        for(int i=0; i<3001; i=i+1){
            table[i]=new HashList();
        }
    }

    public void add(Word w){ //Create word in menu, pass it here.
        int address = hash(w.vocabWord);
        table[address].add(w);

        //TEST
        System.out.println("Hash Table Added: "+w.vocabWord+" to "+address);
        //TEST
    }

    public Node find(String s){
        int address = hash(s);
        if(address==-1){
            //if empty string is passed
            return null;
        }
        Node found = table[address].find(s);
        if (found==null){
            return null;
        }else{
            return found;
        }
    }
    public Word remove(String s){
        if(find(s)==null){
            //if empty string is passed
            return null;
        }
        int address = hash(s);
        Word r = table[address].remove(s);
        return r;
    }

    public int hash(String key){
        //Function: take first two letters, multiply them, then modulo.
        if(key.length()==0){
            return -1;
        }
        int address;
        int firstChar = key.charAt(0);
        address = firstChar;
        if (key.length()>1){
            int secondChar = key.charAt(1);
            address = firstChar*secondChar;
        }
        address = address%3001;
        return address;
    }


    public Word removeNext(){
        int i = 0;
        while(table[i].isEmpty()){
            i=i+1;
            if(i==3001){
                return null;
            }
        }
        return table[i].remove();
    }

    public boolean isEmpty(){
        for(int i=0; i<3001; i++){
            if(!(table[i].isEmpty())){
                return false;
            }
        }
        return true;
    }

    public ArrayList shuffle(){
        ArrayList a = new ArrayList();
        HashList copy = new HashList();
        while(!this.isEmpty()){
            Word current = this.removeNext();
            a.add(current);
            copy.add(current);
        }
        while(!copy.isEmpty()){
            this.add(copy.remove());
        }
        return a;
    }
}
