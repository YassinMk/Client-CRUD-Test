package org.yassinmk.clientcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yassinmk.clientcrud.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
