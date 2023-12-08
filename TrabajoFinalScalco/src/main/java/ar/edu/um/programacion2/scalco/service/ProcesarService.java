package ar.edu.um.programacion2.scalco.service;

import ar.edu.um.programacion2.scalco.domain.Orden;
import ar.edu.um.programacion2.scalco.repository.OrdenRepository;
import ar.edu.um.programacion2.scalco.service.dto.OrdenDTO;
import ar.edu.um.programacion2.scalco.service.mapper.OrdenMapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcesarService {
    List<Orden> ordenesFallidas = new ArrayList<>();
    List<Orden> ordenesExitosas = new ArrayList<>();

    public void procesarOrden(OrdenDTO ordenDTO) {
        // Convertir el DTO a entidad Orden
        Orden orden = convertirDTOaEntidad(ordenDTO);

        // Verificar si es posible procesar la orden
        if (esPosibleProcesar(orden)) {
            // Ejecutar la operación de compra o venta
            ejecutarOperacion(orden);

            // Almacenar el resultado de la orden
            almacenarResultado(orden, true);
        } else {
            // Almacenar la orden en la lista de órdenes fallidas
            almacenarResultado(orden, false);
        }
    }

    private boolean esPosibleProcesar(Orden orden) {
        // Lógica para verificar condiciones de procesamiento
        return orden.getCantidad() > 0 && horarioPermitido(orden.getModo());
    }

    // Método para verificar si una orden es instantánea
    private boolean horarioPermitido(String modo) {
        // Lógica para verificar el horario permitido según el modo de la orden
        return "INMEDIATO".equals(modo) || esHorarioTransacciones();
    }

    private boolean esHorarioTransacciones() {
        // Lógica para verificar si estamos dentro del horario permitido
        // Implementa según tus necesidades específicas
        return true;
    }

    private void ejecutarOperacion(Orden orden) {
        // Lógica para ejecutar operaciones de compra o venta
        // Puedes interactuar con servicios externos o actualizar la base de datos
    }

    private void almacenarResultado(Orden orden, boolean exitoso) {
        // Lógica para almacenar el resultado en la base de datos local
        // Puedes actualizar el estado de la orden en la base de datos, por ejemplo
        if (exitoso) {
            ordenesExitosas.add(orden);
        } else {
            ordenesFallidas.add(orden);
        }

    }
    OrdenMapper INSTANCE = Mappers.getMapper(OrdenMapper.class);


    private Orden convertirDTOaEntidad(OrdenDTO ordenDTO) {
        @Mapping(source = "cliente", target = "cliente")
        @Mapping(source = "accionId", target = "accionId")
        @Mapping(source = "cantidad", target = "cantidad")
        Orden toOrden(OrdenDTO ordenDTO);
        return OrdenMapper.INSTANCE.toOrden(ordenDTO);
    }

}
