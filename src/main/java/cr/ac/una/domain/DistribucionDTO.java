package cr.ac.una.domain;


import java.io.Serializable;

/**
 *
 * @author cgi
 */
public class DistribucionDTO implements Serializable {

    private ActividadDTO actividadDTO;
    private Integer dia;
    private String horaDesde;
    private String horaHasta;

    public DistribucionDTO() {
    }

    public DistribucionDTO(ActividadDTO actividadDTO, Integer dia, String horaDesde, String horaHasta) {
        this.actividadDTO = actividadDTO;
        this.dia = dia;
        this.horaDesde = horaDesde;
        this.horaHasta = horaHasta;
    }

    public ActividadDTO getActividadDTO() {
        return actividadDTO;
    }

    public void setActividadDTO(ActividadDTO actividadDTO) {
        this.actividadDTO = actividadDTO;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public String getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(String horaDesde) {
        this.horaDesde = horaDesde;
    }

    public String getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(String horaHasta) {
        this.horaHasta = horaHasta;
    }
}
