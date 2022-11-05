
package My_classes;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Divyam
 */
public class Func_Class {
     public void displayImage(int width, int height , String ImagePath, JLabel label)
    {
        ImageIcon imgIco=new ImageIcon(getClass().getResource(ImagePath));
        Image image=imgIco.getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH );
        label.setIcon(new ImageIcon(image));
        
     
    }
     
     //function to customize jTable
     
     public void customTable(JTable table)
     {
        table.setSelectionBackground(new Color(236, 179, 101));
        table.setSelectionForeground(Color.white);
        table.setRowHeight(30);
        table.setShowGrid(false);
        table.setBackground(new Color(248,248,248));
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.gray);
         
     }
     
     //create a function to return a resultSet
     public ResultSet getData(String query)
     {
         
            PreparedStatement ps;
            ResultSet rs=null;
            
            try {
             ps = DB.getConnection().prepareStatement(query);
             rs=ps.executeQuery();
              }
            catch (SQLException ex) {
            Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, ex);
        }
            return rs;
         
     }
}
