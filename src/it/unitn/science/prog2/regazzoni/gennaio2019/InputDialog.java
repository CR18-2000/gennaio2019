/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.gennaio2019;

import java.util.Optional;
import javafx.scene.control.TextInputDialog;

/**
 * crea una finestra di dialogo per chiedere all'utente la grandezza della griglia
 * @author crist
 */
public class InputDialog {
        
    static public String getResponse () {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Dimensione della griglia?");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) return result.get();
        else return null;
    }
    
}
