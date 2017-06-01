package Taller3;

/**
 * Clase Abstracta Persona
 */
public abstract class Persona {
    
    // Atributos
    private int codigo;
    private String nombre;
    private String apellido;
    private int edad;
    private ListaCreditos listaCreditos;
    
    // Constructor
    protected Persona(int cod, String nom, String ap, int ed){
        codigo = cod;
        nombre = nom;
        apellido = ap;
        edad = ed;
        listaCreditos = new ListaCreditos(1000);
    }
    
    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ListaCreditos getListaCreditos() {
        return listaCreditos;
    }

    public void setListaCreditos(ListaCreditos listaCreditos) {
        this.listaCreditos = listaCreditos;
    }
 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

   
    
    
}
