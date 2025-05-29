import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.DataFormatException;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * Persona p1;// Nos creamos una variable de persona;
         * Calendar calendar = Calendar.getInstance();
         * p1 = new Persona("123456789T", "Eduardo", "Herreo Simón", "C/Almendro",
         * "null@gmail.com", "699699699",
         * calendar.getTime());// Inicializamos o instanciamos un objeto de la clase
         * Persona
         * System.out.println(p1);// Mostramos por pantalla;
         * 
         * Persona p2;
         * p2 = new Persona("123456789T", "Francisco Javier", "CAno gRanado",
         * "C/Almendro", "null@gmail.com", "699699699",
         * calendar.getTime());// Inicializamos o instanciamos un objeto de la clase
         * Persona
         * System.out.println(p2);// Mostramos por pantalla;
         * 
         * // entre símbolos <> indicamos que es lo que va a guardar la lista en neustro
         * // caso personas
         * ArrayList<Persona> lpersonas;
         * lpersonas = new ArrayList<>();
         * 
         * lpersonas.add(p1);
         * lpersonas.add(p2);
         * 
         * System.out.println("Mostramos las personas que hay en la lista de personas: "
         * );
         * for (Persona persona : lpersonas) {
         * System.out.println(persona);
         * 
         * }
         */
        Cliente c1;
        Calendar calendar = Calendar.getInstance();
        c1 = new Cliente("123456789T", "Eduardo", "Herreo Simón", "C/Almendro", "null@gmail.com", "699699699",
                calendar.getTime(), "edu89T", "cacahuete");
        System.out.println(c1);
        c1.setEmail("eduardohs@gmail.com");
        c1.setContrasena("doritos");
        System.out.println(c1);
        Persona p2;
        p2 = new Persona("123456789T", "Francisco Javier", "CAno gRanado",
                "C/Almendro", "null@gmail.com", "699699699",
                calendar.getTime());// Inicializamos o instanciamos un objeto de la clase
        System.out.println(p2);// Mostramos por pantalla;
        p2.setUsuario("");

    }
}
