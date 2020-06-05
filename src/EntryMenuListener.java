import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryMenuListener implements ActionListener {

    MainMenu em;
    public EntryMenuListener(MainMenu e){
        this.em = e;
    }

    public void actionPerformed(ActionEvent e) {
        em.getContentPane().removeAll();
        em.validate();
        em.repaint();
        em.setUpEntry();
        em.validate();
        em.repaint();
    }

}
