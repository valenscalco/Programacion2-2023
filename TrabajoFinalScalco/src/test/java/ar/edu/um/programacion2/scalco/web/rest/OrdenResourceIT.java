package ar.edu.um.programacion2.scalco.web.rest;

import static ar.edu.um.programacion2.scalco.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import ar.edu.um.programacion2.scalco.IntegrationTest;
import ar.edu.um.programacion2.scalco.domain.Orden;
import ar.edu.um.programacion2.scalco.repository.OrdenRepository;
import ar.edu.um.programacion2.scalco.service.dto.OrdenDTO;
import ar.edu.um.programacion2.scalco.service.mapper.OrdenMapper;
import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link OrdenResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class OrdenResourceIT {

    private static final Integer DEFAULT_ACCION_ID = 1;
    private static final Integer UPDATED_ACCION_ID = 2;

    private static final String DEFAULT_ACCION = "AAAAAAAAAA";
    private static final String UPDATED_ACCION = "BBBBBBBBBB";

    private static final String DEFAULT_OPERACION = "AAAAAAAAAA";
    private static final String UPDATED_OPERACION = "BBBBBBBBBB";

    private static final Integer DEFAULT_CANTIDAD = 1;
    private static final Integer UPDATED_CANTIDAD = 2;

    private static final ZonedDateTime DEFAULT_FECHA_OPERACION = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_FECHA_OPERACION = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_MODO = "AAAAAAAAAA";
    private static final String UPDATED_MODO = "BBBBBBBBBB";

    private static final Boolean DEFAULT_OPERACION_EXITOSA = false;
    private static final Boolean UPDATED_OPERACION_EXITOSA = true;

    private static final String DEFAULT_DESCRIPCION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPCION = "BBBBBBBBBB";

    private static final Boolean DEFAULT_EJECUTADA = false;
    private static final Boolean UPDATED_EJECUTADA = true;

    private static final Boolean DEFAULT_REPORTADA = false;
    private static final Boolean UPDATED_REPORTADA = true;

    private static final Integer DEFAULT_CLIENTE_ID = 1;
    private static final Integer UPDATED_CLIENTE_ID = 2;

    private static final Float DEFAULT_PRECIO = 1F;
    private static final Float UPDATED_PRECIO = 2F;

    private static final String ENTITY_API_URL = "/api/ordens";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private OrdenMapper ordenMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restOrdenMockMvc;

    private Orden orden;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Orden createEntity(EntityManager em) {
        Orden orden = new Orden()
            .accionId(DEFAULT_ACCION_ID)
            .accion(DEFAULT_ACCION)
            .operacion(DEFAULT_OPERACION)
            .cantidad(DEFAULT_CANTIDAD)
            .fechaOperacion(DEFAULT_FECHA_OPERACION)
            .modo(DEFAULT_MODO)
            .operacionExitosa(DEFAULT_OPERACION_EXITOSA)
            .descripcion(DEFAULT_DESCRIPCION)
            .ejecutada(DEFAULT_EJECUTADA)
            .reportada(DEFAULT_REPORTADA)
            .clienteId(DEFAULT_CLIENTE_ID)
            .precio(DEFAULT_PRECIO);
        return orden;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Orden createUpdatedEntity(EntityManager em) {
        Orden orden = new Orden()
            .accionId(UPDATED_ACCION_ID)
            .accion(UPDATED_ACCION)
            .operacion(UPDATED_OPERACION)
            .cantidad(UPDATED_CANTIDAD)
            .fechaOperacion(UPDATED_FECHA_OPERACION)
            .modo(UPDATED_MODO)
            .operacionExitosa(UPDATED_OPERACION_EXITOSA)
            .descripcion(UPDATED_DESCRIPCION)
            .ejecutada(UPDATED_EJECUTADA)
            .reportada(UPDATED_REPORTADA)
            .clienteId(UPDATED_CLIENTE_ID)
            .precio(UPDATED_PRECIO);
        return orden;
    }

    @BeforeEach
    public void initTest() {
        orden = createEntity(em);
    }

    @Test
    @Transactional
    void createOrden() throws Exception {
        int databaseSizeBeforeCreate = ordenRepository.findAll().size();
        // Create the Orden
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);
        restOrdenMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ordenDTO)))
            .andExpect(status().isCreated());

        // Validate the Orden in the database
        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeCreate + 1);
        Orden testOrden = ordenList.get(ordenList.size() - 1);
        assertThat(testOrden.getAccionId()).isEqualTo(DEFAULT_ACCION_ID);
        assertThat(testOrden.getAccion()).isEqualTo(DEFAULT_ACCION);
        assertThat(testOrden.getOperacion()).isEqualTo(DEFAULT_OPERACION);
        assertThat(testOrden.getCantidad()).isEqualTo(DEFAULT_CANTIDAD);
        assertThat(testOrden.getFechaOperacion()).isEqualTo(DEFAULT_FECHA_OPERACION);
        assertThat(testOrden.getModo()).isEqualTo(DEFAULT_MODO);
        assertThat(testOrden.getOperacionExitosa()).isEqualTo(DEFAULT_OPERACION_EXITOSA);
        assertThat(testOrden.getDescripcion()).isEqualTo(DEFAULT_DESCRIPCION);
        assertThat(testOrden.getEjecutada()).isEqualTo(DEFAULT_EJECUTADA);
        assertThat(testOrden.getReportada()).isEqualTo(DEFAULT_REPORTADA);
        assertThat(testOrden.getClienteId()).isEqualTo(DEFAULT_CLIENTE_ID);
        assertThat(testOrden.getPrecio()).isEqualTo(DEFAULT_PRECIO);
    }

    @Test
    @Transactional
    void createOrdenWithExistingId() throws Exception {
        // Create the Orden with an existing ID
        orden.setId(1L);
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        int databaseSizeBeforeCreate = ordenRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restOrdenMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ordenDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Orden in the database
        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkAccionIsRequired() throws Exception {
        int databaseSizeBeforeTest = ordenRepository.findAll().size();
        // set the field null
        orden.setAccion(null);

        // Create the Orden, which fails.
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        restOrdenMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ordenDTO)))
            .andExpect(status().isBadRequest());

        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkOperacionIsRequired() throws Exception {
        int databaseSizeBeforeTest = ordenRepository.findAll().size();
        // set the field null
        orden.setOperacion(null);

        // Create the Orden, which fails.
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        restOrdenMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ordenDTO)))
            .andExpect(status().isBadRequest());

        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCantidadIsRequired() throws Exception {
        int databaseSizeBeforeTest = ordenRepository.findAll().size();
        // set the field null
        orden.setCantidad(null);

        // Create the Orden, which fails.
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        restOrdenMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ordenDTO)))
            .andExpect(status().isBadRequest());

        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFechaOperacionIsRequired() throws Exception {
        int databaseSizeBeforeTest = ordenRepository.findAll().size();
        // set the field null
        orden.setFechaOperacion(null);

        // Create the Orden, which fails.
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        restOrdenMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ordenDTO)))
            .andExpect(status().isBadRequest());

        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkModoIsRequired() throws Exception {
        int databaseSizeBeforeTest = ordenRepository.findAll().size();
        // set the field null
        orden.setModo(null);

        // Create the Orden, which fails.
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        restOrdenMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ordenDTO)))
            .andExpect(status().isBadRequest());

        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkOperacionExitosaIsRequired() throws Exception {
        int databaseSizeBeforeTest = ordenRepository.findAll().size();
        // set the field null
        orden.setOperacionExitosa(null);

        // Create the Orden, which fails.
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        restOrdenMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ordenDTO)))
            .andExpect(status().isBadRequest());

        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkClienteIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = ordenRepository.findAll().size();
        // set the field null
        orden.setClienteId(null);

        // Create the Orden, which fails.
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        restOrdenMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ordenDTO)))
            .andExpect(status().isBadRequest());

        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPrecioIsRequired() throws Exception {
        int databaseSizeBeforeTest = ordenRepository.findAll().size();
        // set the field null
        orden.setPrecio(null);

        // Create the Orden, which fails.
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        restOrdenMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ordenDTO)))
            .andExpect(status().isBadRequest());

        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllOrdens() throws Exception {
        // Initialize the database
        ordenRepository.saveAndFlush(orden);

        // Get all the ordenList
        restOrdenMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(orden.getId().intValue())))
            .andExpect(jsonPath("$.[*].accionId").value(hasItem(DEFAULT_ACCION_ID)))
            .andExpect(jsonPath("$.[*].accion").value(hasItem(DEFAULT_ACCION)))
            .andExpect(jsonPath("$.[*].operacion").value(hasItem(DEFAULT_OPERACION)))
            .andExpect(jsonPath("$.[*].cantidad").value(hasItem(DEFAULT_CANTIDAD)))
            .andExpect(jsonPath("$.[*].fechaOperacion").value(hasItem(sameInstant(DEFAULT_FECHA_OPERACION))))
            .andExpect(jsonPath("$.[*].modo").value(hasItem(DEFAULT_MODO)))
            .andExpect(jsonPath("$.[*].operacionExitosa").value(hasItem(DEFAULT_OPERACION_EXITOSA.booleanValue())))
            .andExpect(jsonPath("$.[*].descripcion").value(hasItem(DEFAULT_DESCRIPCION)))
            .andExpect(jsonPath("$.[*].ejecutada").value(hasItem(DEFAULT_EJECUTADA.booleanValue())))
            .andExpect(jsonPath("$.[*].reportada").value(hasItem(DEFAULT_REPORTADA.booleanValue())))
            .andExpect(jsonPath("$.[*].clienteId").value(hasItem(DEFAULT_CLIENTE_ID)))
            .andExpect(jsonPath("$.[*].precio").value(hasItem(DEFAULT_PRECIO.doubleValue())));
    }

    @Test
    @Transactional
    void getOrden() throws Exception {
        // Initialize the database
        ordenRepository.saveAndFlush(orden);

        // Get the orden
        restOrdenMockMvc
            .perform(get(ENTITY_API_URL_ID, orden.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(orden.getId().intValue()))
            .andExpect(jsonPath("$.accionId").value(DEFAULT_ACCION_ID))
            .andExpect(jsonPath("$.accion").value(DEFAULT_ACCION))
            .andExpect(jsonPath("$.operacion").value(DEFAULT_OPERACION))
            .andExpect(jsonPath("$.cantidad").value(DEFAULT_CANTIDAD))
            .andExpect(jsonPath("$.fechaOperacion").value(sameInstant(DEFAULT_FECHA_OPERACION)))
            .andExpect(jsonPath("$.modo").value(DEFAULT_MODO))
            .andExpect(jsonPath("$.operacionExitosa").value(DEFAULT_OPERACION_EXITOSA.booleanValue()))
            .andExpect(jsonPath("$.descripcion").value(DEFAULT_DESCRIPCION))
            .andExpect(jsonPath("$.ejecutada").value(DEFAULT_EJECUTADA.booleanValue()))
            .andExpect(jsonPath("$.reportada").value(DEFAULT_REPORTADA.booleanValue()))
            .andExpect(jsonPath("$.clienteId").value(DEFAULT_CLIENTE_ID))
            .andExpect(jsonPath("$.precio").value(DEFAULT_PRECIO.doubleValue()));
    }

    @Test
    @Transactional
    void getNonExistingOrden() throws Exception {
        // Get the orden
        restOrdenMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingOrden() throws Exception {
        // Initialize the database
        ordenRepository.saveAndFlush(orden);

        int databaseSizeBeforeUpdate = ordenRepository.findAll().size();

        // Update the orden
        Orden updatedOrden = ordenRepository.findById(orden.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedOrden are not directly saved in db
        em.detach(updatedOrden);
        updatedOrden
            .accionId(UPDATED_ACCION_ID)
            .accion(UPDATED_ACCION)
            .operacion(UPDATED_OPERACION)
            .cantidad(UPDATED_CANTIDAD)
            .fechaOperacion(UPDATED_FECHA_OPERACION)
            .modo(UPDATED_MODO)
            .operacionExitosa(UPDATED_OPERACION_EXITOSA)
            .descripcion(UPDATED_DESCRIPCION)
            .ejecutada(UPDATED_EJECUTADA)
            .reportada(UPDATED_REPORTADA)
            .clienteId(UPDATED_CLIENTE_ID)
            .precio(UPDATED_PRECIO);
        OrdenDTO ordenDTO = ordenMapper.toDto(updatedOrden);

        restOrdenMockMvc
            .perform(
                put(ENTITY_API_URL_ID, ordenDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(ordenDTO))
            )
            .andExpect(status().isOk());

        // Validate the Orden in the database
        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeUpdate);
        Orden testOrden = ordenList.get(ordenList.size() - 1);
        assertThat(testOrden.getAccionId()).isEqualTo(UPDATED_ACCION_ID);
        assertThat(testOrden.getAccion()).isEqualTo(UPDATED_ACCION);
        assertThat(testOrden.getOperacion()).isEqualTo(UPDATED_OPERACION);
        assertThat(testOrden.getCantidad()).isEqualTo(UPDATED_CANTIDAD);
        assertThat(testOrden.getFechaOperacion()).isEqualTo(UPDATED_FECHA_OPERACION);
        assertThat(testOrden.getModo()).isEqualTo(UPDATED_MODO);
        assertThat(testOrden.getOperacionExitosa()).isEqualTo(UPDATED_OPERACION_EXITOSA);
        assertThat(testOrden.getDescripcion()).isEqualTo(UPDATED_DESCRIPCION);
        assertThat(testOrden.getEjecutada()).isEqualTo(UPDATED_EJECUTADA);
        assertThat(testOrden.getReportada()).isEqualTo(UPDATED_REPORTADA);
        assertThat(testOrden.getClienteId()).isEqualTo(UPDATED_CLIENTE_ID);
        assertThat(testOrden.getPrecio()).isEqualTo(UPDATED_PRECIO);
    }

    @Test
    @Transactional
    void putNonExistingOrden() throws Exception {
        int databaseSizeBeforeUpdate = ordenRepository.findAll().size();
        orden.setId(longCount.incrementAndGet());

        // Create the Orden
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restOrdenMockMvc
            .perform(
                put(ENTITY_API_URL_ID, ordenDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(ordenDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Orden in the database
        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchOrden() throws Exception {
        int databaseSizeBeforeUpdate = ordenRepository.findAll().size();
        orden.setId(longCount.incrementAndGet());

        // Create the Orden
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restOrdenMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(ordenDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Orden in the database
        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamOrden() throws Exception {
        int databaseSizeBeforeUpdate = ordenRepository.findAll().size();
        orden.setId(longCount.incrementAndGet());

        // Create the Orden
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restOrdenMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ordenDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Orden in the database
        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateOrdenWithPatch() throws Exception {
        // Initialize the database
        ordenRepository.saveAndFlush(orden);

        int databaseSizeBeforeUpdate = ordenRepository.findAll().size();

        // Update the orden using partial update
        Orden partialUpdatedOrden = new Orden();
        partialUpdatedOrden.setId(orden.getId());

        partialUpdatedOrden
            .operacion(UPDATED_OPERACION)
            .operacionExitosa(UPDATED_OPERACION_EXITOSA)
            .descripcion(UPDATED_DESCRIPCION)
            .reportada(UPDATED_REPORTADA)
            .clienteId(UPDATED_CLIENTE_ID)
            .precio(UPDATED_PRECIO);

        restOrdenMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedOrden.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedOrden))
            )
            .andExpect(status().isOk());

        // Validate the Orden in the database
        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeUpdate);
        Orden testOrden = ordenList.get(ordenList.size() - 1);
        assertThat(testOrden.getAccionId()).isEqualTo(DEFAULT_ACCION_ID);
        assertThat(testOrden.getAccion()).isEqualTo(DEFAULT_ACCION);
        assertThat(testOrden.getOperacion()).isEqualTo(UPDATED_OPERACION);
        assertThat(testOrden.getCantidad()).isEqualTo(DEFAULT_CANTIDAD);
        assertThat(testOrden.getFechaOperacion()).isEqualTo(DEFAULT_FECHA_OPERACION);
        assertThat(testOrden.getModo()).isEqualTo(DEFAULT_MODO);
        assertThat(testOrden.getOperacionExitosa()).isEqualTo(UPDATED_OPERACION_EXITOSA);
        assertThat(testOrden.getDescripcion()).isEqualTo(UPDATED_DESCRIPCION);
        assertThat(testOrden.getEjecutada()).isEqualTo(DEFAULT_EJECUTADA);
        assertThat(testOrden.getReportada()).isEqualTo(UPDATED_REPORTADA);
        assertThat(testOrden.getClienteId()).isEqualTo(UPDATED_CLIENTE_ID);
        assertThat(testOrden.getPrecio()).isEqualTo(UPDATED_PRECIO);
    }

    @Test
    @Transactional
    void fullUpdateOrdenWithPatch() throws Exception {
        // Initialize the database
        ordenRepository.saveAndFlush(orden);

        int databaseSizeBeforeUpdate = ordenRepository.findAll().size();

        // Update the orden using partial update
        Orden partialUpdatedOrden = new Orden();
        partialUpdatedOrden.setId(orden.getId());

        partialUpdatedOrden
            .accionId(UPDATED_ACCION_ID)
            .accion(UPDATED_ACCION)
            .operacion(UPDATED_OPERACION)
            .cantidad(UPDATED_CANTIDAD)
            .fechaOperacion(UPDATED_FECHA_OPERACION)
            .modo(UPDATED_MODO)
            .operacionExitosa(UPDATED_OPERACION_EXITOSA)
            .descripcion(UPDATED_DESCRIPCION)
            .ejecutada(UPDATED_EJECUTADA)
            .reportada(UPDATED_REPORTADA)
            .clienteId(UPDATED_CLIENTE_ID)
            .precio(UPDATED_PRECIO);

        restOrdenMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedOrden.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedOrden))
            )
            .andExpect(status().isOk());

        // Validate the Orden in the database
        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeUpdate);
        Orden testOrden = ordenList.get(ordenList.size() - 1);
        assertThat(testOrden.getAccionId()).isEqualTo(UPDATED_ACCION_ID);
        assertThat(testOrden.getAccion()).isEqualTo(UPDATED_ACCION);
        assertThat(testOrden.getOperacion()).isEqualTo(UPDATED_OPERACION);
        assertThat(testOrden.getCantidad()).isEqualTo(UPDATED_CANTIDAD);
        assertThat(testOrden.getFechaOperacion()).isEqualTo(UPDATED_FECHA_OPERACION);
        assertThat(testOrden.getModo()).isEqualTo(UPDATED_MODO);
        assertThat(testOrden.getOperacionExitosa()).isEqualTo(UPDATED_OPERACION_EXITOSA);
        assertThat(testOrden.getDescripcion()).isEqualTo(UPDATED_DESCRIPCION);
        assertThat(testOrden.getEjecutada()).isEqualTo(UPDATED_EJECUTADA);
        assertThat(testOrden.getReportada()).isEqualTo(UPDATED_REPORTADA);
        assertThat(testOrden.getClienteId()).isEqualTo(UPDATED_CLIENTE_ID);
        assertThat(testOrden.getPrecio()).isEqualTo(UPDATED_PRECIO);
    }

    @Test
    @Transactional
    void patchNonExistingOrden() throws Exception {
        int databaseSizeBeforeUpdate = ordenRepository.findAll().size();
        orden.setId(longCount.incrementAndGet());

        // Create the Orden
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restOrdenMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, ordenDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(ordenDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Orden in the database
        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchOrden() throws Exception {
        int databaseSizeBeforeUpdate = ordenRepository.findAll().size();
        orden.setId(longCount.incrementAndGet());

        // Create the Orden
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restOrdenMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(ordenDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Orden in the database
        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamOrden() throws Exception {
        int databaseSizeBeforeUpdate = ordenRepository.findAll().size();
        orden.setId(longCount.incrementAndGet());

        // Create the Orden
        OrdenDTO ordenDTO = ordenMapper.toDto(orden);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restOrdenMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(ordenDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Orden in the database
        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteOrden() throws Exception {
        // Initialize the database
        ordenRepository.saveAndFlush(orden);

        int databaseSizeBeforeDelete = ordenRepository.findAll().size();

        // Delete the orden
        restOrdenMockMvc
            .perform(delete(ENTITY_API_URL_ID, orden.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Orden> ordenList = ordenRepository.findAll();
        assertThat(ordenList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
