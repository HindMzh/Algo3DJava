package TP4;
import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;


/**
 * La classe lumierePonctuelle représetenune sourche de lumière ponctuelle
 * elle est definie par u, point ans l'espace à partir diquel vont irradier les rayons émis par cette source lumineuse
 * ponctuelle
 *
 * @author (your name)
 * @version 19/03/2019
 */
public class LumierePonctuelle extends Lumiere
{
    // Tableau de floats de dimension 4 reprsentant l'origine d ela souce lumineuse (appelé m_position)
    //La quatrième valeur de ce vecteur vaut 1
    // en tat que paramètre de lumière ponctuelle lors de la phase d'initialisation
    private float [] m_position = {0.0f, 0.0f, 0.0f, 1.0f};
    
    /**
     * Constructeur la classe lumièrePonctuelle, il prend quatre arguemnts 
     * @param _vecteurAmbiant composante ambiante de la lumière
     * @param _vecteurDiffus composante diffuse de la lumière
     * @param _vecteurSpeculaire composantes speculaire de la lumière
     * @param _position vecteur donnant la direction des rayons émis
     */
    public LumiereDirectionelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _position)
    {
        //On appelle le constructeur de la classe parente avec ses paramètres
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
       
        //avec le dernier paramètre on initialise l'attribut m_position(il s'agit d'un tableau de rééls de dimesion 4
        m_position[0] = _vecteurSpeculaire.getX();
        m_position[1] = _vecteurSpeculaire.getY();
        m_position[2] = _vecteurSpeculaire.getZ();
        m_position[3] = 1.0f; //la dernière valeur du tableau de réel est égale à 1 pour indiquerqu'il s'agit
        //d'une lumière ponctuelle voir la doc
    }
    
    /**
     * Constructeur par défaut de la casse LumierePonctuelle il ne prend pas d'argument.
     * Il place une lumière poncutelle à l'origine du systeme de coordonnées (0.0f,0.0f,0.0f)
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
     * de lumière ponctuelle après avoir appelé la méthode d'initialisation de la 
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
