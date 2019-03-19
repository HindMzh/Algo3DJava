package TP4;
import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;


/**
 * La classe spot repr�sente une lumi�re ponctuelle qui diffuse un faisceau de lumi�re selon une direction et un angle de
 * diffusion (GL_SPOT_CUTOFF), Un troisieme param�tre (GL_SPOT_EXPONENT) d�t�remine l'attenuation de l'intensit� lumineuse 
 * lorsque la direction des rayons s'ecarte de la direction principale (GL_SPOT_DIRECTION)
 *
 * @author (your name)
 * @version 19-03-2019 
 */

public class LumiereSpot extends LumierePonctuelle
{
    // La direction principale de la lumi�re spot (tableau de r��l de dimension 3)
    float [] m_spotDirection = {0.0f,0.0f,-1.0f};
    // l'angle de diffusion de la lumiere spot
    //(r�el compris entre 0(distribution uniforme) et 128 (focus maximal)/
    float m_spotCutoff = 0;
    // l'attenuation par rapport � la direction principale ()
    // (r�el entre 0 et 90 -> C�ne de lumi�re ou 180 -> distribution uniforme)
    float m_spotExponent=90;
    

    /**
     * Constructeur par d�faut de la classe LumiereSpot, il ne prend pas arguemnts (@param _vecteurAmbiant...) 
     * Il place une lumiere spot au centre du syst�me de coordonn�es locales orient�es selon les z n�gatifs (droit devant)
     */
    public LumiereSpot()
    {
        super();
         m_spotDirection[0] = 0.0f;
         m_spotDirection[0] = 0.0f;// les rayons tombent verticalement
         m_spotDirection[0] = -1.0f;
         
         m_spotCutoff = 0.0f;
         m_spotExponent = 90.0f;
         
        }
   
       /**
     * Constructeur la classe lumi�reSpot, il prend 7 arguemnts 
     * @param _vecteurAmbiant composante ambiante de la lumi�re
     * @param _vecteurDiffus composante diffuse de la lumi�re
     * @param _vecteurSpeculaire composantes speculaire de la lumi�re
     * @param _position vecteur donnant la direction des rayons �mis
     * @param _spotcutoff r�el donnant l'anle d'ouverture du spot
     * @param _spotExponent  reel donnant l'attenuation des rayons s'ecartant de la direcrion principale
     * @param _spotDirection vecteur donnant la direction du faisceau du spot      
     */
      public LumiereSpot(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _position, Vecteur3D _spotDirection,float _spotCutoff,
                             float _spotExponent )
     {
        //On appelle le constructeur de la classe parente avec ses param�tres
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire, _position);
       
        //avec le dernier param�tre on initialise l'attribut m_spotDirection(il s'agit d'un tableau de r��ls de dimension 3
        m_spotDirection[0] = _vecteurSpeculaire.getX();
        m_spotDirection[1] = _vecteurSpeculaire.getY();
        m_spotDirection[2] = _vecteurSpeculaire.getZ();
        
        m_spotCutoff= _spotCutoff;
        m_spotExponent = _spotExponent; 
    }
   
    
      /**
     * On initialise la valeur du vecteur de direction, de cutoff et d'exponent pour cette instance de classe 
     * de lumi�re ponctuelle apr�s avoir appel� la m�thode d'initialisation de la 
     * classe parente
     */
    public void initialise()
    {
        super.initialise();
        
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(m_spotDirection);
        buffDirection.position(0);
        
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(m_position);
        buffDirection.position(0);
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(m_position);
        buffDirection.position(0);
        

        GL11.glLight(m_currentLight, GL11.GL_AMBIENT, buffDirection);
        GL11.glLightf(m_currentLight, GL11.GL_SPOT_CUTOFF, m_spotCutoff);
        GL11.glLightf(m_currentLight, GL11.GL_SPOT_EXPONENT, m_spotExponent);
        
    }
}
