package menus;
import java.io.Serializable;

public class Usuario implements Serializable{
    //Atributos
    private String nombre, usuario, correo, contra;
    private int avatar, pJugadas, pGanadas, pPerdidas, pAbandonadas;
    
    //<editor-fold desc="constructores">
    public Usuario() {
        this.nombre = this.usuario = this.correo = this.contra = "";
        this.avatar = pGanadas = pPerdidas = pAbandonadas = 0;
    }

    public Usuario(String nombre, String usuario, String correo, String contra, int avatar) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.correo = correo;
        this.contra = contra;
        this.avatar = avatar;
        pGanadas = pPerdidas = pAbandonadas = 0;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Sets y Gets">   
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContra() {
        return contra;
    }
    public void setContra(String contra) {
        this.contra = contra;
    }
    public int getAvatar() {
        return avatar;
    }
    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
    public int getpGanadas() {
        return pGanadas;
    }
    public void setpGanadas(int pGanadas) {
        this.pGanadas = pGanadas;
    }
    public int getpPerdidas() {
        return pPerdidas;
    }
    public void setpPerdidas(int pPerdidas) {
        this.pPerdidas = pPerdidas;
    }
    public int getpAbandonadas() {
        return pAbandonadas;
    }
    public void setpAbandonadas(int pAbandonadas) {
        this.pAbandonadas = pAbandonadas;
    }
    public int getpJugadas() {
        return pJugadas;
    }
    public void setpJugadas(int pJugadas) {
        this.pJugadas = pJugadas;
    }   
    // </editor-fold>      
}
