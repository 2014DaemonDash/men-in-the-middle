import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ListsOnLists {
    
    static ArrayList<String> mainList;
    
    public ArrayList makeList(){
        //Instantiates mainList
        mainList = new ArrayList<String>();
        
        try{
            /* Gets the strings from each line in cardList.txt
             * and adds the string to the mainList ArrayList
             */
            Scanner console = new Scanner(new File("./cardList.txt"));
            while(console.hasNext()){
                String temp = console.next();
                mainList.add(temp);
            }
        } 
        catch(Exception e){
            System.err.println("You be derpin!" + e);
        }

        //Returns mainList
        return mainList;
    }
    
}
