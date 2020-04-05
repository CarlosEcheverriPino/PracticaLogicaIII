/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author CompucenterPC1
 */
public class Termino {
    private int coef = 0;   //--> coeficiente del monomio.
    private int exp = 0;    //--> exponente que acompaña a la variable 
                            //     del monomio.
//------------------------------------------------------------------------------
//Constructor       
 public Termino (int coef, int exp){
    this.coef = coef;
    this.exp = exp;
 }
//------------------------------------------------------------------------------
//Getter and Setter
    public int getCoef() {
        return coef;
    }

    public int getExp() {
        return exp;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
            
    
}
