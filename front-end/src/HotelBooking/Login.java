/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelBooking;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.swing.*;
/**
 *
 * @author Admin
 */

import ClientSocket.Client;
import HotelBooking.Database.DatabaseConn;
public class Login extends javax.swing.JFrame {
    Socket connection = null;
    boolean checkConnection = false;
    Client clientSocket = new Client();
    public static Login l;

    public static String ip;
    public static int port;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        OptionPanel = new javax.swing.JPanel();
        LoginAsManager = new javax.swing.JLabel();
        LoginAsEmployee = new javax.swing.JLabel();
        ConnectToServer = new javax.swing.JLabel();
        PagesPanel = new javax.swing.JPanel();
        ConnectionPage = new javax.swing.JPanel();
        ServerPort = new javax.swing.JPanel();
        ServerIp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ConnectServer = new javax.swing.JLabel();
        PortField = new javax.swing.JTextField();
        Status = new javax.swing.JLabel();
        LoginAdminPage = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        AdminUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        AdminPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LoginAdminButton = new javax.swing.JLabel();
        LoginEmployeePage = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        EmployeeLogin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        EmployeePassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LoginEmployeeButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));

        MainPanel.setBackground(new java.awt.Color(255, 153, 0));
        MainPanel.setLayout(new java.awt.BorderLayout());

        OptionPanel.setBackground(new java.awt.Color(255, 153, 0)); 

        LoginAsManager.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        LoginAsManager.setForeground(new java.awt.Color(255, 255, 255));
        LoginAsManager.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\HMS\\Manager_48.png")); // NOI18N
        LoginAsManager.setText("Manager");
        LoginAsManager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginAsManagerMouseClicked(evt);
            }
        });

        LoginAsEmployee.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        LoginAsEmployee.setForeground(new java.awt.Color(255, 255, 255));
        LoginAsEmployee.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\HMS\\Employee_48.png")); // NOI18N
        LoginAsEmployee.setText("Employee");
        LoginAsEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginAsEmployeeMouseClicked(evt);
            }
        });

        ConnectToServer.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        ConnectToServer.setForeground(new java.awt.Color(255, 255, 255));
        ConnectToServer.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\HMS\\internet_antenna_48.png")); // NOI18N
        ConnectToServer.setText("Connect");
        ConnectToServer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConnectToServerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout OptionPanelLayout = new javax.swing.GroupLayout(OptionPanel);
        OptionPanel.setLayout(OptionPanelLayout);
        OptionPanelLayout.setHorizontalGroup(
            OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OptionPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConnectToServer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginAsManager, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginAsEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        OptionPanelLayout.setVerticalGroup(
            OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(LoginAsEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LoginAsManager)
                .addGap(18, 18, 18)
                .addComponent(ConnectToServer)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        MainPanel.add(OptionPanel, java.awt.BorderLayout.WEST);

        PagesPanel.setBackground(new java.awt.Color(255, 153, 0));
        PagesPanel.setLayout(new java.awt.CardLayout());

        ConnectionPage.setBackground(new java.awt.Color(255, 153, 0));

        ServerPort.setOpaque(false);

        ServerIp.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        ServerIp.setText("localhost");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\HMS\\Network_48.png")); // NOI18N
        jLabel8.setText("Server Ip Address");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\HMS\\Connect_48.png")); // NOI18N
        jLabel9.setText("Connect To Server");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\HMS\\port_48.png")); // NOI18N
        jLabel10.setText("Server Port");

        ConnectServer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ConnectServer.setForeground(new java.awt.Color(255, 255, 255));
        ConnectServer.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\HMS\\startConnect_48.png")); // NOI18N
        ConnectServer.setText("CONNECT");
        ConnectServer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConnectServerMouseClicked(evt);
            }
        });

        PortField.setText("8080");
        PortField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PortFieldMouseClicked(evt);
            }
        });

        Status.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Status.setForeground(new java.awt.Color(255, 255, 255));
        Status.setText("Status: Not Connected");

        javax.swing.GroupLayout ServerPortLayout = new javax.swing.GroupLayout(ServerPort);
        ServerPort.setLayout(ServerPortLayout);
        ServerPortLayout.setHorizontalGroup(
            ServerPortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ServerPortLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ServerPortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PortField)
                    .addComponent(ServerIp, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(ServerPortLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ServerPortLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ServerPortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConnectServer, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
            .addGroup(ServerPortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ServerPortLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addGap(151, 151, 151)))
        );
        ServerPortLayout.setVerticalGroup(
            ServerPortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServerPortLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ServerPortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ServerIp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(PortField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConnectServer, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Status, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(ServerPortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ServerPortLayout.createSequentialGroup()
                    .addContainerGap(123, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addGap(106, 106, 106)))
        );

        javax.swing.GroupLayout ConnectionPageLayout = new javax.swing.GroupLayout(ConnectionPage);
        ConnectionPage.setLayout(ConnectionPageLayout);
        ConnectionPageLayout.setHorizontalGroup(
            ConnectionPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectionPageLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(ServerPort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ConnectionPageLayout.setVerticalGroup(
            ConnectionPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectionPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PagesPanel.add(ConnectionPage, "card2");

        LoginAdminPage.setBackground(new java.awt.Color(255, 153, 0));

        jPanel1.setOpaque(false);

        AdminUsername.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\HMS\\Username_48.png")); // NOI18N
        jLabel3.setText("Admin Username");

        AdminPassword.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin Login");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\HMS\\password_48.png")); // NOI18N
        jLabel4.setText("Admin Password");

        LoginAdminButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LoginAdminButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginAdminButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\HMS\\Login_48.png")); // NOI18N
        LoginAdminButton.setText("Login");
        LoginAdminButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginAdminButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AdminUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AdminPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LoginAdminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addGap(151, 151, 151)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(AdminPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LoginAdminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(123, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(106, 106, 106)))
        );

        javax.swing.GroupLayout LoginAdminPageLayout = new javax.swing.GroupLayout(LoginAdminPage);
        LoginAdminPage.setLayout(LoginAdminPageLayout);
        LoginAdminPageLayout.setHorizontalGroup(
            LoginAdminPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginAdminPageLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        LoginAdminPageLayout.setVerticalGroup(
            LoginAdminPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginAdminPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PagesPanel.add(LoginAdminPage, "card2");

        LoginEmployeePage.setBackground(new java.awt.Color(255, 153, 0));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        EmployeeLogin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        EmployeeLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeLoginActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 153, 0));
        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\HMS\\Username_48.png")); // NOI18N
        jLabel5.setText("Employee Username");

        EmployeePassword.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Employee Login");

        jLabel7.setBackground(new java.awt.Color(255, 153, 0));
        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\HMS\\password_48.png")); // NOI18N
        jLabel7.setText("Employee Password");

        LoginEmployeeButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LoginEmployeeButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginEmployeeButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\HMS\\Login_48.png")); // NOI18N
        LoginEmployeeButton.setText("Login");
        LoginEmployeeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginEmployeeButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 133, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EmployeePassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(EmployeeLogin, javax.swing.GroupLayout.Alignment.TRAILING)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LoginEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addGap(151, 151, 151)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmployeeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(EmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LoginEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(123, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(106, 106, 106)))
        );

        javax.swing.GroupLayout LoginEmployeePageLayout = new javax.swing.GroupLayout(LoginEmployeePage);
        LoginEmployeePage.setLayout(LoginEmployeePageLayout);
        LoginEmployeePageLayout.setHorizontalGroup(
            LoginEmployeePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginEmployeePageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        LoginEmployeePageLayout.setVerticalGroup(
            LoginEmployeePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginEmployeePageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PagesPanel.add(LoginEmployeePage, "card2");

        MainPanel.add(PagesPanel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents




    protected void EmployeeLoginActionPerformed(ActionEvent evt) {
    }

    protected void PortFieldMouseClicked(MouseEvent evt) {
    }

    public void StoreIpPort(String ip,int port){
        try {
            PrintWriter write = new PrintWriter(new FileWriter("ip.txt"));
            write.println(ip);
            write.println(port);
            write.flush();
            write.close();
        } catch (Exception e) {
            //TODO: handle exception
        }        
    }

    private void ConnectServerMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            String ip  = this.ServerIp.getText();
            String port = this.PortField.getText();
            if(ip.length()>0&&port.length()>0){
                try{
                    int portNumber = Integer.parseInt(port);
                    this.connection = new Socket(ip,portNumber);
                    // send command
                    List<Object> obj = new ArrayList<>();
                    obj.add("checkconnection");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.connection.getOutputStream());
                    objectOutputStream.writeObject(obj);
                    // wait for the response
                    ObjectInputStream objectInputStream = new ObjectInputStream(this.connection.getInputStream());
                    List<Object> res = (List<Object>) objectInputStream.readObject();
                    String log = (String) res.get(0);
                    // store it to text file
                    this.StoreIpPort(ip, portNumber);
                    JOptionPane.showMessageDialog(null, log, "Message", 1);
                    this.Status.setText("Status: Connected");
                    this.connection.close();
                    this.checkConnection = true;
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error  Connecting to server", "Error", 1);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Both Fields have to be filled", "Message", 1);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Port must be a number", "Message", 1);

        }

    }

    private void LoginEmployeeButtonMouseClicked(java.awt.event.MouseEvent evt) {
        
        if(this.checkConnection){
            String employeeName = EmployeeLogin.getText();
            String employeePassword = String.valueOf(EmployeePassword.getPassword());
            boolean result = clientSocket.loginEmployee(employeeName, employeePassword);
            if(result){
                l.setVisible(false);
                new HMS().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect username or password", "Error", 1);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Coonect to server first", "Error", 1);

        }
        
    }
    private void LoginAdminButtonMouseClicked(java.awt.event.MouseEvent evt) {
        if(this.checkConnection){
            String adminUsername = AdminUsername.getText();
            String adminPassword = String.valueOf(AdminPassword.getPassword());
            boolean result = clientSocket.loginAdmin(adminUsername, adminPassword);
            if(result){
                    l.setVisible(false);
                    new AdminFrame().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect username or password", "Error", 1);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please Coonect to server first", "Error", 1);

        }
    }

    private void ColorSetter(int index){
        if(index==1){
            this.ConnectToServer.setForeground(Color.black);
            this.LoginAsEmployee.setForeground(Color.white);
            this.LoginAsManager.setForeground(Color.white);
        }
        if(index==2){
            this.ConnectToServer.setForeground(Color.white);
            this.LoginAsEmployee.setForeground(Color.black);
            this.LoginAsManager.setForeground(Color.white);
        }
        if(index==3){ 
            this.ConnectToServer.setForeground(Color.white);
            this.LoginAsEmployee.setForeground(Color.white);
            this.LoginAsManager.setForeground(Color.black);
        }
    }

    private void ConnectToServerMouseClicked(java.awt.event.MouseEvent evt) {
        this.ColorSetter(1);
        PagesPanel.removeAll();
        PagesPanel.repaint();
        PagesPanel.revalidate();
        PagesPanel.add(ConnectionPage);
        PagesPanel.repaint();
        PagesPanel.revalidate();
    }

    private void LoginAsEmployeeMouseClicked(java.awt.event.MouseEvent evt) {
        this.ColorSetter(2);
        PagesPanel.removeAll();
        PagesPanel.repaint();
        PagesPanel.revalidate();
        PagesPanel.add(LoginEmployeePage);
        PagesPanel.repaint();
        PagesPanel.revalidate();
        
    }

    private void LoginAsManagerMouseClicked(java.awt.event.MouseEvent evt) {
        this.ColorSetter(3);
        PagesPanel.removeAll();
        PagesPanel.repaint();
        PagesPanel.revalidate();
        PagesPanel.add(LoginAdminPage);
        PagesPanel.repaint();
        PagesPanel.revalidate();
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               l = new Login();
               l.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField AdminPassword;
    private javax.swing.JTextField AdminUsername;
    private javax.swing.JLabel ConnectServer;
    private javax.swing.JLabel ConnectToServer;
    private javax.swing.JPanel ConnectionPage;
    private javax.swing.JTextField EmployeeLogin;
    private javax.swing.JPasswordField EmployeePassword;
    private javax.swing.JLabel LoginAdminButton;
    private javax.swing.JPanel LoginAdminPage;
    private javax.swing.JLabel LoginAsEmployee;
    private javax.swing.JLabel LoginAsManager;
    private javax.swing.JLabel LoginEmployeeButton;
    private javax.swing.JPanel LoginEmployeePage;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel OptionPanel;
    private javax.swing.JPanel PagesPanel;
    private javax.swing.JTextField PortField;
    private javax.swing.JTextField ServerIp;
    private javax.swing.JPanel ServerPort;
    private javax.swing.JLabel Status;
    private javax.swing.JLabel jLabel10;
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
    // End of variables declaration//GEN-END:variables
}
