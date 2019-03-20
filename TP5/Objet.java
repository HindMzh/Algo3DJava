package TP5;
import org.lwjgl.opengl.GL11;

/**
 * Abstract class Objet - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Objet extends Noeud
{
    // instance variables - replace the example below with your own
    public Objet(Noeud _parent)
    {
       super(_parent); 
    }
    
    public abstract void dessine();
  
    public void affiche()
    {
      //On empile la matrice de transformation sur la matrice courante
        GL11.glPushMatrix();
        
        // On dessie l'objet
        dessine();
         //ici on fait qqch mais quoi?
         //On dessine le contenu de tous les element de cette classe
         //plus le contenu des noeuds enfants.
         //Il s'agit de parcourir le contenu du Vecteur contenant les enfants et d'appeler la méthode afficher()
         //pour chaque enfant référencé dans le vecteur
         
         for (int i=0; i<m_enfants.size(); i++)
             { 
             m_enfants.get(i).affiche();          
              }
         
         
        //On dépile la matrice de transformation pour revenir à la matrice courante
        GL11.glPopMatrix();
          
    }
   
}
