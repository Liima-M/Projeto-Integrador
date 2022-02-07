package com.example.appdereservas.config;

import com.example.appdereservas.entities.Cliente;
import com.example.appdereservas.entities.Servico;
import com.example.appdereservas.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private GestorRepository gestorRepository;

    @Autowired
    private RecepcionistaRepository recepcionistaRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public void run(String... args) throws Exception {

        Cliente c1 = new Cliente(null, "matehus", "teixeira", "Cabo Frio", "matheusportinho12@gmail.com", "22", "988086538", "123456");

        Servico s1 = new Servico(null, "quarto simples", "deixa sem", "quarto simples com vista pro mar", 23.99, c1);
        Servico s2 = new Servico(null, "quarto premium", "deixa sem", "quarto simples com vista pro mar", 32.99, c1);

        clienteRepository.saveAll(Arrays.asList(c1));
        servicoRepository.saveAll(Arrays.asList(s1,s2));
    }
}
