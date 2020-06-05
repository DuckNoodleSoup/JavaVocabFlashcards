import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class FlashCardsMenu extends MainMenu{
    MainMenu frame = new MainMenu();
    JPanel a = new JPanel(); //Panel with type
    JPanel b = new JPanel(); //Panel with vocab details
    JPanel c = new JPanel(); //Panel with back and next buttons
    Container contentPane = this.getContentPane();

    Storage allWords;
    Storage allNouns;
    Storage allVerbs;
    Storage allAdjectives;
    Storage allAdverbs;

    Storage currentStorage;
    ArrayList shuffled;

    public FlashCardsMenu(MainMenu m){
        frame = m;
    }

    public void setUpFrame(){
        contentPane.setLayout(new GridLayout(0,1));

        //Top Frame (a)

        a.setBackground(Color.LIGHT_GRAY);
        a.setMaximumSize(new Dimension(1000,50));
        frame.contentPane.add(a);
        frame.contentPane.add(b);
        frame.contentPane.add(c);
        frame.contentPane.add(new JPanel());

        JLabel welcome = new JLabel("  Flash Cards  ");
        a.add(welcome);

        try {
            initialise(); //Initialises deck of vocab words
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] t = {"All Words","Noun", "Verb", "Adjective", "Adverb"};
        JComboBox type = new JComboBox(t);
        a.add(type);
        currentStorage=allWords;
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

        JButton shuffle = new JButton("Shuffle");
        a.add(shuffle);
        shuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.removeAll();
                b.validate();
                b.repaint();
                c.removeAll();
                c.validate();
                c.repaint();
                shuffled = currentStorage.shuffle();
                flashCardsFrame(shuffled);
            }
        });

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

    public void flashCardsFrame(ArrayList s){
        FlashCardsStack nextNode = new FlashCardsStack();
        FlashCardsStack prevNode = new FlashCardsStack();

        //Shuffle s into nextNode Stack
        while (!s.isEmpty()) {
            int length = s.size();
            int a = (int) ((int) (length-1) * Math.random());
            Word current = (Word) s.remove(a);
            if (current != null) {
                Node c = new Node(current);
                nextNode.push(c);
            }
        }

        JButton prev = new JButton("Previous Word");
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node current = prevNode.remove();
                if(!(current==null)){
                    b.removeAll();
                    b.validate();
                    b.repaint();

                    b.add(new JLabel("Vocab Word : "+current.storage.vocabWord));
                    b.add(new JLabel("Translation: "+current.storage.translation));
                    b.validate();
                    b.repaint();

                    nextNode.push(current);
                }else{
                    b.removeAll();
                    b.validate();
                    b.repaint();

                    b.add(new JLabel("No more vocab words"));
                    b.validate();
                    b.repaint();
                }
            }
        });
        c.add(prev);

        JButton next = new JButton("Next Word");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node current = nextNode.remove();
                if(!(current==null)){
                    b.removeAll();
                    b.validate();
                    b.repaint();

                    b.add(new JLabel("Vocab Word : "+current.storage.vocabWord));
                    b.add(new JLabel("Translation: "+current.storage.translation));
                    b.validate();
                    b.repaint();

                    prevNode.push(current);
                }else{
                    b.removeAll();
                    b.validate();
                    b.repaint();

                    b.add(new JLabel("No more vocab words"));
                    b.validate();
                    b.repaint();
                }
            }
        });
        c.add(next);

        b.validate();
        b.repaint();
        c.validate();
        c.repaint();
    }

}
