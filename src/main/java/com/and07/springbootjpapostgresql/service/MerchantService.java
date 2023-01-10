package com.and07.springbootjpapostgresql.service;

import com.and07.springbootjpapostgresql.dto.MerchantDTO;
import com.and07.springbootjpapostgresql.model.Merchant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MerchantService {

    Merchant create(Merchant merchant);

    Merchant update(Long id, Merchant merchant);

    Boolean delete(long id);

    List<Merchant> findAll();

    Page<Merchant> findAllWithPageable(Pageable pageable);

    Merchant findById(Long id);

    MerchantDTO mapToDto(Merchant merchant);

    Merchant mapToEntity(MerchantDTO merchantDTO);
}
