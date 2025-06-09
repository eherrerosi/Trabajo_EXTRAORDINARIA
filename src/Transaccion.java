import java.util.Date;

//Cuándo hay una compra/venta creamos una transacción
public class Transaccion {
    private String DNIcomprador;
    private String DNIvendedor;
    private int codigoPropiedad;
    private float importe;
    private Date fechaOperacion;

    public Transaccion(String dNIcomprador, String dNIvendedor, int codigoPropiedad, float importe,
            Date fechaOperacion) {
        DNIcomprador = dNIcomprador;
        DNIvendedor = dNIvendedor;
        this.codigoPropiedad = codigoPropiedad;
        this.importe = importe;
        this.fechaOperacion = fechaOperacion;
    }

    public String getDNIcomprador() {
        return DNIcomprador;
    }

    public void setDNIcomprador(String dNIcomprador) {
        DNIcomprador = dNIcomprador;
    }

    public String getDNIvendedor() {
        return DNIvendedor;
    }

    public void setDNIvendedor(String dNIvendedor) {
        DNIvendedor = dNIvendedor;
    }

    public int getCodigoPropiedad() {
        return codigoPropiedad;
    }

    public void setCodigoPropiedad(int codigoPropiedad) {
        this.codigoPropiedad = codigoPropiedad;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    @Override
    public String toString() {
        return "Transaccion [DNIcomprador=" + DNIcomprador + ", DNIvendedor=" + DNIvendedor + ", codigoPropiedad="
                + codigoPropiedad + ", importe=" + importe + ", fechaOperacion=" + fechaOperacion + "]";
    }
}
