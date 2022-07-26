package UI;

import objects.Student;
import managers.StudentManager;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import managers.MenuManager;
import managers.OrderManager;
import managers.SystemManager;
import objects.MenuItem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Karinak
 */
public class AdminUI extends javax.swing.JFrame {

    SystemManager systemManager;
     private ArrayList<JCheckBox> checkBoxArr = new ArrayList<>();

    /**
     * Creates new form HomeScreenWaiterUI
     */
    public AdminUI() throws ClassNotFoundException, SQLException {
        initComponents();
        systemManager = new SystemManager();

        studentDOBdatePicker.setDateToToday();

        this.populateOrdersTable();
        this.populateStatsTable();
        this.populateMenuTable();
        this.populateStudentTable();
        this.populateUserTable();
        this.setOrderTabelSelectionModel();
        this.populateTypeComboBox();
        this.setActionCommands();
        systemManager.stm.orderArray(false);
        this.populateCheckBoxesForStats();

    }

    private void populateTypeComboBox() {
        DefaultComboBoxModel<String> comboModelTypes = new DefaultComboBoxModel<String>();
        String[] types = systemManager.tm.typesForCombobox();
        for (int i = 0; i < systemManager.tm.getSize(); i++) {
            comboModelTypes.addElement(types[i]);
        }
        itemTypesCombobox.setModel(comboModelTypes);
    }

    private void populateCheckBoxesForStats() {
        String[] types = systemManager.tm.typesForCombobox();
        checkBoxPanel.setLayout(new GridLayout(10, 1));
        for (int i = 0; i < systemManager.tm.getSize(); i++) {
            JCheckBox b = new JCheckBox();
            b.setText(types[i]);
            checkBoxPanel.add(b);
            checkBoxArr.add(b); 

        }
    }

    public void setActionCommands() {
        waiterradioButton.setActionCommand("waiter");
        adminRadioButton.setActionCommand("admin");
        mostSoldradioButton.setActionCommand("descending");
        leastSoldRadioButton.setActionCommand("ascending");
    }

    public void populateStudentTable() {

//        String[] coloumNamesForStudentTb = new String[7];
//        coloumNamesForStudentTb[0] = "First Name";
//        coloumNamesForStudentTb[1] = "Surname";
//         coloumNamesForStudentTb[2] = "Grade";
//          coloumNamesForStudentTb[3] = "Class";
//           coloumNamesForStudentTb[4] = "ID Num";
//            coloumNamesForStudentTb[5] = "DOB";
//            
//            
//        // gets data and populates table model, then sets table to table model
//     Object[][] dataForStudentTable = systemManager.sm.getStudentTableData();
//        DefaultTableModel model = new DefaultTableModel(dataForStudentTable, coloumNamesForStudentTb);
//        studentsTable.setModel(model); 
        studentsTable.setModel(systemManager.sm);
    }

    public void populateMenuTable() throws SQLException, ClassNotFoundException {

//        String[] coloumNames = new String[3];
//        coloumNames[0] = "Names";
//        coloumNames[1] = "Type";
//        coloumNames[2] = "Price";
        // gets menu items data for table from menu item array object and populates table
//            Object[][] dataForMenuItemTb = systemManager.mm.getMenuForTable();
        // creates model
//            DefaultTableModel menuItemTableModel = new DefaultTableModel(dataForMenuItemTb, coloumNames);
        // sets table to model
        //menuTable.setModel(menuItemTableModel);
        systemManager.initialiseMenuManager();
        menuTable.setModel(systemManager.mm);

    }

    public void populateUserTable() {
        /*String[] coloumNames = new String[6];
        coloumNames[0] = "Waiter ID"; 
        coloumNames[1] = "Job type"; 
        coloumNames[2] = "First Nam; 
        coloumNames[3] = "Surname"; 
        coloumNames[4] = "Email address"; 
        coloumNames[5] = "Password"; 
        
          Object[][] dataForUserTable = systemManager.um.getUsersForTable(); 
            DefaultTableModel menuItemTableModel = new DefaultTableModel(dataForUserTable, coloumNames);
            userTable.setModel(menuItemTableModel);*/

        userTable.setModel(systemManager.um);

    }

    public void populateStatsTable() throws SQLException {

        statsTable.setModel(systemManager.stm);
    }

    public void orderStatsTable(boolean asc) {
        this.setStatsTableToDefault();
        systemManager.stm.orderArray(asc);
        statsTable.setModel(systemManager.stm);
    }

    public void populateOrdersTable() throws SQLException {
        systemManager.initialiseAllOrders();
        ordersTable.setModel(systemManager.om);
    }

