/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.gennaio2019;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * cella che permette la vittoria immediata
 * @author crist
 */
public class CellaV extends Cella {
    
    /**
     * il costruttore è quello della superclasse anche se non tutto mi serve
     * ad esempio non devo avere i numeri casuali
     * @param cont 
     */
        
    CellaV (Contatori cont) {
        super(cont);
    }
    
    /**
     * una volta richiamato il metodo la carta viene scoperta e visualizzata la V
     * la partita viene vinta e la griglia rinnovata
     */
    
    @Override
    public void scoprire () {
        t.setText("V");
        scoperta = true;
        this.getChildren().add(t);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Premuta casella V");
        alert.setContentText("COMPLIMENTI, HAI VINTO!");
        System.out.println("COMPLIMENTI, HAI VINTO!");
        alert.showAndWait();
        contatori.incrementaPartiteVinte();
    }
    
    /**
     * metodo vuoto per sovrascrivere quello della superclasse perchè una volta 
     * scoperta la carta la partita è vinta e non si può coprire di nuovo
     */
    
    @Override
    public void coprire () {
        
    }
}
