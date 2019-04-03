package TP7;

import TP6.*;
import TP4.Vecteur3D;

/**
 * Write a description of class carr� here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Carre extends Objet
{
    // instance variables - replace the example below with your own
    private int x;

    Transformation m_transformationBase;

    /**
     * Constructor for objects of class carr�
     */
    public Carre(Noeud _parent)
    {
        super(_parent);
        
        String textureCube = "/TP6/res/blanc.png";
        
        // on instancie un transformation de base et quatre carr�s qui seront d�clar�s 
        // comme enfants (graphe de sc�ne) de cette transformation
        Vecteur3D transformationBase = new Vecteur3D(0.0f,0.0f,0.0f);
        m_transformationBase = new Translation(_parent,transformationBase);


        int matricePelle[][] =  {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 1, 1, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 1, 2, 2, 3, 0, 3, 0, 2, 0, 1, 0, 0, 0, 0},
                                    {0, 1, 2, 3, 0, 3, 0, 0, 0, 2, 1, 0, 0, 0, 0},
                                    {1, 2, 2, 1, 3, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0},
                                    {1, 3, 1, 2, 0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0},
                                    {1, 3, 1, 2, 0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0},
                                    {1, 2, 1, 2, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0},
                                    {0, 1, 2, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0},
                                    {0, 1, 2, 2, 0, 0, 0, 0, 2, 2, 1, 0, 0, 0, 0},
                                    {0, 0, 1, 1, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matricePelle[i][j]!=0){
                    switch (matricePelle[i][j]){
                        case 1 : textureCube = "/TP6/res/black.png";
                        break;
                        case 2 : textureCube = "/TP6/res/marron.png";
                        break;
                        case 3 : textureCube = "/TP6/res/gris.png";
                        break;
                        case 4 : textureCube = "/TP6/res/grisfonce.png";
                        break;
                        case 5 : textureCube = "/TP6/res/blanc.png";
                        break;

                    }
                    Vecteur3D vecteur1 = new Vecteur3D(2*i, 2*j, 0.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    CubeTexture cube = new CubeTexture(translation1, textureCube);
                   
                }
            }
        }
    }

    /**
     * La m�thode dessine dessine les quatre carr�s que nous avons in
     * instanci� dans le constructeur
     *
     */

    public void dessine()
    {
        // ici il faut dessiner quelquechose. Le quelque chose en question est intanci� 
        // dans le construteur de la classe carr� 
        m_transformationBase.affiche();
    }
}