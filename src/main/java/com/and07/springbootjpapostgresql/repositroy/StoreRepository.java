package com.and07.springbootjpapostgresql.repositroy;

import com.and07.springbootjpapostgresql.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
