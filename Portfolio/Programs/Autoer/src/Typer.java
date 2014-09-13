import java.awt.AWTException;

public class Typer {
    public static void main(String[] args) throws AWTException{
        
        //Creates MainGUI named frame, makes it visible, and centers it on the screen
        MainGUI frame = new MainGUI();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
    }
}
