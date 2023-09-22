/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.gennaio2019;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * classe che contiene e visualizza il contatore dei punti e delle partite vinte
 * @author crist
 */
public class Contatori extends HBox {
    
    int punteggio;
    Text punti;
    int partiteVinte;
    Text partiteV;
    boolean vittoria;
    
    /**
     * i contatori vengono settati a 0 e vengono stampati a video tramite label e text
     */
    
    Contatori () {
        punteggio = 0;
        vittoria = false;
        Label title1 = new Label ("Punteggio: ");
        punti = new Text (Integer.toString(punteggio));
        colPunteggio();
        this.getChildren().addAll(title1, punti);
        partiteVinte = 0;
        Label title2 = new Label ("    Partite vinte: ");
        partiteV = new Text (Integer.toString(partiteVinte));
        this.getChildren().addAll(title2, partiteV);
    }
    
    /**
     * ad ogni vincita il contatore delle partite vinte viene incrementato e 
     * la grafica aggiornata
     */
    
    public void incrementaPartiteVinte () {
        partiteVinte++;
        punteggio=0;
        update();
        vittoria= true;
    }
    
    /**
     * ritorna il valore del booleano a falso per rincominciare la partita
     */
    
    public void nuovaPartita () {
        vittoria = false;
    }
    
    private void update () {
        punti.setText(Integer.toString(punteggio));
        colPunteggio();
        partiteV.setText(Integer.toString(partiteVinte));
    }
    
    /**
     * colora il punteggio di blu se minore di 10, di rosso se maggiore di 10,
     * di verde se uguale a 10 e fa stampare un alert di vincita facendo 
     * rincominciare il gioco
     */
    
    private void colPunteggio () {
        if (punteggio<10) punti.setFill(Color.BLUE);
        else if (punteggio>10) punti.setFill(Color.RED);
        else {
            punti.setFill(Color.GREEN);
            incrementaPartiteVinte();
            Alert alert = new Alert (AlertType.INFORMATION);
            alert.setTitle("Raggiunto il punteggio 10");
            alert.setContentText("COMPLIMENTI, HAI VINTO!");
            System.out.println("COMPLIMENTI, HAI VINTO!");
            alert.showAndWait();
        }
    }
    
    /**
     * incrementa il punteggio del valore presente sulla cella girata
     * @param i 
     */
    
    public void incrementaPunteggio (int i) {
        punteggio+=i;
        update();
    }
    
    /**
     * decrementa il punteggio del valore presente nella cella coperta
     * @param i 
     */
    
    public void decrementaPunteggio (int i) {
        punteggio-=i;
        update();
    }
    
    /**
     * setta i contatori a 0
     */
    
    public void azzera () {
        punteggio=0;
        partiteVinte=0;
        update();
    }
}
