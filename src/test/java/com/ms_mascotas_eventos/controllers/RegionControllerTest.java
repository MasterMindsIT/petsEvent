package com.ms_mascotas_eventos.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms_mascotas_eventos.dtos.request.RegionRequest;
import com.ms_mascotas_eventos.dtos.responses.RegionResponse;
import com.ms_mascotas_eventos.services.interfaces.IRegionService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(RegionController.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) // Desactiva seguridad en los tests
@Import(HypermediaAutoConfiguration.class)
public class RegionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IRegionService regionService; // ¡Este es el correcto!

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAllRegiones_Con_Registros() throws Exception {
        RegionResponse region = new RegionResponse(1L, "Región Metropolitana", null);
        List<RegionResponse> regiones = List.of(region);

        Mockito.when(regionService.findAll()).thenReturn(regiones);

        mockMvc.perform(get("/regiones"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("Ok"))
                .andExpect(jsonPath("$.cantidad").value(1))
                .andExpect(jsonPath("$.dataCollect", hasSize(1)))
                .andExpect(jsonPath("$.dataCollect[0].nombre").value("Región Metropolitana"))
                .andExpect(jsonPath("$.dataCollect[0].links[?(@.rel=='self')].href").exists());
    }

    @Test
    void testCrearRegion() throws Exception {
        RegionResponse region = new RegionResponse(1L, "Valparaíso", null);
        
        Mockito.when(regionService.save(Mockito.any(RegionRequest.class))).thenReturn(region);

        mockMvc.perform(post("/regiones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(region)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("201"))
                .andExpect(jsonPath("$.data.nombre").value("Valparaíso"))
                .andExpect(jsonPath("$.data.links[?(@.rel=='self')].href").exists());
    }
    @Test
    void testFindById_RegionExistente() throws Exception {
        RegionResponse region = new RegionResponse(1L, "Región Metropolitana", null);
        Mockito.when(regionService.findById(1L)).thenReturn(region);

        mockMvc.perform(get("/regiones/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("200"))
            .andExpect(jsonPath("$.data.id").value(1))
            .andExpect(jsonPath("$.data.nombre").value("Región Metropolitana"))
            .andExpect(jsonPath("$.data.links[?(@.rel=='self')].href").exists());
    }
    
@Test
void testDelete_RegionExitosa() throws Exception {
    Mockito.when(regionService.delete(1L)).thenReturn(true);

    mockMvc.perform(delete("/regiones/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("204"))
            .andExpect(jsonPath("$.mensaje").value("Se elimino la region con ID: 1"));
}

}
