/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

//dsd
public class Nodo {
    private Termino termino;       //-->objeto monomio.
    private Nodo liga;     //-->Liga la cual permite unir un monomio
                                //con otro. 
//------------------------------------------------------------------------------
//Constructor.

    public Nodo(Termino termino, Nodo liga) {
        this.termino = termino;
        this.liga = liga;
    }
    
     public Nodo(Termino termino) {
        this.termino = termino;
    }


//------------------------------------------------------------------------------
//Getter and Setter.
    public Termino getTermino() {
        return termino;
    }

    public void setTermino(Termino termino) {
        this.termino = termino;
    }

    public Nodo retornaLiga() {
        return liga;
    }

    public void asignaLiga(Nodo liga) {
        this.liga = liga;
    }
    
}
