package com.crc.socialbooks.com.algaworks.socialbooks.repository;

import com.crc.socialbooks.com.algaworks.socialbooks.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
