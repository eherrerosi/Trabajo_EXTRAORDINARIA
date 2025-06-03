import java.util.ArrayList;
import java.util.HashMap;

public class Imobilia {
    private ArrayList<Propiedad> lPropiedades;
    private ArrayList<Propiedad> lPropiedadesVendidas;
    private ArrayList<Cliente> lClientes;
    private ArrayList<AgentInmobiliario> lAgentes;
    private ArrayList<Transaccion> lOperaciones;
    // private ArrayList<Cita> lOperaciones;

    public Imobilia() {
        lPropiedades = new ArrayList<>();
        lClientes = new ArrayList<>();
        lAgentes = new ArrayList<>();
        lOperaciones = new ArrayList<>();
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

    public boolean modificarAgente(AgentInmobiliario a) {
        boolean esModificado = false;
        AgentInmobiliario b = buscarAgente(a.getDNI());
        if (b != null) {
            esModificado = true;
            b = a;
        }
        return esModificado;
    }

    // ELIMINAR BUSCAR MODIFICAR
    public void setCliente(Cliente a) {
        this.lClientes.add(a);
    }

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

    // ELIMINAR BUSCAR MODIFICAR
    public void setPropiedad(Propiedad a) {
        this.lPropiedades.add(a);
    }

    // ELIMINAR BUSCAR MODIFICAR
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
        Propiedad b = buscarPropiedad(a.getCodigoPropiedad());
        if (b != null) {
            b.setFavorita(true);
            esModificado = true;
        }
        return esModificado;
    }

    public boolean desmarcarPropiedadFavorita(int codigo) {
        boolean esModificado = false;
        Propiedad b = buscarPropiedad(a.getCodigoPropiedad());
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
            Agente c = this.lAgentes.get(i);
            if (c.getDNI().equalsIgnoreCase(DNI)) {
                this.lAgentes.remove(i);
                eliminado = true;
            }
        }
        return eliminado;
    }

    @Override
    public String toString() {
        return "Imobilia [lPropiedades=" + lPropiedades + ", lClientes=" + lClientes + ", lAgentes=" + lAgentes + "]";
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

}
