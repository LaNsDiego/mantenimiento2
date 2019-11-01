package com.bibliotecaupt.bibliotecaupt.cliente;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteService extends JpaRepository<ClienteModel,Integer> {
}
