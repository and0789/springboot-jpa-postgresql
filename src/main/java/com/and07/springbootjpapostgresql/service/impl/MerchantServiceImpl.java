package com.and07.springbootjpapostgresql.service.impl;

import com.and07.springbootjpapostgresql.dto.MerchantDTO;
import com.and07.springbootjpapostgresql.model.Merchant;
import com.and07.springbootjpapostgresql.repositroy.MerchantRepository;
import com.and07.springbootjpapostgresql.service.MerchantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class MerchantServiceImpl implements MerchantService {
    private final MerchantRepository merchantRepository;
    ObjectMapper mapper = new ObjectMapper();

    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public Merchant create(Merchant merchant) {
        Merchant result = merchantRepository.save(merchant);
        return result;
    }

    @Override
    public Merchant update(Long id, Merchant merchant) {
        Merchant result = findById(id);
        if (result != null) {
            result.setName(merchant.getName());
            return merchantRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(long id) {
        Merchant result = findById(id);
        if (result != null) {
            // hard delete;
            merchantRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Merchant> findAll() {
        return merchantRepository.findAll();
    }

    @Override
    public Page<Merchant> findAllWithPageable(Pageable pageable) {
        return merchantRepository.findAll(pageable);
    }

    @Override
    public Merchant findById(Long id) {
        Optional<Merchant> result = merchantRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public MerchantDTO mapToDto(Merchant merchant) {
        return mapper.convertValue(merchant, MerchantDTO.class);
    }

    @Override
    public Merchant mapToEntity(MerchantDTO merchantDTO) {
        return mapper.convertValue(merchantDTO, Merchant.class);
    }
}
