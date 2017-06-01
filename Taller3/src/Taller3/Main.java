package Taller3;

// Importacion de librerias
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import ucn.StdOut;


public class Main {
 public static void main(String[] args) throws IOException  {
     
    App app = new App();
       
    app.leerPersonas();
    app.leerCreditos();

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  
    StdOut.println(" Taller 3: Banco");
    StdOut.println(" (1) - RF1: Despliegue de todas las personas registradas. ");
    StdOut.println(" (2) - RF2: Despliegue de datos de una persona. " );
    StdOut.println(" (3) - RF3: Despligue de datos y estado de un credito. " );
    StdOut.println(" (4) - RF4: Eliminacion de una persona del registro. " );
    StdOut.println(" (5) - RF5: Eliminacion de un credito. " );
    StdOut.println(" (6) - RF6: Ingresar un nuevo credito. " );
    StdOut.println(" (7) - RF7: Ingresar un nuevo cliente. " );              
    StdOut.println(" (8) - Salir. " );
    
    int op;
        do{  
            StdOut.println("\nIngrese una opción del menú: " );
            op = Integer.parseInt(bf.readLine()); 
            switch(op){
                
                case 1: 
                    app.RF1(); 
                    break;
                case 2:
                    app.RF2(); 
                    break;
                case 3:
                    app.RF3();
                    break;
                case 4:
                    app.RF4();
                    break;
                case 5:
                    app.RF5();
                    break;    
                case 6:
                    app.RF6();
                    break;
                case 7:
                    app.RF7();
                    break;
                case 8:
                default:
                    StdOut.println("\nUsted está saliendo del menú..." );
                    break;               
            }
            }while( op != 8 );
  } 
}

