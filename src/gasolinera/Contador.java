/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasolinera;

import static gasolinera.Gasolinera.jButton1;
import static gasolinera.Gasolinera.jButton2;
import static gasolinera.Gasolinera.jButton3;
import static gasolinera.Gasolinera.jRadioButton1;
import static gasolinera.Gasolinera.jLabel4;
import static gasolinera.Gasolinera.jLabel5;
import static gasolinera.Gasolinera.jLabel6;
import static gasolinera.Gasolinera.jPanel2;
import static gasolinera.Gasolinera.jPanel3;
import static gasolinera.Gasolinera.jRadioButton2;



import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author JHG-7
 */
public class Contador extends Thread {
    private Timer timer = new Timer();
    public static TimerTask tarea;
    private int cont = 0;
    private int ope91 = Integer.parseInt(jLabel5.getText());
    private int ope95 = Integer.parseInt(jLabel6.getText());

    private int lts;
    
    public Contador(int lts){
        this.lts = lts;
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jRadioButton1.setVisible(true);
        jRadioButton2.setVisible(true);

    }
    
    @Override
    public void run(){
        final TimerTask tarea = new TimerTask(){
            
            @Override
            public void run() {  
                cont += 1;
                jLabel4.setText(""+cont);
            }
        };
        timer.schedule(tarea,0,100);
        try {
            Thread.sleep(lts);
        } catch (InterruptedException ex) {
            Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
        }
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        jButton3.setVisible(true);
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        if (Integer.parseInt(jLabel5.getText()) < 100){
            JOptionPane.showMessageDialog(jPanel3, "Ah sobrepasado la Capasidad minima de reserva");
            jPanel2.setVisible(false);
        }else if(Integer.parseInt(jLabel6.getText()) < 100){
            JOptionPane.showMessageDialog(jPanel3, "Ah sobrepasado la Capasidad minima de reserva");
            jPanel2.setVisible(false);
        }
        tarea.cancel();

       
    }
}
