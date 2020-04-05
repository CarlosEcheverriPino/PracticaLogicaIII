/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author CompucenterPC1
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
   Scanner datos = new Scanner(System.in);
 
//------------------------------------------------------------------------------
//Variables
    
    ListaLigada [] polinomios = new ListaLigada[10];
    int coef = 0;   //--> Guarda el coeficiente que ingresa el usuario.
    int exp = 0;    //--> Guarda el exponente que ingresa el usuario.
    int numterm = 0;    //--> Contador de terminos.
    int contterm = JOptionPane.YES_OPTION;   //-->Resector de desicion de agregar mas terminos a un polinomio.
    int numpoli = 0;    //--> Contador de polinomios.   
    int seleccion = 0;  //--> Guarda la opcion digitada por el usuario
                        //del panel de opciones.                      
//------------------------------------------------------------------------------
//Controlador de salida del programa.
    do{                    
//------------------------------------------------------------------------------
//Panel selector de opciones.
        while(seleccion < 1 || seleccion > 4){
            seleccion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una de las siguientes opciones:"
            + "\n"+"1 - Ingresar un polinomio \n"
            + "2 - operacion de polinomios \n"
            + "3 - imprimir polinomio \n"
            + "4 - Salir"));
            if(seleccion < 1 || seleccion > 4){//--> controlador respuesta por fuera de rango.
                JOptionPane.showMessageDialog(null,"Opcion no encontrada, favor eliga de nuevo.");
            }         
        }
        
        
//------------------------------------------------------------------------------
//Operador de la seleccion entre 1 y 3.        
        switch(seleccion){
//------------------------------------------------------------------------------
//Ingresar polinomio.
            case 1:{
//------------------------------------------------------------------------------
//Panel informativo. 
                if(numpoli == 10){
                    JOptionPane.showMessageDialog(null,"Ya alcanso el numero maximo de polinomios");
                }   
                else{
                    JOptionPane.showMessageDialog(null,"numero de polinomios ingresados:  "+numpoli+"\n"
                    +"total espacios para polinomios:      "+ (polinomios.length - numpoli)+"\n"
                    +"Ubicacion de polinomio a ingresar:  "+(numpoli + 1));
                    ListaLigada lista = new ListaLigada();  
//------------------------------------------------------------------------------
//Solicitud de los siguientes terminos.                                 
                    while(contterm == JOptionPane.YES_OPTION){
                        coef = Integer.parseInt(JOptionPane.showInputDialog
                        ("Ingrese el coeficiente del "+(numterm + 1)+" termino"));
                        exp = Integer.parseInt(JOptionPane.showInputDialog
                        ("Ingrese el exponente del "+(numterm + 1)+" termino"));
                        Termino termino = new Termino(coef, exp);
                        lista.addTermino(termino);
                        numterm ++;
                        contterm = JOptionPane.showConfirmDialog(null, "desea ingresar otro termino al polinomio");
                    }
                    polinomios [numpoli] = lista;   //--> lleva l lista ligada a la posicion numpoli en el vector
                    numpoli++;
                    contterm = JOptionPane.YES_OPTION;
                    numterm = 0;
                }
            break;    
            }
//------------------------------------------------------------------------------
//Operacion de polinomio.            
            case 2:{
                int select2 = 0;
                select2 = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una de las siguientes opciones:"
                + "\n"+ "1 - Multiplicacion de polinomios"
                + "\n"+ "2 - Divicion de polinomios"
                + "\n"+ "3 - Derivar polinomio"
                + "\n"+ "4 - Evaluar el polinomio"));
                switch(select2){
                    case 1: {//--->Opcion de multiplicar
                        int pola = 0;
                        int polb = 0;
                        JOptionPane.showMessageDialog(null,"Esta opcion requiere que escoja dos polinomios");
                        pola = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el primer polinomio"));
                        polb = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el segundo polinomio"));
                        JOptionPane.showMessageDialog(null,polinomios[(pola-1)].multiplicar(polinomios[pola-1]
                        ,polinomios[(polb - 1)] ));
                        break;
                    }
                    case 2: {//--->Opcion de dividir
                        int pols = 0;
                        int polt = 0;
                        JOptionPane.showMessageDialog(null,"Esta opcion requiere que escoja dos polinomios");
                        pols = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el primer polinomio"));
                        polt = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el segundo polinomio"));
                        JOptionPane.showMessageDialog(null,polinomios[(pols-1)].devicion(polinomios[pols-1]
                        ,polinomios[(polt - 1)] ));
                        break;                        
                    }
                       
                    case 3:{//--->Opcion de derivar
                        int polc = 0;
                        JOptionPane.showMessageDialog(null,"Esta opcion requiere que escoja un polinomio");
                        polc = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el polinomio"));
                        JOptionPane.showMessageDialog(null,polinomios[polc-1].derivacion(polinomios[polc-1]));
                        break;
                    }
                    case 4:{
                        int pold = 0;
                        int valor = 0;
                        JOptionPane.showMessageDialog(null,"Esta opcion requiere que escoja un polinomios y "
                        + "defina el valor para al X");
                        pold = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el polinomio"));
                        valor = Integer.parseInt(JOptionPane.showInputDialog("Defina el valor para al X"));
                        JOptionPane.showMessageDialog(null,polinomios[pold-1].evaluate(polinomios[pold-1],valor));
                        break;
                    }
                }
                
               
                
            break;
            }
//------------------------------------------------------------------------------
//Imprimir polinomio.            
            case 3:{
                int select = 0;
                int posicion = 0;
                select = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una de las siguientes opciones:"
            + "\n"+"1 - Imprimir un polinomio"
            + "\n"+ "2 - Imprimir todos los polinomios"));
                if(select == 1){
                    posicion = select = Integer.parseInt(
                    JOptionPane.showInputDialog("ingrese la posicion del polinomio que desea imprimir"));
                    JOptionPane.showMessageDialog
                    (null,"Polinomio "+posicion+": "+polinomios[(posicion - 1)].imprimirUno());
                }
                else{
                    StringBuilder datos2 = new StringBuilder();
                    for(int a = 0;a < numpoli; a++){
                    datos2.append("Polinomio ").append((a+1)).append(": ").append(polinomios[a].imprimirUno()).append("\n");
                    }
                JOptionPane.showMessageDialog(null,datos2);    
                } 
            }      
        }
        
        if(seleccion >= 1 && seleccion <= 3){//-->reseteador de seleccion en caso de que la seleccion
            seleccion = 0;                   //este dentro del rango para poder ingresar al bucle.
        }
    }while(seleccion != 4);
    JOptionPane.showMessageDialog(null,"Fin de la ejecucion.");
    }

    
}
