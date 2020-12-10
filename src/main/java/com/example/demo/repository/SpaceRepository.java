package com.example.demo.repository;

import com.example.demo.domain.Space;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpaceRepository extends JpaRepository<Space, Long> {

    List<Space> findByHostId(Long hostId);
}
