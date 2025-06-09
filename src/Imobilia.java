import java.util.ArrayList;
import java.util.PriorityQueue;

//Clase gestoria de los inmuebles del empresa
public class Imobilia {
    // Atributos que principalmente son todos colecciones
    private ArrayList<Propiedad> lPropiedades;
    private ArrayList<Propiedad> lPropiedadesVendidas;
    private ArrayList<Cliente> lClientes;
    private ArrayList<AgentInmobiliario> lAgentes;
    private ArrayList<Transaccion> lOperaciones;
    private PriorityQueue<String> bandeja;// He usado una cola prioritaria, sin aplicar prioridad (funciona como una
                                          // cola normal), por añadir otra colección disinta

    public Imobilia() { // Inicializamos todas las colecciones en el constructor
        lPropiedades = new ArrayList<>();
        lClientes = new ArrayList<>();
        lAgentes = new ArrayList<>();
        lOperaciones = new ArrayList<>();
        bandeja = new PriorityQueue<>();
    }

    public void anadirPropiedadVendiad(Propiedad p) {
        lPropiedadesVendidas.add(p);
    }

    public void setlPropiedad(Propiedad propiedad) {
        this.lPropiedades.add(propiedad);
    }

    public ArrayList<Propiedad> getLPropiedad() {
        return this.lPropiedades;
    }

    public void setAgente(AgentInmobiliario a) {
        this.lAgentes.add(a);
    }

    // Buscamos un Agente según su DNI
    public AgentInmobiliario buscarAgente(String s) {
        AgentInmobiliario c = null;
        for (int i = 0; i < this.lAgentes.size() && c != null; i++) {
            AgentInmobiliario aux = this.lAgentes.get(i);
            if (aux.getDNI().compareToIgnoreCase(s) == 0) {
                c = aux;
            }
        }
        return c;
    }

    // Actualizamos un agnete con el pasado por parámetro siempre que tenga el mismo
    // DNI, por ello he creado el método anterior
    public boolean modificarAgente(AgentInmobiliario a) {
        boolean esModificado = false;
        AgentInmobiliario b = buscarAgente(a.getDNI());
        if (b != null) {
            esModificado = true;
            b = a;
        }
        return esModificado;
    }

    public void setCliente(Cliente a) {
        this.lClientes.add(a);
    }

    // Igual que el anterior pero de cliente
    public Cliente buscarCliente(String s) {
        Cliente c = null;
        for (int i = 0; i < this.lClientes.size() && c != null; i++) {
            Cliente aux = this.lClientes.get(i);
            if (aux.getDNI().compareToIgnoreCase(s) == 0) {
                c = aux;
            }
        }
        return c;
    }

    public boolean modificarCliente(Cliente a) {
        boolean esModificado = false;
        Cliente b = buscarCliente(a.getDNI());
        if (b != null) {
            esModificado = true;
            b = a;
        }
        return esModificado;
    }

    // Si el cliente se ha olvidado de su contraseña, le permitimos cambiarla
    // siempre que este ya en nuestro sistema
    public boolean cambiarPassword(String DNI, String password) {
        boolean cambiada = false;
        Cliente c = buscarCliente(DNI);
        if (c != null) {
            c.setContrasena(password);
            cambiada = true;
        }
        return cambiada;
    }

    public void setPropiedad(Propiedad a) {
        this.lPropiedades.add(a);
    }

    // Buscamos unas propiedad según su código de propiedad
    public Propiedad buscarPropiedad(int codigoPropiedad) {
        Propiedad c = null;
        for (int i = 0; i < this.lPropiedades.size() && c == null; i++) {
            Propiedad aux = this.lPropiedades.get(i);
            if (aux.getCodigoPropiedad() == codigoPropiedad) {
                c = aux;
            }
        }
        return c;
    }

    public boolean modificarPropiedad(Propiedad a) {
        boolean esModificado = false;
        Propiedad b = buscarPropiedad(a.getCodigoPropiedad());
        if (b != null) {
            esModificado = true;
            b = a;
        }
        return esModificado;
    }

    public boolean eliminarPropiedad(int codigoPropiedad) {
        boolean eliminado = false;
        for (int i = 0; i < this.lPropiedades.size() && !eliminado; i++) {
            Propiedad aux = this.lPropiedades.get(i);
            if (aux.getCodigoPropiedad() == codigoPropiedad) {
                this.lPropiedades.remove(i);
                eliminado = true;
            }
        }
        return eliminado;
    }

    public boolean marcarPropiedadFavorita(int codigo) {
        boolean esModificado = false;
        Propiedad b = buscarPropiedad(codigo);
        if (b != null) {
            b.setFavorita(true);
            esModificado = true;
        }
        return esModificado;
    }

    public boolean desmarcarPropiedadFavorita(int codigo) {
        boolean esModificado = false;
        Propiedad b = buscarPropiedad(codigo);
        if (b != null) {
            b.setFavorita(false);
            esModificado = true;
        }
        return esModificado;
    }

    public boolean eliminarPersona(String DNI) {
        boolean eliminado = false;
        for (int i = 0; i < this.lClientes.size() && !eliminado; i++) {
            Cliente c = this.lClientes.get(i);
            if (c.getDNI().equalsIgnoreCase(DNI)) {
                this.lClientes.remove(i);
                eliminado = true;
            }
        }

        for (int i = 0; i < this.lAgentes.size() && !eliminado; i++) {
            AgentInmobiliario c = this.lAgentes.get(i);
            if (c.getDNI().equalsIgnoreCase(DNI)) {
                this.lAgentes.remove(i);
                eliminado = true;
            }
        }
        return eliminado;
    }

    @Override
    public String toString() {
        return "Imobilia [lPropiedades=" + lPropiedades + ", lPropiedadesVendidas=" + lPropiedadesVendidas
                + ", lClientes=" + lClientes + ", lAgentes=" + lAgentes + ", lOperaciones=" + lOperaciones
                + ", bandeja=" + bandeja + "]";
    }

    public ArrayList<Propiedad> getlPropiedades() {
        return lPropiedades;
    }

    public void setlPropiedades(ArrayList<Propiedad> lPropiedades) {
        this.lPropiedades = lPropiedades;
    }

    public ArrayList<Propiedad> getlPropiedadesVendidas() {
        return lPropiedadesVendidas;
    }

    public void setlPropiedadesVendidas(ArrayList<Propiedad> lPropiedadesVendidas) {
        this.lPropiedadesVendidas = lPropiedadesVendidas;
    }

    public ArrayList<Cliente> getlClientes() {
        return lClientes;
    }

    public void setlClientes(ArrayList<Cliente> lClientes) {
        this.lClientes = lClientes;
    }

    public ArrayList<AgentInmobiliario> getlAgentes() {
        return lAgentes;
    }

    public void setlAgentes(ArrayList<AgentInmobiliario> lAgentes) {
        this.lAgentes = lAgentes;
    }

    public ArrayList<Transaccion> getlOperaciones() {
        return lOperaciones;
    }

    public void setlOperaciones(ArrayList<Transaccion> lOperaciones) {
        this.lOperaciones = lOperaciones;
    }

    public void enviarCorreoASoporte(String msg) {
        this.bandeja.add(msg);
    }

}
