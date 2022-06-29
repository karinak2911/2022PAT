/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import objects.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Karinak
 */
public class StudentManager implements TableModel{
    

    Student[] studentArr = new Student[200];
    private int size = 0;
    private int studentArrComboBoxSize = 0; 
    
    public StudentManager() throws SQLException{ 
        String query = "SELECT * FROM studentstbl;"; 
         ResultSet rs = SystemManager.db.query(query);
         while(rs.next()){ 
             int studentID = rs.getInt(1); 
             String firstName = rs.getString(2); 
             String surname = rs.getString(3); 
             int grade = rs.getInt(4); 
             String sClass = rs.getString(5); 
             String idnum = rs.getString(6); 
             java.sql.Date dob = rs.getDate(7);  
             LocalDate d = dob.toLocalDate(); 
             
             studentArr[size] = new Student(studentID, firstName, surname, idnum, sClass, grade, d); 
             size++; 
         }
    }
    
    
    public StudentManager(int gradeIn) throws SQLException{ 
        String query = "SELECT * FROM studentstbl WHERE grade = " + gradeIn + ";"; 
         ResultSet rs = SystemManager.db.query(query);
         while(rs.next()){ 
             int studentID = rs.getInt(1); 
             String firstName = rs.getString(2); 
             String surname = rs.getString(3); 
             int grade = rs.getInt(4); 
             String sClass = rs.getString(5); 
             String idnum = rs.getString(6); 
             java.sql.Date dob = rs.getDate(7);  
             LocalDate d = dob.toLocalDate(); 
             
             studentArr[size] = new Student(studentID, firstName, surname, idnum, sClass, grade, d); 
             size++; 
         }
    }
     public void shiftLeft(int index) {
        for (int i = index; i < size; i++) {
            studentArr[i] = studentArr[i + 1];
        }
        size--;
    }

    public void shiftRight(int index) {
        size++;
        for (int i = size - 1; i > index; i--) {
            studentArr[i] = studentArr[i - 1];
        }
    }

 

    // removes student from array using compare to method 
    public void deleteStudent(int row) throws SQLException {
           String query = "DELETE FROM cutos.studentstbl WHERE `studentID` = " + studentArr[row].getStudentID();
        SystemManager.db.update(query);
                this.shiftLeft(row);

        

    }

    // adds a student to array 
    public void addStudent(String idNumber, String firstname, String surname, String sClass, int grade, LocalDate dob) throws SQLException {
 
        String query = "INSERT INTO cutos.studentstbl (`firstName`, surname, grade, `Class`, `IDNumber`, dob) VALUES ('" + firstname + "','" + surname + "'," + grade + ",'" + sClass  + "','" + idNumber + "','" + dob.toString() + "');"; 
        System.out.println(query);
    SystemManager.db.update(query); 
studentArr[size] = new Student(firstname, surname, idNumber, sClass, grade, dob); 
        size++; 
     // studentArr[size] = new Student(firstname, surname, idNumber, sClass, grade, dob);
       
    
        
       


    }
//  public Object[][] getStudentTableData() {
//        Object[][] out = new Object[size][6];
//        for (int row = 0; row < size; row++) {
//
//            out[row][0] = studentArr[row].getFirstname(); 
//            out[row][1] = studentArr[row].getSurname(); 
//            out[row][2] = studentArr[row].getGrade(); 
//            out[row][3] = studentArr[row].getsClass();
//            out[row][4] = studentArr[row].getIdNumber(); 
//            out[row][5] = studentArr[row].getDob(); 
//
//        }
//        return out;
//
//    }

    @Override
    public int getRowCount() {
       return size; 
    }

    @Override
    public int getColumnCount() {
       return 7; 
    }

    @Override
    public String getColumnName(int columnIndex) {
          String name ="";
        switch(columnIndex){
            case 0 -> name = "Student ID"; 
            case 1 -> name = "Firstname"; 
            case 2 -> name =  "Last name"; 
            case 3 -> name = "Grade"; 
            case 4 -> name = "Class"; 
            case 5 -> name = "ID Number"; 
              case 6 -> name = "DOB";        
                    } 
        return name; 
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
         Class<?> temp =getClass();
        try {
            switch(columnIndex){
                case 0 -> temp = Class.forName("java.lang.Integer");
                case 1 -> temp = Class.forName("java.lang.String");
                case 2 -> temp = Class.forName("java.lang.String");
                case 3 -> temp = Class.forName("java.lang.Integer");
                case 4 -> temp = Class.forName("java.lang.String");
                case 5 -> temp = Class.forName("java.lang.String");
                 case 6 -> temp = Class.forName("java.time.LocalDate");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
         if(columnIndex == 0)
            return false; 
        else 
            return true; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object out = new Object(); 
         switch(columnIndex){
              case 0 -> out = studentArr[rowIndex].getStudentID();
            case 1 ->  out = studentArr[rowIndex].getFirstname();
            case 2 -> out = studentArr[rowIndex].getSurname();
            case 3 -> out = studentArr[rowIndex].getGrade();
             case 4 -> out = studentArr[rowIndex].getsClass();
              case 5 -> out = studentArr[rowIndex].getIdNumber();
              case 6 -> out = studentArr[rowIndex].getDob();
                  }
         return out; 
    }
    
    

    
    

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       Student s = studentArr[rowIndex]; 
        String query = "UPDATE studentstbl SET "; 
        
          switch(columnIndex){
            case 1: 
                studentArr[rowIndex].setFirstname((String)aValue);
                query+= "`firstName` = '" + ((String)aValue) + "' WHERE `StudentID` = " + s.getStudentID() + ";"; 
           
                break; 
            case 2: 
                studentArr[rowIndex].setSurname((String)aValue);
                 query+= "`surname` = '" + ((String)aValue) + "' WHERE `StudentID` = " + s.getStudentID() + ";";             
                
                  break; 
            case 3: 
                studentArr[rowIndex].setGrade(((Integer) aValue).intValue());
                 query+= "`grade` = " + ((Integer) aValue).intValue() + " WHERE `StudentID` = " + s.getStudentID() + ";"; 
            
                                  break; 
            case 4: 
                studentArr[rowIndex].setsClass((String)aValue);
                 query+= "`Class` = '" + ((String)aValue) + "' WHERE `StudentID` = " + s.getStudentID() + ";"; 
            
                                  break; 
             case 5:
                 studentArr[rowIndex].setIdNumber((String)aValue);
                 query+= "`IDNumber` = '" + ((String)aValue) + "' WHERE `StudentID` = " + s.getStudentID() + ";";
           
                                  break; 
              case 6: 
                 studentArr[rowIndex].setDob((LocalDate) aValue);
                 query+= "`dob` = '" + ((LocalDate)aValue) + "' WHERE `StudentID` = " + s.getStudentID() + ";";
              
                                  break; 
        }
       try {
                   SystemManager.db.update(query); 
                           } catch (SQLException ex) {
                   Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
       
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
       
    }
    
    public String[] getStudentsnamesAsarrayForComboBox(int grade) {
        String[] output = new String[200];
        for (int i = 0; i < size; i++) {
           if(studentArr[i].getGrade() == grade){ 
            output[i] = studentArr[i].getFirstname() + " " + studentArr[i].getSurname();
            studentArrComboBoxSize++; 
        } 
        } 
        return output;

    }

    public int getStudentArrComboBoxSize() {
        return studentArrComboBoxSize;
    }
    
    
    
}
