package com.ms_mascotas_eventos.services;

import com.ms_mascotas_eventos.dtos.request.RegionRequest;
import com.ms_mascotas_eventos.dtos.responses.RegionResponse;
import com.ms_mascotas_eventos.entities.Region;
import com.ms_mascotas_eventos.exceptions.EntityNotFoundException;
import com.ms_mascotas_eventos.repositories.RegionRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class RegionServiceImplTest {

    @Mock
    private RegionRepository regionRepository;

    @InjectMocks
    private RegionServiceImpl regionService;

    @Test
    void testFindAll() {

        Region r1 = new Region(1L, "Región Metropolitana", new ArrayList<>());
        Region r2 = new Region(2L, "Valparaíso", new ArrayList<>());
        when(regionRepository.findAll()).thenReturn(List.of(r1, r2));

        List<RegionResponse> result = regionService.findAll();

      
        assertEquals(2, result.size());
        assertEquals("Región Metropolitana", result.get(0).nombre());
    }

    @Test
    void testFindById_Existente() {
        // Arrange
        Region region = new Region(1L, "Biobío", new ArrayList<>());
        when(regionRepository.findById(1L)).thenReturn(Optional.of(region));

        RegionResponse result = regionService.findById(1L);

        assertEquals("Biobío", result.nombre());
        assertEquals(1L, result.id());
    }

    @Test
    void testFindById_NoExistente() {

        when(regionRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> regionService.findById(99L));
    }

    
    @Test
    void testUpdate_Existente() {
        // Arrange
        Region existingRegion = new Region(5L, "Antigua Región", new ArrayList<>());
        RegionRequest request = new RegionRequest(null, "Nueva Región", new ArrayList<>());

        when(regionRepository.findById(5L)).thenReturn(Optional.of(existingRegion));

        // Act
        RegionResponse result = regionService.update(5L, request);

        // Assert
        assertEquals("Nueva Región", result.nombre());
        assertEquals(5L, result.id());
    }

    @Test
    void testUpdate_NoExistente() {
        // Arrange
        when(regionRepository.findById(50L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> regionService.update(50L, new RegionRequest(null,"Cualquiera", new ArrayList<>())));
    }

    @Test
    void testDelete_SinComunas() {
        // Arrange
        Region region = new Region(8L, "Sin Comuna", new ArrayList<>());

        when(regionRepository.existsById(8L)).thenReturn(true);
        when(regionRepository.findById(8L)).thenReturn(Optional.of(region));

        // Act
        boolean result = regionService.delete(8L);

        // Assert
        assertTrue(result);
        verify(regionRepository).deleteById(8L);
    }

    @Test
    void testDelete_NoExistente() {
        // Arrange
        when(regionRepository.existsById(100L)).thenReturn(false);

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> regionService.delete(100L));
    }
}
