import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import static java.awt.event.KeyEvent.*;

/**
 *
 * @author josmek
 */
public class ClickRun implements Runnable{

    private MainGUI gui;
    
    private Robot robot;
    
    private boolean toggle;
    
    public ClickRun(MainGUI c) throws AWTException{
        //Creates a new robot
        this.robot = new Robot();
        gui = c;
        toggle = true;
    }
    
    public ClickRun(Robot robot) {
        this.robot = robot;
    }
    
    
    public void setToggle(){
        toggle = false;
    }
    
    @Override
    public void run() {
        int seconds = 1;
        //The delay in milliseconds
        try{
            seconds = gui.getSeconds2() * 1000;
        } catch (Exception e) {
            
        }
        
        //Presses and Releases the mouse as long as the thread it running
        while(!Thread.currentThread().isInterrupted()){
            robot.delay(seconds);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
        toggle = true;
    }

}

