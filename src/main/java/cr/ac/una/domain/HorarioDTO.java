package cr.ac.una.domain;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cgi
 */
public class HorarioDTO implements Serializable {

    private Long id;
    private List<DistribucionDTO> distribuciones;
    private String estado;
    private String fechaInicio;
    private String fechaFin;
    private String fechaVencimiento;
    private String dependencia;
    private String tipoNombramiento;
    private String puesto;

    public HorarioDTO() {
        distribuciones = new ArrayList();
    }

    public HorarioDTO(Long id, List<DistribucionDTO> distribuciones, String estado, String fechaInicio, String fechaFin, String fechaVencimiento) {
        this.id = id;
        this.distribuciones = distribuciones;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DistribucionDTO> getDistribuciones() {
        return distribuciones;
    }

    public void setDistribuciones(List<DistribucionDTO> distribuciones) {
        this.distribuciones = distribuciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            this.fechaInicio = sdf.format(sdf.parse(fechaInicio));
        } catch (ParseException ex) {
            Logger.getLogger(HorarioDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (fechaFin != null && !fechaFin.equals("")) {
            try {
                this.fechaFin = sdf.format(sdf.parse(fechaFin));
            } catch (ParseException ex) {
                Logger.getLogger(HorarioDTO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.fechaFin = fechaFin;
        }
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (fechaVencimiento != null && !fechaVencimiento.equals("")) {
            try {
                this.fechaVencimiento = sdf.format(sdf.parse(fechaVencimiento));
            } catch (ParseException ex) {
                Logger.getLogger(HorarioDTO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.fechaVencimiento = fechaVencimiento;
        }
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getTipoNombramiento() {
        return tipoNombramiento;
    }

    public void setTipoNombramiento(String tipoNombramiento) {
        this.tipoNombramiento = tipoNombramiento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }



}
