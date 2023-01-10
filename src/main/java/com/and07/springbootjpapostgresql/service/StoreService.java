package com.and07.springbootjpapostgresql.service;

import com.and07.springbootjpapostgresql.dto.StoreDTO;
import com.and07.springbootjpapostgresql.model.Store;

public interface StoreService {

    Store addStore(Long merchantId, Store store);

    Store mapToEntity(StoreDTO storeDTO);

    StoreDTO mapToDto(Store store);
}
