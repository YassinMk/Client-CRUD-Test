package org.yassinmk.clientcrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.yassinmk.clientcrud.entities.Client;
import org.yassinmk.clientcrud.repository.ClientRepository;

@SpringBootApplication
public class ClientCrudApplication {


    public static void main(String[] args) {
        SpringApplication.run(ClientCrudApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                Client client = Client.builder()
                        .name("Client" + i)
                        .email("client" + i + "@example.com")
                        .phone("123456789" + i)
                        .build();
                clientRepository.save(client);
            }
        };
    }


}
