package es.core.ecommerce.inditexreactivecore.infrastructure.controller;

import es.core.ecommerce.inditexreactivecore.application.PriceReactiveService;
import es.core.ecommerce.inditexreactivecore.domain.model.Brands;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/reactive/price")
@RequiredArgsConstructor
public class PriceReactiveController {

        private final PriceReactiveService priceReactiveService;

        @GetMapping("/find")
        public Mono<ResponseEntity<Brands>> getPriceByBrand(
                @RequestParam Long productId,
                @RequestParam Long brandId,
                @RequestParam String date) {
            LocalDateTime applicationDate = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
            return priceReactiveService.getPriceReactivePort(productId, brandId, applicationDate)
                    .map(ResponseEntity::ok)
                    .defaultIfEmpty(ResponseEntity.notFound().build());
        }
}
