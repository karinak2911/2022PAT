/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

/**
 *
 * @author Karinak
 */
public class StudentArray {
    

    Student[] studentArr = new Student[200];
    private int size;
    
    public StudentArray(){ 
        
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
    public void addStudent(String idNumber, String firstname, String surname, String sClass, int grade, LocalDate dob) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (studentArr[i].compareTo(firstname) > 0) {
                index = i;
                break;
            }
        }
        this.shiftRight(index);
        studentArr[index] = new Student(firstname, surname, idNumber, sClass, grade, dob);

    

    }

}
