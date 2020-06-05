import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//GENERAL STRUCTURE
/*
Save: input TYPE and STORAGE,
- Takes TYPE, if-else between different txt documents for type of storage
  - ALL: SWITCH between different things to write in txt
  - NOUN,VERB,ADJECTIVE,ADVERB: writes just vocabWord, translation down with spaces

Load: input TYPE
 - Takes TYPE, SWITCH between different types to determine scanner's txt file
 - IF-ELSE between different types:
  - ALL: SWITCH between different types, creates new Word based on type
  - NOUN,VERB,ADJECTIVE,ADVERB: creates new Word based off of type, and loops.
 */

//Usage: Construct with file to write to, pass storage object to each method.
public class LoadSave {

    public LoadSave(){ 
    }

    //Pass type: All, Noun, Verb, Adjective, Adverb.
    public Storage load(String type) throws IOException {
        Storage storage = new HashTable();
        //Storage storage = new BinarySearchTree();
        Scanner scanner = new Scanner("");

        //Deciding what file to read from
        switch(type) {
            case "all":
                scanner = new Scanner(new FileReader("VocabWords.txt"));
                break;
            case "noun":
                scanner = new Scanner(new FileReader("NounWords.txt"));
                break;
            case "verb":
                scanner = new Scanner(new FileReader("VerbWords.txt"));
                break;
            case "adjective":
                scanner = new Scanner(new FileReader("AdjectiveWords.txt"));
                break;
            case "adverb":
                scanner = new Scanner(new FileReader("AdverbWords.txt"));
                break;
        }

        //Deciding which Storage to write to.
        if(type.equals("all")||type.equals("All")){
            String vo = "";
            String tr = "";
            Word current;
            //Get Type, create Word object off of type.
            while(scanner.hasNext()){
                String t = scanner.nextLine();
                switch(t){
                    case "Noun ":
                        vo = scanner.nextLine();
                        tr = scanner.nextLine();
                        current = new Noun(vo, tr);
                        storage.add(current);
                        break;
                    case "Verb ":
                        vo = scanner.nextLine();
                        tr = scanner.nextLine();
                        current = new Verb(vo, tr);
                        storage.add(current);
                        break;
                    case "Adjective ":
                        vo = scanner.nextLine();
                        tr = scanner.nextLine();
                        current = new Adjective(vo, tr);
                        storage.add(current);
                        break;
                    case "Adverb ":
                        vo = scanner.nextLine();
                        tr = scanner.nextLine();
                        current = new Adverb(vo, tr);
                        storage.add(current);
                        break;
                }
            }
            //Delete contents of file after reading from it
            new FileWriter("VocabWords.txt", false).close();
        }else if(type.equals("noun")||type.equals("Noun")){
            while (scanner.hasNext()) {
                String vo = scanner.nextLine();
                String tr = scanner.nextLine();
                Word current = new Noun(vo, tr);
                storage.add(current);
            }
            new FileWriter("NounWords.txt", false).close();
        }else if(type.equals("verb")||type.equals("Verb")){
            while (scanner.hasNext()) {
                String vo = scanner.nextLine();
                String tr = scanner.nextLine();
                Word current = new Verb(vo, tr);
                storage.add(current);
            }
            new FileWriter("VerbWords.txt", false).close();
        }else if(type.equals("adjective")||type.equals("Adjective")){
            while (scanner.hasNext()) {
                String vo = scanner.nextLine();
                String tr = scanner.nextLine();
                Word current = new Adjective(vo, tr);
                storage.add(current);
            }
            new FileWriter("AdjectiveWords.txt", false).close();
        }else if(type.equals("adverb")||type.equals("Adverb")){
            while (scanner.hasNext()) {
                String vo = scanner.nextLine();
                String tr = scanner.nextLine();
                Word current = new Adverb(vo, tr);
                storage.add(current);
            }
            new FileWriter("AdverbWords.txt", false).close();
        }else{
            System.out.println("Type not found, nothing was saved.");
        }
        return storage;
    }

    public void save(String type, Storage storage) throws IOException {
        //Takes type, and writes storage into correct file
        //Make sure to send a COPY of the storage, so that it doesn't delete everything
        //Deciding what file to write to:
        if(type.equals("all")||type.equals("All")){
            java.io.FileWriter writer = new java.io.FileWriter("VocabWords.txt");
            java.io.PrintWriter out = new java.io.PrintWriter(writer);
            while(!storage.isEmpty()){
                Word current = storage.removeNext();
                switch(current.type()){
                    case "Noun":
                        out.println("Noun ");
                        out.println(current.vocabWord);
                        out.println(current.translation);
                        break;
                    case "Verb":
                        out.println("Verb ");
                        out.println(current.vocabWord);
                        out.println(current.translation);
                        break;
                    case "Adjective":
                        out.println("Adjective ");
                        out.println(current.vocabWord);
                        out.println(current.translation);
                        break;
                    case "Adverb":
                        out.println("Adverb ");
                        out.println(current.vocabWord);
                        out.println(current.translation);
                        break;
                }
            }
            out.close();
        }else if(type.equals("noun")||type.equals("Noun")){
            java.io.FileWriter writer = new java.io.FileWriter("NounWords.txt");
            java.io.PrintWriter out = new java.io.PrintWriter(writer);
            while(!storage.isEmpty()){
                Word current = storage.removeNext();
                out.println(current.vocabWord);
                out.println(current.translation);
            }
            out.close();
        }else if(type.equals("verb")||type.equals("Verb")){
            java.io.FileWriter writer = new java.io.FileWriter("VerbWords.txt");
            java.io.PrintWriter out = new java.io.PrintWriter(writer);
            while(!storage.isEmpty()){
                Word current = storage.removeNext();
                out.println(current.vocabWord);
                out.println(current.translation);
            }
            out.close();
        }else if(type.equals("adjective")||type.equals("Adjective")){
            java.io.FileWriter writer = new java.io.FileWriter("AdjectiveWords.txt");
            java.io.PrintWriter out = new java.io.PrintWriter(writer);
            while(!storage.isEmpty()){
                Word current = storage.removeNext();
                out.println(current.vocabWord);
                out.println(current.translation);
            }
            out.close();
        }else if(type.equals("adverb")||type.equals("Adverb")){
            java.io.FileWriter writer = new java.io.FileWriter("AdverbWords.txt");
            java.io.PrintWriter out = new java.io.PrintWriter(writer);
            while(!storage.isEmpty()){
                Word current = storage.removeNext();
                out.println(current.vocabWord);
                out.println(current.translation);
            }
            out.close();
        }else{
            System.out.println("Type not found, nothing was saved.");
        }
    }
}
