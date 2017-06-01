package Taller3;

import ucn.StdOut;

/**
 * Lista de Creditos
 */
public class ListaCreditos {
    
    // Atributos
    private Credito [] lc;
    private int cantCreditos;
    private int max;
    
    // Constructor de la lista de creditos
    public ListaCreditos(int max){
        this.max = max;
        lc = new Credito[max];
        cantCreditos = 0;
    }
    
   // Get para obtener la cant. de creditos de la lista 
   public int getCantCreditos (){
       return cantCreditos;
   }
   
   // Funcion para ingresar creditos a la lista
   public boolean ingresarCreditos (Credito c){
       if(cantCreditos < max){
           lc [cantCreditos] = c;
           cantCreditos++;
           return true;
       }else{
           return false;
       }
   }
   
   // Funcion para buscar un credito en la lista con un codigo
   public Credito buscarCredito (int cod) {
       int i;
       for(i = 0; i < cantCreditos; i++){
           if(lc[i].getCodigo() == cod){
               break;
           }
       }
       if (i == cantCreditos){
          return null;
       }else{
            return lc[i];
       }

   }
   
   // Funcion para obtener la posicion I de un credito de la lista
   public Credito getCreditoI(int i){
       if(i < cantCreditos && i >= 0){
           return lc[i];
       }else{
            return null;
       }
   }
   
   // Funcion para eliminar un credito de la lista
   public boolean eliminar(int cod) {

    int i;
    for(i=0; i< cantCreditos; i++){
       if(lc[i].getCodigo()== cod) {
          break;
        }
    }
    if(i== cantCreditos) { 
       return false;
    }
    else { 
       for(int j=i; j< cantCreditos - 1; j++) {
           lc[j] = lc[j+1];
       } 
          cantCreditos --; 
          StdOut.println("Se eliminó el código correctamente");
          StdOut.println("------------------");
          return true; 
       } 
    }
   
   // Funcion para ordenar los creditos de la lista de forma ascendente
   // (menor a mayor).
   public void OrdenarC(){
   for (int i = 0; i<cantCreditos; i++) {
        for (int j = 0; j<cantCreditos && i != j; j++) {
                if(lc[i].getMontoSolicitado()<lc[j].getMontoSolicitado()){
                        Credito c = lc[i];
                        lc[i] = lc[j];
                        lc[j]= c ;
                        }   
            }
        }
    } 
    
}
