package TP5;

import org.lwjgl.opengl.GL11;
import TP4.Vecteur3D;


/**
 * Abstract class Echelle - write a description of the class here
 *
 * @author Hind
 * @version 20/03/2019
 */
public abstract class Echelle extends Transformation
    {
    // instance variables - replace the example below with your own
    private Vecteur3D m_VecteurEchelle;
   
    /**
     * Constructeur for objects of class Echelle,Ce constructeur fixe les coordonn�es de mise � l'echelle en meme temps 
     * qu'une reference vers l'instance de neoud parent
     @param _parent le noeud d�clar� comme parent de l'instance courante (this)
     @param  _VecteurEchelle les ccoordonnes de mise � l'echelle � appliquer
    
     */
    public Echelle(Noeud _parent, Vecteur3D _VecteurEchelle)
    
    {
      super (_parent);
      m_VecteurEchelle = _VecteurEchelle;
      
    }
    
    public void transforme()
    {
     GL11.glScalef(m_VecteurEchelle.getX(),m_VecteurEchelle.getY(),m_VecteurEchelle.getZ());   
    }
    
   
     }
