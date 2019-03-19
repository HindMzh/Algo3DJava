package TP3;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * Abstract class lumiere - Cette classe est abstraite elle sert à
 * factoriser les attributs communs à toutes les lumières:
 * La composante ambiante, la composante  spéculaire et
 * la composante diffuse

 * @author (Hind Mazhar)
 * @version (06/02/2019)
 */
public abstract class lumiere
{
    // instance variables - replace the example below with your own
    private float[]m_ambientComponent={0.0f,0.0f,0.0f,0.0f};
    private float[]m_diffuseComponent={0.0f,0.0f,0.0f,0.0f};
    private float[]m_specularComponent={0.0f,0.0f,0.0f,0.0f};
    
    protected int m_currentLight= -1;
    private static int m_nextFreeLight = GL11.GL_LIGHT0;
    
    /** 
     * ce constructeur assigne une parmi les 8 lumières disponibles 
     * en OpenGL1.1. Le compteur m_currentLight est statique, 
     * c'est à dire que toute les instances de la classe lumiere 
     * partagent la valeur de m_currentLight.
     * Chaque instance connait donc le nombre de lumières 
     * dèja instanciées
     */
    public lumiere(){
        m_currentLight = m_nextFreeLight;
        m_nextFreeLight ++;
    }
    
    /**
     * Constructeur de la classe lumiere prenant en paramètres trois instances de vecteur 3D pour les composantes ambiante,
     * diffuses, et spéculaire de la lumière
     * @param_vecteurAmbiant la composante ambiante de la lumière (Vecteur3D)
     * @param_vecteurDiffus la composante diffuse de la lumière (Vecteur3D)
     * @param_vecteurSpeculaire la composante speculaire de la lumiere (Vecteur3D)
     **/
     public lumiere(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, Vecteur3D _vecteurSpeculaire)
     {
         
         this();
         m_ambientComponent[0] = _vecteurAmbiant.getX();
         m_ambientComponent[1] = _vecteurAmbiant.getY();
         m_ambientComponent[2] = _vecteurAmbiant.getZ();
         m_ambientComponent[3] = 1.0f;
         
         m_diffuseComponent[0] = _vecteurDiffus.getX();
         m_diffuseComponent[1] = _vecteurDiffus.getY();
         m_diffuseComponent[2] = _vecteurDiffus.getZ();
         m_diffuseComponent[3] = 1.0f;
         
         m_specularComponent[0] = _vecteurSpeculaire.getX();
         m_specularComponent[1] = _vecteurSpeculaire.getY();
         m_specularComponent[2] = _vecteurSpeculaire.getZ();
         m_specularComponent[3] = 1.0f;       
         
        }
    
    /**
     * initialisation de la lumière courante.
     */
    public void initialise()
      {
          FloatBuffer buffAmbient = BufferUtils.createFloatBuffer(4).put(m_ambientComponent);
          buffAmbient.position(0);
                
         FloatBuffer buffDiffuse = BufferUtils.createFloatBuffer(4).put(m_diffuseComponent);
         buffDiffuse.position(0);

         FloatBuffer buffSpecular = BufferUtils.createFloatBuffer(4).put(m_specularComponent);
         buffSpecular.position(0);
        
                
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_AMBIENT, buffAmbient);
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, buffDiffuse);
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_SPECULAR, buffSpecular);
        

        }
    
    /**
     * Active la lumière courante (on suppose que GL_LIGHTING)
     * est également activé
     * 
     */
    public void allumer()
    {
        
    }
    
}
