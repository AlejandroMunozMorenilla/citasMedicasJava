package com.formacion.citasMedicasJava.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String clave;
}
