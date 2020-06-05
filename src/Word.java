import java.io.IOException;

public class Word {
    public String vocabWord;
    public String translation;
    public Word next; //for tree implementation

    public Word(){}

    public Word(String v){
        vocabWord = v;
    }

    public String type(){
        return "";
    }



  /*  public void test() throws IOException {

        HashTable test = new HashTable();
        test.add(new Noun("1","one"));
        test.add(new Verb("2","two"));
        test.add(new Adjective("3","three"));
        test.add(new Adverb("б","one"));
        test.add(new Noun("е","two"));
        test.add(new Adjective("л","three"));
        test.add(new Noun("ас","one"));
        test.add(new Adverb("фд","two"));
        test.add(new Noun("федер","three"));

        LoadSave saveNouns = new LoadSave();
        saveNouns.save("all", test);

        LoadSave loadNouns = new LoadSave();
        Storage t2 = loadNouns.load("all");

        System.out.println(t2.removeNext().vocabWord);
        System.out.println(t2.removeNext().vocabWord);
        System.out.println(t2.removeNext().vocabWord);
    }

   */
}
