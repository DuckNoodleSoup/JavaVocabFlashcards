import javax.management.remote.rmi._RMIConnection_Stub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EntryMenu extends MainMenu{

    MainMenu frame = new MainMenu();
    JPanel a = new JPanel(); //Panel with entry and type
    JPanel b = new JPanel(); //Panel with vocab details
    Container contentPane = this.getContentPane();

    Storage allWords;
    Storage allNouns;
    Storage allVerbs;
    Storage allAdjectives;
    Storage allAdverbs;

    public EntryMenu(MainMenu m){
        frame = m;
    }

    public void setUpFrame(){
        contentPane.setLayout(new GridLayout(0,1));

        //Welcome and Return
        a.setBackground(Color.LIGHT_GRAY);
        a.setMaximumSize(new Dimension(1000,50));
        frame.contentPane.add(a);
        frame.contentPane.add(b);
        frame.contentPane.add(new JPanel());

        JLabel welcome = new JLabel("  Vocabulary Entry  ");
        a.add(welcome);

        try {
            initialise(); //Initialises deck of vocab words
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] t = {"Select Part of Speech","Noun", "Verb", "Adjective", "Adverb"};
        JComboBox type = new JComboBox(t);
        a.add(type);
        type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = type.getSelectedIndex();
                switch(index){
                    case 0: b.removeAll();
                            b.repaint();
                        break;
                    case 1: setUpNoun();
                        break;
                    case 2: setUpVerb();
                        break;
                    case 3: setUpAdjective();
                        break;
                    case 4: setUpAdverb();
                        break;
                }
            }
        });

        JButton back = new JButton("Back to main menu");
        a.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoadSave s = new LoadSave();
                try {
                    s.save("all", allWords);
                    s.save("noun", allNouns);
                    s.save("verb", allVerbs);
                    s.save("adjective", allAdjectives);
                    s.save("adverb", allAdverbs);
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
    }

    public void initialise() throws IOException {
        LoadSave l = new LoadSave();
        allWords = l.load("all");
        allNouns = l.load("noun");
        allVerbs = l.load("verb");
        allAdjectives = l.load("adjective");
        allAdverbs = l.load("adverb");
    }

    public void setUpNoun(){

        //Set Up text fields and frame for nouns
        b.removeAll();
        b.repaint();

        JLabel addingNoun = new JLabel("                                                                                                                                                              Adding Noun                                                                                                                                                              ");
        b.add(addingNoun);

        JLabel vo = new JLabel("Vocab Word");
        JTextField vocabWord = new JTextField("", 80);
        b.add(vo);
        b.add(vocabWord);

        JLabel tr = new JLabel("Translation ");
        JTextField translation = new JTextField("", 80);
        b.add(tr);
        b.add(translation);

        frame.validate();
        frame.repaint();

        //Add the word

        JButton add = new JButton("Add Word");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String v = vocabWord.getText();
                String t = translation.getText();

                Word newNoun = new Noun(v, t);
                allWords.add(newNoun);
                allNouns.add(newNoun);

                vocabWord.setText("");
                translation.setText("");
            }
        });
        b.add(add);

        frame.validate();
        frame.repaint();
    }

    public void setUpVerb(){
        //Set Up text fields and frame for nouns
        b.removeAll();
        b.repaint();

        JLabel addingNoun = new JLabel("                                                                                                                                                              Adding Verb                                                                                                                                                              ");
        b.add(addingNoun);

        JLabel vo = new JLabel("Vocab Word");
        JTextField vocabWord = new JTextField("", 80);
        b.add(vo);
        b.add(vocabWord);

        JLabel tr = new JLabel("Translation ");
        JTextField translation = new JTextField("", 80);
        b.add(tr);
        b.add(translation);

        frame.validate();
        frame.repaint();

        //Add the word

        JButton add = new JButton("Add Word");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String v = vocabWord.getText();
                String t = translation.getText();

                Word newVerb = new Verb(v, t);
                allWords.add(newVerb);
                allVerbs.add(newVerb);

                vocabWord.setText("");
                translation.setText("");
            }
        });
        b.add(add);

        frame.validate();
        frame.repaint();
    }
    public void setUpAdjective(){
        //Set Up text fields and frame for nouns
        b.removeAll();
        b.repaint();

        JLabel addingAdj = new JLabel("                                                                                                                                                              Adding Adjective                                                                                                                                                              ");
        b.add(addingAdj);

        JLabel vo = new JLabel("Vocab Word");
        JTextField vocabWord = new JTextField("", 80);
        b.add(vo);
        b.add(vocabWord);

        JLabel tr = new JLabel("Translation ");
        JTextField translation = new JTextField("", 80);
        b.add(tr);
        b.add(translation);

        frame.validate();
        frame.repaint();

        //Add the word

        JButton add = new JButton("Add Word");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String v = vocabWord.getText();
                String t = translation.getText();

                Word newAdjective= new Adjective(v, t);
                allWords.add(newAdjective);
                allAdjectives.add(newAdjective);

                vocabWord.setText("");
                translation.setText("");
            }
        });
        b.add(add);

        frame.validate();
        frame.repaint();
    }
    public void setUpAdverb(){

        //Set Up text fields and frame for nouns
        b.removeAll();
        b.repaint();

        JLabel addingAdv = new JLabel("                                                                                                                                                              Adding Adverb                                                                                                                                                              ");
        b.add(addingAdv);

        JLabel vo = new JLabel("Vocab Word");
        JTextField vocabWord = new JTextField("", 80);
        b.add(vo);
        b.add(vocabWord);

        JLabel tr = new JLabel("Translation ");
        JTextField translation = new JTextField("", 80);
        b.add(tr);
        b.add(translation);

        frame.validate();
        frame.repaint();

        //Add the word

        JButton add = new JButton("Add Word");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String v = vocabWord.getText();
                String t = translation.getText();

                Word newAdverb = new Adjective(v, t);
                allWords.add(newAdverb);
                allAdverbs.add(newAdverb);

                vocabWord.setText("");
                translation.setText("");
            }
        });
        b.add(add);

        frame.validate();
        frame.repaint();
    }
}
