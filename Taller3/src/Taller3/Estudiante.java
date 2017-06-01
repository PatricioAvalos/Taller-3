package Taller3;

/**
 * Clase Estudiante
 */
public class Estudiante extends Persona {
    
    // Atributos
    private int anioactual;
    private int duracioncarrera;
    
    // Constructor
    public Estudiante(int cod, String nom, String ap, int ed, int aa, int da){
        super(cod,nom,ap,ed);  
        anioactual = aa;
        duracioncarrera = da;      
    }
    
    // Funcion que verifica la aprobación de un credito para un Estudiante
    public boolean aprobacionCredito(Credito c){
        
        int monto = c.getMontoSolicitado();
        int UF = 26600;
        int resultado = anioactual/duracioncarrera;
        
        // Si cumple las condiciones se aprueba, caso contrario no se aprueba
        if(resultado < 0.5 && monto < UF*20 || resultado >= 0.5 && monto < UF*40){
           return true;
        }
        else{
          return false;      
        }  
    
     } 
    
    // Getters y Setters
    public int getAnioactual() {
        return anioactual;
    }

    public void setAnioactual(int anioactual) {
        this.anioactual = anioactual;
    }

    public int getDuracioncarrera() {
        return duracioncarrera;
    }

    public void setDuracioncarrera(int duracioncarrera) {
        this.duracioncarrera = duracioncarrera;
    }
    
}
