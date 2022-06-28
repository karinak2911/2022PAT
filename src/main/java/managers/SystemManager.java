/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
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
    public static StaticsManager stm;
    public static TypeManager tm;
    public static OrderManager orm;
    public static OrderedItemManager oim; 

    public SystemManager() {
        try {
            db = new DB();
            System.out.println("SM: DB object created"); 
            sm = new StudentManager();
            System.out.println("SM: Students initialised");
            um = new UserManager();
            System.out.println("SM: users initialised");
            om = new OrdersManager();
            System.out.println("SM: orders initialised");
            stm = new StaticsManager();
            System.out.println("SM: order items  initialised");
            tm = new TypeManager();
            System.out.println("SM: type items  initialised");
            oim = new OrderedItemManager();
            System.out.println("SM: ordered items  initialised");

        } catch (ClassNotFoundException ex) {
            System.out.println("SM: Database driver could not be loaded");
            Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("SM: Database connection or query issue");
            Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void initialiseOrderManager(int id) throws SQLException {
        orm = new OrderManager(id);
        System.out.println("SM: order items  initialised");
    }
    public void initialiseMenuManagerToPlaceOrder(String type) throws SQLException {
        mm = new MenuManager(type);
        System.out.println("SM: order items  initialised");
    }
    
    public void initialiseMenuManager() throws SQLException, ClassNotFoundException {
        mm = new MenuManager();
            System.out.println("SM: Memu items initialised");
    }
    
    public void initialiseAllOrders() throws SQLException{ 
        om = new OrdersManager();
            System.out.println("SM: orders initialised");
    }
    
    public void initialiseSpecificWaiterOrders(int waiterID) throws SQLException{ 
        om = new OrdersManager(waiterID);
            System.out.println("SM: orders initialised");
    }
    
   public void initialiseStudentManagerForGrade(int grade) throws SQLException{ 
       sm = new StudentManager(grade); 
   }
    

    

}
