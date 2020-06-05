import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SearchMenu extends MainMenu{

    MainMenu frame = new MainMenu();
    JPanel a = new JPanel(); //Panel with "search" and back button
    JPanel b = new JPanel(); //Panel with search entry
    JPanel c = new JPanel(); //Panel with vocab details
    Container contentPane = this.getContentPane();

    Storage allWords;
    Storage allNouns;
    Storage allVerbs;
    Storage allAdjectives;
    Storage allAdverbs;

    Node found;

    //which one are we looking at right now?
    //changes depending on JComboBox
    Storage currentStorage;

    public SearchMenu(MainMenu m){
        frame = m;
    }

    public void setUpFrame() {
        contentPane.setLayout(new GridLayout(0, 1));

        //Welcome and Return
        a.setBackground(Color.LIGHT_GRAY);
        a.setMaximumSize(new Dimension(1000, 50));

        //a.setLayout(new BoxLayout(a, BoxLayout.PAGE_AXIS));
        //b.setLayout(new BoxLayout(b, BoxLayout.PAGE_AXIS));

        frame.contentPane.add(a);
        frame.contentPane.add(b);
        frame.contentPane.add(c);
        frame.contentPane.add(new JPanel());

        //Top Frame (a)

        JLabel welcome = new JLabel("Search: ");
        a.add(welcome);

        try {
            initialise(); //Initialises deck of vocab words
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton back = new JButton("Back to main menu");
        a.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveAll();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                frame.getContentPane().removeAll();
                frame.validate();
                frame.repaint();
                frame.setUpMenu();
                frame.validate();
                frame.repaint();
            }
        });

        //Middle Frame (b)

        JTextField searchWord = new JTextField("", 80);
        b.add(searchWord);

        //Selecting which Storage to search off of
        currentStorage = allWords;
        String[] t = {"All Vocab Words","Noun", "Verb", "Adjective", "Adverb"};
        JComboBox type = new JComboBox(t);
        b.add(type);
        type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = type.getSelectedIndex();
                switch(index){
                    case 0: currentStorage = allWords;
                        break;
                    case 1: currentStorage = allNouns;
                        break;
                    case 2: currentStorage = allVerbs;
                        break;
                    case 3: currentStorage = allAdjectives;
                        break;
                    case 4: currentStorage = allAdverbs;
                        break;
                }
            }
        });

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               displayVocab(searchWord);
            }
        });
        b.add(searchButton);
    }

    public void initialise() throws IOException {
        LoadSave l = new LoadSave();
        allWords = l.load("all");
        allNouns = l.load("noun");
        allVerbs = l.load("verb");
        allAdjectives = l.load("adjective");
        allAdverbs = l.load("adverb");
    }

    public void saveAll() throws IOException {
        LoadSave l = new LoadSave();
        l.save("all", allWords);
        l.save("noun", allNouns);
        l.save("verb", allVerbs);
        l.save("adjective", allAdjectives);
        l.save("adverb", allAdverbs);
    }

    public void displayVocab(JTextField searchWord){
        String s = searchWord.getText();

        Node found = currentStorage.find(s);

        //Bottom Frame (c)

        if (found==null){
            c.removeAll();
            c.validate();
            c.repaint();
            c.add(new JLabel("No such vocab word found"));
        }else{

            //TEST
            System.out.println("found" + found.storage.vocabWord);
            //TEST

            c.removeAll();
            c.validate();
            c.repaint();
            c.add(new JLabel("Vocab Word : "+found.storage.vocabWord));
            c.add(new JLabel("Translation: "+found.storage.translation));
        }
        c.validate();
        c.repaint();
    }

}
