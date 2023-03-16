package com.formacion.citasMedicasJava;

import com.formacion.citasMedicasJava.controllers.MedicoController;
import com.formacion.citasMedicasJava.controllers.PacienteController;
import com.formacion.citasMedicasJava.controllers.UsuarioController;
import com.formacion.citasMedicasJava.models.Medico;
import com.formacion.citasMedicasJava.models.Paciente;
import com.formacion.citasMedicasJava.repositories.MedicoRepository;
import com.formacion.citasMedicasJava.repositories.PacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Demo implements CommandLineRunner {
    private final UsuarioController usuarioController;
    private final MedicoController medicoController;
    private final PacienteController pacienteController;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public Demo(UsuarioController usuarioController, MedicoController medicoController, PacienteController pacienteController,
                PacienteRepository pacienteRepository,
                MedicoRepository medicoRepository) {
        this.usuarioController = usuarioController;
        this.medicoController = medicoController;
        this.pacienteController = pacienteController;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Medico medico = new Medico();
        medico.setUsuario("antonio");
        medico.setNombre("Antonio");
        medico.setApellidos("Perez");
        medico.setClave("123");
        medico.setNumColegiado("123");

        Paciente paciente = new Paciente();
        paciente.setUsuario("pepe");
        paciente.setNombre("Pepe");
        paciente.setApellidos("Martinez");
        paciente.setClave("123");
        paciente.setNSS("123");
        paciente.setTelefono("123");
        paciente.setNumTarjeta("123");
        paciente.setDireccion("asd");

        medico.getPacientes().add(paciente);
        pacienteRepository.save(paciente);
        medicoRepository.save(medico);
    }
}
