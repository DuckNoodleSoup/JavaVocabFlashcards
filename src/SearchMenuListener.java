import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchMenuListener implements ActionListener {

    MainMenu sm;
    public SearchMenuListener(MainMenu e){
        this.sm = e;
    }

    public void actionPerformed(ActionEvent e) {
        sm.getContentPane().removeAll();
        sm.validate();
        sm.repaint();
        sm.setUpSearch();
        sm.validate();
        sm.repaint();
    }

}


