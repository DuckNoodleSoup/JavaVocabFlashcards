import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlashCardsMenuListener implements ActionListener {
    MainMenu f;
    public FlashCardsMenuListener(MainMenu e){
        this.f = e;
    }

    public void actionPerformed(ActionEvent e) {
        f.getContentPane().removeAll();
        f.validate();
        f.repaint();
        f.setUpFlashCards();
        f.validate();
        f.repaint();
    }

}
