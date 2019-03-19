package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * Une lumi�re directionnelle repr�sente un source de lumi�re situ�e  l'infini
 * tous les rayons �mis par cette lumi�re sont parall�les et leur direction est donn�e par un vecteur de dimesion trois.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LumiereDirectionelle extends Lumiere
{

    private float[] m_direction = {0.0f,0.0f,0.0f,0.0f};
    
    /**
     * Constructeur de la classe lumi�reDirectionnelle, il prend quatre arguemnts 
     * @param _vecteurAmbiant composante ambiante de la lumi�re
     * @param _vecteurDiffus composante diffuse
     * @param _vecteurSpeculaire composantes speculaire de la lumi�re
     * @param _direction vecteur donnant la direction des rayons �mis
     */
    public LumiereDirectionelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _direction)
    {
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
        m_direction[0] = _direction.getX();
        m_direction[0] = _direction.getY();
        m_direction[0] = _direction.getZ();
        m_direction[0] = 1.0f;        
    }
    
    /**
     * Constructeur par d�faut de la casse LumiereDirectionnele il ne prend pas d'argument.
     * Il place une lumi�re directionnelle qui simule la lumi�re d'un soleil au zenith
     * */
     pubic LumiereDirectionelle()
     {
         super();
         m_direction[0] = 0.0f;
         m_direction[1] = -1.0f;
         m_direction[2] = 0.0f;
         m_direction[3] = 0.0f;
        }
    
    /**
     * On initialise la valeur du vecteur de direction pour cette instance de classe 
     * de lumi�re directionelle apr�s avoir appel� la m�thode d'initialisation de la 
     * classe parente
     */
    public void initialise()
    {
        super.initialise();
        
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(m_direction);
        buffDirection.position(0);

        GL11.glLight(m_currentLight, GL11.GL_AMBIENT, buffDirection);
        
    }

}
