package com.formacion.citasMedicasJava.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@NoArgsConstructor
@Component
public class PacienteDTO extends UsuarioDTO{
    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;
    private Set<MedicoDTO> medicos;

    private String clave;

}
