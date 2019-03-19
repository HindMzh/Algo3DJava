package TP3;



/**
 * Write a description of class lumierePonctuelle here.
 * @author (your name)
 * @version (a version number or a date)
 */

public class lumierePonctuele extends lumiere
{
     /**Constructor for objects of class lumierePonctuelle
     */
    public lumierePonctuelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, Vecteur3D _vecteurSpeculaire,
    vecteur3D _direction)
    {
     super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
     m_direction[0] = _direction.getX();
     m_direction[0] = _direction.getY();
     m_direction[0] = _direction.getZ();
     m_direction[0] = 1.0f;
     
     }
    }
