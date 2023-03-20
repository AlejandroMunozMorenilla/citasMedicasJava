package com.formacion.citasMedicasJava.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@NoArgsConstructor
@Component
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String clave;
}
