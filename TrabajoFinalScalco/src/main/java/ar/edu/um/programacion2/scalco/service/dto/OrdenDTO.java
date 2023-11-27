package ar.edu.um.programacion2.scalco.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link ar.edu.um.programacion2.scalco.domain.Orden} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class OrdenDTO implements Serializable {

    private Long id;

    private Integer accionId;

    @NotNull
    private String accion;

    @NotNull
    private String operacion;

    @NotNull
    private Integer cantidad;

    @NotNull
    private ZonedDateTime fechaOperacion;

    @NotNull
    private String modo;

    @NotNull
    private Boolean operacionExitosa;

    private String descripcion;

    private Boolean ejecutada;

    private Boolean reportada;

    @NotNull
    private Integer clienteId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccionId() {
        return accionId;
    }

    public void setAccionId(Integer accionId) {
        this.accionId = accionId;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ZonedDateTime getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(ZonedDateTime fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public Boolean getOperacionExitosa() {
        return operacionExitosa;
    }

    public void setOperacionExitosa(Boolean operacionExitosa) {
        this.operacionExitosa = operacionExitosa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEjecutada() {
        return ejecutada;
    }

    public void setEjecutada(Boolean ejecutada) {
        this.ejecutada = ejecutada;
    }

    public Boolean getReportada() {
        return reportada;
    }

    public void setReportada(Boolean reportada) {
        this.reportada = reportada;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrdenDTO)) {
            return false;
        }

        OrdenDTO ordenDTO = (OrdenDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, ordenDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OrdenDTO{" +
            "id=" + getId() +
            ", accionId=" + getAccionId() +
            ", accion='" + getAccion() + "'" +
            ", operacion='" + getOperacion() + "'" +
            ", cantidad=" + getCantidad() +
            ", fechaOperacion='" + getFechaOperacion() + "'" +
            ", modo='" + getModo() + "'" +
            ", operacionExitosa='" + getOperacionExitosa() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", ejecutada='" + getEjecutada() + "'" +
            ", reportada='" + getReportada() + "'" +
            ", clienteId=" + getClienteId() +
            "}";
    }
}
