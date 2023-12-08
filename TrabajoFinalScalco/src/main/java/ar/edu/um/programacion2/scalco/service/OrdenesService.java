package ar.edu.um.programacion2.scalco.service;

import ar.edu.um.programacion2.scalco.domain.Orden;
import ar.edu.um.programacion2.scalco.repository.OrdenRepository;
import ar.edu.um.programacion2.scalco.service.dto.OrdenDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class OrdenesService {

    private final OrdenRepository ordenRepository;

    @Autowired
    public OrdenesService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

}
