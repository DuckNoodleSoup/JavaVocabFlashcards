public class Noun extends Word{
    //These are already in the superclass:
    //vocabWord
    //translation
    public Noun next; //for tree implementation

    public Noun(String v, String t){
        vocabWord = v;
        translation = t;
    }

    @Override
    public String type(){
        return "Noun";
    }
}
