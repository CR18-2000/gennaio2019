/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.gennaio2019;

import java.util.Random;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * classe che contiene un rettangolo, che è la carta coperta, e se scoperta viene 
 * aggiunto un text con il valore
 * @author crist
 */
public class Cella extends StackPane {
    Rectangle rect;
    Text t;
    int valore;
    boolean scoperta;
    Contatori contatori;
    
    /**
     * crea un rettangolo e un valore random
     * l'eventHandler fa cambiare lo stato da coperto a scoperto
     * @param cont è il contatore
     */
    
    Cella(Contatori cont) {
        contatori=cont;
        scoperta=false;
        this.setWidth(50);
        this.setHeight(50);
        rect = new Rectangle (50, 50);
        rect.setFill(Color.YELLOW);
        rect.setStroke(Color.BLACK);
        this.getChildren().add(rect);
        t = new Text();
        Random random = new Random();
        valore = random.nextInt(9)+1;
        EventHandler<MouseEvent> mouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                  if (scoperta) coprire();
                  else scoprire();
            }
        };
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent);
    }
    
    public void scoprire () {
        String s = Integer.toString(valore);
        t.setText(s);
        this.getChildren().add(t);
        scoperta=true;
        contatori.incrementaPunteggio(valore);
    }
    
    public void coprire () {
        this.getChildren().clear();
        rect = new Rectangle (50, 50);
        rect.setFill(Color.YELLOW);
        rect.setStroke(Color.BLACK);
        this.getChildren().add(rect);
        scoperta=false;
        contatori.decrementaPunteggio(valore);
    }
    
}