    private void setStatsTableToDefault() {
        DefaultTableModel dtm = new DefaultTableModel();
        statsTable.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        soldButtonGroup = new javax.swing.ButtonGroup();
        confirmationSlipButtonGroup = new javax.swing.ButtonGroup();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        itemTypeComboBox = new javax.swing.JComboBox<>();
        mealButtongroup = new javax.swing.ButtonGroup();
        viewPasswordButton = new javax.swing.JButton();
        usertypeButtonGroup = new javax.swing.ButtonGroup();
        orderBybuttonGroup = new javax.swing.ButtonGroup();
        adminTabbedPan = new javax.swing.JTabbedPane();
        viewOrdersPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        orderedItemtable = new javax.swing.JTable();
        manageMenuPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        menuTable = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        deleteItemButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        itemNameTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        itempricetextField = new javax.swing.JTextField();
        addItemtButton = new javax.swing.JButton();
        itemTypesCombobox = new javax.swing.JComboBox<>();
        typenameTextField = new javax.swing.JTextField();
        deleteTypeButton = new javax.swing.JButton();
        addTypeButton = new javax.swing.JButton();
        menuErrorMsgLabel = new javax.swing.JLabel();
        manageEmployeesPanel = new javax.swing.JPanel();
        menageemployeesPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        deletedEmpployeeButton = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        addEmployeeButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        employeeFirstnameTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        employeelastNameTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        employeeemailtextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        employeepasswordTextField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        waiterradioButton = new javax.swing.JRadioButton();
        adminRadioButton = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        manageStudenstPanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        studentPanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        studentFirstNameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        studentSurnameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        studentgradeComboBox = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        studentIDtextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        studentclassComboBox = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        studentDOBdatePicker = new com.github.lgooddatepicker.components.DatePicker();
        addStudentButton = new javax.swing.JButton();
        studentErrorMsgLabel = new javax.swing.JLabel();
        deleteStudentButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        FAQsPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        helpMessagetextArea = new javax.swing.JTextArea();
        manageMenuFAQsButton = new javax.swing.JButton();
        manageEmployeesFAQsButton = new javax.swing.JButton();
        manageStudentsFAQsButton = new javax.swing.JButton();
        viewStatsFAQsButton = new javax.swing.JButton();
        viewOrdersFAQsButton = new javax.swing.JButton();
        viewStatsPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        statsTable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        mostSoldradioButton = new javax.swing.JRadioButton();
        leastSoldRadioButton = new javax.swing.JRadioButton();
        checkBoxPanel = new javax.swing.JPanel();
        viewTypeStatsButton = new javax.swing.JButton();
        viewAllButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        itemTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sandwich", "Wrap", "Drink", "Snack", "Salad" }));

        viewPasswordButton.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adminTabbedPan.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        adminTabbedPan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminTabbedPanMouseClicked(evt);
            }
        });

        jLabel19.setText("ORDERS");
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "student name", "Total", "Paynet method", "User ", "Collected "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(ordersTable);

        jLabel24.setText("ORDERED ITEMS ");
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        orderedItemtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Type", "Price", "Quantity"
            }
        ));
        jScrollPane7.setViewportView(orderedItemtable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(224, 224, 224))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout viewOrdersPanelLayout = new javax.swing.GroupLayout(viewOrdersPanel);
        viewOrdersPanel.setLayout(viewOrdersPanelLayout);
        viewOrdersPanelLayout.setHorizontalGroup(
            viewOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewOrdersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewOrdersPanelLayout.setVerticalGroup(
            viewOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewOrdersPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        adminTabbedPan.addTab("View orders", viewOrdersPanel);

        jLabel7.setText("MENU");

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );

        jLabel27.setText("MENU ");
        jLabel27.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N

        menuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item Name", "Item Type", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(menuTable);

        jLabel28.setText("ADD MENU ITEM ");
        jLabel28.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N

        deleteItemButton.setText("DELETE ITEM");
        deleteItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemButtonActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Item Name: ");

        itemNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNameTextFieldActionPerformed(evt);
            }
        });
        itemNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemNameTextFieldKeyTyped(evt);
            }
        });

        jLabel10.setText("Item Type: ");

        jLabel11.setText("Price: ");

        itempricetextField.setText("0");
        itempricetextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itempricetextFieldActionPerformed(evt);
            }
        });
        itempricetextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itempricetextFieldKeyTyped(evt);
            }
        });

        addItemtButton.setText("ADD ITEM");
        addItemtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemtButtonActionPerformed(evt);
            }
        });

        itemTypesCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        itemTypesCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTypesComboboxActionPerformed(evt);
            }
        });

        typenameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typenameTextFieldActionPerformed(evt);
            }
        });

        deleteTypeButton.setText("DELETE TYPE");
        deleteTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTypeButtonActionPerformed(evt);
            }
        });

        addTypeButton.setText("ADD TYPE");
        addTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTypeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(itemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(typenameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(addTypeButton))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(itemTypesCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(deleteTypeButton)))))
                        .addContainerGap(196, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(35, 35, 35)
                                .addComponent(itempricetextField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addItemtButton)))
                        .addGap(25, 25, 25))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuErrorMsgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(itemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(itemTypesCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteTypeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typenameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTypeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itempricetextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuErrorMsgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addItemtButton)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout manageMenuPanelLayout = new javax.swing.GroupLayout(manageMenuPanel);
        manageMenuPanel.setLayout(manageMenuPanelLayout);
        manageMenuPanelLayout.setHorizontalGroup(
            manageMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageMenuPanelLayout.createSequentialGroup()
                .addGroup(manageMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(manageMenuPanelLayout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jLabel27)
                        .addGap(77, 77, 77)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(manageMenuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(manageMenuPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(manageMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(manageMenuPanelLayout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageMenuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageMenuPanelLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteItemButton)
                .addGap(140, 140, 140))
        );
        manageMenuPanelLayout.setVerticalGroup(
            manageMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageMenuPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(manageMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteItemButton)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(manageMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(281, 281, 281)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        adminTabbedPan.addTab("Manage Menu", manageMenuPanel);

        manageEmployeesPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageEmployeesPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                manageEmployeesPanelMouseEntered(evt);
            }
        });

        menageemployeesPanel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Waiter ID ", "Email", "Name", "Username", "Password"
            }
        ));
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userTableMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(userTable);

        jLabel15.setText("EMPLOYEES ");

        deletedEmpployeeButton.setText("DELETE EMPLOYEE");
        deletedEmpployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletedEmpployeeButtonActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addEmployeeButton.setText("ADD EMPLOYEE");
        addEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeButtonActionPerformed(evt);
            }
        });

        jLabel16.setText("Name: ");

        jLabel25.setText("Surname: ");

        jLabel17.setText("Email:");

        jLabel18.setText("Password: ");

        jLabel26.setText("Type:");

        usertypeButtonGroup.add(waiterradioButton);
        waiterradioButton.setSelected(true);
        waiterradioButton.setText("Waiter");
        waiterradioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waiterradioButtonActionPerformed(evt);
            }
        });

        usertypeButtonGroup.add(adminRadioButton);
        adminRadioButton.setText("Admin");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addEmployeeButton)
                .addGap(30, 30, 30))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(employeeFirstnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(employeelastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(employeeemailtextField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel18)
                            .addGap(22, 22, 22)
                            .addComponent(employeepasswordTextField)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(waiterradioButton)
                        .addGap(18, 18, 18)
                        .addComponent(adminRadioButton)))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeFirstnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(employeelastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(employeeemailtextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(employeepasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(waiterradioButton)
                    .addComponent(adminRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(addEmployeeButton)
                .addContainerGap())
        );

        jLabel8.setText("ADD EMPLOYEE ");
        jLabel8.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N

        javax.swing.GroupLayout menageemployeesPanelLayout = new javax.swing.GroupLayout(menageemployeesPanel);
        menageemployeesPanel.setLayout(menageemployeesPanelLayout);
        menageemployeesPanelLayout.setHorizontalGroup(
            menageemployeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menageemployeesPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(172, 172, 172)
                .addComponent(deletedEmpployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(menageemployeesPanelLayout.createSequentialGroup()
                .addGroup(menageemployeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menageemployeesPanelLayout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel15))
                    .addGroup(menageemployeesPanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menageemployeesPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        menageemployeesPanelLayout.setVerticalGroup(
            menageemployeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menageemployeesPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(menageemployeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deletedEmpployeeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout manageEmployeesPanelLayout = new javax.swing.GroupLayout(manageEmployeesPanel);
        manageEmployeesPanel.setLayout(manageEmployeesPanelLayout);
        manageEmployeesPanelLayout.setHorizontalGroup(
            manageEmployeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageEmployeesPanelLayout.createSequentialGroup()
                .addComponent(menageemployeesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        manageEmployeesPanelLayout.setVerticalGroup(
            manageEmployeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageEmployeesPanelLayout.createSequentialGroup()
                .addComponent(menageemployeesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 183, Short.MAX_VALUE))
        );

        adminTabbedPan.addTab("Manage employees", manageEmployeesPanel);

        manageStudenstPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageStudenstPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout studentPanelLayout = new javax.swing.GroupLayout(studentPanel);
        studentPanel.setLayout(studentPanelLayout);
        studentPanelLayout.setHorizontalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 714, Short.MAX_VALUE)
        );
        studentPanelLayout.setVerticalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jLabel1.setText("STUDENTS");

        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "First Name", "Surname", "Grade", "Class", "ID", "Date of Birth"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        studentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentsTableMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(studentsTable);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Name: ");

        studentFirstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentFirstNameTextFieldActionPerformed(evt);
            }
        });
        studentFirstNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                studentFirstNameTextFieldKeyTyped(evt);
            }
        });

        jLabel4.setText("Suname");

        studentSurnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentSurnameTextFieldActionPerformed(evt);
            }
        });
        studentSurnameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                studentSurnameTextFieldKeyTyped(evt);
            }
        });

        jLabel5.setText("Grade: ");

        studentgradeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        studentgradeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentgradeComboBoxActionPerformed(evt);
            }
        });

        jLabel20.setText("ID number: ");

        studentIDtextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                studentIDtextFieldKeyTyped(evt);
            }
        });

        jLabel6.setText("Class:");

        studentclassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "R", "E", "D", "A", "M" }));

        jLabel22.setText("Date of birth:");

        addStudentButton.setText("ADD STUDENT");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(studentgradeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel6)
                                .addGap(28, 28, 28)
                                .addComponent(studentclassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(studentFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentSurnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 211, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(studentDOBdatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(studentIDtextField, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addStudentButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(studentErrorMsgLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(studentFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentSurnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(studentgradeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(studentclassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(studentIDtextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(studentDOBdatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(studentErrorMsgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addStudentButton)
                        .addContainerGap())))
        );

        deleteStudentButton.setText("DELETE STUDENT");
        deleteStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("ADD STUDENT");
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(deleteStudentButton)
                        .addGap(26, 26, 26))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(deleteStudentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout manageStudenstPanelLayout = new javax.swing.GroupLayout(manageStudenstPanel);
        manageStudenstPanel.setLayout(manageStudenstPanelLayout);
        manageStudenstPanelLayout.setHorizontalGroup(
            manageStudenstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageStudenstPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23))
            .addGroup(manageStudenstPanelLayout.createSequentialGroup()
                .addGroup(manageStudenstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(manageStudenstPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(studentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(67, 67, 67)))
                .addContainerGap())
        );
        manageStudenstPanelLayout.setVerticalGroup(
            manageStudenstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageStudenstPanelLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(59, 59, 59)
                .addComponent(studentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        adminTabbedPan.addTab("Manage Students", manageStudenstPanel);

        helpMessagetextArea.setEditable(false);
        helpMessagetextArea.setColumns(20);
        helpMessagetextArea.setLineWrap(true);
        helpMessagetextArea.setRows(5);
        jScrollPane5.setViewportView(helpMessagetextArea);

        manageMenuFAQsButton.setText("Manage menu");
        manageMenuFAQsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageMenuFAQsButtonActionPerformed(evt);
            }
        });

        manageEmployeesFAQsButton.setText("Manage employees");
        manageEmployeesFAQsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeesFAQsButtonActionPerformed(evt);
            }
        });

        manageStudentsFAQsButton.setText("Manage students");
        manageStudentsFAQsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStudentsFAQsButtonActionPerformed(evt);
            }
        });

        viewStatsFAQsButton.setText("View stats");
        viewStatsFAQsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStatsFAQsButtonActionPerformed(evt);
            }
        });

        viewOrdersFAQsButton.setText("View orders");
        viewOrdersFAQsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrdersFAQsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewStatsFAQsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(manageEmployeesFAQsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(manageMenuFAQsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(manageStudentsFAQsButton, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(viewOrdersFAQsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(319, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(viewOrdersFAQsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewStatsFAQsButton)
                        .addGap(9, 9, 9)
                        .addComponent(manageMenuFAQsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(manageEmployeesFAQsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(manageStudentsFAQsButton))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FAQsPanelLayout = new javax.swing.GroupLayout(FAQsPanel);
        FAQsPanel.setLayout(FAQsPanelLayout);
        FAQsPanelLayout.setHorizontalGroup(
            FAQsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FAQsPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        FAQsPanelLayout.setVerticalGroup(
            FAQsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FAQsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(399, Short.MAX_VALUE))
        );

        adminTabbedPan.addTab("FAQS", FAQsPanel);

        jLabel12.setText("STATS ");

        statsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Item Type", "Item Price ", "Times Sold "
            }
        ));
        jScrollPane3.setViewportView(statsTable);

        jLabel13.setText("FILTER ");
        jLabel13.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N

        soldButtonGroup.add(mostSoldradioButton);
        mostSoldradioButton.setSelected(true);
        mostSoldradioButton.setText("Most sold");
        mostSoldradioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostSoldradioButtonActionPerformed(evt);
            }
        });

        soldButtonGroup.add(leastSoldRadioButton);
        leastSoldRadioButton.setText("Least Sold");
        leastSoldRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leastSoldRadioButtonActionPerformed(evt);
            }
        });

        checkBoxPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout checkBoxPanelLayout = new javax.swing.GroupLayout(checkBoxPanel);
        checkBoxPanel.setLayout(checkBoxPanelLayout);
        checkBoxPanelLayout.setHorizontalGroup(
            checkBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );
        checkBoxPanelLayout.setVerticalGroup(
            checkBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 129, Short.MAX_VALUE)
        );

        viewTypeStatsButton.setText("VIEW ");
        viewTypeStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTypeStatsButtonActionPerformed(evt);
            }
        });

        viewAllButton.setText("VIEW ALL");
        viewAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllButtonActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jLabel14.setText("ORDER BY");

        javax.swing.GroupLayout viewStatsPanelLayout = new javax.swing.GroupLayout(viewStatsPanel);
        viewStatsPanel.setLayout(viewStatsPanelLayout);
        viewStatsPanelLayout.setHorizontalGroup(
            viewStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewStatsPanelLayout.createSequentialGroup()
                .addGroup(viewStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewStatsPanelLayout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewStatsPanelLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewStatsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(226, 226, 226))
            .addGroup(viewStatsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewStatsPanelLayout.createSequentialGroup()
                        .addGroup(viewStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(leastSoldRadioButton)
                            .addComponent(mostSoldradioButton)
                            .addComponent(viewAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(checkBoxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(viewStatsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(viewTypeStatsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
            .addGroup(viewStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(viewStatsPanelLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jLabel14)
                    .addContainerGap(540, Short.MAX_VALUE)))
        );
        viewStatsPanelLayout.setVerticalGroup(
            viewStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewStatsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(viewStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(viewStatsPanelLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(mostSoldradioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(leastSoldRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewStatsPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addComponent(viewTypeStatsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
            .addGroup(viewStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(viewStatsPanelLayout.createSequentialGroup()
                    .addGap(306, 306, 306)
                    .addComponent(jLabel14)
                    .addContainerGap(421, Short.MAX_VALUE)))
        );

        adminTabbedPan.addTab("View Stats ", viewStatsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(adminTabbedPan, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(adminTabbedPan, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addItemtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemtButtonActionPerformed

        // TODO add your handling code here:
// gets the name, type and price of new mneu item 
        String name = itemNameTextField.getText();
        String type = (String) (itemTypesCombobox.getSelectedItem());
        double price = 0;
        price = Double.parseDouble(itempricetextField.getText());

        if (name.isBlank() || !MenuItem.isValidMenuitemName(name)) {
            itemNameTextField.setBackground(Color.red);
            menuErrorMsgLabel.setText("Menu Item Name not valid");
            menuErrorMsgLabel.setForeground(Color.red);

        } else if (price == 0) {
            itempricetextField.setBackground(Color.red);
            menuErrorMsgLabel.setText("Price not valid");
            menuErrorMsgLabel.setForeground(Color.red);

        } else {

            try {
                //adds the item to the array
                systemManager.mm.add(name, type, price);
            } catch (SQLException ex) {
                Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            itemNameTextField.setText("");
            itempricetextField.setText("");
            itemTypeComboBox.setSelectedIndex(1);
            try {
                this.populateMenuTable();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Menu Item successfully added");
        }
    }//GEN-LAST:event_addItemtButtonActionPerformed

    private void studentFirstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentFirstNameTextFieldActionPerformed
        // TODO add your handling code here:]
        studentErrorMsgLabel.setText("");
        studentFirstNameTextField.setBackground(Color.white);
    }//GEN-LAST:event_studentFirstNameTextFieldActionPerformed

    private void studentgradeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentgradeComboBoxActionPerformed
        // TODO add your handling code here:
        studentErrorMsgLabel.setText("");
    }//GEN-LAST:event_studentgradeComboBoxActionPerformed

    private void studentIDtextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentIDtextFieldKeyTyped
        // TODO add your handling code here:
        studentIDtextField.setBackground(Color.white);
        studentErrorMsgLabel.setText("");

    }//GEN-LAST:event_studentIDtextFieldKeyTyped

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentButtonActionPerformed
        // TODO add your handling code here:

        String firstName = studentFirstNameTextField.getText();
        String surname = studentSurnameTextField.getText();
        String idNumber = studentIDtextField.getText();
        String sClass = (String) (studentclassComboBox.getSelectedItem());
        int grade = 0;
        String gradeStr = (String) studentgradeComboBox.getSelectedItem();
        LocalDate dob = studentDOBdatePicker.getDate();

        //check if id
        if (firstName.isBlank() || !Student.isValidFirstName(firstName)) {
            studentFirstNameTextField.setBackground(Color.red);
            studentErrorMsgLabel.setText("First name not valid");
            studentErrorMsgLabel.setForeground(Color.red);

        } else if (surname.isBlank() || !Student.isValidLastName(surname)) {
            studentSurnameTextField.setBackground(Color.red);
            studentErrorMsgLabel.setText("Surname not valid");
            studentErrorMsgLabel.setForeground(Color.red);
        } else if (idNumber.isBlank() || !Student.isValidID(idNumber)) {
            studentIDtextField.setBackground(Color.red);
            studentErrorMsgLabel.setText("ID num not valid");
            studentErrorMsgLabel.setForeground(Color.red);
        } else if (sClass.compareToIgnoreCase("-") == 0) {
            studentErrorMsgLabel.setText("Please select a class");
            studentErrorMsgLabel.setForeground(Color.red);
        } else if (gradeStr.equals("-")) {
            studentErrorMsgLabel.setText("Please select a grade");
            studentErrorMsgLabel.setForeground(Color.red);
        } else if (!Student.isValidDOB(idNumber, dob)) {
            studentErrorMsgLabel.setText("Birthdate does not match id");
            studentDOBdatePicker.setBackground(Color.red);
            studentErrorMsgLabel.setForeground(Color.red);

        } else {

            try {
                grade = Integer.parseInt(gradeStr);
                JOptionPane.showMessageDialog(null, "Student successfully added");
                systemManager.sm.addStudent(idNumber, firstName, surname, sClass, grade, dob);

                studentFirstNameTextField.setText("");
                studentSurnameTextField.setText("");
                studentIDtextField.setText("");
                studentgradeComboBox.setSelectedIndex(0);
                studentDOBdatePicker.setDateToToday();
                studentclassComboBox.setSelectedIndex(0);

                this.populateStudentTable();
            } catch (SQLException ex) {
                Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addStudentButtonActionPerformed

    private void studentSurnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentSurnameTextFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_studentSurnameTextFieldActionPerformed

    private void studentFirstNameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentFirstNameTextFieldKeyTyped
        // TODO add your handling code here:
        studentFirstNameTextField.setBackground(Color.white);
        studentErrorMsgLabel.setText("");
    }//GEN-LAST:event_studentFirstNameTextFieldKeyTyped

    private void studentSurnameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentSurnameTextFieldKeyTyped
        // TODO add your handling code here:
        studentSurnameTextField.setBackground(Color.white);
        studentErrorMsgLabel.setText("");
    }//GEN-LAST:event_studentSurnameTextFieldKeyTyped

    private void DOBdatePickerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DOBdatePickerPropertyChange
        // TODO add your handling code here:  
        studentDOBdatePicker.setBackground(Color.white);
        studentErrorMsgLabel.setText("");

    }//GEN-LAST:event_DOBdatePickerPropertyChange

    private void adminTabbedPanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminTabbedPanMouseClicked
        // this array is teh coloumn names for the menu item table


    }//GEN-LAST:event_adminTabbedPanMouseClicked

    private void deleteItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemButtonActionPerformed
        // TODO add your handling code here:
        // the menutitem arrray reads in the menu items from a text file and populates an array 

        // gets the menu item name and type at seleceted row in table to be removed 
        int row = menuTable.getSelectedRow();

        try {
            // deleted the menu item from the array
            systemManager.mm.remove(row);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.populateMenuTable();
        } catch (SQLException ex) {
            Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Menu Item successfully deleted");

    }//GEN-LAST:event_deleteItemButtonActionPerformed

    private void manageStudenstPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageStudenstPanelMouseClicked
        // TODO add your handling code here:
        this.populateStudentTable();


    }//GEN-LAST:event_manageStudenstPanelMouseClicked

    private void studentsTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsTableMouseEntered
        // TODO add your handling code here:


    }//GEN-LAST:event_studentsTableMouseEntered

    private void addTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTypeButtonActionPerformed
        // TODO add your handling code here:
        String typeName = typenameTextField.getText();
        try {
            systemManager.tm.addType(typeName);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.populateTypeComboBox();
        typenameTextField.setText("");
        JOptionPane.showMessageDialog(null, "Menu item type successfully added");
        this.populateCheckBoxesForStats();
    }//GEN-LAST:event_addTypeButtonActionPerformed

    private void typenameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typenameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typenameTextFieldActionPerformed

    private void deleteTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTypeButtonActionPerformed
        try {
            // TODO add your handling code here:
            systemManager.tm.deleteType((String) itemTypesCombobox.getSelectedItem());
        } catch (SQLException ex) {
            Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.populateTypeComboBox();
        JOptionPane.showMessageDialog(null, "Menu item type successfully removed");
this.populateCheckBoxesForStats();

    }//GEN-LAST:event_deleteTypeButtonActionPerformed

    private void itemTypesComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTypesComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemTypesComboboxActionPerformed

    private void manageEmployeesPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageEmployeesPanelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_manageEmployeesPanelMouseEntered

    private void manageEmployeesPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageEmployeesPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_manageEmployeesPanelMouseClicked

    private void waiterradioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waiterradioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_waiterradioButtonActionPerformed

    private void userTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userTableMouseEntered

    private void addEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeButtonActionPerformed
        // TODO add your handling code here:
        String firstname = employeeFirstnameTextField.getText();
        String surname = employeelastNameTextField.getText();
        String email = employeeemailtextField.getText();
        String password = employeepasswordTextField.getText();
        String type = usertypeButtonGroup.getSelection().getActionCommand();

        try {
            systemManager.um.addUser(firstname, surname, type, email, password);

        } catch (SQLException ex) {
            Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.populateUserTable();//UI Is not being updated 
        employeeFirstnameTextField.setText("");
        employeelastNameTextField.setText("");
        employeeemailtextField.setText("");
        employeepasswordTextField.setText("");
        waiterradioButton.setSelected(true);
        JOptionPane.showMessageDialog(null, "Employee successfully added");

    }//GEN-LAST:event_addEmployeeButtonActionPerformed

    private void deletedEmpployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletedEmpployeeButtonActionPerformed
        // TODO add your handling code here:
        int row = userTable.getSelectedRow();
        try {
            systemManager.um.deleteUser(row);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.populateUserTable();
        JOptionPane.showMessageDialog(null, "Employye successfully deleted");
    }//GEN-LAST:event_deletedEmpployeeButtonActionPerformed

    private void deleteStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentButtonActionPerformed
        // TODO add your handling code here:
        int row = studentsTable.getSelectedRow();
        try {
            systemManager.sm.deleteStudent(row);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Student successfully deleted");
    }//GEN-LAST:event_deleteStudentButtonActionPerformed

    private void itemNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNameTextFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_itemNameTextFieldActionPerformed

    private void itempricetextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itempricetextFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_itempricetextFieldActionPerformed

    private void itemNameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemNameTextFieldKeyTyped
        // TODO add your handling code here:
        menuErrorMsgLabel.setText("");
        itemNameTextField.setBackground(Color.white);
    }//GEN-LAST:event_itemNameTextFieldKeyTyped

    private void itempricetextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itempricetextFieldKeyTyped
        // TODO add your handling code here:
        menuErrorMsgLabel.setText("");
        itempricetextField.setBackground(Color.white);
    }//GEN-LAST:event_itempricetextFieldKeyTyped

    private void leastSoldRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leastSoldRadioButtonActionPerformed
        // TODO add your handling code here:
        this.orderStatsTable(true);

    }//GEN-LAST:event_leastSoldRadioButtonActionPerformed

    private void viewOrdersFAQsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrdersFAQsButtonActionPerformed
        // TODO add your handling code here:
        helpMessagetextArea.setText(systemManager.hsm.getMessage(1));
    }//GEN-LAST:event_viewOrdersFAQsButtonActionPerformed

    private void viewStatsFAQsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStatsFAQsButtonActionPerformed
        // TODO add your handling code here:
        helpMessagetextArea.setText(systemManager.hsm.getMessage(2));
    }//GEN-LAST:event_viewStatsFAQsButtonActionPerformed

    private void manageMenuFAQsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageMenuFAQsButtonActionPerformed
        // TODO add your handling code here:
        helpMessagetextArea.setText(systemManager.hsm.getMessage(3));
    }//GEN-LAST:event_manageMenuFAQsButtonActionPerformed

    private void manageEmployeesFAQsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeesFAQsButtonActionPerformed
        helpMessagetextArea.setText(systemManager.hsm.getMessage(4));        // TODO add your handling code here:
    }//GEN-LAST:event_manageEmployeesFAQsButtonActionPerformed

    private void manageStudentsFAQsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStudentsFAQsButtonActionPerformed
        helpMessagetextArea.setText(systemManager.hsm.getMessage(5));        // TODO add your handling code here:
    }//GEN-LAST:event_manageStudentsFAQsButtonActionPerformed

    private void mostSoldradioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostSoldradioButtonActionPerformed
        // TODO add your handling code here:
        this.orderStatsTable(false);
    }//GEN-LAST:event_mostSoldradioButtonActionPerformed

    private void viewTypeStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTypeStatsButtonActionPerformed
        // TODO add your handling code here:
         ArrayList<String> sArr = new ArrayList<>();
        for(int i = 0; i < checkBoxArr.size(); i++){ 
            if(checkBoxArr.get(i).isSelected()){ 
                sArr.add(checkBoxArr.get(i).getText()); 
            }
        }
        systemManager.stm.filter(sArr);
        try {
            this.setStatsTableToDefault();
            this.populateStatsTable();
        } catch (SQLException ex) {
            Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sArr);
    }//GEN-LAST:event_viewTypeStatsButtonActionPerformed

    private void viewAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllButtonActionPerformed
        // TODO add your handling code here:
        systemManager.stm.orderArray(true);
         try {
            this.setStatsTableToDefault();
            this.populateStatsTable();
        } catch (SQLException ex) {
            Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_viewAllButtonActionPerformed

    private void setOrderTabelSelectionModel() {
        ordersTable.setRowSelectionAllowed(true);
        ListSelectionModel cellSelectionModel = ordersTable.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int id = ((Integer) ordersTable.getValueAt(ordersTable.getSelectedRow(), 0)).intValue();
                try {
                    systemManager.initialiseOrderManager(id);
                    orderedItemtable.setModel(systemManager.orm);
                } catch (SQLException ex) {
                    Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdminUI().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FAQsPanel;
    private javax.swing.JButton addEmployeeButton;
    private javax.swing.JButton addItemtButton;
    private javax.swing.JButton addStudentButton;
    private javax.swing.JButton addTypeButton;
    private javax.swing.JRadioButton adminRadioButton;
    private javax.swing.JTabbedPane adminTabbedPan;
    private javax.swing.JPanel checkBoxPanel;
    private javax.swing.ButtonGroup confirmationSlipButtonGroup;
    private javax.swing.JButton deleteItemButton;
    private javax.swing.JButton deleteStudentButton;
    private javax.swing.JButton deleteTypeButton;
    private javax.swing.JButton deletedEmpployeeButton;
    private javax.swing.JTextField employeeFirstnameTextField;
    private javax.swing.JTextField employeeemailtextField;
    private javax.swing.JTextField employeelastNameTextField;
    private javax.swing.JTextField employeepasswordTextField;
    private javax.swing.JTextArea helpMessagetextArea;
    private javax.swing.JTextField itemNameTextField;
    private javax.swing.JComboBox<String> itemTypeComboBox;
    private javax.swing.JComboBox<String> itemTypesCombobox;
    private javax.swing.JTextField itempricetextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton leastSoldRadioButton;
    private javax.swing.JButton manageEmployeesFAQsButton;
    private javax.swing.JPanel manageEmployeesPanel;
    private javax.swing.JButton manageMenuFAQsButton;
    private javax.swing.JPanel manageMenuPanel;
    private javax.swing.JPanel manageStudenstPanel;
    private javax.swing.JButton manageStudentsFAQsButton;
    private javax.swing.ButtonGroup mealButtongroup;
    private javax.swing.JPanel menageemployeesPanel;
    private javax.swing.JLabel menuErrorMsgLabel;
    private javax.swing.JTable menuTable;
    private javax.swing.JRadioButton mostSoldradioButton;
    private javax.swing.ButtonGroup orderBybuttonGroup;
    private javax.swing.JTable orderedItemtable;
    private javax.swing.JTable ordersTable;
    private javax.swing.ButtonGroup soldButtonGroup;
    private javax.swing.JTable statsTable;
    private com.github.lgooddatepicker.components.DatePicker studentDOBdatePicker;
    private javax.swing.JLabel studentErrorMsgLabel;
    private javax.swing.JTextField studentFirstNameTextField;
    private javax.swing.JTextField studentIDtextField;
    private javax.swing.JPanel studentPanel;
    private javax.swing.JTextField studentSurnameTextField;
    private javax.swing.JComboBox<String> studentclassComboBox;
    private javax.swing.JComboBox<String> studentgradeComboBox;
    private javax.swing.JTable studentsTable;
    private javax.swing.JTextField typenameTextField;
    private javax.swing.JTable userTable;
    private javax.swing.ButtonGroup usertypeButtonGroup;
    private javax.swing.JButton viewAllButton;
    private javax.swing.JButton viewOrdersFAQsButton;
    private javax.swing.JPanel viewOrdersPanel;
    private javax.swing.JButton viewPasswordButton;
    private javax.swing.JButton viewStatsFAQsButton;
    private javax.swing.JPanel viewStatsPanel;
    private javax.swing.JButton viewTypeStatsButton;
    private javax.swing.JRadioButton waiterradioButton;
    // End of variables declaration//GEN-END:variables
}
