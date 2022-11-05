
package My_classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Author {
    
    private int id;
    private String firstName;
    private String lastName;
    private String field_Of_Expertise;
    private String about;
    
    public Author () {}
        public Author(int _id, String _fname, String _lname, String _expertise, String _about)
    {
        this.id= _id;
        this.firstName=_fname;
        this.lastName=_lname;
        this.field_Of_Expertise=_expertise;
        this.about=_about;
    }

    public void setId(int _id) {
        
        this.id = _id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setField_Of_Expertise(String field_Of_Expertise) {
        this.field_Of_Expertise = field_Of_Expertise;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getField_Of_Expertise() {
        return field_Of_Expertise;
    }

    public String getAbout() {
        return about;
    }

    
    //functions 
    
    public void addAuthor(String _fname,String _lname,String _expertise,String _about)
    {   
        String insertQuery = "INSERT INTO `author`(`firstName`, `lastName`, `expertise`, `about`) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1,_fname);
            ps.setString(2,_lname);
            ps.setString(3,_expertise);
            ps.setString(4,_about);
            
            if(ps.executeUpdate() != 0)
            {
                JOptionPane.showMessageDialog(null, "Author Added", "add Author", 1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Author Not Added", "add Author", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    
    
    public void editAuthor(int _id, String _fname,String _lname,String _expertise,String _about)
    {   
        String editQuery = "UPDATE `author` SET `firstName`= ?,`lastName`=?,`expertise`= ?,`about`=? WHERE 'id' = ?";
        
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
            
            ps.setString(1,_fname);
            ps.setString(2,_lname);
            ps.setString(3,_expertise);
            ps.setString(4,_about);
            ps.setInt(4, _id);
            
            
            if(ps.executeUpdate() != 0)
            {
                JOptionPane.showMessageDialog(null, "Author Edited", "edit Author", 1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Author Not Edited", "edit Author", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
       
 public void removeAuthor(int _id)
    {   
        String editQuery = "DELETE FROM `author` WHERE `id` = ?";
        
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
            
            
            ps.setInt(1, _id);
            
            
            if(ps.executeUpdate() != 0)
            {
                JOptionPane.showMessageDialog(null, "Author Deleted", "remove", 1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Author Not Deleted", "remove", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
 
 
 //function to populate an arrayList with author
        
        public ArrayList<Author> authorsList()
        {
            ArrayList<Author> aList= new ArrayList<>();
            

            My_classes.Func_Class func= new Func_Class();
            
            try {
             
            ResultSet rs=func.getData("SELECT * FROM `author`");
            Author author;
             
             while(rs.next())
             {
                 author = new Author(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastName"),rs.getString("expertise"),rs.getString("about"));
                 aList.add(author);
             }
          
           
        }
            catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
            return aList;
            
        }
    

 
 
 
}
