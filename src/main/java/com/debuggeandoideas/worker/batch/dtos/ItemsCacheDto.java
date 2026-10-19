package com.debuggeandoideas.worker.batch.dtos;

import lombok.Builder;

@Builder
public record ItemsCacheDto(
        String code,
        String value,
        String description,
        Integer displayOrder
) {
}