import java.awt.AWTException;
import java.awt.Robot;
import static java.awt.event.KeyEvent.*;

/**
 *
 * @author josmek
 */
public class Runnah implements Runnable{

    private MainGUI gui;
    
    //A new robot
    private Robot robot;
    
    private boolean toggle;
    
    private static boolean enter;
    
    public Runnah(MainGUI c) throws AWTException{
        //Creates the Robot
        this.robot = new Robot();
        //Sets the current GUI
        gui = c;
        toggle = true;
        enter = false;
    }
    
    public Runnah(Robot robot) {
        this.robot = robot;
    }
    
    private void typeNow(int... key) {
        typeNow(key, 0, key.length);
    }
    
    private void typeNow(int[] key, int offset, int length) {
        if (length == 0) {
            return;
        }

        //Presses and releases the key that is passed into typeNow
        robot.keyPress(key[offset]);
        typeNow(key, offset + 1, length - 1);
        robot.keyRelease(key[offset]);
    }
    
    //GIANT SWITCH STATEMENT FOR EVERY CHARACTER ON THE KEYBOARD
    public void typeThis(char let){
        switch (let) {
        case 'a': typeNow(VK_A); break;
        case 'b': typeNow(VK_B); break;
        case 'c': typeNow(VK_C); break;
        case 'd': typeNow(VK_D); break;
        case 'e': typeNow(VK_E); break;
        case 'f': typeNow(VK_F); break;
        case 'g': typeNow(VK_G); break;
        case 'h': typeNow(VK_H); break;
        case 'i': typeNow(VK_I); break;
        case 'j': typeNow(VK_J); break;
        case 'k': typeNow(VK_K); break;
        case 'l': typeNow(VK_L); break;
        case 'm': typeNow(VK_M); break;
        case 'n': typeNow(VK_N); break;
        case 'o': typeNow(VK_O); break;
        case 'p': typeNow(VK_P); break;
        case 'q': typeNow(VK_Q); break;
        case 'r': typeNow(VK_R); break;
        case 's': typeNow(VK_S); break;
        case 't': typeNow(VK_T); break;
        case 'u': typeNow(VK_U); break;
        case 'v': typeNow(VK_V); break;
        case 'w': typeNow(VK_W); break;
        case 'x': typeNow(VK_X); break;
        case 'y': typeNow(VK_Y); break;
        case 'z': typeNow(VK_Z); break;
        case 'A': typeNow(VK_SHIFT, VK_A); break;
        case 'B': typeNow(VK_SHIFT, VK_B); break;
        case 'C': typeNow(VK_SHIFT, VK_C); break;
        case 'D': typeNow(VK_SHIFT, VK_D); break;
        case 'E': typeNow(VK_SHIFT, VK_E); break;
        case 'F': typeNow(VK_SHIFT, VK_F); break;
        case 'G': typeNow(VK_SHIFT, VK_G); break;
        case 'H': typeNow(VK_SHIFT, VK_H); break;
        case 'I': typeNow(VK_SHIFT, VK_I); break;
        case 'J': typeNow(VK_SHIFT, VK_J); break;
        case 'K': typeNow(VK_SHIFT, VK_K); break;
        case 'L': typeNow(VK_SHIFT, VK_L); break;
        case 'M': typeNow(VK_SHIFT, VK_M); break;
        case 'N': typeNow(VK_SHIFT, VK_N); break;
        case 'O': typeNow(VK_SHIFT, VK_O); break;
        case 'P': typeNow(VK_SHIFT, VK_P); break;
        case 'Q': typeNow(VK_SHIFT, VK_Q); break;
        case 'R': typeNow(VK_SHIFT, VK_R); break;
        case 'S': typeNow(VK_SHIFT, VK_S); break;
        case 'T': typeNow(VK_SHIFT, VK_T); break;
        case 'U': typeNow(VK_SHIFT, VK_U); break;
        case 'V': typeNow(VK_SHIFT, VK_V); break;
        case 'W': typeNow(VK_SHIFT, VK_W); break;
        case 'X': typeNow(VK_SHIFT, VK_X); break;
        case 'Y': typeNow(VK_SHIFT, VK_Y); break;
        case 'Z': typeNow(VK_SHIFT, VK_Z); break;
        case '`': typeNow(VK_BACK_QUOTE); break;
        case '0': typeNow(VK_0); break;
        case '1': typeNow(VK_1); break;
        case '2': typeNow(VK_2); break;
        case '3': typeNow(VK_3); break;
        case '4': typeNow(VK_4); break;
        case '5': typeNow(VK_5); break;
        case '6': typeNow(VK_6); break;
        case '7': typeNow(VK_7); break;
        case '8': typeNow(VK_8); break;
        case '9': typeNow(VK_9); break;
        case '-': typeNow(VK_MINUS); break;
        case '=': typeNow(VK_EQUALS); break;
        case '~': typeNow(VK_SHIFT, VK_BACK_QUOTE); break;
        case '!': typeNow(VK_SHIFT, VK_1); break;
        case '@': typeNow(VK_SHIFT, VK_2); break;
        case '#': typeNow(VK_SHIFT, VK_3); break;
        case '$': typeNow(VK_SHIFT, VK_4); break;
        case '%': typeNow(VK_SHIFT, VK_5); break;
        case '^': typeNow(VK_SHIFT, VK_6); break;
        case '&': typeNow(VK_SHIFT, VK_7); break;
        case '*': typeNow(VK_SHIFT, VK_8); break;
        case '(': typeNow(VK_SHIFT, VK_9); break;
        case ')': typeNow(VK_SHIFT, VK_0); break;
        case '_': typeNow(VK_SHIFT, VK_MINUS); break;
        case '+': typeNow(VK_SHIFT, VK_EQUALS); break;
        case '\t': typeNow(VK_TAB); break;
        case '\n': typeNow(VK_ENTER); break;
        case '[': typeNow(VK_OPEN_BRACKET); break;
        case ']': typeNow(VK_CLOSE_BRACKET); break;
        case '\\': typeNow(VK_BACK_SLASH); break;
        case '{': typeNow(VK_SHIFT, VK_OPEN_BRACKET); break;
        case '}': typeNow(VK_SHIFT, VK_CLOSE_BRACKET); break;
        case '|': typeNow(VK_SHIFT, VK_BACK_SLASH); break;
        case ';': typeNow(VK_SEMICOLON); break;
        case ':': typeNow(VK_SHIFT, VK_SEMICOLON); break;
        case '\'': typeNow(VK_QUOTE); break;
        case '"': typeNow(VK_SHIFT, VK_QUOTE); break;
        case ',': typeNow(VK_COMMA); break;
        case '<': typeNow(VK_SHIFT, VK_COMMA); break;
        case '.': typeNow(VK_PERIOD); break;
        case '>': typeNow(VK_SHIFT, VK_PERIOD); break;
        case '/': typeNow(VK_SLASH); break;
        case '?': typeNow(VK_SHIFT, VK_SLASH); break;
        case ' ': typeNow(VK_SPACE); break;
        default: throw new IllegalArgumentException("Derp! That chatacter doesn't work " + let);
        }
    }
    
    public void setToggle(){
        toggle = false;
    }
    
    //Enables/Disables the enter key
    public void setEnter(boolean a){
        enter = a;
    }
    
    @Override
    public void run() {
        
        int seconds = 1;
        
        //Get the input from the textField in the GUI
        String temp = gui.getInput();
        
        //Turns it into an array of chars      
        char[] test = new char[temp.length()];
        
        for(int i = 0; i < temp.length(); i++){
            test[i] = temp.charAt(i);
        }
        
        //Sets the seconds to the entered seconds * 1000
        //Becase .delay() runs in Milliseconds
        try{
            seconds = gui.getSeconds() * 1000;
        }
        catch (Exception e) {
            
        }
        //Types as long as the thread is running
        while(!Thread.currentThread().isInterrupted()){
            //The delay in seconds (aka milliseconds)
            robot.delay(seconds);
            //Types the individual characters from the array
            for(int i = 0; i < temp.length(); i++){
                typeThis(test[i]);
            }
            //Hits enter after each sequence is typed if the user selected the option
            if(enter){
                typeNow(VK_ENTER);
            }
        }
        toggle = true;
    }

}

