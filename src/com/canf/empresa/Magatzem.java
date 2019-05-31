package com.canf.empresa;

import com.canf.articles.Article;
import com.canf.articles.Disc;
import com.canf.articles.Llibre;
import com.canf.articles.Pelicula;
import com.canf.articles.Venta;
import static com.canf.articles.tipusArticle.DISC;
import static com.canf.articles.tipusArticle.LLIBRE;
import static com.canf.articles.tipusArticle.PELÍCULA;
import com.canf.excepcions.ArticleException;
import com.canf.excepcions.ValidacioException;
import com.canf.utilitats.Validacions;
import java.util.ArrayList;


public class Magatzem {

    private int codi;
    private String nom;
    private ArrayList<Article> llistaArticles;
    private ArrayList<Venta> historialVentes;

    public Magatzem(int codi, String nom, ArrayList<Article> llistaArticles, ArrayList<Venta> historialVentes) throws ValidacioException {
        this.setNom(nom);
        this.codi = codi;
        this.llistaArticles = new ArrayList<>();
        this.historialVentes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ValidacioException {
        if (Validacions.validaCadena(nom)) {
            this.nom = nom;
        } else {
            throw new ValidacioException("El nom no pot esser null, ni estar en blanc.");
        }
    }

    public int getCodi() {
        return codi;
    }

    public ArrayList<Article> getLlistaArticles() {
        return llistaArticles;
    }

    public ArrayList<Venta> getHistorialVentes() {
        return historialVentes;
    }
    

    public Disc obtenirDisc(String interpret) {
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == DISC) {
                Disc y = (Disc) x;
                if (y.getInterpret().equals(interpret)) {
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

    public Article obtenirArticle(int referencia) {
        for (Article x : llistaArticles) {
            if (x.getReferencia() == referencia) {
                return x;
            }
        }
        return null;
    }
    
     public Article obtenirArticle(String titol) {
        for (Article x : llistaArticles) {
            if (x.getNom().equals(titol)) {
                return x;
            }
        }
        return null;
    }

    public void addArticle(Article article) {
        llistaArticles.add(article);
    }

    public void removeArticle(Article article) {
       llistaArticles.remove(article);
    }

    public void disminuirQuantitat(Article y) throws ArticleException {
        for (Article x : llistaArticles) {
            if (y.equals(x)) {
                x.setQuantitat(x.getQuantitat() - 1);
            }

        }
    }

    

    @Override
    public String toString() {
        return "Magatzem{" + "codi=" + codi + ", nom=" + nom + ", llistaArticles=" + llistaArticles + ", llistaVentes=" + historialVentes + '}';
    }
}
