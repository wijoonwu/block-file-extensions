package com.flow.board.repository;

import com.flow.board.entity.FixedExtension;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedExtensionRepository extends JpaRepository<FixedExtension, Long > {

    Optional<FixedExtension> findByName(String name);
}
