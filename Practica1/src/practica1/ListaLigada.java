/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;
import java.time.Clock;
import practica1.Nodo;

/**
 *
 * @author CompucenterPC1
 */
public class ListaLigada {
    
    private final Nodo cabeza;

    public ListaLigada() {
        cabeza = new Nodo(null);
        cabeza.asignaLiga(null);
    }

    public Nodo getCabeza() {
        return cabeza;
    }
    
    public Nodo getPrimero(){
        return cabeza.retornaLiga();
    }

    private boolean finRecorrido(Nodo p){
        return p == null;
    }
    
    public int getGrado (){
        Nodo primero = cabeza;
        if (primero.retornaLiga() != null){
           return primero.getTermino().getExp(); 
        }
        else{
        return -1;    
        }
        
    }
    
    public void addTermino(int coef,int exp){//--->Añade un nuevo termino a la lista apartir de un coeficiente y un exponente
        Nodo nuevo = new Nodo(new Termino(coef, exp));
        this.addNodo(nuevo); 
        
    }
    //--------------------------------------------------------------------------
    //Añadir datos
     public void addTermino(Termino dato){//--->Añade un nuevo termino a la lista
        Nodo nuevo = new Nodo(dato);
        this.addNodo(nuevo); 
        
    }
    public void addNodo(Nodo nuevo){
        int romper = 0; //--->sentinela para indicar cuando hay suma
        Nodo recorrido = this.getPrimero(); //-->Nodo que se para en la primera posicioncon dato
        Nodo ult = cabeza;  //--->Nodo que se ubica una posicion atrsa de recorrido
        while(!this.finRecorrido(recorrido)){   //---> Nodo recorrido es nulo
            Termino terminoR = recorrido.getTermino();
            int exponenteR = terminoR.getExp();//---> Se extrae el dato del recorrido
            
            Termino nuevoT = nuevo.getTermino();
            int exponenteNT = nuevoT.getExp();//---> Se extrae el dato del nodo nuevo
            if (exponenteNT < exponenteR){//---> el exp nuevo es menor que el exp en el nodo recorrido
                ult = recorrido;
                recorrido = recorrido.retornaLiga(); //--->trasnlacion de los dos nodos una posicion
            }
            else{ if(exponenteNT == exponenteR){ 
                        if(terminoR.getCoef() + nuevoT.getCoef() == 0){
                        ult.asignaLiga(recorrido.retornaLiga());
                        romper = 1;
                        }
                        else{//--->el exp nuevo es igual que el exp en el nodo recorrido
                    recorrido.getTermino().setCoef(terminoR.getCoef() + nuevoT.getCoef());//---> suma exponentes
                    romper = 1;}
            }
            break;   
            }
        }
        if(romper != 1){
            nuevo.asignaLiga(ult.retornaLiga());
            ult.asignaLiga(nuevo);
        }
    }
    
    public StringBuilder imprimirUno(){
        int coef = 0;
        int exp = 0;
        StringBuilder datos = new StringBuilder();
        Nodo r;//--->Nodo para recorrer
        r = cabeza.retornaLiga();//--->Se ubica el nodo en la primera posicion con dato de la lista 
        while(r != null){//--->Cpontrola el desbordamiento de la lista
        coef = r.getTermino().getCoef();//--->cargue de los alores del nodo actual a las variables
        exp =  r.getTermino().getExp();
        if(coef >= 0){//--->controlador puesta de signo positivo
            datos.append("+").append(coef).append("X^").append(exp).append(" ");    
        }
        else{
            datos.append(coef).append("X^").append(exp).append(" ");
        }
        r = r.retornaLiga();//---> Se mueve al siguiente nodo de la lista 
        }
    return datos;
    }
    //--------------------------------------------------------------------------
    //Multiplicar
     public StringBuilder multiplicar (ListaLigada a, ListaLigada b){
        StringBuilder datos = new StringBuilder();
        ListaLigada primera = a;
        ListaLigada segunda = b;
        ListaLigada result = new ListaLigada();//--->Lista que va almacenar el resultado de la operacion
        Nodo rprimero = primera.cabeza.retornaLiga();//--->Posicionamos el nodo al inicio del polinomio a
        Nodo rsegundo = segunda.cabeza.retornaLiga();//--->Posicionamos el nodo al inicio del polinomio b
        while(rprimero != null){//--->Ciclo que recorre el polinomio a
            while(rsegundo!= null){//--->Ciclo que recorre el polinomio b
                int coefprimero = rprimero.getTermino().getCoef();//--->Se cargan los valores en variables para ser manipulados
                int coefsegundo = rsegundo.getTermino().getCoef();
                int expprimero = rprimero.getTermino().getExp();
                int expsegunfo = rsegundo.getTermino().getExp();
                coefprimero = coefprimero * coefsegundo;//--->se opera  los coeficientes
                expprimero = expprimero + expsegunfo;//--->se suman los exponentes
                result.addTermino(coefprimero, expprimero);//--->se envia el dato a la lista de resultado
                rsegundo = rsegundo.retornaLiga();//---> Se mueve al siguiente nodo de la lista  
            }
        rsegundo = segunda.cabeza.retornaLiga();//--->se inicializa la posicion del nodo que recorreel 2do polinomio
        rprimero = rprimero.retornaLiga();//---> Se mueve al siguiente nodo de la lista del primer polinomio
        }
        datos = result.imprimirUno();
        
        return datos;
        
    }
    
