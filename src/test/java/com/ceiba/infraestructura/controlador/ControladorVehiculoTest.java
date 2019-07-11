package com.ceiba.infraestructura.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.aplicacion.comando.ComandoVehiculo;
import com.ceiba.infraestructura.testdatabuilder.ComandoVehiculoTestDataBuilder;
import com.ceiba.insfraestructura.controlador.ControladorVehiculo;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(ControladorVehiculo.class)
@ComponentScan("com.ceiba.infraestructura")
public class ControladorVehiculoTest {

	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void guardar() throws Exception{
        // arrange
        ComandoVehiculo comandoVehiculo = new ComandoVehiculoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("webapi/vehiculos")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(comandoVehiculo)))
        		.andExpect(status().isOk());
    }
    
    @Test 
    public void listar() throws Exception{
        // arrange

        // act - assert
    	mocMvc.perform(get("webapi/vehiculos")
    		      .contentType(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk())
    		      .andExpect(jsonPath("$", hasSize(1)))
    		      .andExpect(jsonPath("$[0].placa", is("ZAS345")));
    }

}
