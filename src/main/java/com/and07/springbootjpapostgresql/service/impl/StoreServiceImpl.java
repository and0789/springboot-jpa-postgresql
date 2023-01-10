package com.and07.springbootjpapostgresql.service.impl;

import com.and07.springbootjpapostgresql.dto.StoreDTO;
import com.and07.springbootjpapostgresql.model.Merchant;
import com.and07.springbootjpapostgresql.model.Store;
import com.and07.springbootjpapostgresql.repositroy.MerchantRepository;
import com.and07.springbootjpapostgresql.repositroy.StoreRepository;
import com.and07.springbootjpapostgresql.service.MerchantService;
import com.and07.springbootjpapostgresql.service.StoreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    ObjectMapper mapper = new ObjectMapper();


    @Autowired
    MerchantService merchantService;

    @Autowired
    StoreRepository storeRepository;

    @Override
    public Store addStore(Long merchantId, Store store) {
        Merchant merchant = merchantService.findById(merchantId);
        if (merchant != null) {
            //add store to db
            store = storeRepository.save(store);
            if (merchant.getStores() != null) {
                List<Store> stores = merchant.getStores();
                stores.add(store);
                merchant.setStores(stores);
            } else {
                merchant.setStores(Collections.singletonList(store));
            }
            merchantService.create(merchant);
            return store;
        }
        return null;
    }

    @Override
    public Store mapToEntity(StoreDTO storeDTO) {
        return mapper.convertValue(storeDTO, Store.class);
    }

    @Override
    public StoreDTO mapToDto(Store store) {
        return mapper.convertValue(store, StoreDTO.class);
    }
}
