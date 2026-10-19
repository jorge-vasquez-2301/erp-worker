package com.debuggeandoideas.worker.batch.writers;

import com.debuggeandoideas.worker.batch.dtos.CatalogCacheDto;
import com.debuggeandoideas.worker.batch.utils.RedisKeys;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import static com.debuggeandoideas.worker.batch.utils.RedisKeys.*;

@Component
@RequiredArgsConstructor
public class CatalogRedisWriter implements ItemWriter<CatalogCacheDto> {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void write(Chunk<? extends CatalogCacheDto> chunk) {
        chunk.getItems().forEach(catalog -> {

            redisTemplate.opsForValue().set(
                    CATALOGS_BY_TYPE + catalog.type(),
                    catalog,
                    RedisKeys.TTL_HOURS, TimeUnit.HOURS
            );

            catalog.items().forEach(item ->
                    redisTemplate.opsForValue().set(
                            CATALOGS_ITEMS + item.code(),
                            item,
                            RedisKeys.TTL_HOURS, TimeUnit.HOURS
                    )
            );
        });
    }
}