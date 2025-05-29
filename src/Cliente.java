
//Decimos que Cliente hereda de Persona, es decir,

import java.util.Date;

public class Cliente extends Persona {
    private String usuario;
    private String contrasena;

    public Cliente(String dNI, String nombre, String apellidos, String direccion, String email, String telefono,
            Date fechaNacimiento, String usuario, String contrasena) {
        super(dNI, nombre, apellidos, direccion, email, telefono, fechaNacimiento);// Llamamos al constructor de Persona
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Cliente [usuario=" + usuario + ", contrasena=" + contrasena + "]" + super.toString();// Le concatenamos
                                                                                                     // el toString de
                                                                                                     // Persona
    }

}
