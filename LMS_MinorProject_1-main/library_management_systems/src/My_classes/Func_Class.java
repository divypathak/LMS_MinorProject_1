
package My_classes;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Divyam
 */
public class Func_Class {
     public void displayImage(int width, int height , String ImagePath, JLabel label)
    {
        ImageIcon imgIco=new ImageIcon(getClass().getResource("/My_images/logo2.png"));
        Image image=imgIco.getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH );
        label.setIcon(new ImageIcon(image));
        
     
    }
}
