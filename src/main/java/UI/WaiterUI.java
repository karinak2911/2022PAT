package UI;

import javax.swing.DefaultComboBoxModel;
import managers.SystemManager;
import objects.User;
import UI.LoginUI; 
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Karinak
 */
public class WaiterUI extends javax.swing.JFrame {

    SystemManager systemManager;
    int waiterID = 2; //this needs to be set to logins 
 
    /**
     * Creates new form HomeScreenAdminUI
     */
    public WaiterUI() throws SQLException {
        initComponents();
          systemManager = new SystemManager();
          this.populateTypeCombobox();
          this.populateOrdersTable();
          this.populateMenuTableForOrder();
          this.setOrderTabelSelectionModel();
          this.populateStudentTable();
        this.setActionCommands();
       
         
          
    }

    public void setActionCommands(){ 
        cardradiobutton.setActionCommand("card");
        cashRadioButton.setActionCommand("cash");
        zapperRadioButton.setActionCommand("zapper");
        
        collectedRadioButton.setActionCommand("1");
        notCollectedRadioButton.setActionCommand("0");
        
    } 
   public void populateTypeCombobox(){ 
         DefaultComboBoxModel<String> comboModelTypes = new DefaultComboBoxModel<String>();
        String[] types = systemManager.tm.typesForCombobox();
        for (int i = 0; i < systemManager.tm.getSize(); i++) {
            comboModelTypes.addElement(types[i]);
        }
        menuTypeComboBox.setModel(comboModelTypes);
    }
   
 
   private void populateStudentTable() throws SQLException{ 
       int grade = ((Integer)(studentGradeSpinner.getValue())).intValue(); 
       systemManager.initialiseStudentManagerForGrade(grade);
       studentTable.setModel(systemManager.sm);
   }
   
   
   
   private void populateOrdersTable() throws SQLException{ 
    systemManager.initialiseSpecificWaiterOrders(waiterID);
    ordersTable.setModel(systemManager.om);
   }
   
   public void populateMenuTableForOrder() throws SQLException{ 
       String type = (String)menuTypeComboBox.getSelectedItem(); 
        systemManager.initialiseMenuManagerToPlaceOrder(type); 
       menuItemsTable.setModel(systemManager.mm);
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        paymentMethodButtonGroup = new javax.swing.ButtonGroup();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        collectedButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        FAQsPane = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        currentOrderTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuItemsTable = new javax.swing.JTable();
        menuTypeComboBox = new javax.swing.JComboBox<>();
        quantitySpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderedItemsTable = new javax.swing.JTable();
        addToOrderbutton = new javax.swing.JButton();
        removeFromOrderButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cardradiobutton = new javax.swing.JRadioButton();
        cashRadioButton = new javax.swing.JRadioButton();
        zapperRadioButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addOrderRadioButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        totalPriceTextAreas = new javax.swing.JTextArea();
        studentGradeSpinner = new javax.swing.JSpinner();
        jScrollPane5 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        notCollectedRadioButton = new javax.swing.JRadioButton();
        collectedRadioButton = new javax.swing.JRadioButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FAQsPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student Name", "Order", "Total", "Collected "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(ordersTable);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Select Waiter: ");

        jLabel7.setText("ORDERS: ");

        currentOrderTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(currentOrderTable);

