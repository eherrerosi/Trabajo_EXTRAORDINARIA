import java.util.Date;

public class AgentInmobiliario extends Persona {
    private float salario;// número décimal precisión son 32 bits
                          // double => 64 bits

    public AgentInmobiliario(String dNI, String nombre, String apellidos, String direccion, String email,
            String telefono, Date fechaNacimiento, float salario) {
        super(dNI, nombre, apellidos, direccion, email, telefono, fechaNacimiento);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "AgentInmobiliario [salario=" + salario + ", toString()=" + super.toString() + "]";
    }
}
