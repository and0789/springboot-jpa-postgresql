package com.and07.springbootjpapostgresql.dto;

import java.util.List;

public record MerchantDTO (Long id, String name, List<StoreDTO> stores) {
}
