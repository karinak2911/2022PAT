/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DB;

/**
 *
 * @author Karinak
 */
public class SystemManager {
    	public static DB db;
        public static MenuManager mm; 
        public static StudentManager sm; 
        public static UserManager um; 
        public static OrdersManager om; 
        public static OrderedItemManager otm; 
        
      public SystemManager(){   try {
			db = new DB();
			System.out.println("SM: DB object created");
			mm = new MenuManager(); 
			System.out.println("SM: Memu items initialised");
			sm =  new StudentManager(); 
			System.out.println("SM: Students initialised");
                        um = new UserManager(); 
                        System.out.println("SM: users initialised");
                        om = new OrdersManager(); 
                         System.out.println("SM: orders initialised");
                         otm = new OrderedItemManager(); 
                          System.out.println("SM: order items  initialised");
                         
                       
		} catch (ClassNotFoundException ex) {
			System.out.println("SM: Database driver could not be loaded");
			Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			System.out.println("SM: Database connection or query issue");
			Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
		}
        
    
}
} 
