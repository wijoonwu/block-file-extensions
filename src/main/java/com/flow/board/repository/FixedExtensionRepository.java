package com.flow.board.repository;

import com.flow.board.entity.FixedExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedExtensionRepository extends JpaRepository<FixedExtension, Long > {

    FixedExtension findByName(String name);
}
