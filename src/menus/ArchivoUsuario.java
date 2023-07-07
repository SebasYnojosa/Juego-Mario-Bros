package menus;

import java.io.*;

public class ArchivoUsuario {
    private ObjectOutputStream salida; //Envia datos a un archivo
    private ObjectInputStream entrada;
    
    
    
    //Permite especificar nombre del archivo
    public void abrirArchivoEscritura() {
        try {
            salida = new ObjectOutputStream(new FileOutputStream("../Usuarios.txt"));
        } catch (IOException exception) {
            System.err.println("Error al abrir el archivo");
            System.exit(1);
        }
    }
    
    public ObjectOutputStream abrirArchivoEscritura(String nombre) {
        ObjectOutputStream salidaArch;
        try {
            salidaArch = new ObjectOutputStream(new FileOutputStream(nombre));
            return salidaArch;
        } catch (IOException exception) {
            System.err.println("Error al abrir el archivo");
            System.exit(1);
        }
        return null;
    }
    
    public void agregarRegistros(Usuario registro){
         try {   
             salida.writeObject(registro);
        } catch (IOException ex) {
            System.err.println("Error al escribir en archivo");
        }
    }
    
    public void agregarRegistros(Usuario registro, ObjectOutputStream sal){
         try {   
             sal.writeObject(registro);
        } catch (IOException ex) {
            System.err.println("Error al escribir en archivo");
        }
    }
    
    public void cerrarArchivo(){
        try { 
            if (salida != null)
           
            salida.close();
        } catch (IOException ex) {
            System.err.println("Error al cerrar archivo");
            System.exit(1);
        }
    }
    
     
    
     public void abrirArchivoLectura() {
        try {
            entrada = new ObjectInputStream(new FileInputStream("../Usuarios.txt"));
        } catch (IOException ex) {
            System.err.println("Error al abrir archivo");
        }
        
       
       
    }
      public Usuario buscarRegistro(String user){
          Usuario registro;
          try{
              while(true){
                    registro=(Usuario) entrada.readObject();
                    if(registro.getUsuario().equals(user)){
                        return registro;
                    }
                }
            
          }catch (EOFException endOfFileException) {
                return null;//Se llego al fin de archivo
            } catch (ClassNotFoundException ex) {
                System.err.println("No se pudo crear el objeto");
            }
          catch(IOException ioException){
              System.err.println("Error al leer archivo");
              
            }catch(NullPointerException e){
              abrirArchivoEscritura();
            }
          return null;
      }
      
      public void modificarRegistro(Usuario user){
          abrirArchivoLectura();
          Usuario registro;
          ObjectOutputStream archAux = abrirArchivoEscritura("Aux.txt");
          
          File arch = new File("Usuarios.txt");
          File arch2 = new File("Aux.txt");
          try{
              while(true){
                    registro=(Usuario) entrada.readObject();
                    if(registro.getUsuario().equals(user.getUsuario())){
                        agregarRegistros(user,archAux);
                    }else{
                        agregarRegistros(registro,archAux);
                    }
                }
            
          }catch (EOFException endOfFileException) {
                arch2.renameTo(arch);
                return ;//Se llego al fin de archivo
            } catch (ClassNotFoundException ex) {
                System.err.println("No se pudo crear el objeto");
            }
          catch(IOException ioException){
              System.err.println("Error al leer archivo");
              
          }
      }
}
