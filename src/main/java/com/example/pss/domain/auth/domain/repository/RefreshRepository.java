package com.example.pss.domain.auth.domain.repository;

import com.example.pss.domain.auth.domain.Refresh;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RefreshRepository extends CrudRepository<Refresh, String> {
}
