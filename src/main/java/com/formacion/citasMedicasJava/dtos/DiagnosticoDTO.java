package com.formacion.citasMedicasJava.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class DiagnosticoDTO {
    private Long id;
    private String valoracionEspecialista;
    private String enfermedad;
}
