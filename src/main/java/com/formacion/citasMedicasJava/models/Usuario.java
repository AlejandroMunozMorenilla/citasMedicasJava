package com.formacion.citasMedicasJava.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
public class Usuario extends AbstractPersistable<Long> {
    @Column(name = "nombre", length = 25, nullable = false)
    private String nombre;
    @Column(name = "apellidos", length = 30, nullable = false)
    private String apellidos;
    @Column(name = "usuario", length = 25, nullable = false, unique = true)
    private String usuario;
    @Column(name = "clave", nullable = false)
    private String clave;


}