package com.and07.springbootjpapostgresql.controller;

import com.and07.springbootjpapostgresql.dto.StoreDTO;
import com.and07.springbootjpapostgresql.model.Store;
import com.and07.springbootjpapostgresql.service.StoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {

    final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }


    @PostMapping("/add/{merchantId}")
    public StoreDTO addStoreToMerchant(@PathVariable Long merchantId, @RequestBody StoreDTO request) {
        Store store = storeService.mapToEntity(request);
        Store result = storeService.addStore(merchantId, store);
        return storeService.mapToDto(result);
    }


}
