package es.core.ecommerce.inditexreactivecore.infrastructure.datebase;

import es.core.ecommerce.inditexreactivecore.domain.model.Brands;
import es.core.ecommerce.inditexreactivecore.domain.repository.PriceReactivePort;
import io.r2dbc.spi.Row;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class PriceReactiveRepository implements PriceReactivePort {

    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    @Override
    public Mono<Brands> findAllBrands(long productId, long brandId, LocalDateTime date) {
        String query = "SELECT * FROM PRICES WHERE PRODUCT_ID = :productId " +
                "AND BRAND_ID = :brandId " +
                "AND :date BETWEEN START_DATE AND END_DATE " +
                "ORDER BY PRIORITY DESC LIMIT 1";
        return r2dbcEntityTemplate
                .getDatabaseClient()
                .sql(query)
                .bind("productId", productId)
                .bind("brandId", brandId)
                .bind("date", date)
                .map((row, rowMetadata) -> mapRowToPrice(row))
                .one();
    }

    private Brands mapRowToPrice(Row row) {
        return new Brands(
                row.get("id", String.class),
                row.get("brand_id", Integer.class),        // BRAND_ID
                row.get("brand_name", String.class),
                row.get("start_date", LocalDateTime.class),  // START_DATE
                row.get("end_date", LocalDateTime.class),    // END_DATE
                row.get("price_list", Integer.class),      // PRICE_LIST
                row.get("product_id", Integer.class),      // PRODUCT_ID
                row.get("priority", Integer.class),     // PRIORITY
                row.get("price", BigDecimal.class),     // PRICE
                row.get("currency", String.class),       // CURRENCY
                row.get("create_date", LocalDateTime.class),
                row.get("update_date", LocalDateTime.class),
                row.get("state_register", String.class));
    }}
