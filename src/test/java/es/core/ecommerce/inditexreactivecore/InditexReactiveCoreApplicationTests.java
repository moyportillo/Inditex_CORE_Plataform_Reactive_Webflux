package es.core.ecommerce.inditexreactivecore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InditexReactiveCoreApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetPriceReactiveFirstDate() {
        webTestClient.get().uri(uriBuilder -> uriBuilder.path("/api/reactive/price/find")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .queryParam("date", "2020-06-14T10:00:00").build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.price").isEqualTo(35.50);
    }

    @Test
    void testGetPriceReactiveSecondDate() {
        webTestClient.get().uri(uriBuilder -> uriBuilder.path("/api/reactive/price/find")
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .queryParam("date", "2020-06-14T16:00:00").build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.price").isEqualTo(25.45);
    }

    @Test
    void testGetPriceReactiveThirdDate() {
        webTestClient.get().uri(uriBuilder -> uriBuilder.path("/api/reactive/price/find")
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .queryParam("date", "2020-06-14T21:00:00").build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.price").isEqualTo(35.50);
    }

    @Test
    void testGetPriceReactiveFourDate() {
        webTestClient.get().uri(uriBuilder -> uriBuilder.path("/api/reactive/price/find")
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .queryParam("date", "2020-06-15T10:00:00").build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.price").isEqualTo(30.50);
    }

    @Test
    void testGetPriceReactiveFiveDate() {
        webTestClient.get().uri(uriBuilder -> uriBuilder.path("/api/reactive/price/find")
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .queryParam("date", "2020-06-16T21:00:00").build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.price").isEqualTo(38.95);
    }


}