    //--------------------------------------------------------------------------
    //Derivar 
    public StringBuilder derivacion (ListaLigada a){
        StringBuilder datos = new StringBuilder();
        ListaLigada principal = a;
        ListaLigada result = new ListaLigada();//--->Lista que va almacenar el resultado de la operacion
        Nodo recorrido = principal.cabeza.retornaLiga();//--->Posicionamos el nodo al inicio del polinomio
        while(recorrido != null){//--->Ciclo que recorre el polinomio
           int coef = recorrido.getTermino().getCoef();//--->Se cargan los valores en variables para ser manipulados
           int exp = recorrido.getTermino().getExp();
           coef = (coef*exp);
           exp = (exp - 1);
           if(coef != 0){//--->Se sacan los terminos en 0 de el cargue de nodos
               result.addTermino(coef, exp);
           }
           recorrido = recorrido.retornaLiga();
        }
        datos = result.imprimirUno();
        return datos;
    }
    
    //--------------------------------------------------------------------------
    //Evaluar la x
    public Double evaluate(ListaLigada a, int num){
        double datos = 0;
        double elevar = 0;
        double number = num;
        ListaLigada principal = a;
        Nodo recorrido = principal.cabeza.retornaLiga();//--->Posicionamos el nodo al inicio del polinomio
        while(recorrido != null){//--->Ciclo que recorre el polinomio
           double coef = recorrido.getTermino().getCoef();//--->Extraemos los datos del nodo en posicion
           double exp = recorrido.getTermino().getExp();
           elevar = Math.pow(number, exp);//--->Operamos el valor de la x
           elevar = (elevar * coef);
           datos = (datos + elevar);//--->Se lleva el valor a la variable
           elevar = 0;
           recorrido = recorrido.retornaLiga();//---> Se mueve al siguiente nodo de la lista del primer polinomio
        } 
        return datos;    
    }
    
    //--------------------------------------------------------------------------
    //Dividir
    public StringBuilder devicion (ListaLigada a, ListaLigada b){
        StringBuilder infor = new StringBuilder();//--->se inicican las variables a utilizar
        StringBuilder infoc = new StringBuilder();
        StringBuilder infod = new StringBuilder();
        ListaLigada r = a;
        ListaLigada d = b;
        ListaLigada c = new ListaLigada();
        Nodo rr = r.cabeza.retornaLiga();
        Nodo rd = d.cabeza.retornaLiga();
        int coefrr = 0;
        int coefd = 0;
        int exprr = 0;
        int expd = 0;
        int coefope = 0;
        int expope = 0;
        int cont = 0;
        coefrr = rr.getTermino().getCoef();//--->trae el coef del termino a que se convertira en el residuo
        exprr = rr.getTermino().getExp();////--->trae el exp del termino a que se convertira en el residuo
        coefd = rd.getTermino().getCoef();//--->trae el coeficiente del termino divisor
        expd = rd.getTermino().getExp();//--->trae el exponente del termino divisor
        
        if(coefrr >= coefd && exprr >= expd){//--->controla que la divicion se pueda llevar a cabo
            while(exprr >= expd || rr != null){
                while (rd != null){//--->ciclo que controla el primer recorrido
                    //System.out.println("una vez"+c.imprimirUno());
                    coefrr = rr.getTermino().getCoef();//--->trae el coef del termino a que se convertira en el residuo
                    exprr = rr.getTermino().getExp();//--->trae el exp del termino a que se convertira en el residuo
                    coefd = rd.getTermino().getCoef();//--->trae el coeficiente del termino divisor
                    expd = rd.getTermino().getExp();//--->trae el exponente del termino divisor
                    cont ++;//--->control para envio de un solo dato al cosiente 
                    if (cont == 1){
                         expope = exprr - expd;//--->hallamos la diferencia entre los coef el residuo y el divisor
                        coefope = coefrr / coefd;//--->hallamos la diferencia entre los exp el residuo y el divisor
                        c.addTermino(coefope, expope);//--->obtenemos el primer valor del cosiente
                    }
                    coefd = (coefope * coefd)* -1;//--->multiplicamos * -1 la suma del coefanterior
                                                    //con el del divisor
                    expd = (expope + expd);//--->sumamos el exp anterior con el del divisor
                    if((coefd*-1) == coefrr && expd==exprr){//--->valido si se elimina un termino
                        r.addTermino((coefd ), expd);//--->envio valor al residuo
                        rr = r.cabeza.retornaLiga();//--->como se elimino un termino reinicio el puntero
                    }
                    else{
                        r.addTermino((coefd ), expd);//--->envio valor al residuo
                        rr = rr.retornaLiga();//--->como no se elimino un termino avanzo en la lista
                    }
                    rd = rd.retornaLiga();//--->avanzo en la lizta de divisores
                }
                coefope = 0;//--->reinicio valores
                expope = 0;
                cont = 0;
                rr = r.cabeza.retornaLiga();
                rd = d.cabeza.retornaLiga();
                if(rr.getTermino().getExp() < rd.getTermino().getExp() || rr == null){//--->controlador de retorno de ciclo
                    break;                                                            //cuando el dividendo es de menor grado  
                }                                                                     //que el divisor.  
            }
              
            
        }
        else{//--->concatenando la clase StringBuilder
            infor.append("No se cumplen las condiciones para la division");
        }
        infoc = c.imprimirUno();//--->organizamos la informacion en un String Buider
        infoc.append("+ (");
        infor = r.imprimirUno();
        infor.append("/");
        infod = d.imprimirUno();
        infoc.insert(infoc.length(), infor);
        infoc.insert(infoc.length(), infod);
        infoc.append(")");
        
        return infoc;
    }

    
    
}
    






   
    
    











    

