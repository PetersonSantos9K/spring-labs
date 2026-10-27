package com.petersonsantos.projeto_teste_springboot.repository;

import com.petersonsantos.projeto_teste_springboot.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
