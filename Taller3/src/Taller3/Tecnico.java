package Taller3;

/**
 * Clase Tecnico
 */
public class Tecnico extends Persona {
    
    // Atributos
    private int sueldo;
    private int gastos;
    
    // Constructor
    public Tecnico(int cod, String nom, String ap, int ed, int su, int ga){
        super(cod,nom,ap,ed);  
        sueldo = su;
        gastos = ga;      
    }
    
    // Funcion que verifica la aprobación de un credito para un Tecnico
    public boolean aprobracionCredito(Credito c){
        
        int monto = c.getMontoSolicitado();
        int resultado = sueldo - gastos;
        
        // Si cumple las condiciones se aprueba, caso contrario no se aprueba
        if(resultado < monto*0.15){
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

    public int getGastos() {
        return gastos;
    }

    public void setGastos(int gastos) {
        this.gastos = gastos;
    }
    
    
}
