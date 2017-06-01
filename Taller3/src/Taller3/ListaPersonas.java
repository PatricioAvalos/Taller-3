package Taller3;

import ucn.StdOut;

/**
 * Lista de Personas
 */
public class ListaPersonas {
    
    // Atributos
    private Persona [] lp;
    private int cantPersonas;
    private int max;
    
    // Constructor
    public ListaPersonas(int max){
        this.max = max;
        lp = new Persona[max];
        cantPersonas = 0;
    }
   
   // Get para obtener la cant. de creditos de la lista  
   public int getCantPersonas (){
       return cantPersonas;
   }
   
   // Funcion para ingresar un Tecnico
   public void ingresaTecnico(int cod, String nom, String ap, int ed, int su, int ga){
   Persona t = new Tecnico(cod, nom, ap, ed, su, ga);
   this.ingresarPersonas(t);
   }
   
   // Funcion para ingresar un Profesional
   public void ingresaProfesional(int cod, String nom, String ap, int ed,  int su, int at){
   Persona p = new Profesional(cod, nom, ap, ed, su, at);
   this.ingresarPersonas(p);
   }
   
   // Funcion para ingresar un Estudiante
   public void ingresaEstudiante(int cod, String nom, String ap, int ed, int aa, int da){
   Persona e = new Estudiante(cod, nom, ap, ed, aa, da);
   this.ingresarPersonas(e);
   }
   
   // Funcion para ingresar personas a la lista
   public boolean ingresarPersonas (Persona p){
       if(cantPersonas < max){
           lp[cantPersonas] = p;
           cantPersonas++;
           return true;
       }else{
           return false;
       }
   }
   
   // Funcion para eliminar una persona usando un codigo
   public boolean eliminar(int cod) {
    int i;
    for(i=0; i< cantPersonas; i++){
       if(lp[i].getCodigo() == cod) {
          break;
        }
    }
    if(i== cantPersonas) { 
       return false;
    }
    else { 
       for(int j=i; j< cantPersonas - 1; j++) {
           lp[j] = lp[j+1];
       } 
          StdOut.println("Se eliminó la persona correctamente");
          StdOut.println("------------------");
          cantPersonas --; 
          return true; 
       } 
    }
   
   // Funcion para buscar una persona usando un codigo
   public Persona buscarPersona (int cod) {
       int i;
       for(i = 0; i < cantPersonas; i++){
           if(lp[i].getCodigo() == cod){
               break;
           }
       }
       if (i == cantPersonas){
          return null;
       }else{
            return lp[i];
       }

   }
   
   // Funcion para obtener la posicion I de una persona de la lista
   public Persona getPersonaI(int i){
       if(i < cantPersonas && i >= 0){
           return lp[i];
       }else{
            return null;
       }
   }
   
   // Funcion para ordenar las personas de una lista de A-Z
   public void Ordenar(){
   for (int i = 0; i<cantPersonas; i++) {
        for (int j = 0; j<cantPersonas && i != j; j++) {
                if(lp[i].getApellido().compareToIgnoreCase(lp[j].getApellido()) <0){
                        Persona p = lp[i];
                        lp[i] = lp[j];
                        lp[j]= p ;
                        }   
            }
        }
    }
    
}
