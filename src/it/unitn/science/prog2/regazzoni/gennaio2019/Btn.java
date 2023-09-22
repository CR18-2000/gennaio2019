/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.gennaio2019;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * contiene due bottoni
 * @author crist
 */
public class Btn extends HBox {

    Button reset;
    Button cheat;
    Contatori contatori;
    Griglia griglia;
    
    /**
     * crea i due bottoni e aggiunge loro gli eventHandler
     * @param cont contatore della partita
     * @param g griglia della partita
     */

    Btn(Contatori cont, Griglia g) {
        griglia = g;
        contatori = cont;
        reset = new Button("Reset");
        this.getChildren().add(reset);
        cheat = new Button("Cheat");
        this.getChildren().add(cheat);
        EventHandler<ActionEvent> eventHandlerReset = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                reset();
            }
        };
        reset.addEventHandler(ActionEvent.ACTION, eventHandlerReset);
        EventHandler<ActionEvent> eventHandlerCheat = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cheat();
            }
        };
        cheat.addEventHandler(ActionEvent.ACTION, eventHandlerCheat);
    }

    private void reset() {
        griglia.nuovoGioco();
        contatori.azzera();
    }

    private void cheat() {
        GridPane gp = new GridPane();
        ColumnConstraints cc;
        for (int i=0; i<griglia.N; i++) {
            cc = new ColumnConstraints ();
            cc.setPercentWidth(100. / griglia.N);
            gp.getColumnConstraints().add(cc);
        }
        RowConstraints rc;
        for (int i=0; i<griglia.N; i++) {
            rc = new RowConstraints();
            rc.setPercentHeight(100. / griglia.N);
            gp.getRowConstraints().add(rc);
        }
        Text t = null;
        ObservableList<Node> list = griglia.getChildren();
        int i = 0;
        int j = 0;
        for (Node a : list) {
            if (a instanceof CellaP) {
                t = new Text("P");
            } else if (a instanceof CellaV) {
                t = new Text("V");
            } else if (a instanceof Cella) {
                t = new Text(Integer.toString(((Cella) a).valore));
            }
            gp.add(t, i, j);
            if (i < griglia.N-1) {
                i++;
            } else {
                i = 0;
                j++;
            }
        }
        Scene scene = new Scene(gp, 400, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Sbircia!");
        stage.show();
    }

}
