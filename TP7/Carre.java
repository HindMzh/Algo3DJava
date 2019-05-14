package TP7;

import TP6.*;
import TP4.Vecteur3D;

/**
 * Write a description of class carré here.
 *
 * @author HIND RIME
 * @version 15/04/2019
 */
public class Carre extends Objet
{
    // instance variables - replace the example below with your own
    private int x;

    Transformation m_transformationBase;

    /**
     * Constructor for objects of class carré
     */
    public Carre(Noeud _parent)
    {
        super(_parent);
        
        String textureCube = "/TP6/res/blanc.jpg";
        
        // on instancie un transformation de base et quatre carrés qui seront déclarés 
        // comme enfants (graphe de scène) de cette transformation
        Vecteur3D transformationBase = new Vecteur3D(0.0f,0.0f,0.0f);
        m_transformationBase = new Translation(_parent,transformationBase);


        int matricePelle[][] =     {{0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                    {3, 5, 4, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {3, 4, 5, 4, 4, 3, 0, 0, 0, 0, 0, 0, 0},
                                    {3, 4, 4, 5, 4, 4, 3, 0, 0, 0, 0, 0, 0},
                                    {0, 3, 4, 4, 5, 1, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 3, 4, 1, 2, 1, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 3, 0, 1, 2, 1, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0}};

        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matricePelle[i][j]!=0){
                    switch (matricePelle[i][j]){
                        case 1 : textureCube = "/TP6/res/marron_fonce.jpg";
                        break;
                        case 2 : textureCube = "/TP6/res/marron_clair.jpg";
                        break;
                        case 3 : textureCube = "/TP6/res/bleu_fonce.jpg";
                        break;
                        case 4 : textureCube = "/TP6/res/bleu_clair.jpg";
                        break;
                        case 5 : textureCube = "/TP6/res/bleu_moyen.jpg";
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
     * La méthode dessine dessine les quatre carrés que nous avons in
     * instancié dans le constructeur
     *
     */

    public void dessine()
    {
        // ici il faut dessiner quelquechose. Le quelque chose en question est intancié 
        // dans le construteur de la classe carré 
        m_transformationBase.affiche();
    }
}