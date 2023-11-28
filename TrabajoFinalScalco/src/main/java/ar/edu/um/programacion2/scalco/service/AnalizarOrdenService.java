package ar.edu.um.programacion2.scalco.service;

import ar.edu.um.programacion2.scalco.domain.Orden;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalizarOrdenService {
    private static final Logger log = LoggerFactory.getLogger(AnalizarOrdenService.class);

    @Value("${infoUrl.ordenesUrl}")
    private String ordenUrl;

    @Value("${infoUrl.clientesAllUrl}")
    private String clientesAllUrl;
    @Value("${infoUrl.accionesAllUrl}")
    private String accionesAllUrl;
    @Value("${infoUrl.reporteCLiAcUrl}")
    private String reporteCLiAcUrl;
    @Value("${infoUrl.ultimovalorUrl}")
    private String ultimovalorUrl;
    @Value("${infoUrl.reportarUrl}")
    private String reportarUrl;



/*
    public static void procesarOrdenes(List<Orden> ordenes) {
        // Método principal para el procesamiento de órdenes
        List<Orden> ordenesFallidas = new ArrayList<>();
        List<Orden> ordenesExitosas = new ArrayList<>();

            for (Orden orden : ordenes) {
                // Verificar restricciones horarias para órdenes instantáneas
                if (esOrdenInstantanea(orden) && !esHorarioTransacciones()) {
                    ordenesFallidas.add(orden);
                    continue;
                }

                // Verificar existencia de cliente y acción
                if (!validarClienteYAccion(orden)) {
                    ordenesFallidas.add(orden);
                    continue;
                }

                // Verificar número de acciones
                if (orden.getNumeroAcciones() <= 0) {
                    ordenesFallidas.add(orden);
                    continue;
                }

                // Procesar la orden y almacenar en la base de datos local
                procesarYAlmacenar(orden);
                ordenesExitosas.add(orden);
            }

            // Notificar al servidor sobre órdenes exitosas
            notificarServidor(ordenesExitosas);

            // Notificar al servidor sobre órdenes fallidas
            notificarServidorFallidas(ordenesFallidas);
        }

        // Método para verificar si una orden es instantánea
        private static boolean esOrdenInstantanea(Orden orden) {
            return orden.getModo().equals("instantaneo");
        }

        // Método para verificar si es horario de transacciones
        private static boolean esHorarioTransacciones() {
            // Lógica para verificar horario de transacciones
            // Devuelve true si es horario permitido, false en caso contrario
            return true;
        }

        // Método para validar la existencia de cliente y acción
        private static boolean validarClienteYAccion(Orden orden) {
            // Lógica para validar cliente y acción en el servidor correspondiente
            // Devuelve true si son válidos, false en caso contrario
            return true;
        }

        // Método para procesar y almacenar la orden en la base de datos local
        private static void procesarYAlmacenar(Orden orden) {
            // Lógica para procesar y almacenar la orden en la base de datos local
        }

        // Método para notificar al servidor sobre órdenes exitosas
        private static void notificarServidor(List<Orden> ordenes) {
            // Lógica para enviar notificación al servidor de servicios de la cátedra
        }

        // Método para notificar al servidor sobre órdenes fallidas
        private static void notificarServidorFallidas(List<Orden> ordenes) {
            // Lógica para enviar notificación al servidor de servicios complementarios
        }

        // Clase que representa una orden
        static class Orden {
            // Atributos de la orden (ajustar según necesidades)
            String modo;
            int numeroAcciones;

            // Constructor de la clase Orden
            public Orden(String modo, int numeroAcciones) {
                this.modo = modo;
                this.numeroAcciones = numeroAcciones;
            }

            // Métodos getter y setter (ajustar según necesidades)
            public String getModo() {
                return modo;
            }

            public int getNumeroAcciones() {
                return numeroAcciones;
            }
        }

        // Método principal (main) para probar el código
        public static void main(String[] args) {
            // Ejemplo de uso: Crear una lista de órdenes y llamar al método procesarOrdenes
            List<Orden> listaOrdenes = new ArrayList<>();
            listaOrdenes.add(new Orden("instantaneo", 10));
            listaOrdenes.add(new Orden("programado", 5));

            procesarOrdenes(listaOrdenes);
        }
*/    }
