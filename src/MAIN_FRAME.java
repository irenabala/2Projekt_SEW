

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IreBal14
 */
public class MAIN_FRAME extends javax.swing.JFrame { 
    Connection con=null;        
    DatabaseMetaData md=null;
    String primary_key=null;
    int pkPosition=0;
    //Hier habe ich die Variablen, die ich spaeter nutzen werde, initialisiert.
    /**
     * Creates new form MAIN_FRAME
     */
    public MAIN_FRAME() { 
        initComponents(); //Hier wird die  Methode initComponents() drinnen im Konstruktor aufgerufen.
         try{
        Class.forName("com.mysql.jdbc.Driver"); //Der Datenbanktreiber wurde hochgeladen, das habe ich in einem try and catch Block hinzugefuegt
        }catch(ClassNotFoundException e){
            System.out.println("Datenbanktreiber not Found");
            javax.swing.JOptionPane.showMessageDialog(this,"Error loading mySql Driver"); //Wenn der Datenbanktreiber nicht gefunden wird, wird ein SOUT gezeigt und ein JOptionPane mit einem Message dass es ein Fehler bei der Hochladung der Datenbanktreiber gibt.
            System.exit(1); //Brute-Force Variante, 1 bedeutet es ist ein Fehler passiert, 0 bedeutet dass es alles okay ist
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblServer = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        txtServer = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        btnDisconnect = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEntries = new javax.swing.JTable();
        Delete = new javax.swing.JButton();
        Insert = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);

        lblServer.setText("Server:");

        lblPort.setText("Port:");

        txtServer.setText("localhost");
        txtServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServerActionPerformed(evt);
            }
        });

        txtPort.setText("3306");
        txtPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPortActionPerformed(evt);
            }
        });

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnDisconnect.setText("Disconnect");
        btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnectActionPerformed(evt);
            }
        });

        tblEntries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblEntries);

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Insert.setText("Insert");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblServer)
                    .addComponent(lblPort))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDisconnect))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConnect)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServer)
                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect)
                    .addComponent(Delete))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPort)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDisconnect)
                        .addComponent(Insert)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServerActionPerformed
      // Hier ist der Event von Server-Button
    }//GEN-LAST:event_txtServerActionPerformed

    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed
    // Hier ist der Event von Disconnect Button
        try {
            con = DriverManager.getConnection("jdbc:mysql://"+txtServer.getText()+":3306/world", "root",""); //Herstellung der Verbindung mit der Datenbank, das habe ich in einem try und catch Block hineingegeben
            btnConnect.setEnabled(true);  // Connect-Button wurde aktiviert
            txtServer.setEnabled(true); //Server-Button wurde aktiviert
            btnDisconnect.setEnabled(false); //Disconnect-Button wurde deaktiviert
         }catch(SQLException e){
             System.out.println("Couldn't connect"); 
             javax.swing.JOptionPane.showMessageDialog(this, "error disconnectiong to datenbank", null, WIDTH, null); //Wenn die Verbindung nicht geht, dann wird eine Nachricht von einem JOptionPane gezeigt und die obere SOUT auch 
         }
    }//GEN-LAST:event_btnDisconnectActionPerformed

    private void txtPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPortActionPerformed
        //Hier ist der Event von Port-Button
    }//GEN-LAST:event_txtPortActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
         //Hier ist der Event von Connect-Button, wenn man drauf klickt soll die Verbindung mit der Datenbank gemacht werden
        try {
            con = DriverManager.getConnection("jdbc:mysql://"+txtServer.getText()+":3306/world", "root",""); //Herstellung der Verbindung mit der Datenbank, das habe ich in einem try und catch Block hineingegeben
            btnConnect.setEnabled(false); //Connect-Button wurde deaktiviert
            txtServer.setEnabled(false); //Server-Button wurde deaktiviert
            btnDisconnect.setEnabled(true); //Disconnect-Button wurde aktiviert
            
            md= con.getMetaData(); //Mithilfe der Methode getMetaData() koennen wir die Metadaten von einer Tabelle bekommen, wie z.B Spaltename, Spaltetyp, Anzahl der Spalten usw. Diese Daten werden in einer Variable gespeichert die "md" heisst.Sie wird am Anfang initialisiert.
            
          
            
           ResultSet res=md.getColumns(null, null, "city",null); //Mithilfe der Methode getColumns() bekommen wir die Anzahl der Spalten fuer die angegebene Tabelle zurueck. Das wird dann in der Variable "res" gespeichert. 
           ResultSet res_prim=md.getPrimaryKeys(null, null, "city");//Ruft eine Information fuer die  Primärschlüsselspalten der angegebenen Tabelle.Das wird in einer Variable gespeichert, die res_prim heisst
          res_prim.next(); //sucht fuer die naechste Primaerschluesselspalte
          primary_key=res_prim.getString(4); 
          pkPosition = res_prim.getInt("KEY_SEQ")-1; //Wir bekommen die Sequenznummer von der Spalte in einem mehrspaltigen Primärschlüssel,das wird in der Variable "pkPosition" gespeichert. Ich habe -1 verwendet, weil wir -1 immer brauchen deswegen speichern wir es direkt mit -1.
             System.out.println("primary keys:"+res_prim.getInt("KEY_SEQ"));
          //Hier wird die Sequenznummer von Primaerschluessel ausgegeben
               System.out.println("primary keys:"+res_prim.getString(4));
           //Hier wird die Name von Primaerschluesselspalte ausgegeben

               OurTableModel tableModel=new OurTableModel(pkPosition);  //Ich habe ein Objekt tableModel erstellt. Dieses Objekt kommt aus der Klasse OurTableModel die ich zusaetzlich programmiert habe
              
                //ID-Spalte soll nicht aendern!!!!!!!!!!!(Das habe ich in der Klasse OurTableModel gemacht)
               
           
           int num_cols=0;
           while (res.next()){ //es sucht die naechste Spalte
               tableModel.addColumn(res.getString(4));  
               System.out.println(res.getString(4));
               num_cols++; 
           }
           
           Statement stmt=con.createStatement(); // Erzeugen von Statements
           res=stmt.executeQuery("Select * from city"); // Ausfuhren von Statements
           
           while(res.next()){
               Object[] arr=new Object[num_cols]; //default ist object,fuer jede Zeile wird ein Array erstellt,ich gebe dem TableModel ein array
               for(int i=0;i<num_cols;i++){
                   arr[i]=res.getObject(i+1);
               }
               tableModel.addRow(arr); //fuer jede zeile haben wir ein array
               
           }
           tableModel.addRow(new Object[num_cols]); //weil wir wollen vielleicht eine zeile hinzufugen
           
           tblEntries.setModel(tableModel); //Legt das Datenmodell für diese Tabelle auf newModel fest und registriert es für Listener-Benachrichtigungen aus dem neuen Datenmodell.
           
           tableModel.addTableModelListener(new TableModelListener() { //Fügt der Liste einen Listener hinzu, der bei jeder Änderung des Datenmodells benachrichtigt wird.

                @Override
                public void tableChanged(TableModelEvent e) {
                   
                    tableModelChanged(e);
                }
            }); //Ich habe mich selbst eine Klasse programmiert, ich programmiere meine Klasse in argument drinnen
           
           
         }catch(SQLException e){
             System.out.println("Couldn't connect");
             javax.swing.JOptionPane.showMessageDialog(this, "error connectiong to datenbank", null, WIDTH, null); //Wenn die Verbindung mit der Datenbank nicht geht, wird diese Nachricht gezeigt
         }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
      
        //Hier ist der Event von Delete-Button
        
        int  row=tblEntries.getSelectedRow();//wir speichern die Selected row in einer variable
          String col_name=tblEntries.getModel().getColumnName(pkPosition); //wir bekommen die Name der Spalte
            
     if(row!=tblEntries.getModel().getRowCount()-1){ //die letzte row darf nicht geloescht werden
       
       int id=(int) tblEntries.getModel().getValueAt(row, pkPosition); //wir bekommen die ID von der Spalte 
       
        try{
        PreparedStatement delete=con.prepareStatement("DELETE FROM city WHERE "+primary_key+"=?"); //Hier habe ich den Prepared Statement erstellt, wo drinnen ein mysql Delete Statement steht, das habe ich in einem try und catch Block hinzugefuegt
      
        delete.setInt(1,id); //Wenn wir eine Zeile loeschen, es wird die ID von der geloeschten Zeile gezeigt
           System.out.println(delete); 
           System.out.println(delete.executeUpdate() + "rows deleted"); //Ausfuehren von Statement
            tblEntries.setModel(new DefaultTableModel()); //Legt das Datenmodell für diese Tabelle auf newModel fest und registriert es für Listener-Benachrichtigungen aus dem neuen Datenmodell.
        
      
    }catch(SQLException ex){
            System.out.println("Couldn't delete the row"); //Wenn die Zeile nicht geloescht wird, wird diese SOUT gezeigt
        }
     }
     else{
         System.out.println("You can't delete this row"); //Wenn es die letzte Zeile der Tabelle ist, darf sie nicht geloescht werden
     }
        

    }//GEN-LAST:event_DeleteActionPerformed

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
     
        //Hier ist der Event von Insert Button
        int row=tblEntries.getSelectedRow(); //Wir bekommen die selektierte Spalte hier

     
     
     
        System.out.println("Row "+row); //hier wird die Spalte gezeigt
     
        
         
      try{
        String name =tblEntries.getModel().getValueAt(row, 1).toString(); //Hier bekommen wir das Wert von Spalte "Name" und speichern es in einer Variable
        String country =tblEntries.getModel().getValueAt(row, 2).toString(); //Hier bekommen wir das Wert von Spalte "CountryCode" und speichern es in einer Variable
        String distrinct =tblEntries.getModel().getValueAt(row, 3).toString(); //Hier bekommen wir das Wert von Spalte "District" und speichern es in einer Variable
        String population =tblEntries.getModel().getValueAt(row, 4).toString(); //Hier bekommen wir das Wert von Spalte "population" und speichern es in einer Variable
        System.out.println(country+" "+distrinct+" "+" "+population); //Hier geben wir die Variablen country,distrinct und population aus
       PreparedStatement insert=con.prepareStatement("INSERT INTO city" +" (Name, CountryCode, District, Population) VALUES " +"(?,?,?,?)"); //Hier habe ich ein Prepared Statement erstellt, wo eine INSERT INTO Statement drinnen steht
      
       
       
        insert.setString(1,name); //Wir koennen Werte in der name-Spalte geben
        insert.setString(2, country); //Wir koennen Werte in der country-Spalte geben
        insert.setString(3, distrinct); //wir koennen  Werte in der distrinct-Spalte geben
        insert.setString(4, population); //Wir koennen Werte in der population-Spalte geben
   
        // ID-Spalte brauchen wir nicht, weil es AutoIncrement ist!!
        //Wir sollen Werte bei allen Spalten geben, weil sie im Datenbank keine NULL Werte bekommen duerfen.
           
           System.out.println(insert);
           System.out.println(insert.executeUpdate()+ "rows added"); //Ausfuehren von Statement
           
      
      
        

    }catch(SQLException e){
            System.out.println("Couldn't add the row"); //In diesem Catch-Block, wird ein Fehler zuruckgegeben wenn die Zeile nicht hinzugefuegt werden kann
        }
      //Hier habe ich den try und catch Block von oben hineingeschrieben, weil ich wollte, dass nach ich eine Zeile hinzugefuegt habe, diese Zeile auch speichern im Datenbank
   try {
            con = DriverManager.getConnection("jdbc:mysql://"+txtServer.getText()+":3306/world", "root",""); //Herstellung der Verbindung mit der Datenbank, das habe ich in einem try und catch Block hineingegeben
            btnConnect.setEnabled(false); //Connect-Button wurde deaktiviert
            txtServer.setEnabled(false); //Server-Button wurde deaktiviert
            btnDisconnect.setEnabled(true); //Disconnect-Button wurde aktiviert
            
            md= con.getMetaData(); //Mithilfe der Methode getMetaData() koennen wir die Metadaten von einer Tabelle bekommen, wie z.B Spaltename, Spaltetyp, Anzahl der Spalten usw. Diese Daten werden in einer Variable gespeichert die "md" heisst.Sie wird am Anfang initialisiert.
            
          
            
           ResultSet res=md.getColumns(null, null, "city",null); //Mithilfe der Methode getColumns() bekommen wir die Anzahl der Spalten fuer die angegebene Tabelle zurueck. Das wird dann in der Variable "res" gespeichert. 
           ResultSet res_prim=md.getPrimaryKeys(null, null, "city");//Ruft eine Information fuer die  Primärschlüsselspalten der angegebenen Tabelle.Das wird in einer Variable gespeichert, die res_prim heisst
          res_prim.next(); //sucht fuer die naechste Primaerschluesselspalte
          primary_key=res_prim.getString(4); 
          pkPosition = res_prim.getInt("KEY_SEQ")-1; //Wir bekommen die Sequenznummer von der Spalte in einem mehrspaltigen Primärschlüssel,das wird in der Variable "pkPosition" gespeichert. Ich habe -1 verwendet, weil wir -1 immer brauchen deswegen speichern wir es direkt mit -1.
             System.out.println("primary keys:"+res_prim.getInt("KEY_SEQ"));
          //Hier wird die Sequenznummer von Primaerschluessel ausgegeben
               System.out.println("primary keys:"+res_prim.getString(4));
           //Hier wird die Name von Primaerschluesselspalte ausgegeben

               OurTableModel tableModel=new OurTableModel(pkPosition);  //Ich habe ein Objekt tableModel erstellt. Dieses Objekt kommt aus der Klasse OurTableModel die ich zusaetzlich programmiert habe
              
                //ID-Spalte soll nicht aendern!!!!!!!!!!!
               
           
           int num_cols=0;
           while (res.next()){
               tableModel.addColumn(res.getString(4));
               System.out.println(res.getString(4));
               num_cols++;
           }
           
           Statement stmt=con.createStatement(); // Erzeugen von Statements
           res=stmt.executeQuery("Select * from city"); // Ausfuehren von Statements
           
           while(res.next()){
               Object[] arr=new Object[num_cols]; //default ist object,fuer jede Zeile wird ein Array erstellt,ich gebe dem TableModel ein array
               for(int i=0;i<num_cols;i++){
                   arr[i]=res.getObject(i+1);
               }
               tableModel.addRow(arr); //fuer jede zeile haben wir ein array
               
           }
           tableModel.addRow(new Object[num_cols]); //weil wir wollen vielleicht eine zeile hinzufugen
           
           tblEntries.setModel(tableModel); //Legt das Datenmodell für diese Tabelle auf newModel fest und registriert es für Listener-Benachrichtigungen aus dem neuen Datenmodell.
           
           tableModel.addTableModelListener(new TableModelListener() { //Fügt der Liste einen Listener hinzu, der bei jeder Änderung des Datenmodells benachrichtigt wird.

                @Override
                public void tableChanged(TableModelEvent e) {
                   
                    tableModelChanged(e);
                }
            }); 
           
           
         }catch(SQLException e){
             System.out.println("Couldn't connect");
             javax.swing.JOptionPane.showMessageDialog(this, "error connectiong to datenbank", null, WIDTH, null); //Wenn die Zeile nicht hinzugefuegt wird, wird diese Nachricht gezeigt
         }
       
     
    }//GEN-LAST:event_InsertActionPerformed
    private void tableModelChanged(TableModelEvent e){
       //Diese Methode haben wir selbst programmiert
        int row=e.getFirstRow(); //Hier bekommen wir die 
    System.out.println("table changed");
      if(row !=tblEntries.getModel().getRowCount() -1){ //Alle Zeile ausser der letzten Zeile
          System.out.println("Last Edited");
                  
      
    
    String columnName=tblEntries.getModel().getColumnName(e.getColumn()); //wir bekommen die Name der Spalte
        System.out.println(columnName);
        
        int id=Integer.parseInt(tblEntries.getModel().getValueAt(row, pkPosition).toString()); //wir bekommen die ID  Spalte
        System.out.println(columnName+""+id);
        String entry_changed=
        tblEntries.getModel().getValueAt(row,e.getColumn()).toString();
        // wenn wir etwas andern, es zeigt in welcheer spalte und zeile es geandert wird.
       try{ 
        PreparedStatement update=con.prepareStatement("UPDATE city SET "+columnName+"=? WHERE "+primary_key+"=?"); //Hier habe ich den Prepare-Statement erstellt,wo ein MYSQL UPDATE STATEMENT drinnen steht, das habe ich in einem try und catch block hineingegeben
        update.setString(1,entry_changed); //es wird die Name der geaenderten Spalte gezeigt
        update.setInt(2,id); //Es wird  ID der geaenderten Spalte gezeigt
           System.out.println(update);
           System.out.println(update.executeUpdate() + "rows changed"); //Ausfuehren von Statement
    }catch(SQLException ex){
           System.out.println("Error updating table"); //Wenn die Spalte nicht geaendert werden kann, wird diese SOUT ausgegeben
    }
      } 
    }
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
            java.util.logging.Logger.getLogger(MAIN_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAIN_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAIN_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAIN_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MAIN_FRAME().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton Insert;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDisconnect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblServer;
    private javax.swing.JTable tblEntries;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtServer;
    // End of variables declaration//GEN-END:variables
}