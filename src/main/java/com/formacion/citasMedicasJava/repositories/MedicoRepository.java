package com.formacion.citasMedicasJava.repositories;

import com.formacion.citasMedicasJava.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query("select m from Medico m inner join m.pacientes pacientes where pacientes.id = ?1")
    Set<Medico> findAllByPacientes_Id(Long id);

    @Override
    List<Medico> findAll();
}
