public class Verb extends Word {
    //These are already in the superclass:
    //vocabWord
    //translation
    public Verb next; //for tree implementation

    public Verb(String v, String t) {
        vocabWord = v;
        translation = t;
    }

    @Override
    public String type() {
        return "Verb";
    }
}
