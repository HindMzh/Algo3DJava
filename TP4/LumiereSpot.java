package TP4;
import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;


/**
 * La classe spot représente une lumière ponctuelle qui diffuse un faisceau de lumière selon une direction et un angle de
 * diffusion (GL_SPOT_CUTOFF), Un troisieme paramètre (GL_SPOT_EXPONENT) détéremine l'attenuation de l'intensité lumineuse 
 * lorsque la direction des rayons s'ecarte de la direction principale (GL_SPOT_DIRECTION)
 *
 * @author (your name)
 * @version 19-03-2019 
 */

public class LumiereSpot extends LumierePonctuelle
{
    // La direction principale de la lumière spot (tableau de réél de dimension 3)
    float [] m_spotDirection = {0.0f,0.0f,-1.0f};
    // l'angle de diffusion de la lumiere spot
    //(réel compris entre 0(distribution uniforme) et 128 (focus maximal)/
    float m_spotCutoff = 0;
    // l'attenuation par rapport à la direction principale ()
    // (réel entre 0 et 90 -> Cône de lumière ou 180 -> distribution uniforme)
    float m_spotExponent=90;
    

    /**
     * Constructeur par défaut de la classe LumiereSpot, il ne prend pas arguemnts (@param _vecteurAmbiant...) 
     * Il place une lumiere spot au centre du système de coordonnées locales orientées selon les z négatifs (droit devant)
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
     * Constructeur la classe lumièreSpot, il prend 7 arguemnts 
     * @param _vecteurAmbiant composante ambiante de la lumière
     * @param _vecteurDiffus composante diffuse de la lumière
     * @param _vecteurSpeculaire composantes speculaire de la lumière
     * @param _position vecteur donnant la direction des rayons émis
     * @param _spotcutoff réel donnant l'anle d'ouverture du spot
     * @param _spotExponent  reel donnant l'attenuation des rayons s'ecartant de la direcrion principale
     * @param _spotDirection vecteur donnant la direction du faisceau du spot      
     */
      public LumiereSpot(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _position, Vecteur3D _spotDirection,float _spotCutoff,
                             float _spotExponent )
     {
        //On appelle le constructeur de la classe parente avec ses paramètres
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire, _position);
       
        //avec le dernier paramètre on initialise l'attribut m_spotDirection(il s'agit d'un tableau de rééls de dimension 3
        m_spotDirection[0] = _vecteurSpeculaire.getX();
        m_spotDirection[1] = _vecteurSpeculaire.getY();
        m_spotDirection[2] = _vecteurSpeculaire.getZ();
        
        m_spotCutoff= _spotCutoff;
        m_spotExponent = _spotExponent; 
    }
   
    
      /**
     * On initialise la valeur du vecteur de direction, de cutoff et d'exponent pour cette instance de classe 
     * de lumière ponctuelle après avoir appelé la méthode d'initialisation de la 
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
