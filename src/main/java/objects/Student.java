/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Karinak
 */
public class Student {
    private int studentID; 
    private String firstname; 
    private String surname; 
    private String idNumber; 
    private String sClass; 
    private int grade; 
    private LocalDate dob; 

    public Student(int studentID,String firstname, String surname, String idNumber, String sClass, int grade, LocalDate dob) {
        this.studentID = studentID; 
        this.firstname = firstname;
        this.surname = surname;
        this.idNumber = idNumber;
        this.sClass = sClass;
        this.grade = grade;
        this.dob = dob; 
    }

    public Student(String firstname, String surname, String idNumber, String sClass, int grade, LocalDate dob) {
        this.firstname = firstname;
        this.surname = surname;
        this.idNumber = idNumber;
        this.sClass = sClass;
        this.grade = grade;
        this.dob = dob;
    }

    
    
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    
    public static boolean isValidID(String idNumber){ 
        if( !(idNumber.length() == 13) || !hasNumbersOnly(idNumber)){
            return false;
        }
        return true; 
    }
    
    private static boolean hasNumbersOnly(String idNumber){
        for(char c: idNumber.toCharArray()){
            if(!Character.isDigit(c))
            {
                return false;
            }
        }
        return true;
    }

    public LocalDate getDob() {
        return dob;
    }
    
    private static boolean hasLettersOnly(String idNumber){
        for(char c: idNumber.toCharArray()){
            if(!Character.isAlphabetic(c))
            {
                return false;
            }
        }
        return true;
    }
    
   /* private static boolean isPresent(String input){ 
        if(input.isBlank())
            return false; 
        else 
            return true; 
                   
    }
    */
    
    
    public static boolean isValidFirstName(String name){ 
        return hasLettersOnly(name); 
    }
    
    public static boolean isValidLastName(String name){ 
        return hasLettersOnly(name); 
    }
    
    public static boolean isValidDOB(String idNum, LocalDate dob){ 
        
        
        String year = "";
        int yearDig = Integer.parseInt(idNum.substring(0,2)); 
        if(yearDig < 50)
            year = "20" + idNum.substring(0,2); 
        else 
            year = "19" + idNum.substring(0,2); 
        String month = idNum.substring(2,4);
        String date = idNum.substring(4,6);
        
        String birthdate = date + "-" + month + "-" + year;
        System.out.println(birthdate);
        
        String dateStr = dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(dateStr);
        
        if(dateStr.equals(birthdate))
            return true; 
        else 
            return false; 
       
    }
    
     public int compareTo(String name) {
        return this.surname.compareToIgnoreCase(name);
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
     
     
     
     

}
