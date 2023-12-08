package ar.edu.um.programacion2.scalco.service.mapper;

import ar.edu.um.programacion2.scalco.domain.Orden;
import ar.edu.um.programacion2.scalco.service.dto.OrdenDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for the entity {@link Orden} and its DTO {@link OrdenDTO}.
 */
@Mapper(componentModel = "spring")
public interface OrdenMapper extends EntityMapper<OrdenDTO, Orden> {}
