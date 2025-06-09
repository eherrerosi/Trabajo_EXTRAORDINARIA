import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class App {
    public static void main(String[] args) throws Exception {

        // He creado varios objetos para probar el funcionamiento de las clases.
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
        p2 = new AgentInmobiliario("987654321Z", "José ", "Fernández Gutiérrez",
                "C/Guadalquivir", "null@gmail.com", "699699699",
                calendar.getTime(), 30000);// Inicializamos o instanciamos un objeto de la clase
        gestionImobilia.setAgente(p2);

        Propiedad p = new Propiedad(13, tipoPropiedad.PISO, 180000, "Palencia", "buen piso ubicado en zona cnetro...",
                "3 habitaciones 2 baños....");
        Propiedad p3 = new Propiedad(3, tipoPropiedad.CASA, 300000, "Salamanca", "buena casa moderna ...",
                "2 plantas un patio ...");
        gestionImobilia.setPropiedad(p);
        gestionImobilia.setPropiedad(p3);
        System.out.println(gestionImobilia);
        boolean fin = false;
        boolean menuAgente = false;
        int opcion;

        Scanner teclado;
        teclado = new Scanner(System.in);

        while (!fin) // Bucle de la aplicación solamente terminaremos cuando le demos a salir
        {
            menu();// Muestro el menú con todas las opciones del sistema
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
                case 14:
                    comprarPropiedad(gestionImobilia);
                    break;
                case 15:
                    verHistorico(gestionImobilia);
                    break;
                case 16:
                    cambiarContrasena(gestionImobilia);
                    break;
                case 17:
                    verPreguntasFrecuentes();
                    break;
                case 18:
                    enviarCorreoASoporte(gestionImobilia);
                    break;
                case 19:
                    calcularSueldoAgentes(gestionImobilia);
                    break;
                case 20:
                    asignarVentaAAgente(gestionImobilia);
                    break;
                case 21:
                    mostrarPropiedadesEnRango(gestionImobilia);
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
        System.out.println("13-  Comparar dos propiedades");
        System.out.println("14.- Comprar propiedad");
        System.out.println("15.- Ver histórico operaciones");
        System.out.println("16.- Cambiar contraseña");
        System.out.println("17.- Ver Preguntas frecuentes");
        System.out.println("18.- Enviar correo a soporte técnico");
        System.out.println("19.- Calcular sueldos Agentes");
        System.out.println("20.- Asignar venta a Agente");
        System.out.println("21.- Mostrar propiedades en una franja de precio");
        System.out.print("Opcion seleccionada ->");
    }

    public static void verDatosPropiedasDesdeAgente(Imobilia imo) {
        // El agente busca las propiedades por el código de esta
        System.out.print("\n Introduzca un código propiedad ->:");
        Scanner teclado;
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
        // Los clientes buscan las propiedades por su ubicación
        System.out.print("\n Introduzca una ubicación para buscar propiedades->");
        Scanner teclado;
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
        // Creamos una nueva propiedad, por lo tanto, necesito pedir todos los datos de
        // esta
        Scanner teclado = new Scanner(System.in);
        System.out.print("\nIntroduzca un código de propiedad:");
        int codigoPropiedad = teclado.nextInt();
        System.out.print("\nIntroduzca un tipo de propiedad 1.CASA 2.CHALET y 3.PISO:");
        int tipo = teclado.nextInt();
        tipoPropiedad tp = null;
        switch (tipo) {// Pasamos de la opción elegida al tipo de dato del enumerado
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
        // Para editar los datos de la propiedad, pedimos todos los datos de esta
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
            // Según el tipo de Persona tenemos que modificar un atributo u otro
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
        Scanner teclado;
        teclado = new Scanner(System.in);
        int codigo = teclado.nextInt();
        if (imo.marcarPropiedadFavorita(codigo)) {
            System.out.println(" Propiedad marcada como favorita");

        } else {
            System.out.println("Propiedad no encontra");
        }
    }

    public static void desmarcarPropiedadComoFavorita(Imobilia imo) {
        System.out.print("\n Introduzca un código propiedad ->:");
        Scanner teclado;
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
        // 1º Buscamos cuales son favoritas entre todas las propiedades
        for (Propiedad propiedad : lPropiedades) {
            if (propiedad.isFavorita()) {
                lPropiedadesFavoritas.add(propiedad);
            }
        }
        // 2º Mostramos las propiedades marcadas como favoritas
        System.out.println("Mostrando las propiedades Favoritas: ");
        for (Propiedad propiedad : lPropiedadesFavoritas) {
            System.out.println(propiedad);
        }

    }

    public static void estadisticasPorZona(Imobilia imo) {
        // Buscamos las características de cada zona.
        System.out.print("\n Introduzca una ubicación para buscar propiedades->");
        Scanner teclado;
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
        precioMedio /= aux.size();// Calculamos el precio medio del metro cuadrado del a zona
        System.out.println("El precio medio de la zona es: " + precioMedio);
    }

    public static void compararPropiedades(Imobilia imo) {
        System.out.print("\n Introduzca un código propiedad 1 ->:");
        Scanner teclado;
        teclado = new Scanner(System.in);
        // Pedimos dos códigos de propiedades y mostramos sus datos para compararlos
        int codigo1 = teclado.nextInt();
        Propiedad p1 = imo.buscarPropiedad(codigo1);
        System.out.print("\n Introduzca un código propiedad 2 ->:");
        int codigo2 = teclado.nextInt();
        Propiedad p2 = imo.buscarPropiedad(codigo2);
        System.out.println("Comparamos las dos propiedades");
        System.out.println("Tipo: " + "P1: " + p1.getTipo() + "P2: " + p2.getTipo());
        System.out.println("Precio: " + "P1: " + p1.getPrecio() + "P2: " + p2.getPrecio());
        System.out.println("Descripción: " + "P1: " + p1.getDescripcion() + "P2: " + p2.getDescripcion());
    }

    public static void verHistorico(Imobilia imo) {// Mostramos el histórico de compras/ventas
        ArrayList<Transaccion> lOperaciones = imo.getlOperaciones();
        System.out.println("Mostramos el histórico: ");
        for (Transaccion transaccion : lOperaciones) {
            System.out.println(transaccion);
        }
    }

    public static void cambiarContrasena(Imobilia imo) {
        String DNI;
        String password;
        Scanner teclado;
        teclado = new Scanner(System.in);
        System.out.println("Introduzca el DNI del cliente: ");
        DNI = teclado.nextLine();
        System.out.println("Introduzca la nueva contraseña: ");
        password = teclado.nextLine();
        if (imo.cambiarPassword(DNI, password))
            System.out.println("Contraseña cambiada con éxito");
        else
            System.out.println("No se ha podido cambiar la contraseña");

    }

    public static void asignarVentaAAgente(Imobilia imo) {
        // Si un agnete vende una propiedad, la amumentamos su bonus
        String DNI;
        Scanner teclado;
        teclado = new Scanner(System.in);
        System.out.println("Introduzca el DNI del agente: ");
        DNI = teclado.nextLine();
        AgentInmobiliario a = imo.buscarAgente(DNI);
        a.incBonus();
    }

    public static void calcularSueldoAgentes(Imobilia imo) {
        // Calculamos los gastos de la empresa calculado el sueldo total de todos los
        // agentes
        ArrayList<AgentInmobiliario> lAgentes = imo.getlAgentes();
        float total = 0;
        for (AgentInmobiliario agentInmobiliario : lAgentes) {
            total += agentInmobiliario.calcularSueldo();
        }
        System.out.println("El total de los sueldos de los es: " + total);
    }

    public static void enviarCorreoASoporte(Imobilia imo) {
        System.out.println("Introduzca el mensaje a enviar al soporte técnico");
        Scanner teclado = new Scanner(System.in);
        String mensaje = teclado.nextLine();
        imo.enviarCorreoASoporte(mensaje);
    }

    public static void verPreguntasFrecuentes() {
        System.out.println(
                "¿Cómo puedo protegerme de posibles fraudes? Los estafadores utilizan diferentes formas para tratar de robarte datos y dinero, haciéndose pasar por idealista. Queremos ayudarte a entender..."
                        + "¿Cómo reservar una habitación en idealista? Si te has enamorado de una habitación o simplemente encontraste esa que cumple con todo lo que necesitas, entonces puedes... ¿Cómo puedo detectar anuncios falsos? Detectar un anuncio de Reserva Online fraudulento puede ser complicado, pero hay varios indicios que pueden ayudarte a identificar una..."
                        + "¿Cuál es la tarifa de servicio de idealista en una reserva online de habitación?"
                        + "Cuando reservas una habitación en idealista, pagas una tarifa de servicio única, adicional al primer mes de renta. Esta tarifa..."
                        + "¿Cómo funcionan las políticas de cancelación para el inquilino?"
                        + "Si quieres cancelar tu reserva, hay plazos determinados en los que puedes recibir una devolución total o parcial de lo..."
                        + "Condiciones del servicio de Reserva Online de idealista"
                        + "Fecha de actualización: 9 de mayo de 2025 Índice ¿En qué consiste? Acceso y aceptación de las Condiciones ROL ¿Cómo..."
                        + "¿Qué es la Reserva Online con Seguro y qué coberturas tengo como inquilino?"
                        + "En idealista buscamos ofrecerte el mejor servicio en la búsqueda de tu nuevo hogar. Mudarte a una ciudad que no..."
                        + "¿Cuánto debo pagar de renta mensual según el tipo de contrato que me aplica?"
                        + "El importe a pagar por el inquilino cuando solicita una reserva viene determinado por 2 aspectos: El día que seleccione..."
                        + "¿Cuánto debo pagar en total por mi estancia?"
                        + "Una vez hayas solicitado tu reserva con una fecha de entrada y de salida podrás acceder al desglose exacto de..."
                        + "¿Cómo puedo cancelar mi reserva?"
                        + "Como inquilino, tienes derecho a cancelar tu reserva después de que te la acepten. Antes de hacerlo, te recomendamos que..."
                        + "He realizado una reserva y no voy a utilizarla, ¿en qué casos puedo recuperar mi dinero?"
                        + "Cuando realizas una reserva, estás aceptando los Términos y Condiciones de idealista, por lo que cualquier devolución se regirá por...");
    }

    public static void mostrarPropiedadesEnRango(Imobilia imo) {
        Scanner teclado;
        teclado = new Scanner(System.in);
        float inicio, fin;
        // Buscamos las propiedades que queremos comprar según el rango de precios
        // introducido
        System.out.println("Introduzca el valor incial del rango: ");
        inicio = teclado.nextFloat();
        System.out.println("Introduzca el valor final del rango: ");
        fin = teclado.nextFloat();
        ArrayList<Propiedad> lPropiedades = imo.getLPropiedad();
        ArrayList<Propiedad> lPropiedadesEnRango = new ArrayList<>();
        for (Propiedad propiedad : lPropiedades) {
            if (propiedad.getPrecio() >= inicio && propiedad.getPrecio() <= fin) {
                lPropiedadesEnRango.add(propiedad);
            }
        }
        System.out.println("Mostramos las propiedades del rango establecido: ");
        for (Propiedad propiedad : lPropiedadesEnRango) {
            System.out.println(propiedad);
        }
    }

    public static void comprarPropiedad(Imobilia imo) {
        // Indicamos que una propiedad ha sido comprada y, por lo tanto, la quitamos de
        // la web de la aplicación
        int codigo;
        Scanner teclado;
        teclado = new Scanner(System.in);
        System.out.println("Introducir código propiedad: ");
        codigo = teclado.nextInt();
        Propiedad p = imo.buscarPropiedad(codigo);
        imo.eliminarPropiedad(codigo);
        imo.anadirPropiedadVendiad(p);
    }
}
