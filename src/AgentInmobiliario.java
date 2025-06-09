import java.util.Date;

//El Agente inmobiliario hereda de Persona, extiende.
public class AgentInmobiliario extends Persona {
    // Definimos los atributos AgenteInmobilario
    private float salario;
    private int bonus;

    // Métodos de la clase Agente Inmobiliario
    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void incBonus() {
        this.bonus++;
    }

    // Aunque calculemos el sueldo del agente con los bonus, también mostramos los
    // cálculos para ver si nos hemos equivocado en algo
    public float calcularSueldo() {
        float total = salario + bonus * 300;
        System.out.println("El sueldo del agente " + this.getDNI() + "es:");
        System.out.println("Base " + salario);
        System.out.println("Bonus " + bonus * 300);
        System.out.println("Total: " + total);
        return total;
    }

    public AgentInmobiliario(String dNI, String nombre, String apellidos, String direccion, String email,
            String telefono, Date fechaNacimiento, float salario) {
        // Llamamos al constructor de Persona y luego añadimos valor al atributo de
        // agende
        super(dNI, nombre, apellidos, direccion, email, telefono, fechaNacimiento);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    // Sobreescribimos el método toString del padre para ampliarlo con el del hijo
    @Override
    public String toString() {
        return "AgentInmobiliario [salario=" + salario + ", bonus=" + bonus + ", toString()=" + super.toString() + "]";
    }

}
