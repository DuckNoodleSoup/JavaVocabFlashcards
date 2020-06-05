public class Adjective extends Word{
    //These are already in the superclass:
    //vocabWord
    //translation
    public Adjective next; //for tree implementation

    public Adjective(String v, String t) {
        vocabWord = v;
        translation = t;
    }

    @Override
    public String type() {
        return "Adjective";
    }
}
