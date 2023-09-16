
import javax.swing.JFileChooser;



public class FileChooserHelper {
    private static JFileChooser chooser;
    
    public static JFileChooser getFileChooser(){
        if (chooser == null){
            chooser = new JFileChooser();
        }
        return chooser;
    }
}
