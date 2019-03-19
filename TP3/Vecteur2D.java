package TP3;

/**
 * Write a description of class Vecteur2D here: Cette classe repr�sete un vecteur � deux dimensions
 * elle est surout utilis�e pour d�finir les coordon�es (u,v) de texture
 *
 * @author (Hind Mazhar)
 * @version (0.0.0,1 alpha)
 */
public class Vecteur2D
{
    // Attrucuts de la classe
    private float m_u=0.0f, m_v=0.0f;

    /**
     * le constructeur par d�faut initialise le deux composants du vecteur � z�ro
     */
    public Vecteur2D()
    {
        // initialisation des attributs � l'appel du constructeur 
        m_u = 0.0f;
        m_v = 0.0f;
    }

    /**
    *Ce constructeur prend deux param�tres: la variable avec m_X et l'attribut (valeur) est avec un underscore _Y
    *les valeurs qui seront assign�es aux composantes
    * m_u et m_v de l'instancede Vecteur2D
    * 
    * @parm _u la valeur de la composante u du vecteur
    * @param _v la valeur de la composante v du vecteur
    
    
    */
     public Vecteur2D(float _u, float _v)
     {
         m_u = _u;
         m_v = _v;
        }
      
      /**
       * Cette m�thode ajoute au vecteur courant le vecteur pass� en param�tre
       * Les composantes du vecteur pass� en param�tre sot ajout�esn aux composantes du vecteur repr�sent� par l'instance courante
       * 
       * @param_vec vecteur � ajouter � l'instance courante
       * 
       */
       public void add(Vecteur2D _vec)
       {
           m_u += _vec.getU(); //on n'a pas acc�s car ces attributs sot priv�s
           m_v += _vec.getV();
        }
        /** 
         * acesseur pour la composante u
         * �return la valeur de la composante u
         */
        public float getU()
        {
            return m_u;
        }
        
        /** 
         * acesseur pour la composante v
         * �return la valeur de la composante v
         */
        public float getV()
        {
            return m_v;
        }
        
        /** mutateur pour la composante u
         * @param _u la valeur de la composante u
         */
        public void setU(float _u)
        {
            this.m_u = _u;
        }
            
            /** mutateur pour la composante v
         * @param _v la valeur de la composante v
         */
        public void setV(float _v)
        {
            this.m_u = _v;
        }
    
      
}
