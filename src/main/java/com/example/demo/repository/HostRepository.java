package com.example.demo.repository;

import com.example.demo.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {

    Host findByEmail(String email);
}
