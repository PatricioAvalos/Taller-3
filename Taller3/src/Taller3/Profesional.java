package Taller3;

/**
 * Clase Profesional
 */
public class Profesional extends Persona {
    
    // Atributos
    private int sueldo;
    private int aniostrabajo;
    
    // Constructor
    public Profesional(int cod, String nom, String ap, int ed, int su, int at){
        super(cod,nom,ap,ed);  
        sueldo = su;
        aniostrabajo = at;      
    }
    
    // Funcion que verifica la aprobación de un credito para un Profesional
    public boolean aprobracionCredito(Credito c){
        int monto = c.getMontoSolicitado();
        
        // Si cumple las condiciones se aprueba, caso contrario no se aprueba
        if(sueldo < monto*0.2 || aniostrabajo < 2){
           return false;
        }
        else{
          return true;      
        }
    
    }
    
    // Getters y Setters
    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getAniostrabajo() {
        return aniostrabajo;
    }

    public void setAniostrabajo(int aniostrabajo) {
        this.aniostrabajo = aniostrabajo;
    }
    
    

    
    
}
