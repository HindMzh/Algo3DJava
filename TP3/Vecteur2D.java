package TP3;

/**
 * Write a description of class Vecteur2D here: Cette classe représete un vecteur à deux dimensions
 * elle est surout utilisée pour définir les coordonées (u,v) de texture
 *
 * @author (Hind Mazhar)
 * @version (0.0.0,1 alpha)
 */
public class Vecteur2D
{
    // Attrucuts de la classe
    private float m_u=0.0f, m_v=0.0f;

    /**
     * le constructeur par défaut initialise le deux composants du vecteur à zéro
     */
    public Vecteur2D()
    {
        // initialisation des attributs à l'appel du constructeur 
        m_u = 0.0f;
        m_v = 0.0f;
    }

    /**
    *Ce constructeur prend deux paramètres: la variable avec m_X et l'attribut (valeur) est avec un underscore _Y
    *les valeurs qui seront assignées aux composantes
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
       * Cette méthode ajoute au vecteur courant le vecteur passé en paramètre
       * Les composantes du vecteur passé en paramètre sot ajoutéesn aux composantes du vecteur représenté par l'instance courante
       * 
       * @param_vec vecteur à ajouter à l'instance courante
       * 
       */
       public void add(Vecteur2D _vec)
       {
           m_u += _vec.getU(); //on n'a pas accès car ces attributs sot privés
           m_v += _vec.getV();
        }
        /** 
         * acesseur pour la composante u
         * àreturn la valeur de la composante u
         */
        public float getU()
        {
            return m_u;
        }
        
        /** 
         * acesseur pour la composante v
         * àreturn la valeur de la composante v
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
