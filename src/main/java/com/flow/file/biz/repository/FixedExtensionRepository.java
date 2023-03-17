package com.flow.file.biz.repository;

import com.flow.file.biz.entity.FixedExtension;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedExtensionRepository extends JpaRepository<FixedExtension, Long> {

    Optional<FixedExtension> findByName(String name);
}
