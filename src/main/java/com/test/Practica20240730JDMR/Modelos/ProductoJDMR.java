package com.test.Practica20240730JDMR.Modelos;

import java.math.BigDecimal;
import java.sql.Date;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "productos")
public class ProductoJDMR {

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //nombre
    @NotBlank(message = "El nombre es requerido")
    private String nombreJDMR;

    //descripcion
    @NotBlank(message = "La descripción es requerida")
    private String descripcionJDMR;

    //precio
    @NotNull(message = "El precio es requerido")
    private BigDecimal precioJDMR;

    //fecha de vencimiento
    @NotNull(message = "La fecha de vencimiento es requerida")
    private Date fechaVencimientoJDMR;

    //Estatus
    @NotNull(message = "El estatus es requerido")
    private Byte estatusJDMR;

    //Existencia
    @NotNull(message = "La existencia es requerida")
    private Integer existenciaJDMR;

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreJDMR() {
        return nombreJDMR;
    }

    public void setNombreJDMR(String nombreJDMR) {
        this.nombreJDMR = nombreJDMR;
    }

    public String getDescripcionJDMR() {
        return descripcionJDMR;
    }

    public void setDescripcionJDMR(String descripcionJDMR) {
        this.descripcionJDMR = descripcionJDMR;
    }

    public BigDecimal getPrecioJDMR() {
        return precioJDMR;
    }

    public void setPrecioJDMR(BigDecimal precioJDMR) {
        this.precioJDMR = precioJDMR;
    }

    public Date getFechaVencimientoJDMR() {
        return fechaVencimientoJDMR;
    }

    public void setFechaVencimientoJDMR(Date fechaVencimientoJDMR) {
        this.fechaVencimientoJDMR = fechaVencimientoJDMR;
    }

    public Byte getEstatusJDMR() {
        return estatusJDMR;
    }

    public void setEstatusJDMR(Byte estatusJDMR) {
        this.estatusJDMR = estatusJDMR;
    }

    public Integer getExistenciaJDMR() {
        return existenciaJDMR;
    }

    public void setExistenciaJDMR(Integer existenciaJDMR) {
        this.existenciaJDMR = existenciaJDMR;
    }

    
    

}
