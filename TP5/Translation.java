package TP5;
import org.lwjgl.opengl.GL11;
import TP4.Vecteur3D;

/**
 * La classe translation applique une translation d�finie par l'attribut m_coordonnees
 * @author Hind
 * @version 20/03/2019
 */
public abstract class Translation extends Transformation
{
    // instance variables - replace the example below with your own
    private Vecteur3D m_coordonnees;

    /**
     Ce constructeur fixe les coordonn�es de translation en meme temps qu'une reference vers l'instance de neoud parent
     @param _parent le noeud d�clar� comme parent de l'instance courante (this)
     @param  _coordonnees les ccoordonnes de translation � appliquer
     */
    public Translation(Noeud _parent, Vecteur3D _coordonnees)
    {
      super (_parent);
      m_coordonnees = _coordonnees;
    }
    
    
    /**
     * Impl�mentation de la m�thode abstraite transforme() d�clar�e initialemnt dans la classse abstraite transformation.
     * Elle consiste � appeler l'instruction Open Gl glTranslatef avec trois coordonnn�ees (float)
     *
     */
    public void translate()
    {
        GL11.glTranslatef(m_coordonnees.getX(),m_coordonnees.getY(),m_coordonnees.getZ());
    }
    
}
