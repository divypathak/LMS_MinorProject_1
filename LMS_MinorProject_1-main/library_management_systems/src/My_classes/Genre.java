/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package My_classes;

/**
 *
 * @author Divyam
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Genre {
    
    private int id;
    private String name;
    //constructors
    
    public Genre() {};
    
    public Genre(int _id, String _name)
    {
        this.id = _id;
        this.name = _name;
    }
    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    //setters
    public void setId(int _id) {
        this.id = _id;
    }

    public void setName(String _name) {
        this.name = _name;
    }
    
    //functions 
    
    public void addGenre(String _name)
    {   
        String insertQuery = "INSERT INTO `book_genres`(`name`) VALUES (?)";
        
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1,_name);
            
            if(ps.executeUpdate() != 0)
            {
                JOptionPane.showMessageDialog(null, "Genre Added", "add genre", 1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Genre Not Added", "add genre", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
       public void editGenre(int _id,String _name)
    {   
        String editQuery = "UPDATE `book_genres` SET `name`= ? WHERE `id` = ?";
        
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
            
            ps.setString(1,_name);
            ps.setInt(2, _id);
            
            
            if(ps.executeUpdate() != 0)
            {
                JOptionPane.showMessageDialog(null, "Genre Edited", "edit genre", 1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Genre Not Edited", "edit genre", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    

}
