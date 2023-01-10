package com.and07.springbootjpapostgresql.repositroy;

import com.and07.springbootjpapostgresql.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
