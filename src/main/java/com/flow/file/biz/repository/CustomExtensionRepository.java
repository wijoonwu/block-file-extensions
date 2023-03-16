package com.flow.file.biz.repository;

import com.flow.file.biz.entity.CustomExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomExtensionRepository extends JpaRepository<CustomExtension, Long> {

    Optional<CustomExtension> findByName(String name);

    void deleteByName(String name);
}
