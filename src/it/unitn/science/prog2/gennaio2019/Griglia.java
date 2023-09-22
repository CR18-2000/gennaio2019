/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.gennaio2019;

import java.util.Random;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * griglia di gioco
 * @author crist
 */
public class Griglia extends GridPane {

    int N;
    Contatori contatori;
    
    /**
     * costruisce una griglia nxn con 1 cella di vittoria, 1 di perdita e le altre normali
     * oltre a visualizzarle a schermo le visualizza in console
     * inoltre c'è un eventHandler per verificare la vittoria ad ogni cella girata
     * @param cont contatori del gioco
     * @param n grandezza della griglia
     */

    Griglia(Contatori cont, int n) {
        N = n;
        contatori = cont;
        this.setWidth(50 * N);
        this.setHeight(50 * N);
        ColumnConstraints cc1;
        RowConstraints rc1;
        for (int i = 0; i < N; i++) {
            cc1 = new ColumnConstraints();
            cc1.setPercentWidth(100. / N);
            this.getColumnConstraints().add(cc1);
        }
        for (int j = 0; j < N; j++) {
            rc1 = new RowConstraints();
            rc1.setPercentHeight(100. / N);
            this.getRowConstraints().add(rc1);
        }
        Random random = new Random();
        int rigaV, colonnaV;
        int rigaP, colonnaP;
        rigaV = random.nextInt(N);
        colonnaV = random.nextInt(N);
        rigaP = random.nextInt(N);
        colonnaP = random.nextInt(N);
        Cella c = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == rigaV && j == colonnaV) {
                    c = new CellaV(contatori);
                } else if (i == rigaP && j == colonnaP) {
                    c = new CellaP(contatori);
                } else {
                    c = new Cella(contatori);
                }
                this.add(c, j, i);
            }
        }
        System.out.println("===========");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == N - 1) {
                    System.out.println("[ ]");
                } else {
                    System.out.print("[ ] ");
                }
            }
        }
        EventHandler<MouseEvent> mouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                update();
                if (contatori.vittoria) {
                    nuovoGioco();
                }
            }
        };
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent);
    }
    
    /**
     * crea una nuova griglia con un nuovo gioco
     */

    public void nuovoGioco() {
        this.getChildren().clear();
        //this.setWidth(100*N);
        //this.setHeight(100*N);
        //this.setHgap(50);
        //this.setVgap(50);
        //ColumnConstraints cc1 = new ColumnConstraints();
        //cc1.setPercentWidth(100. / N);
        //RowConstraints rc1 = new RowConstraints ();
        //rc1.setPercentHeight(100. / N);
        //this.getColumnConstraints().addAll(cc1, cc1, cc1, cc1);
        //this.getRowConstraints().addAll(rc1, rc1, rc1, rc1);
        Random random = new Random();
        int rigaV, colonnaV;
        int rigaP, colonnaP;
        rigaV = random.nextInt(N);
        colonnaV = random.nextInt(N);
        do {
        rigaP = random.nextInt(N);
        colonnaP = random.nextInt(N);
        } while (rigaP==rigaV&&colonnaP==colonnaV);
        Cella c = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == rigaV && j == colonnaV) {
                    c = new CellaV(contatori);
                } else if (i == rigaP && j == colonnaP) {
                    c = new CellaP(contatori);
                } else {
                    c = new Cella(contatori);
                }
                this.add(c, j, i);
            }
        }
        System.out.println();
        System.out.println("============");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == N - 1) {
                    System.out.println("[ ]");
                } else {
                    System.out.print("[ ] ");
                }
            }
        }
        contatori.nuovaPartita();
    }

    private void update() {
        System.out.println();
        System.out.println("==============");
        int i = 0;
        ObservableList<Node> list = this.getChildren();
        for (Node a : list) {
            if (a instanceof CellaV) {
                if (((CellaV) a).scoperta) {
                    if (i < N - 1) {
                        System.out.print(" V ");
                        i++;
                    } else {
                        System.out.println(" V ");
                        i = 0;
                    }
                } else {
                    if (i < N - 1) {
                        System.out.print("[ ] ");
                        i++;
                    } else {
                        System.out.println("[ ] ");
                        i = 0;
                    }
                }
            } else if (a instanceof CellaP) {
                if (((CellaP) a).scoperta) {
                    if (i < N - 1) {
                        System.out.print(" P ");
                        i++;
                    } else {
                        System.out.println(" P ");
                        i = 0;
                    }
                } else {
                    if (i < N - 1) {
                        System.out.print("[ ] ");
                        i++;
                    } else {
                        System.out.println("[ ] ");
                        i = 0;
                    }
                }
            } else if (a instanceof Cella) {
                if (((Cella) a).scoperta) {
                    if (i < N - 1) {
                        System.out.print(" " + ((Cella) a).valore + " ");
                        i++;
                    } else {
                        System.out.println(" " + ((Cella) a).valore + " ");
                        i = 0;
                    }
                } else {
                    if (i < N - 1) {
                        System.out.print("[ ] ");
                        i++;
                    } else {
                        System.out.println("[ ] ");
                        i = 0;
                    }
                }
            }
        }
    }

}
