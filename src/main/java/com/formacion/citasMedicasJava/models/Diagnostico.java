package com.formacion.citasMedicasJava.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "DIAGNOSTICO")
@Getter
@Setter
@NoArgsConstructor
public class Diagnostico extends AbstractPersistable<Long> {
    @Column(nullable = false)
    private String valoracionEspecialista;
    @Column(length = 30)
    private String enfermedad;
}
