package ar.edu.um.programacion2.scalco.service;
import ar.edu.um.programacion2.scalco.domain.Orden;
import ar.edu.um.programacion2.scalco.service.dto.OrdenDTO;
import ar.edu.um.programacion2.scalco.service.dto.OrdenesDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Transactional
public class ObtenerService {
    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
    private final Logger log = LoggerFactory.getLogger(ObtenerService.class);


    @Value("${infoUrl.ordenesUrlmine}")
    private String urlOrdenesLocal;

    @Value("${infoUrl.ordenesUrl}")
    private String urlOrdenes;

    @Value("${infoUrl.token}")
    private String token;

    @Autowired
    OrdenService ordenService;
}
/*    public HttpResponse<String> obtenerRespuestaOrdenes() {
        //String uri = urlOrdenesLocal;
        String uri = urlOrdenes;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).header("Authorization", "Bearer " + token).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println("Response status code: " + response.statusCode());
            //System.out.println("Response body: " + response.body());

            log.info("GET " + uri + " : " + response.statusCode());

            return response;
        } catch (IOException | InterruptedException e) {
            //e.printStackTrace();
            return null;
        }
    }

    public List<Orden> mapearRespuestaAOrdenes(HttpResponse<String> jsonResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            OrdenesDTO response = objectMapper.readValue(jsonResponse.body(), OrdenesDTO.class);
            List<Orden> ordenes = response.getOrdenes();
            return ordenes;
        } catch (IOException e) {
            //e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Map<String, List<Orden>> obtenerOrdenes() {
        log.info("Obteniendo ordenes ...");
        HttpResponse<String> jsonResponse = obtenerRespuestaOrdenes();
        List<Orden> ordenes = mapearRespuestaAOrdenes(jsonResponse);
        log.info(ordenes.size() + " ordenes recuperadas");
        Map<String, List<Orden>> mapaLista = new HashMap<>();
        mapaLista.put("Ordenes Obtenidas", ordenes);
        return mapaLista;
    }
}
*/