        jLabel9.setText("Orderred Items");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(jLabel9)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        FAQsPane.addTab("View orders", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel8)
                .addContainerGap(769, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel8)
                .addContainerGap(771, Short.MAX_VALUE))
        );

        FAQsPane.addTab("FAQs", jPanel5);

        menuItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Item", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(menuItemsTable);

        menuTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        menuTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTypeComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("MENU: ");

        jLabel2.setText("CURRENT ORDER");

        orderedItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Item Type", "Quantity ", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderedItemsTable);

        addToOrderbutton.setText("ADD TO ORDER");
        addToOrderbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToOrderbuttonActionPerformed(evt);
            }
        });

        removeFromOrderButton.setText("REMOVE FROM ORDER");
        removeFromOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFromOrderButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Payment Method: ");

        paymentMethodButtonGroup.add(cardradiobutton);
        cardradiobutton.setSelected(true);
        cardradiobutton.setText("Card");
        cardradiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardradiobuttonActionPerformed(evt);
            }
        });

        paymentMethodButtonGroup.add(cashRadioButton);
        cashRadioButton.setText("Cash");

        paymentMethodButtonGroup.add(zapperRadioButton);
        zapperRadioButton.setText("Zapper");

        jLabel4.setText("Student grade: ");

        jLabel5.setText("Student Name: ");

        addOrderRadioButton.setText("ADD ORDER");
        addOrderRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderRadioButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Total Price: ");

        totalPriceTextAreas.setColumns(20);
        totalPriceTextAreas.setRows(5);
        jScrollPane3.setViewportView(totalPriceTextAreas);

        studentGradeSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        studentGradeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                studentGradeSpinnerStateChanged(evt);
            }
        });

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(studentTable);

        jLabel11.setText("Is order collected: ");

        collectedButtonGroup.add(notCollectedRadioButton);
        notCollectedRadioButton.setSelected(true);
        notCollectedRadioButton.setText("Not collected");

        collectedButtonGroup.add(collectedRadioButton);
        collectedRadioButton.setText("Collected");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1)
                        .addGap(55, 55, 55)
                        .addComponent(menuTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(159, 159, 159))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(addToOrderbutton)
                                .addGap(179, 179, 179))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cardradiobutton)
                                .addGap(36, 36, 36)
                                .addComponent(cashRadioButton)
                                .addGap(34, 34, 34)
                                .addComponent(zapperRadioButton)
                                .addGap(205, 205, 205)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(49, 49, 49)
                        .addComponent(studentGradeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(removeFromOrderButton)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(addOrderRadioButton)
                        .addGap(82, 82, 82))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(notCollectedRadioButton)
                .addGap(18, 18, 18)
                .addComponent(collectedRadioButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(menuTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(17, 17, 17)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addToOrderbutton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cardradiobutton)
                                    .addComponent(cashRadioButton)
                                    .addComponent(zapperRadioButton)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(removeFromOrderButton)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(notCollectedRadioButton)
                            .addComponent(collectedRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel5)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(studentGradeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addComponent(addOrderRadioButton)
                .addGap(233, 233, 233))
        );

        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        studentGradeSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        FAQsPane.addTab("Place order", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(FAQsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FAQsPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cardradiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardradiobuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardradiobuttonActionPerformed

    private void menuTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTypeComboBoxActionPerformed
        try {
            // TODO add your handling code here:
            this.populateMenuTableForOrder();
        } catch (SQLException ex) {
            Logger.getLogger(WaiterUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuTypeComboBoxActionPerformed

    private void addToOrderbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToOrderbuttonActionPerformed
        // TODO add your handling code here:
        int itemId = (int) menuItemsTable.getValueAt(menuItemsTable.getSelectedRow(), 0); 
          String itemname = (String) menuItemsTable.getValueAt(menuItemsTable.getSelectedRow(), 1); 
            String itemtype = (String) menuItemsTable.getValueAt(menuItemsTable.getSelectedRow(), 2); 
              double price = (double) menuItemsTable.getValueAt(menuItemsTable.getSelectedRow(), 3); 
              int quntity = (int)quantitySpinner.getValue(); 
              
              systemManager.oim.addOrderedItem(itemId, itemname, itemtype, price, quntity);
            this.populateOrderedItemTable();
            totalPriceTextAreas.setText( Double.toString (systemManager.oim.getTotalPriceOfOrder()));
        
    }//GEN-LAST:event_addToOrderbuttonActionPerformed

    private void removeFromOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromOrderButtonActionPerformed
        // TODO add your handling code here:
        int menuID = (int) orderedItemsTable.getValueAt(orderedItemsTable.getSelectedRow(), 0); 
        systemManager.oim.deleteOrderedItem(menuID);
        this.populateOrderedItemTable();
    }//GEN-LAST:event_removeFromOrderButtonActionPerformed

    private void studentGradeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_studentGradeSpinnerStateChanged
        try {
            // TODO add your handling code here:
            this.populateStudentTable();
        } catch (SQLException ex) {
            Logger.getLogger(WaiterUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_studentGradeSpinnerStateChanged

    private void addOrderRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderRadioButtonActionPerformed
        // TODO add your handling code here:
        int studentID = ((Integer)studentTable.getValueAt(studentTable.getSelectedRow(), 0)).intValue(); 
        String paymentMethod = (String) paymentMethodButtonGroup.getSelection().getActionCommand(); 
        int collectedInt = Integer.parseInt(collectedButtonGroup.getSelection().getActionCommand()); 
//       boolean collected = false; 
//        if(collectedInt == 1)
//            collected = true; 
//        
        try {
            systemManager.om.addOrder(studentID, paymentMethod, waiterID, collectedInt);
            this.populateOrdersTable();
            this.populateOrdersTable();
        } catch (SQLException ex) {
            Logger.getLogger(WaiterUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
        
        
        
        
        
        
        
    }//GEN-LAST:event_addOrderRadioButtonActionPerformed

    private void populateOrderedItemTable(){ 
        orderedItemsTable.setModel(systemManager.oim);
    }
    
    
    private void setOrderTabelSelectionModel() {
        ordersTable.setRowSelectionAllowed(true);
        ListSelectionModel cellSelectionModel = ordersTable.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int id = ((Integer)ordersTable.getValueAt(ordersTable.getSelectedRow(), 0)).intValue(); 
                try {
                    systemManager.initialiseOrderManager(id);
                    currentOrderTable.setModel(systemManager.orm);
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
            java.util.logging.Logger.getLogger(WaiterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WaiterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WaiterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WaiterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new WaiterUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(WaiterUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane FAQsPane;
    private javax.swing.JButton addOrderRadioButton;
    private javax.swing.JButton addToOrderbutton;
    private javax.swing.JRadioButton cardradiobutton;
    private javax.swing.JRadioButton cashRadioButton;
    private javax.swing.ButtonGroup collectedButtonGroup;
    private javax.swing.JRadioButton collectedRadioButton;
    private javax.swing.JTable currentOrderTable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable menuItemsTable;
    private javax.swing.JComboBox<String> menuTypeComboBox;
    private javax.swing.JRadioButton notCollectedRadioButton;
    private javax.swing.JTable orderedItemsTable;
    private javax.swing.JTable ordersTable;
    private javax.swing.ButtonGroup paymentMethodButtonGroup;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JButton removeFromOrderButton;
    private javax.swing.JSpinner studentGradeSpinner;
    private javax.swing.JTable studentTable;
    private javax.swing.JTextArea totalPriceTextAreas;
    private javax.swing.JRadioButton zapperRadioButton;
    // End of variables declaration//GEN-END:variables
}
