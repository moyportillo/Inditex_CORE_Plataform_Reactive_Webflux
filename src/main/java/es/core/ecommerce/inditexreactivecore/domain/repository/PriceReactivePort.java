package es.core.ecommerce.inditexreactivecore.domain.repository;

import es.core.ecommerce.inditexreactivecore.domain.model.Brands;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface PriceReactivePort {
    Mono<Brands> findAllBrands(long productId, long brandId, LocalDateTime date);
}
