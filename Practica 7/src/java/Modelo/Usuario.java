
package Modelo;

public class Usuario {
    private String nombre, correo, contrasenia;
    private static Usuario user;
    
    private Usuario(){
    }
    
    public static Usuario getUser() {
       if(user == null){
          user = new Usuario();
       }
        return user;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia(){
        return contrasenia;

    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
