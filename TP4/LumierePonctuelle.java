package TP4;
import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;


/**
 * La classe lumierePonctuelle repr�setenune sourche de lumi�re ponctuelle
 * elle est definie par u, point ans l'espace � partir diquel vont irradier les rayons �mis par cette source lumineuse
 * ponctuelle
 *
 * @author (your name)
 * @version 19/03/2019
 */
public class LumierePonctuelle extends Lumiere
{
    // Tableau de floats de dimension 4 reprsentant l'origine d ela souce lumineuse (appel� m_position)
    //La quatri�me valeur de ce vecteur vaut 1
    // en tat que param�tre de lumi�re ponctuelle lors de la phase d'initialisation
    private float [] m_position = {0.0f, 0.0f, 0.0f, 1.0f};
    
    /**
     * Constructeur la classe lumi�rePonctuelle, il prend quatre arguemnts 
     * @param _vecteurAmbiant composante ambiante de la lumi�re
     * @param _vecteurDiffus composante diffuse de la lumi�re
     * @param _vecteurSpeculaire composantes speculaire de la lumi�re
     * @param _position vecteur donnant la direction des rayons �mis
     */
    public LumiereDirectionelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _position)
    {
        //On appelle le constructeur de la classe parente avec ses param�tres
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
       
        //avec le dernier param�tre on initialise l'attribut m_position(il s'agit d'un tableau de r��ls de dimesion 4
        m_position[0] = _vecteurSpeculaire.getX();
        m_position[1] = _vecteurSpeculaire.getY();
        m_position[2] = _vecteurSpeculaire.getZ();
        m_position[3] = 1.0f; //la derni�re valeur du tableau de r�el est �gale � 1 pour indiquerqu'il s'agit
        //d'une lumi�re ponctuelle voir la doc
    }
    
    /**
     * Constructeur par d�faut de la casse LumierePonctuelle il ne prend pas d'argument.
     * Il place une lumi�re poncutelle � l'origine du systeme de coordonn�es (0.0f,0.0f,0.0f)
     * */
     pubic LumierePonctuelle()
     {
         super();
         m_position[0] = 0.0f;
         m_position[1] = 0.0f;
         m_position[2] = 0.0f;
         m_position[3] = 1.0f;
        }
           
          
    /**
     * On initialise la valeur du vecteur de direction pour cette instance de classe 
     * de lumi�re ponctuelle apr�s avoir appel� la m�thode d'initialisation de la 
     * classe parente
     */
    public void initialise()
    {
        super.initialise();
        
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(m_position);
        buffDirection.position(0);

        GL11.glLight(m_currentLight, GL11.GL_AMBIENT, buffDirection);
        
    }
    
}
