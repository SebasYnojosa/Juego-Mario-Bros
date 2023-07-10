package menus;

import java.io.*;
import java.util.ArrayList;

public class ArchivoUsuario {
    private ObjectOutputStream salida; //Envia datos a un archivo
    private ObjectInputStream entrada;
    
    
    
    //Permite especificar nombre del archivo
    public void abrirArchivoEscritura() {
        try {
            salida = new ObjectOutputStream(new FileOutputStream("../Usuarios"));
        } catch (IOException exception) {
            System.err.println("Error al abrir el archivo");
            System.exit(1);
        }
    }
    
    public void agregarRegistros(Usuario registro){
         try {   
             salida.writeObject(registro);
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
        cerrarArchivo();
        try {
            entrada = new ObjectInputStream(new FileInputStream("../Usuarios"));
        } catch (IOException ex) {
            abrirArchivoEscritura();
            cerrarArchivo();
            System.err.println("Error al abrir archivo lectura");
            abrirArchivoLectura();
        }
    }
      public Usuario buscarRegistro(String user){
          abrirArchivoLectura();
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
      public void appendRegitros(Usuario registro){
        ArrayList<Usuario> lista = new ArrayList();
        abrirArchivoLectura();
        lista = leerArchivo(lista);
        abrirArchivoEscritura();
        for(Usuario user: lista){
            agregarRegistros(user);
        }
        agregarRegistros(registro);
        cerrarArchivo();
    }

      public void modificarRegistro(Usuario user){
          abrirArchivoLectura();
          ArrayList<Usuario> lista = new ArrayList();
          lista = leerArchivo(lista);
          abrirArchivoEscritura();
          for(Usuario u : lista){
              if(!user.getUsuario().equals(u.getUsuario())){
                  agregarRegistros(u);
              }else{
                  agregarRegistros(user);
              }
          }
          cerrarArchivo();
      }

    public ArrayList leerArchivo(ArrayList<Usuario> lista){
        abrirArchivoLectura();
        Usuario registro;
        try{
            while(true){
                registro=(Usuario) entrada.readObject();
                lista.add(registro);
            }
        }catch (EOFException endOfFileException) {
            return lista;//Se llego al fin de archivo
        } catch (ClassNotFoundException ex) {
            System.err.println("No se pudo crear el objeto");
        }catch(IOException ioException){
            System.err.println("Error al leer archivo xd");
            //ioException.printStackTrace();
        }
        return lista;
    }
}
