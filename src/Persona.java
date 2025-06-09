import java.util.Date;

//Clase base de mi proyecto, tiene todos los datos de las personas ya vayan a ser cliente o agentes
public class Persona {
    private String DNI;
    private String Nombre;
    private String Apellidos;
    private String direccion;
    private String email;
    private String telefono;
    private Date fechaNacimiento;

    public Persona(String dNI, String nombre, String apellidos, String direccion, String email, String telefono,
            Date fechaNacimiento) {
        DNI = dNI;
        Nombre = nombre;
        Apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {// toString de la clase base en las hijas lo ampliaremos
        return "Persona [DNI=" + DNI + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", direccion=" + direccion
                + ", email=" + email + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + "]";
    }
}
