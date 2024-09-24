package es.core.ecommerce.inditexreactivecore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Brands {

    private String id;
    private Integer brandId;
    private String brandName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Integer productId;
    private Integer priority;
    private BigDecimal price;
    private String currency;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String stateRegister;
}
