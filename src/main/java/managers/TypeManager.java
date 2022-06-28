/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import objects.Type;

/**
 *
 * @author Karinak
 */
public class TypeManager {
    Type[] typeArr = new Type[200]; 
    private int size = 0;

    public TypeManager() throws SQLException {
        String query = "SELECT * FROM typetbl;";
          ResultSet rs = SystemManager.db.query(query);
         while(rs.next()){ 
             int typeId = rs.getInt(1); 
             String typename = rs.getString(2); 
             
             typeArr[size] = new Type(typeId, typename); 
             size++; 
         }
        
    }

    public int getSize() {
        return size;
    }
    
    public String[] typesForCombobox(){ 
          String[] output = new String[200];
        for (int i = 0; i < size; i++) {
           
            output[i] = typeArr[i].getTypeName();
        }
        return output;
    }
    
    
    
    public void addType(String typeName) throws SQLException{ 
        String query = "INSERT INTO cutos.typetbl (`typeName`) VALUES ('" + typeName + "');";
        SystemManager.db.update(query); 
        typeArr[size] = new Type(size, typeName);
    size++; 
    }
    
    public void deleteType(String typeName) throws SQLException{ 
        for(int i = 0; i < size; i++){ 
            if(typeArr[i].getTypeName().equalsIgnoreCase(typeName))
                this.shiftLeft(i);
        }
        String query = "DELETE FROM cutos.typetbl WHERE `typeName` = '" + typeName + "';" ;
        SystemManager.db.update(query); 

    }
    
    private void shiftLeft(int index) {
        for (int i = index; i < size; i++) {
            typeArr[i] = typeArr[i + 1];
        }
        size--;
    }
    
    
 
}
