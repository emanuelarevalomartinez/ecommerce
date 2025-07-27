package com.firstSpringBootProject.first.Product.infrastructure.configs;

import com.firstSpringBootProject.first.Product.application.usecases.*;
import com.firstSpringBootProject.first.Product.domain.ports.out.ProductRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepositoryPort productRepositoryPort) {
        return new CreateProductUseCase(productRepositoryPort);
    }

    @Bean
    public FindAllProductsUseCase findAllProductsUseCase(ProductRepositoryPort productRepositoryPort) {
        return new FindAllProductsUseCase(productRepositoryPort);
    }


    @Bean
    public FindProductByIdUseCase findProductByIdUsecase(ProductRepositoryPort productRepositoryPort) {
        return new FindProductByIdUseCase(productRepositoryPort);
    }


    @Bean
    public UpdateProductByIdUseCase updateProductByIdUseCase(ProductRepositoryPort productRepositoryPort) {
        return new UpdateProductByIdUseCase(productRepositoryPort);
    }

    @Bean
    public DeleteProductUseCase deleteProductUseCase(ProductRepositoryPort productRepositoryPort) {
        return new DeleteProductUseCase(productRepositoryPort);
    }

}
