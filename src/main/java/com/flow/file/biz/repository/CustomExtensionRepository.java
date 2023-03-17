package com.flow.file.biz.repository;

import com.flow.file.biz.entity.CustomExtension;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomExtensionRepository extends JpaRepository<CustomExtension, Long> {

    Optional<CustomExtension> findByName(String name);

}
