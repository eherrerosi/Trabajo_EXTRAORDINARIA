import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class App {
    public static void main(String[] args) throws Exception {
        Imobilia gestionImobilia;
        gestionImobilia = new Imobilia();

        Cliente c1;
        Calendar calendar = Calendar.getInstance();
        c1 = new Cliente("123456789T", "Eduardo", "Herreo Simón", "C/Almendro", "null@gmail.com", "699699699",
                calendar.getTime(), "edu89T", "cacahuete");
        System.out.println(c1);
        c1.setEmail("eduardohs@gmail.com");
        c1.setContrasena("doritos");

        gestionImobilia.setCliente(c1);
        System.out.println(c1);
        AgentInmobiliario p2;
        p2 = new AgentInmobiliario("123456789T", "Francisco Javier", "CAno gRanado",
                "C/Almendro", "null@gmail.com", "699699699",
                calendar.getTime(), 30000);// Inicializamos o instanciamos un objeto de la clase
        gestionImobilia.setAgente(p2);

        Propiedad p = new Propiedad(13, tipoPropiedad.PISO, 180000, "Palencia", "buen piso ubicado en zona cnetro...",
                "3 habitaciones 2 baños....");
        Propiedad p3 = new Propiedad(3, tipoPropiedad.CASA, 300000, "Palencia", "buena casa moderna ...",
                "2 plantas un patio ...");
        gestionImobilia.setPropiedad(p);
        gestionImobilia.setPropiedad(p3);
        System.out.println(gestionImobilia);
        boolean fin = false;
        boolean menuAgente = false;
        int opcion;
        Scanner teclado;// Scanner es un tipo de dato que se encarga de vincular mi teclado del
                        // ordenador con el programa
        teclado = new Scanner(System.in);
        // Le decimos a la variable teclado que trabaje con el sistema de entrada
        // (teclado)
        while (!fin) {
            menu();
            opcion = teclado.nextInt();
            switch (opcion)// Según el valor de opcion vamos a un case
            {
                case 1:
                    fin = true;
                    break;
                case 2:
                    verDatosPropiedasDesdeAgente(gestionImobilia);
                    break;
                case 3:
                    verDatosPropiedasDesdeCliente(gestionImobilia);
                    break;
                case 4:
                    anadirPropiedad(gestionImobilia);
                    break;
                case 5:
                    editarPropiedad(gestionImobilia);
                    break;
                case 6:
                    editarPersona(gestionImobilia);
                    break;
                case 7:
                    eliminarPropiedad(gestionImobilia);
                    break;
                case 8:
                    eliminarPersona(gestionImobilia);
                    break;
                case 9:
                    marcarPropiedadComoFavorita(gestionImobilia);
                    break;
                case 10:
                    desmarcarPropiedadComoFavorita(gestionImobilia);
                    break;
                case 11:
                    mostrarPropiedadesFavoritas(gestionImobilia);
                    break;
                case 12:
                    estadisticasPorZona(gestionImobilia);
                    break;
                case 13:
                    compararPropiedades(gestionImobilia);
                    break;
                case 15:
                    verHistorico(gestionImobilia);
                    break;
                default:
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("Seleccione una operación:");
        System.out.println("1.- Salir");
        System.out.println("2.- Buscar propiedad (agente)");
        System.out.println("3.- Buscar propiedad (cliente)");
        System.out.println("4.- Registrar propiedad (agente)");
        System.out.println("5.- Editar datos propiedad");
        System.out.println("6.- Editar datos Persona (tanto cliente como agente)");
        System.out.println("7.- Eliminar Propiedad");
        System.out.println("8.- Eliminar Persona");
        System.out.println("9.- Marcar Propiedad como favorita");
        System.out.println("10.- Desmarcar Propiedad como favorita");
        System.out.println("11.- Mostrar propiedades favoritas");
        System.out.println("12.- Mostrar estadísticas por zona (precio, ...)");
        System.out.println("13- Comparar dos propiedades");
        System.out.println("14.- Comprar propiedad");
        System.out.println("15.- Ver histórico operaciones");
        // System.out.println("15.- Agendar cita");
        // System.out.println("15.- Eliminar cita");
        // Cita DNI agente DNI cliente fecha
        System.out.print("Opcion seleccionada ->");
    }

    public static void verDatosPropiedasDesdeAgente(Imobilia imo) {
        System.out.print("\n Introduzca un código propiedad ->:");
        Scanner teclado;// Scanner es un tipo de dato que se encarga de vincular mi teclado del
                        // ordenador con el programa
        teclado = new Scanner(System.in);
        int codigo = teclado.nextInt();
        Propiedad p = imo.buscarPropiedad(codigo);
        if (p == null) {
            System.out.println(" El código de propiedad introducido no pertecene a ninguna propiedad del sistema");

        } else {
            System.out.println(p);
        }
    }

    public static void verDatosPropiedasDesdeCliente(Imobilia imo) {
        System.out.print("\n Introduzca una ubicación para buscar propiedades->");
        Scanner teclado;// Scanner es un tipo de dato que se encarga de vincular mi teclado del
                        // ordenador con el programa
        teclado = new Scanner(System.in);
        String ubi = teclado.nextLine();
        ArrayList<Propiedad> lPropiedades = imo.getLPropiedad();
        ArrayList<Propiedad> aux = new ArrayList<>();
        // Buscamos todas las propiedades de una ubicación
        for (int i = 0; i < lPropiedades.size(); i++) {
            Propiedad p = lPropiedades.get(i);
            if (p.getUbicacion().equalsIgnoreCase(ubi)) {
                aux.add(p);
            }
        }
        // Mostramos
        System.out.println("Mostramos los datos de las propiedades en la ubicación introducida:");
        for (Propiedad propiedad : aux)

        {
            System.out.println(propiedad);
        }
    }

    public static void anadirPropiedad(Imobilia imo) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("\nIntroduzca un código de propiedad:");
        int codigoPropiedad = teclado.nextInt();
        System.out.print("\nIntroduzca un tipo de propiedad 1.CASA 2.CHALET y 3.PISO:");
        int tipo = teclado.nextInt();
        tipoPropiedad tp = null;
        switch (tipo) {
            case 1:
                tp = tipoPropiedad.CASA;

                break;
            case 3:
                tp = tipoPropiedad.PISO;

                break;
            case 2:
                tp = tipoPropiedad.CHALET;

                break;
            default:
                break;
        }
        System.out.println("Introduzca el precio de la propiedad");
        float precio = teclado.nextFloat();
        // cuando pedimos un número 3.14\n, y luego una cadena ""
        teclado.nextLine();
        System.out.println("Introduzca una ubicación");
        String ubicacion = teclado.nextLine();
        System.out.println("Introduzca una descripción");
        String descripcion = teclado.nextLine();
        System.out.println("Introduzca una características Adicionales");
        String caracteristicasAdicionales = teclado.nextLine();

        Propiedad p = new Propiedad(codigoPropiedad, tp, precio, ubicacion, descripcion, caracteristicasAdicionales);
        imo.setPropiedad(p);
    }

    public static void editarPropiedad(Imobilia imo) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("\nIntroduzca un código de propiedad:");
        int codigoPropiedad = teclado.nextInt();
        Propiedad p = imo.buscarPropiedad(codigoPropiedad);

        System.out.print("\nIntroduzca un tipo de propiedad 1.CASA 2.CHALET y 3.PISO:");
        int tipo = teclado.nextInt();
        tipoPropiedad tp = null;
        switch (tipo) {
            case 1:
                tp = tipoPropiedad.CASA;

                break;
            case 3:
                tp = tipoPropiedad.PISO;

                break;
            case 2:
                tp = tipoPropiedad.CHALET;

                break;
            default:
                break;
        }
        System.out.println("Introduzca el precio de la propiedad");
        float precio = teclado.nextFloat();
        // cuando pedimos un número 3.14\n, y luego una cadena ""
        teclado.nextLine();
        System.out.println("Introduzca una ubicación");
        String ubicacion = teclado.nextLine();
        System.out.println("Introduzca una descripción");
        String descripcion = teclado.nextLine();
        System.out.println("Introduzca una características Adicionales");
        String caracteristicasAdicionales = teclado.nextLine();

        Propiedad p2 = new Propiedad(codigoPropiedad, tp, precio, ubicacion, descripcion, caracteristicasAdicionales);
        p = p2;
    }

    public static void editarPersona(Imobilia imo) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("\nIntroduzca el DNI:");
        String DNI = teclado.nextLine();
        Persona p = imo.buscarAgente(DNI);
        int tipo = 0;
        if (p == null) {
            p = imo.buscarCliente(DNI);
            tipo = 1;
        }

        if (p == null) {
            System.out.println("La persona no existe");
        } else {

            System.out.println("Introduzca el nombre: ");
            String nombre = teclado.nextLine();
            System.out.println("Introduzca los apellidos: ");
            String apellido = teclado.nextLine();
            System.out.println("Introduzca la dirección: ");
            String dirección = teclado.nextLine();
            System.out.println("Introduzca el email: ");
            String email = teclado.nextLine();
            Calendar calendar = Calendar.getInstance();
            if (tipo == 0) {
                System.out.println("Introduzca una salario:");
                float salario = teclado.nextFloat();
                p = new AgentInmobiliario(DNI, nombre, apellido, dirección, email, email, calendar.getTime(), salario);
            } else {
                System.out.println("Introduzca un usuario");
                String usuario = teclado.nextLine();
                System.out.println("Introduzca una constraseña");
                String password = teclado.nextLine();
                p = new Cliente(DNI, nombre, apellido, dirección, email, email, calendar.getTime(), usuario, password);
            }
        }

    }

    public static void eliminarPropiedad(Imobilia imo) {
        System.out.println("Introduzca un código de propiedad");
        Scanner teclado;
        teclado = new Scanner(System.in);
        int codigo = teclado.nextInt();
        if (imo.eliminarPropiedad(codigo))
            System.out.println("Propiedad elimina con éxito");
        else
            System.out.println("Error al eliminar");
    }

    public static void eliminarPersona(Imobilia imo) {
        System.out.println("Introduzca un DNI");
        Scanner teclado;
        teclado = new Scanner(System.in);
        String DNI = teclado.nextLine();
        if (imo.eliminarPersona(DNI))
            System.out.println("Persona elimina con éxito");
        else
            System.out.println("Error al eliminar");
    }

    public static void marcarPropiedadComoFavorita(Imobilia imo) {
        System.out.print("\n Introduzca un código propiedad ->:");
        Scanner teclado;// Scanner es un tipo de dato que se encarga de vincular mi teclado del
                        // ordenador con el programa
        teclado = new Scanner(System.in);
        int codigo = teclado.nextInt();
        if (imo.marcarComoFavorita(codigo)) {
            System.out.println(" Propiedad marcada como favorita");

        } else {
            System.out.println("Propiedad no encontra");
        }
    }

    public static void desmarcarPropiedadComoFavorita(Imobilia imo) {
        System.out.print("\n Introduzca un código propiedad ->:");
        Scanner teclado;// Scanner es un tipo de dato que se encarga de vincular mi teclado del
                        // ordenador con el programa
        teclado = new Scanner(System.in);
        int codigo = teclado.nextInt();
        if (imo.desmarcarPropiedadFavorita(codigo)) {
            System.out.println(" Propiedad marcada como favorita");

        } else {
            System.out.println("Propiedad no encontra");
        }
    }

    public static void mostrarPropiedadesFavoritas(Imobilia imo) {
        ArrayList<Propiedad> lPropiedades = imo.getLPropiedad();
        ArrayList<Propiedad> lPropiedadesFavoritas = new ArrayList<>();
        for (Propiedad propiedad : lPropiedadesFavoritas) {
            if (propiedad.isFavorita()) {
                lPropiedadesFavoritas.add(propiedad);
            }
        }
        System.out.println("Mostrando las propiedades Favoritas: ");
        for (Propiedad propiedad : lPropiedadesFavoritas) {
            System.out.println(propiedad);
        }

    }

    public static void estadisticasPorZona(Imobilia imo) {
        System.out.print("\n Introduzca una ubicación para buscar propiedades->");
        Scanner teclado;// Scanner es un tipo de dato que se encarga de vincular mi teclado del
                        // ordenador con el programa
        teclado = new Scanner(System.in);
        String ubi = teclado.nextLine();
        ArrayList<Propiedad> lPropiedades = imo.getLPropiedad();
        ArrayList<Propiedad> aux = new ArrayList<>();
        // Buscamos todas las propiedades de una ubicación
        for (int i = 0; i < lPropiedades.size(); i++) {
            Propiedad p = lPropiedades.get(i);
            if (p.getUbicacion().equalsIgnoreCase(ubi)) {
                aux.add(p);
            }
        }
        float precioMedio = 0;
        for (Propiedad propiedad : aux) {

            precioMedio += propiedad.getPrecio();
        }
        precioMedio /= aux.size();// precioMedio = precioMedio / aux.size();
        System.out.println("El precio medio de la zona es: " + precioMedio);
    }

    public static void compararPropiedades(Imobilia imo) {
        System.out.print("\n Introduzca un código propiedad 1 ->:");
        Scanner teclado;// Scanner es un tipo de dato que se encarga de vincular mi teclado del
                        // ordenador con el programa
        teclado = new Scanner(System.in);
        int codigo1 = teclado.nextInt();
        Propiedad p1 = imo.buscarPropiedad(codigo);
        System.out.print("\n Introduzca un código propiedad 2 ->:");
        int codigo2 = teclado.nextInt();
        Propiedad p2 = imo.buscarPropiedad(codigo);
        System.out.println("Comparamos las dos propiedades");
        System.out.println("Tipo: " + "P1: " + p1.getTipo() + "P2: " + p2.getTipo());
        System.out.println("Precio: " + "P1: " + p1.getPrecio() + "P2: " + p2.getPrecio());
        System.out.println("Descripción: " + "P1: " + p1.getDescripcion() + "P2: " + p2.getDescripcion());
    }

    public static void verHistorico(Imobilia imo) {
        ArrayList<Transaccion> lOperaciones = imo.getlOperaciones();
        System.out.println("Mostramos el histórico: ");
        for (Transaccion transaccion : lOperaciones) {
            System.out.println(transaccion);
        }
    }
}
