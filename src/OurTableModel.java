
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
//Diese Klasse wurde vererbt von DefaultTableModel Klasse
public class OurTableModel extends DefaultTableModel{
    int columnDisabled=0; 
    
    public OurTableModel(int columnDisabled){ //Hier ist der Konstruktor von dieser Klasse
        super();  //Mit super ruft den Konstruktor von der oberen Klasse auf
        this.columnDisabled=columnDisabled; 
    
    }
    @Override
    //Die Funktionalitaet dieser Methode ist, dass man die ID-Spalte nicht aendern kann
    public boolean isCellEditable(int row,int column){
        if(column== columnDisabled)
            return false;
        else
            return true;
    }
    
}
