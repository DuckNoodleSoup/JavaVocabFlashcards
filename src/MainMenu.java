import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu(){ }

    public Container contentPane = this.getContentPane();

    public void setUpMenu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(new GridLayout(0,1));

        JPanel topFrame = new JPanel();
        topFrame.setBackground(Color.WHITE);
        topFrame.setPreferredSize(new Dimension(1000,200));
        topFrame.add(new JLabel("Welcome to Vocab Flashcards!"));
        contentPane.add(topFrame);

        //Buttons on the Menu
        //Vocabulary Entry:
        JPanel middleFrame = new JPanel();
        middleFrame.setBackground(Color.LIGHT_GRAY);
        middleFrame.setPreferredSize(new Dimension(1000,500));
        JButton entry = new JButton("  Vocabulary Entry  ");
        entry.addActionListener(new EntryMenuListener(this));
        middleFrame.add(entry);
        contentPane.add(middleFrame);

        //Vocabulary Search
        JPanel middleFrame2 = new JPanel();
        middleFrame2.setBackground(Color.LIGHT_GRAY);
        middleFrame2.setPreferredSize(new Dimension(1000,500));
        JButton search = new JButton("Vocabulary Search");
        search.addActionListener(new SearchMenuListener(this));
        middleFrame2.add(search);
        contentPane.add(middleFrame2);

        //Flash Cards
        JPanel middleFrame3 = new JPanel();
        middleFrame3.setBackground(Color.LIGHT_GRAY);
        middleFrame3.setPreferredSize(new Dimension(1000,500));
        JButton flashCards = new JButton("       Flash Cards       ");
        flashCards.addActionListener(new FlashCardsMenuListener(this));
        middleFrame3.add(flashCards);
        contentPane.add(middleFrame3);

        JPanel bottomFrame = new JPanel();
        bottomFrame.setBackground(Color.WHITE);
        bottomFrame.setPreferredSize(new Dimension(1000,200));
        contentPane.add(bottomFrame);
    }

    public void setUpEntry(){
        EntryMenu e = new EntryMenu(this);
        e.setUpFrame();
    }

    public void setUpSearch(){
        SearchMenu s = new SearchMenu(this);
        s.setUpFrame();
    }

    public void setUpFlashCards(){
        FlashCardsMenu f = new FlashCardsMenu(this);
        f.setUpFrame();
    }

}
