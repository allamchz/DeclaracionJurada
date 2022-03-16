package cr.ac.una.domain;

import java.io.Serializable;

/**
 *
 * @author cgi
 */
public class ActividadDTO implements Serializable {

    private String codigoActividad;
    private String descripcion;

    public ActividadDTO() {
    }

    public ActividadDTO(String codigoActividad, String descripcion) {
        this.codigoActividad = codigoActividad;
        this.descripcion = descripcion;
    }

    public String getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
