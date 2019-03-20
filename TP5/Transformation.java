package TP5;

import org.lwjgl.opengl.GL11;

/**
 * La classe transformation permet de factoriser le code commun aux classes filles Translation, Rotation et Echelle
 * Les fonctions communes � ses transformations sont principalement l'empilement et le d�pilement des matrices
 *
 * @author Hind Mazhar
 * @version 20/03/2019
 */
   public abstract class Transformation extends Noeud
{
    
    
    
    public Transformation(Noeud _parent){
        
        super (_parent);
    }
    
    public abstract void transforme();    
    
    public void  affiche(){
        //On empile la matrice de transformation sur la matrice courante
        GL11.glPushMatrix();
        
        
        // On ex�cute la transformation de la classe meme si on ne sait pas encore quelle transformation il s'agit
        transforme();
         //ici on fait qqch mais quoi?
         //On dessine le contenu de tous les element de cette classe
         //plus le contenu des noeuds enfants.
         //Il s'agit de parcourir le contenu du Vecteur contenant les enfants et d'appeler la m�thode afficher()
         //pour chaque enfant r�f�renc� dans le vecteur
         
         for (int i=0; i<m_enfants.size(); i++)
         { m_enfants.get(i).affiche();            }
         
         
        //On d�pile la matrice de transformation pour revenir � la matrice courante
        GL11.glPopMatrix();
        
    }
}
