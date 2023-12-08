package ar.edu.um.programacion2.scalco.service.dto;

import ar.edu.um.programacion2.scalco.domain.Orden;
import java.util.List;

public class OrdenesDTO {

    private List<Orden> ordenes;

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }
}
