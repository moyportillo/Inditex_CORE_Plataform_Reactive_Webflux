# Inditex Product Pricing Service

Este proyecto es un servicio basado en **Spring Boot** utilizando arquitectura hexagonal y **Spring WebFlux** para gestionar los precios de productos del ecommerce de **Inditex**. Proporciona una API REST que permite consultar el precio aplicable en función de la fecha de consulta, el identificador del producto y la marca, sobre una base de datos en memoria.

## Descripción

El servicio permite consultar los precios de productos con las siguientes especificaciones:

- Se aceptan como parámetros: fecha de consulta, identificador del producto y el identificador de la marca.
- Se retorna la tarifa y el precio aplicable, dentro del rango de fechas en que esté vigente.
- La base de datos es **H2 en memoria** y contiene una tabla llamada **PRICES**, con los campos `ID`, `BRAND_ID`, `BRAND_NAME`, `START_DATE`, `END_DATE`, `PRICE_LIST`, `PRODUCT_ID`, `PRIORITY`, `PRICE`, `CURRENCY`, `CREATE_DATE` y `STATE_REGISTER`.

### Arquitectura Hexagonal

El proyecto sigue la arquitectura hexagonal para permitir una separación clara entre la lógica de negocio (dominio) y las interfaces externas (como bases de datos y API REST).

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

- **Java 21**
- **Maven 3.8+**
- **IntelliJ IDEA** o cualquier otro IDE con soporte para Maven y Java.

## Tecnologías Utilizadas

- **Java 21**: Versión más reciente de Java, que incluye nuevas características del lenguaje y mejoras de rendimiento.
- **Spring Boot 3.x**: Framework para desarrollar aplicaciones Java rápidas y seguras.
- **Spring WebFlux**: Para crear servicios reactivos no bloqueantes.
- **R2DBC**: Para trabajar con bases de datos reactivas.
- **JUnit 5**: Framework para pruebas unitarias.
- **H2**: Base de datos en memoria para pruebas.

## Instalación y Configuración

1. Clona este repositorio:

    ```bash
    git clone https://github.com/tu-usuario/inditex-pricing-service.git
    cd inditex-pricing-service
    ```

2. Compila el proyecto y descarga las dependencias:

    ```bash
    mvn clean install
    ```

## Ejecución del Proyecto

1. Ejecuta la aplicación desde la línea de comandos:

    ```bash
    mvn spring-boot:run
    ```

2. La aplicación estará disponible en `http://localhost:8080`.

## API Endpoints

### Consulta de precios

- **GET** `/api/v1/prices`

#### Parámetros:

- `date` (String, formato ISO8601): Fecha de la consulta.
- `productId` (Long): Identificador del producto.
- `brandId` (Long): Identificador de la marca.

#### Ejemplo de solicitud:

```bash
curl -X GET "http://localhost:8080/api/v1/prices?date=2020-06-14T10:00:00&productId=35455&brandId=1"
