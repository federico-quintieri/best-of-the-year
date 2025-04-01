package org.java.thymeleaf.best_of_the_year.controllers;

public class Song {
      // Variabili istanza private
      private int id;
      private String titolo;
  
      // Costruttore vuoto
      public Song() {
  
      }
  
      // Costruttore che inizializza le variabili istanza
      public Song(int id, String titolo) {
          // This si riferisce solo alle variabile dell'istanza corrente
          this.id = id;
          this.titolo = titolo;
      }
  
      // Metodi getter
      public int getId() {
          return this.id;
      }
  
      public String getTitolo() {
          return this.titolo;
      }
  
      // Metodi setter
      public void setId(int id) {
          this.id = id;
      }
  
      public void setTitolo(String titolo) {
          this.titolo = titolo;
      }
  
      // Metodo to String override per mostrare variabili istanza classe
      @Override
      public String toString() {
          return String.format("Titolo canzone: %s \n Id canzone: %d", this.titolo, this.id);
      }
}
