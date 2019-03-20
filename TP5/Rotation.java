package TP5;

import org.lwjgl.opengl.GL11;
import TP4.Vecteur3D;

/**
 * La classe rotation applique une rotation 
 *
 * @author Hind
 * @version 20/03/2019
 */
public abstract class Rotation extends Transformation
{
    // instance variables - replace the example below with your own
    private Vecteur3D m_axe;
    private float m_angle;

    /**
     * Constructeur for objects of class rotation
     * Ce constructeur fixe les coordonnées de rotation en meme temps 
     * qu'une reference vers l'instance de neoud parent
     @param _axe l'axe de rotation
     @param  _angle l'angle de rotation autour de l'axe
     */
    public Rotation(Noeud _parent, Vecteur3D _axe, float _angle)
    
    {
      super (_parent);
      m_axe = _axe;
      m_angle= _angle;
    }
    
    
    /**
     * iplémentation de la méthode abstraite trasforme() déclarée initialement dans la classe abstraite transformation.
     * Elle consiste à appeler les instruction open gl.
     * glRotatef avec une coordonée représentant l'angle
     */
    public void transforme()
    {
     GL11.glRotatef(m_angle,m_axe.getX(),m_axe.getY(),m_axe.getZ());   
    }
    
   
}
