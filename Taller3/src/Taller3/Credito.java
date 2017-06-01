package Taller3;

/**
 * Clase Credito
 */
public class Credito {
    
    // Atributos
    private int codigo;
    private int montoSolicitado;
    private double tasaInteres;
    private int cantCoutas;
    private Persona persona;
    
    // Constructor
    public Credito(int codigo, int montoSolicitado, double tasaInteres, int cantCoutas) {
        this.codigo = codigo;
        this.montoSolicitado = montoSolicitado;
        this.tasaInteres = tasaInteres;
        this.cantCoutas = cantCoutas;
        persona = null;
    }
    
    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(int montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(int tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public int getCantCoutas() {
        return cantCoutas;
    }

    public void setCantCoutas(int cantCoutas) {
        this.cantCoutas = cantCoutas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
    
    
}
