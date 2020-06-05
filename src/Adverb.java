public class Adverb extends Word{
    //These are already in the superclass:
    //vocabWord
    //translation
    public Adverb next; //for tree implementation

    public Adverb(String v, String t) {
        vocabWord = v;
        translation = t;
    }

    @Override
    public String type() {
        return "Adverb";
    }
}
