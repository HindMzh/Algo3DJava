package TP5;

import java.util.Vector;

/**
 * Classe noeud est une classe abstraite en amont de l'hi�rarchie de classes de notre graphe de scene.
 * sa fonction principale est de porter la structure de l'arbre du graphe de sc�ne.
 * Un noeud peut avoir plusieurs enfants et un seul parent.
 * Seul le noeud d'origine de la sc�ne n'a pas de parnet.
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
     * Le constructeur par d�faut de la classe Noeud prend le noeud parent en param�tre
     */
    public Noeud(Noeud _parent){
        m_parent = _parent;
        _parent.ajouteEnfant(this); //le pparent m'ajoute � sa liste d'enfants
    }
    
    
    /** 
     * Ajoute le noeud _enfnat pass� en param�tre � la liste d'enfant en attribut
     * @param _enfant le noeud enfant � rajouter � la liste d'enfants m_enfants
     * 
     */
    public void ajouteEnfant(Noeud _enfant){
        m_enfants.add(_enfant);
    }
    /**
     * M�thode abstraite en charge d'appeler es instructions OPEN Gl permettant d'afficher le noeud ( m�me si on sait pas 
     * encore ce qu'il pr�sente).
     */
    public abstract void affiche();
    
}
