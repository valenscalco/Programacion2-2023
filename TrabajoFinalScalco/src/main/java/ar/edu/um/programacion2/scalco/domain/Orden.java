package ar.edu.um.programacion2.scalco.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Orden.
 */
@Entity
@Table(name = "orden")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "accion_id")
    private Integer accionId;

    @NotNull
    @Column(name = "accion", nullable = false)
    private String accion;

    @NotNull
    @Column(name = "operacion", nullable = false)
    private String operacion;

    @NotNull
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @NotNull
    @Column(name = "fecha_operacion", nullable = false)
    private ZonedDateTime fechaOperacion;

    @NotNull
    @Column(name = "modo", nullable = false)
    private String modo;

    @NotNull
    @Column(name = "operacion_exitosa", nullable = false)
    private Boolean operacionExitosa;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "ejecutada")
    private Boolean ejecutada;

    @Column(name = "reportada")
    private Boolean reportada;

    @NotNull
    @Column(name = "cliente_id", nullable = false)
    private Integer clienteId;

    @NotNull
    @Column(name = "precio", nullable = false)
    private Float precio;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Orden id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccionId() {
        return this.accionId;
    }

    public Orden accionId(Integer accionId) {
        this.setAccionId(accionId);
        return this;
    }

    public void setAccionId(Integer accionId) {
        this.accionId = accionId;
    }

    public String getAccion() {
        return this.accion;
    }

    public Orden accion(String accion) {
        this.setAccion(accion);
        return this;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getOperacion() {
        return this.operacion;
    }

    public Orden operacion(String operacion) {
        this.setOperacion(operacion);
        return this;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public Orden cantidad(Integer cantidad) {
        this.setCantidad(cantidad);
        return this;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ZonedDateTime getFechaOperacion() {
        return this.fechaOperacion;
    }

    public Orden fechaOperacion(ZonedDateTime fechaOperacion) {
        this.setFechaOperacion(fechaOperacion);
        return this;
    }

    public void setFechaOperacion(ZonedDateTime fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public String getModo() {
        return this.modo;
    }

    public Orden modo(String modo) {
        this.setModo(modo);
        return this;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public Boolean getOperacionExitosa() {
        return this.operacionExitosa;
    }

    public Orden operacionExitosa(Boolean operacionExitosa) {
        this.setOperacionExitosa(operacionExitosa);
        return this;
    }

    public void setOperacionExitosa(Boolean operacionExitosa) {
        this.operacionExitosa = operacionExitosa;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Orden descripcion(String descripcion) {
        this.setDescripcion(descripcion);
        return this;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEjecutada() {
        return this.ejecutada;
    }

    public Orden ejecutada(Boolean ejecutada) {
        this.setEjecutada(ejecutada);
        return this;
    }

    public void setEjecutada(Boolean ejecutada) {
        this.ejecutada = ejecutada;
    }

    public Boolean getReportada() {
        return this.reportada;
    }

    public Orden reportada(Boolean reportada) {
        this.setReportada(reportada);
        return this;
    }

    public void setReportada(Boolean reportada) {
        this.reportada = reportada;
    }

    public Integer getClienteId() {
        return this.clienteId;
    }

    public Orden clienteId(Integer clienteId) {
        this.setClienteId(clienteId);
        return this;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Float getPrecio() {
        return this.precio;
    }

    public Orden precio(Float precio) {
        this.setPrecio(precio);
        return this;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Orden)) {
            return false;
        }
        return getId() != null && getId().equals(((Orden) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Orden{" +
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
            ", precio=" + getPrecio() +
            "}";
    }
}
