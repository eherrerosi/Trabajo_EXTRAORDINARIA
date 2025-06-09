
//Decimos que Cliente hereda de Persona, es decir,

import java.util.Date;

//Creamos al cliente que hereda de Persona
public class Cliente extends Persona {
    // Atributos propios del cliente
    private String usuario;
    private String contrasena;

    public Cliente(String dNI, String nombre, String apellidos, String direccion, String email, String telefono,
            Date fechaNacimiento, String usuario, String contrasena) {
        // Creamos el constructor parametrizcado llamando al del padre y, además, le
        // damos valores a los suyos propios
        super(dNI, nombre, apellidos, direccion, email, telefono, fechaNacimiento);
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

    @Override // Ampliamos el toString del padre añadiendo los atributos del hijo
    public String toString() {
        return "Cliente [usuario=" + usuario + ", contrasena=" + contrasena + "]" + super.toString();
    }

}
