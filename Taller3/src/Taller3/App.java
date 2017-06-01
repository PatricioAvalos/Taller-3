package Taller3;

// Importacion de librerias
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

// Inicialización de la App.
public class App implements IApp {
 
    private ListaPersonas listaPersonas;
    private ListaCreditos listaCreditos;
    
    // Inicialización de listas
    public App() {
        
        listaPersonas = new ListaPersonas(1000);
        listaCreditos = new ListaCreditos(1000);
        
    }
     
    /*
    * Método que lee los datos de los créditos de un archivo "personas.txt". 
    * De acuerdo a lo que diga en la cadena de Estudio, se instanciara el tipo
    * de persona (Técnico, profesional y estudiante)y se ingresara a aquella lista
    * de personas.
    */
    @Override        
    public void leerPersonas() {
             
        try {
            ArchivoEntrada in = new ArchivoEntrada("Personas.txt");
            while(!in.isEndFile()){
                Registro reg = in.getRegistro();
                
                int cod = reg.getInt();
                String nombre = reg.getString();
                String apellido = reg.getString();
                int edad = reg.getInt();
                String estudio = reg.getString();
                int datos1 = reg.getInt();
                int datos2 = reg.getInt();
                
                if(estudio.equals("tecnico")){                    
                   listaPersonas.ingresaTecnico(cod, nombre, apellido, edad, datos1, datos2);
                }
                if(estudio.equals("profesional")){                   
                   listaPersonas.ingresaProfesional(cod, nombre, apellido, edad, datos1, datos2);
                }
                if(estudio.equals("estudiante")){
                   listaPersonas.ingresaEstudiante(cod, nombre, apellido, edad, datos1, datos2);
                }
                                                
            }           
            //Ordena las Personas de A-Z
            listaPersonas.Ordenar();
            
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }

    }
      
    
    /*
    * Método que lee los datos de los créditos de un archivo "Creditos.txt" 
    * Se asocian inmediatamente con la persona, que se entrega como dato y luego
    * se guarda en un contedor general de creditos.
    */
    @Override
    public void leerCreditos () {
        try {
            
            FileReader f = new FileReader("creditos.txt");
            BufferedReader  br = new BufferedReader(f);
            
            String linea;
            
            while((linea=br.readLine())!=null){
                String[] campos = linea.split(";");
   
                int cod = Integer.parseInt(campos[0]);
                int montosolicitado = Integer.parseInt(campos[1]);
                int persona = Integer.parseInt(campos[2]);
                String valueStr = campos[3];
                valueStr = valueStr.replace(',', '.');
                double interes = Double.parseDouble(valueStr);

                int cantcuotas = Integer.parseInt(campos[4]);

                Credito c = new Credito(cod,montosolicitado,interes,cantcuotas);
                // Se busca la persona según el código "persona" dado en el txt, en la lista general de personas
                Persona p = listaPersonas.buscarPersona(persona);
                // Se acocia el credito con la persona encontrada en la lista
                c.setPersona(p);
                p.getListaCreditos().ingresarCreditos(c);
                listaCreditos.ingresarCreditos(c);                               
            }
            //Ordena los montos solicitados de la lista de creditos 
            //en forma ascendente
            listaCreditos.OrdenarC();
            
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
    } 
    
   
   
    /*
    *  Método que permite obtener los datos de una persona según el código ingresado por pantalla.  
    *  Esto incluye la información de los créditos aprobados de cada persona.
    */
    @Override
    public void RF1(){
        
        int j,i;
        for(j=0 ;j<listaPersonas.getCantPersonas();j++){
        Persona p = listaPersonas.getPersonaI(j);
        
        
        if(p instanceof Tecnico){
        Tecnico t = (Tecnico)p;    
        StdOut.println("\nCodigo: " +t.getCodigo()+"\nNombre:  "+t.getNombre()
                       +" "+t.getApellido()+"\nEdad: " + t.getEdad() +"\nEstudios: Tecnico \n");
        
        ListaCreditos lc = t.getListaCreditos();
        int cc = lc.getCantCreditos();
        // Si tiene créditos asociados y además aprobados se mostraran los datos de estos. 
        if(cc > 0){

            for(i=0; i<cc ; i++){
               
                Credito c = lc.getCreditoI(i);
                if (t.aprobracionCredito(c) == true){
                   StdOut.println("   Tasa interés: " + c.getTasaInteres()); 
                   StdOut.println("   Monto solicitado: " + c.getMontoSolicitado()); 
                   StdOut.println("   Cantidad Coutas: " + c.getCantCoutas()); 
                   StdOut.println("   --------------------------- ");
                }           
             }
           }        
        }    
        if(p instanceof Profesional){
        Profesional pr = (Profesional)p; 
        StdOut.println("\nCodigo: " +p.getCodigo()+"\nNombre:  "+p.getNombre()
                       +" "+p.getApellido()+"\nEdad: " + p.getEdad() +"\nEstudios: Profesional \n");
        
        
        ListaCreditos lc = pr.getListaCreditos();
        int cc = lc.getCantCreditos();

           if(cc > 0){
           for(i=0; i<cc ; i++){
               
               Credito c = lc.getCreditoI(i);
               if (pr.aprobracionCredito(c) == true){
                 StdOut.println(" Tasa interés: " + c.getTasaInteres()); 
                 StdOut.println(" Monto solicitado: " + c.getMontoSolicitado()); 
                 StdOut.println(" Cantidad Coutas: " + c.getCantCoutas()); 
                 StdOut.println(" --------------------------- ");
               }         
           }
           }
        }  
     
        if(p instanceof Estudiante){
        Estudiante e = (Estudiante)p;     
        StdOut.println("\nCodigo: " +e.getCodigo()+"\nNombre:  "+e.getNombre()
                       +" "+e.getApellido()+"\nEdad: " + e.getEdad() +"\nEstudios: Estudiante \n");
        
        ListaCreditos lc = e.getListaCreditos();
        int cc = lc.getCantCreditos();
               
        if(cc > 0){
           for(i=0; i<cc ; i++){
               
               Credito c = lc.getCreditoI(i);
               if (e.aprobacionCredito(c) == true){
                 StdOut.println(" Tasa interés: " + c.getTasaInteres()); 
                 StdOut.println(" Monto solicitado: " + c.getMontoSolicitado()); 
                 StdOut.println(" Cantidad Coutas: " + c.getCantCoutas()); 
                 StdOut.println(" --------------------------- ");
               }
           } 
        }
        }                  
      }    
    }
    
    /*
    *  Método que permite obtener los datos de una persona según el código ingresado por pantalla.
    *  Se mostrarán los créditos asociados de cada persona
    */
    
    @Override
    public void RF2(){
             
        int i;
        StdOut.println("\nIngrese código de una persona para obtener sus datos: ");
        int cod = StdIn.readInt();
        Persona p = listaPersonas.buscarPersona(cod);
        
        
        if(p instanceof Tecnico){
        Tecnico t = (Tecnico)p;    
        StdOut.println("\nCodigo: " +t.getCodigo()+"\nNombre: "+t.getNombre()
                       +" "+t.getApellido()+"\nEdad: " + t.getEdad() +"\nEstudios: Tecnico \n");
        StdOut.println(" -------CREDITOS-------- ");   
        
        ListaCreditos lc = t.getListaCreditos();
        int cc = lc.getCantCreditos();
        //Despliega de los créditos asociado de la persona

           for(i=0; i<cc ; i++){
               
                Credito c = lc.getCreditoI(i);
             
                StdOut.println(" Tasa interés: " + c.getTasaInteres()); 
                StdOut.println(" Monto solicitado: " + c.getMontoSolicitado()); 
                StdOut.println(" Cantidad Coutas: " + c.getCantCoutas()); 
                StdOut.println(" --------------------------- ");            
           }
        }
          
        if(p instanceof Profesional){
        Profesional pr = (Profesional)p; 
        StdOut.println(pr.getCodigo()+" - "+pr.getNombre()
                       +" - "+pr.getApellido()+" - "+"Profesional "+"\n");
               
        ListaCreditos lc = pr.getListaCreditos();
        int cc = lc.getCantCreditos();

           for(i=0; i<cc ; i++){
               
                Credito c = lc.getCreditoI(i);
              
                StdOut.println(" Tasa interés: " + c.getTasaInteres()); 
                StdOut.println(" Monto solicitado: " + c.getMontoSolicitado()); 
                StdOut.println(" Cantidad Coutas: " + c.getCantCoutas()); 
                StdOut.println(" --------------------------- ");             
           }
        }    
        if(p instanceof Estudiante){
        Estudiante e = (Estudiante)p;     
        StdOut.println(e.getCodigo()+" - "+e.getNombre()
                       +" - "+e.getApellido()+" - "+"Estudiante "+"\n");
        
        ListaCreditos lc = e.getListaCreditos();
        int cc = lc.getCantCreditos();

            for(i=0; i<cc ; i++){
                
                Credito c = lc.getCreditoI(i);
              
                StdOut.println(" Tasa interés: " + c.getTasaInteres()); 
                StdOut.println(" Monto solicitado: " + c.getMontoSolicitado()); 
                StdOut.println(" Cantidad Coutas: " + c.getCantCoutas()); 
                StdOut.println(" --------------------------- ");
              
           }      
        }                
    }
       
    /*
    *    Método que busca un código de un crédito (en la lista de créditos)ingresado por pantalla y 
    *    determina si fue aprobado según el metodo particular "aprobacionCredito" segun el tipo de persona.    
    */
    @Override
    public void RF3(){
        
        
        StdOut.println("Ingrese codigo de un credito: ");
        int codcre = StdIn.readInt();
        Credito c = listaCreditos.buscarCredito(codcre);
        Persona p = c.getPersona();
        StdOut.println("Nombre: "+ p.getNombre() + " "+ p.getApellido() );
        
        if(p instanceof Tecnico){
        Tecnico t = (Tecnico)p; 
             if (t.aprobracionCredito(c) == true){
                StdOut.println("El crédito fue aprobado.");        
             }
             else{
                StdOut.println("El crédito fue rechazo.");
             }
        }    
        
        if(p instanceof Profesional){
             Profesional pr = (Profesional)p; 
             if (pr.aprobracionCredito(c) == true){
                StdOut.println("El crédito fue aprobado.");        
             }
             else{
                StdOut.println("El crédito fue rechazo.");
             }
         }
        
        if(p instanceof Estudiante){
        Estudiante e = (Estudiante)p;  
             if (e.aprobacionCredito(c) == true){
                StdOut.println("El crédito fue aprobado.");        
             }
             else{
                StdOut.println("El crédito fue rechazo.");
             }
         }        
    }

    /*
    * Función que elimina una persona de la lista según un codigo ingresado por pantalla.
    */
    @Override
    public void RF4(){
        
        StdOut.println("Ingrese código de la persona a eliminar");
        int cod = StdIn.readInt();
        Persona p = listaPersonas.buscarPersona(cod);
        
        if(p!= null){
           listaPersonas.eliminar(cod);       
        }
        else{           
           StdOut.println("El código ingresado no es encuentra en la base de datos");  
           StdOut.println("-----------------------"); 
           
        }
              
    }
    
    /*
    * Método que elimina un crédito ingresado por pantalla, se procedera a buscar en la lista
    * de personas en busca de que despues de eliminado el crédito, algun credito restante.
      Si no tiene más créditos restantes se eliminará la persona. 
    */
    @Override
    public void RF5() {
        
        StdOut.println("Ingrese código del crédito a eliminar");
        int cod = StdIn.readInt();
        Credito c = listaCreditos.buscarCredito(cod);
        
        if(c != null){
           listaCreditos.eliminar(cod);       
        }
        else{           
           StdOut.println("El código ingresado no es encuentra en la base de datos");  
           StdOut.println("-----------------------");  
        }
        
        /* Se recorre la lista de personas. Se eliminara de la lista general de persona si al buscar 
         * el crédito eliminado ya no existe (retorna null) y si la cantidad de creditos asociado es 0.
         */
        for(int i=0; i< listaPersonas.getCantPersonas(); i++){
            
            Persona p = listaPersonas.getPersonaI(i);
            int codPersona = p.getCodigo();
            
            if (p.getListaCreditos().buscarCredito(cod) == null && 
                p.getListaCreditos().getCantCreditos() == 0) {
          
            listaPersonas.eliminar(codPersona);
            StdOut.println("Ingrese código del crédito a eliminar \n");  
          
            }
        }
    }
    
    /*
    *  Método que ingresa un nuevo crédito por teclado, pidiendo primero el 
    *  codigo de la persona solicitante. Si existe la personas en los registros  
    *  del banco se procedera a ingresar el credito a la persona, 
    *  solicitando los datos correspondientes.
    *  Se cancelará el ingreso del credito si la persona cuenta con 10 creditos.
    */ 
    @Override
    public void RF6() {
        StdOut.println("\nIngrese el código de la persona solicitante: ");
        int codper = StdIn.readInt();
        Persona per = listaPersonas.buscarPersona(codper);
        
        // Se verificará si la persona no tiene mas de 10 creditos
        // con un contador.
        int ver10cred = 0;
        for(int i = 0;i<(listaCreditos.getCantCreditos());i++){
            int x = listaCreditos.getCreditoI(i).getPersona().getCodigo();
            if(codper == x){
            ver10cred++;
            }
        }

        // Se realiza el ingreso del credito si la persona existe
        // en los registros y si no tiene mas de 10 creditos
        if(per!=null||(ver10cred<10)){
            int totalcreditoslis = listaCreditos.getCantCreditos();
            int totalcreditosmas = totalcreditoslis + 1;
            
            StdOut.println("\n---PERSONA EXISTENTE EN EL SISTEMA---");
            StdOut.println("Ingrese monto a solicitar: ");
            int monto = StdIn.readInt();
            
            StdOut.println("\nIngrese cantidad de cuotas: ");
            int cuotas = StdIn.readInt();            
            
            double tasa;
            do{StdOut.println("\nIngrese tasa de interés entre 0% y 30%: ");
                tasa = StdIn.readDouble();
            }while(tasa>30||tasa<0);//do-while que limita entre 0% y 30% la tasa
            
            Credito c = new Credito(totalcreditosmas,monto,tasa,cuotas);
            Persona p = listaPersonas.buscarPersona(codper);
            c.setPersona(p);
            listaCreditos.ingresarCreditos(c); 
            
            //Se ordena la lista de creditos
            listaCreditos.OrdenarC();
        }
        //En caso de que no exista
        else{StdOut.println("---PERSONA NO EXISTE EN EL SISTEMA---");
             StdOut.println(" Se cancela el ingreso de un nuevo crédito");
        }
    }
    
    /*
    *  Método que ingresa una persona por teclado, pidiendo todos los datos requeridos, si tiene
    *  un nivel de estudios en la lista, se pedirán los datos particulares de aquel tipo de persona.
    *  Se rechazará el ingreso de la persona si es menos de 18 años y si no tiene estudio. 
    */
    @Override
    public void RF7(){
        
        int cant = listaPersonas.getCantPersonas();
        
        if(cant < 100){
            
           StdOut.println("\nIngrese Nombre: ");
           String nom = StdIn.readString();
           StdOut.println("\nIngrese Apellido: ");
           String ape = StdIn.readString();
           StdOut.println("\nIngrese edad: ");
           int edad = StdIn.readInt();
              
           StdOut.println("\nIngrese nivel de estudios \n 1.- Técnico \n 2.- Profesional \n 3.- Estudiante \n 4.- Ninguno");
           int estudio = StdIn.readInt();
        
        
           if(edad < 18 || estudio == 4){
               StdOut.println("---LA PERSONA NO CUMPLE CON LOS REQUISITOS---");
            
           }
           else{
             switch(estudio){
                
                case 1: 
                    
                StdOut.println("\nIngrese Sueldo");
                int sueldo = StdIn.readInt();
                StdOut.println("\nIngrese Gastos");
                int gastos = StdIn.readInt();
                    
                listaPersonas.ingresaTecnico(cant, nom, ape, edad, sueldo, gastos);
                break;
                    
                case 2:  
                StdOut.println("\nIngrese Sueldo");
                int sueldo1 = StdIn.readInt();
                StdOut.println("\nIngrese Anios en el trabajo");
                int anios = StdIn.readInt();
                    
                listaPersonas.ingresaProfesional(cant, nom, ape, edad, sueldo1, anios);
                break;          

                case 3:
                    
                StdOut.println("\nIngrese Anios actual carrera");
                int aniosc = StdIn.readInt();
                StdOut.println("\nIngrese Duración carrera");
                int duracion = StdIn.readInt();
                    
                listaPersonas.ingresaEstudiante(cant, nom, ape, edad, aniosc, duracion);
                break;                     
                  
                }     
            } 
         }
        //Ordena las Personas de A-Z
            listaPersonas.Ordenar();
    }
   
}