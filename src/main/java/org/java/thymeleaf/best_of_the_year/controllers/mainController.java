package org.java.thymeleaf.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class mainController {

    // Metodo che restituisce view thymeleaf
    @GetMapping("/")
    public String home(Model model) {
        // Creo stringa da passare poi al model
        String nome = "Federico";

        // Passiamo la variabile nome alla view tramite il model che fa da collegamento
        // controller => view
        model.addAttribute("nome", nome);

        // Nome del file HTML Thymeleaf (Senza .html)
        return "home";
    }

    // Metodo privato che restituisce lista oggetti tipo Movie
    private ArrayList<Movie> getBestMovies() {

        ArrayList<Movie> movies = new ArrayList<>();

        // Riempio la mia lista
        movies.add(new Movie(1, "Interstellar"));
        movies.add(new Movie(2, "Inception"));
        movies.add(new Movie(3, "The Dark Knight"));

        return movies;
    }

    // Metodi privato che restituisce lista oggetti di tipo Song
    private ArrayList<Song> getBestSongs() {

        // Faccio la mia collection che contiene solo Songs
        ArrayList<Song> songs = new ArrayList<>();

        // Aggiungo canzoni alla mia collection
        songs.add(new Song(1, "Imagine"));
        songs.add(new Song(2, "Hotel California"));
        songs.add(new Song(3, "Sugar Crash"));

        return songs;
    }

    // Mapping di due url

    @GetMapping("/movies")
    public String getMovies(Model model) {

        ArrayList<Movie> movies = getBestMovies();

        String movieTitles = movies.stream()
                .map(Movie::getTitolo)
                .collect(Collectors.joining(", "));

        model.addAttribute("movieTitles", movieTitles);
        return "movies";
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {

        ArrayList<Song> songs = getBestSongs();
        
        String songTitles = songs.stream()
                .map(Song::getTitolo)
                .collect(Collectors.joining(", "));

        model.addAttribute("songTitles", songTitles);
        return "songs";
    }

}
