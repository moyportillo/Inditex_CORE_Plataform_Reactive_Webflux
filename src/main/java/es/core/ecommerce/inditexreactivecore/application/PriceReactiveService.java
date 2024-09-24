package es.core.ecommerce.inditexreactivecore.application;

import es.core.ecommerce.inditexreactivecore.domain.model.Brands;
import es.core.ecommerce.inditexreactivecore.domain.repository.PriceReactivePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceReactiveService {

    private final PriceReactivePort priceReactivePort;

    public Mono<Brands> getPriceReactivePort(long productId, long brandId, LocalDateTime date) {
        return priceReactivePort.findAllBrands(productId,brandId, date);
    }
}
