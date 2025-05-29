import java.util.ArrayList;
import java.util.HashMap;

public class Imobilia {
    private ArrayList<Propiedad> lPropiedades;
    private ArrayList<Cliente> lClientes;
    private ArrayList<Agente> lAgentes;

    public Imobilia() {
        lPropiedades = new ArrayList<>();
        lClientes = new ArrayList<>();
        lAgentes = new ArrayList<>();
    }

    public void setlPropiedad(Propiedad propiedad) {
        this.lPropiedades.add(propiedad);
    }
    // aÑADIR AGENTE
    // ELIMINAR BUSCAR MODIFICAR
    // aÑADIR Cliente
    // ELIMINAR BUSCAR MODIFICAR
    // aÑADIR Propiedad
    // ELIMINAR BUSCAR MODIFICAR
}
