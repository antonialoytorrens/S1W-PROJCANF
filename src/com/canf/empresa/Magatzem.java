package com.canf.empresa;

import com.canf.articles.Article;
import com.canf.articles.*;
import static com.canf.articles.tipusArticle.*;
import java.util.ArrayList;

public class Magatzem {

    private int codi;
    private String nom;
    private ArrayList<Article> llistaArticles;
    private ArrayList<Venta> historialVentes;    

    public Magatzem(int codi, String nom, ArrayList<Article> llistaArticles, ArrayList<Venta> historialVentes) {
        this.codi = codi;
        this.nom = nom;
        this.llistaArticles = llistaArticles;
        this.historialVentes = historialVentes;
    }


    // GETTERS && SETTERS
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodi() {
        return codi;
    }

    public ArrayList<Article> getLlistaArticles() {
        return llistaArticles;
    }

    // METODS
    public void addArticle(Article article) {
        llistaArticles.add(article);
    }

    public void removeArticle(Article article) {
        llistaArticles.remove(article.getReferencia());
    }

    public void modArticle(int referencia, int quantitat) {
        for (Article a : llistaArticles) {
            if (a.getReferencia() == referencia) {
                a.setQuantitat(quantitat);
            }
        }
    }

    public void wantArticle(int referencia) {
        for (Article a : llistaArticles) {
            if (a.getReferencia() == referencia) {
                System.out.println(a.toString());
            }
        }
    }

    public Disc obtenirDisc(String interpret) {
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == DISC) {
                Disc y = (Disc) x;
                if (y.getInterpret() == interpret) {
                    return y;
                }
            }
        }
        return null;
    }

    public Pelicula obtenirPelicula(Object participant) {
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == PELÍCULA) {
                Pelicula y = (Pelicula) x;
                if (y.getLlistaActors().contains(participant)) {
                    return y;
                }
            }
        }
        return null;
    }

    public Llibre obtenirLlibre(String autor) {
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == LLIBRE) {
                Llibre y = (Llibre) x;
                if (y.getNomAutor().equals(autor)) {
                    return y;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Magatzem{" + "codi=" + codi + ", nom=" + nom + ", llistaArticles=" + llistaArticles + '}';
    }

}
