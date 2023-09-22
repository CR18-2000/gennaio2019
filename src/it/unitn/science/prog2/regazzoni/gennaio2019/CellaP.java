/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.gennaio2019;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * cella che fa perdere immediatamente
 * @author crist
 */
public class CellaP extends Cella {
    
    /**
     * il costruttore è quello della superclasse anche se non tutto mi serve
     * @param cont 
     */

    CellaP(Contatori cont) {
        super(cont);
    }
    
    /**
     * fa perdere immediamente la partita e visualizza una P
     */
    
    @Override
    public void scoprire () {
        t.setText("P");
        scoperta = true;
        this.getChildren().add(t);
        Alert alert = new Alert (AlertType.INFORMATION);
        alert.setTitle("Premuta casella P");
        alert.setContentText("PECCATO, HAI PERSO!");
        System.out.println("PECCATO, HAI PERSO!");
        alert.showAndWait();
        System.exit(0);
    }
    
    /**
     * metodo vuoto perchè erediterebbe dalla superclasse, ma una volta
     * scoperta la carta non può essere rigirata perchè il gioco termina
     */
    
    @Override
    public void coprire () {
        
    }

}
