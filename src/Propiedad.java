public class Propiedad {
    private int codigoPropiedad;
    private tipoPropiedad tipo;
    private float precio;
    private String ubicacion;
    private String descripcion;
    private String caracteristicasAdicionales;
    private boolean favorita;

    public Propiedad(int codigoPropiedad, tipoPropiedad tipo, float precio, String ubicacion, String descripcion,
            String caracteristicasAdicionales) {
        this.codigoPropiedad = codigoPropiedad;
        this.tipo = tipo;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.caracteristicasAdicionales = caracteristicasAdicionales;
        this.favorita = false;
    }

    public int getCodigoPropiedad() {
        return codigoPropiedad;
    }

    public void setCodigoPropiedad(int codigoPropiedad) {
        this.codigoPropiedad = codigoPropiedad;
    }

    public tipoPropiedad getTipo() {
        return tipo;
    }

    public void setTipo(tipoPropiedad tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicasAdicionales() {
        return caracteristicasAdicionales;
    }

    public void setCaracteristicasAdicionales(String caracteristicasAdicionales) {
        this.caracteristicasAdicionales = caracteristicasAdicionales;
    }

    @Override
    public String toString() {
        return "Propiedad [codigoPropiedad=" + codigoPropiedad + ", tipo=" + tipo + ", precio=" + precio
                + ", ubicacion=" + ubicacion + ", descripcion=" + descripcion + ", caracteristicasAdicionales="
                + caracteristicasAdicionales + "]";
    }

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

}
