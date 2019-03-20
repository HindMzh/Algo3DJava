package TP5;

import java.util.Vector;

/**
 * Classe noeud est une classe abstraite en amont de l'hiérarchie de classes de notre graphe de scene.
 * sa fonction principale est de porter la structure de l'arbre du graphe de scène.
 * Un noeud peut avoir plusieurs enfants et un seul parent.
 * Seul le noeud d'origine de la scène n'a pas de parnet.
 *
 * @author (Hind Mazhar)
 * @version 20/03/2019
 */
public abstract class Noeud
{
    
    //Un noeud peu avoir plusieurs enfants
    protected Vector<Noeud> m_enfants;
    
    // un noeud a un seul parent
    protected Noeud m_parent;
    
    /**
     * Le constructeur par défaut de la classe Noeud prend le noeud parent en paramètre
     */
    public Noeud(Noeud _parent){
        m_parent = _parent;
        _parent.ajouteEnfant(this); //le pparent m'ajoute à sa liste d'enfants
    }
    
    
    /** 
     * Ajoute le noeud _enfnat passé en paramètre à la liste d'enfant en attribut
     * @param _enfant le noeud enfant à rajouter à la liste d'enfants m_enfants
     * 
     */
    public void ajouteEnfant(Noeud _enfant){
        m_enfants.add(_enfant);
    }
    /**
     * Méthode abstraite en charge d'appeler es instructions OPEN Gl permettant d'afficher le noeud ( même si on sait pas 
     * encore ce qu'il présente).
     */
    public abstract void affiche();
    
}
