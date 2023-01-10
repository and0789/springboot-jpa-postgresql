package com.and07.springbootjpapostgresql.controller;


import com.and07.springbootjpapostgresql.dto.MerchantDTO;
import com.and07.springbootjpapostgresql.model.Merchant;
import com.and07.springbootjpapostgresql.service.MerchantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }


    @PostMapping("/create")
    public MerchantDTO create(@RequestBody MerchantDTO request) {
        Merchant merchant = merchantService.mapToEntity(request);
        Merchant result = merchantService.create(merchant);
        return merchantService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public MerchantDTO update(@PathVariable Long id, @RequestBody MerchantDTO request) {
        Merchant merchant = merchantService.mapToEntity(request);
        Merchant result = merchantService.update(id, merchant);
        return merchantService.mapToDto(result);
    }


    @GetMapping("/all")
    public List<MerchantDTO> findAll() {
        return merchantService.findAll().stream().map(merchantService::mapToDto).collect(Collectors.toList());
    }

    @GetMapping("/search")
    public Page<MerchantDTO> findAllWithPagination(@PageableDefault Pageable pageable) {
        return merchantService.findAllWithPageable(pageable).map(merchantService::mapToDto);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id) {
        return merchantService.delete(id);
    }


}
