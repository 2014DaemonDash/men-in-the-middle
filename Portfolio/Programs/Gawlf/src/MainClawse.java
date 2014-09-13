
public class MainClawse {
    public static void main(String[] args){
        
        //Creates an instance of the ListsOnLists class
        ListsOnLists lists = new ListsOnLists();
        
        //Creates an instance of the Gooey class, centers it on the screen, and makes it visible
        Gooey gui = new Gooey();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.getMainList();
    }
}
