/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.gennaio2019;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * classe che funge da main
 * nel boderpane c'è al top i contatori, al center la griglia e al bottom i bottoni
 * inoltre c'è una finestra di dialogo che permette all'utente di scegliere 
 * la dimensione della griglia
 * @author crist
 */
public class Gennaio2019 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        int n=0;
        do {
        String response = InputDialog.getResponse();
        n = Integer.parseInt(response);} while (n<3||n>9);
        Contatori c = new Contatori();
        BorderPane root = new BorderPane();
        root.setTop(c);
        Griglia griglia = new Griglia(c, n);
        root.setCenter(griglia);
        Btn button = new Btn (c, griglia);
        root.setBottom(button);
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
