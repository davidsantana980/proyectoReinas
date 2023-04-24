/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoreinasbeans;
import javax.swing.JOptionPane;
/**
 *
 * @author david
 */
public class Pila <Tipo>{
    private class Nodo<T>{
        T info;
        Nodo<T> siguiente;
        public Nodo(T info) {
            this.info = info;
            this.siguiente = null;
        }
    }

    private Nodo<Tipo> top;
    private int elementos;

    Pila(){
        top = null;
        elementos = 0;
    }

    public void push(Tipo x){
        try {
            Nodo<Tipo> nuevoNodo = new Nodo<Tipo>(x);
            nuevoNodo.siguiente = top;
            elementos++;
            top = nuevoNodo; 
        } catch (Exception e) {
            throw e;
        }

    }

    public void muestraTodo(){
        try {
            Nodo<Tipo> copia = top;
            while(copia != null){
                JOptionPane.showMessageDialog(null, copia.info);
                copia = copia.siguiente;
            }     
        } catch (Exception e) {
            throw e;
        }

    }

    public Tipo top(){
        try {
            return top.info;    
        } catch (Exception e) {
            throw e;
        }
    }

    public Tipo pop(){
        try {
            Tipo infoEliminada;
            infoEliminada = top.info;
            top = top.siguiente;
            elementos--;
            return infoEliminada;
        } catch (Exception e) {
            throw e;
        }
    }
    public Tipo pop(int index) {
        try {
            Tipo infoEliminada;
            if (index == 0) {
                infoEliminada = this.pop();
            } else {
                Nodo<Tipo> nodo = top;
                for (int i = 0; i < index - 1 && nodo.siguiente != null; i++) {
                    nodo = nodo.siguiente;
                }
                infoEliminada = nodo.siguiente.info;
                elementos--;
                nodo.siguiente = nodo.siguiente.siguiente;
            }
    
            return infoEliminada;
        } catch (Exception e) {
            throw e;
        }
    }

    public void modifica(int indice, Tipo nuevoValor) {
        try {
            Nodo<Tipo> nodo = top;
            for (int i = 0; i < indice && nodo != null; i++) {
                nodo = nodo.siguiente;
            }
            nodo.info = nuevoValor;     
        } catch (Exception e) {
            throw e;
        }
    }   
    
    public Tipo elementoEnIndex(int indice) {
        try {
            if (indice < 0 || indice >= this.cantidadDeElementos()) {
                throw new IndexOutOfBoundsException();
            }
        
            Nodo<Tipo> nodo = top;
            for (int i = 0; i < indice && nodo != null; i++) {
                nodo = nodo.siguiente;
            }
            return nodo.info;
        } catch (Exception e) {
            throw e;
        }
    } 


    public int indiceDe(Tipo obj) {
        try {
            int pos = 1;
            for (Nodo<Tipo> nodo = top; nodo != null; nodo = nodo.siguiente) {
                if (nodo.info.equals(obj)) {
                    return pos;
                }
                pos++;
            }
            return -1;           
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean vacia(){
        try {
            return top == null;   
        } catch (Exception e) {
            throw e;
        }
    }

    public int cantidadDeElementos(){
        try {
            return elementos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void menu(){
        try {
            ejerciciosInstanciados e = new ejerciciosInstanciados();
            Pila<Integer> pila = new Pila<>();
            String mensaje = "";
            boolean deNuevo = true;

            while(deNuevo){  
                String opcion = JOptionPane.showInputDialog("Escribe uno de los comandos: \n'1' para el estado de la pila, \n'2'  para llenarla, \n'3' para ver su cantidad de elementos, \n\'4\' para ver su tope, \n\'5\' para eliminar un elemento, \n'6' para ver su contenido, \n\'7\' para modificar un elemento, \n'8' para buscar un elemento por indice, \n\'9\', para cerrar el menu pilas: ");
                switch(opcion){
                    case "1": 

                        String vacia = pila.vacia() ? "esta vacia" : "no esta vacia" ;
                        JOptionPane.showMessageDialog(null, "\nLa pila "+ vacia);

                        break;
                    case "2":

                        mensaje = "Introduce numeros a la pila, o introduce cualquier otro caracter para terminar: ";
                        boolean leer = true;
                        while(leer){
                                try {
                                    String input = JOptionPane.showInputDialog(null, mensaje);
                                    int numero = Integer.parseInt(input); 
                                    pila.push(numero);
                                } catch (NumberFormatException error) {     
                                    leer = false;
                                }
                        }

                        break;
                    case "3":

                        mensaje = "Hay "+ pila.cantidadDeElementos() + " elementos en la lista.";
                        JOptionPane.showMessageDialog(null, mensaje);

                        break;
                    case "4":

                        mensaje = "\nEl ultimo elemento de la lista es nulo";
                        if(!pila.vacia()){
                            mensaje = "El pico de la pila es " +  pila.top();
                        }     
                        JOptionPane.showMessageDialog(null, mensaje);

                        break;
                    case "5":
                        mensaje = "\nNo hay elementos que eliminar";

                        if(!pila.vacia()){
                            JOptionPane.showMessageDialog(null, "\nEscribe el indice del numero que quieres cambiar: ");
                            int index = e.numeroEntero();

                            while(index >= pila.cantidadDeElementos() || index < 0){
                                JOptionPane.showMessageDialog(null, "Ese indice es invalido! Intenta de nuevo:");
                                index = e.numeroEntero();
                            }

                            pila.pop(index);
                            mensaje = "\nEl numero ha sido eliminado.";
                        }                        
                    
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                    case "6": 
                        if(!pila.vacia()){
                            JOptionPane.showMessageDialog(null, "\nEl contenido de la pila es: \n");
                            pila.muestraTodo();
                        }else{
                            JOptionPane.showMessageDialog(null, "\nNo hay contenido que ver");
                        }

                        break;
                    case "7":
                        mensaje = "\nLa pila esta vacia";

                        if(!pila.vacia()){
                            JOptionPane.showMessageDialog(null, "Escribe el indice del numero que quieres cambiar: ");
                            int index = e.numeroEntero();

                            while(index >= pila.cantidadDeElementos() || index < 0){
                                JOptionPane.showMessageDialog(null, "Ese indice es invalido! Intenta de nuevo:");
                                index = e.numeroEntero();
                            }

                        JOptionPane.showMessageDialog(null, "Escribe el numero por el que quieres sustituir el elemento en el indice " + index + " (el valor actual en ese indice es "+ pila.elementoEnIndex(index)+"): ");
                        int nuevoNumero = e.numeroEntero();    

                            pila.modifica(index, nuevoNumero);

                            mensaje = "\nElemento correctamente modificado. Nuevo valor: " + nuevoNumero;
                        }     

                        JOptionPane.showMessageDialog(null, mensaje);    
                        break;
                    case "8":
                        mensaje = "\nNo hay elementos";
    
                        if(!pila.vacia()){
                            JOptionPane.showMessageDialog(null, "\nEscribe el indice del numero que buscas: ");
                            int index = e.numeroEntero();
    
                            while(index >= pila.cantidadDeElementos() || index < 0){
                                JOptionPane.showMessageDialog(null, "Ese indice es invalido! Intenta de nuevo:");
                                index = e.numeroEntero();
                            }
    
                            
                            mensaje = "\nEl numero es: " + pila.elementoEnIndex(index);
                        }                        
                        
                        JOptionPane.showMessageDialog(null, mensaje);
                        break;
                    case "9":
                        JOptionPane.showMessageDialog(null, "\nHasta pronto! ");
                        deNuevo = false;

                        break;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}