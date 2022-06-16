/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import objects.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Karinak
 */
public class StudentManager {
    

    Student[] studentArr = new Student[200];
    private int size = 0;
    
    public StudentManager() throws SQLException{ 
        String query = "SELECT * FROM studentstbl;"; 
         ResultSet rs = SystemManager.db.query(query);
         while(rs.next()){ 
             String firstName = rs.getString(2); 
             String surname = rs.getString(3); 
             int grade = rs.getInt(4); 
             String sClass = rs.getString(5); 
             String idnum = rs.getString(6); 
             java.sql.Date dob = rs.getDate(7);  
             LocalDate d = dob.toLocalDate(); 
             
             studentArr[size] = new Student(firstName, surname, idnum, sClass, grade, d); 
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
    public void deleteStudent(String name) {
        for (int i = 0; i < size; i++) {
            if (studentArr[i].compareTo(name) == 0) {
                this.shiftLeft(i);
            }

        }

        

    }

    // adds a student to array 
    public void addStudent(String idNumber, String firstname, String surname, String sClass, int grade, LocalDate dob) throws SQLException {
    
        
      
        
        
        String query = "INSERT INTO cutos.studentstbl (`firstName`, surname, grade, `Class`, `IDNumber`, dob) VALUES ('" + firstname + "','" + surname + "'," + grade + ",'" + sClass  + "','" + idNumber + "','" + dob.toString() + "');"; 
        System.out.println(query);
    SystemManager.db.update(query); 
    size++; 
      studentArr[size] = new Student(firstname, surname, idNumber, sClass, grade, dob);
       
    
        
       


    }
  public Object[][] getStudentTableData() {
        Object[][] out = new Object[size][6];
        for (int row = 0; row < size; row++) {

            out[row][0] = studentArr[row].getFirstname(); 
            out[row][1] = studentArr[row].getSurname(); 
            out[row][2] = studentArr[row].getGrade(); 
            out[row][3] = studentArr[row].getsClass();
            out[row][4] = studentArr[row].getIdNumber(); 
            out[row][5] = studentArr[row].getDob(); 

        }
        return out;

    }
}
