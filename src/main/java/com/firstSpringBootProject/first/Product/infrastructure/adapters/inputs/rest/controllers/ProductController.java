package com.firstSpringBootProject.first.Product.infrastructure.adapters.inputs.rest.controllers;

import com.firstSpringBootProject.first.Product.application.usecases.*;
import com.firstSpringBootProject.first.Product.domain.models.Product;
import com.firstSpringBootProject.first.Product.infrastructure.adapters.inputs.rest.dto.CreateProductDto;
import com.firstSpringBootProject.first.Product.infrastructure.adapters.inputs.rest.dto.UpdateProductDto;
import com.firstSpringBootProject.first.Product.infrastructure.adapters.inputs.rest.mappers.ProductRestMapper;
import com.firstSpringBootProject.first.shared.ApiResponse.ApiResponse;
import com.firstSpringBootProject.first.shared.ApiResponse.ResponseHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

  @Autowired
  private ProductRestMapper productRestMapper;

  @Autowired
  private CreateProductUseCase createProductUseCase;

  @Autowired
  private FindAllProductsUseCase findAllProductsUseCase;

  @Autowired
  private FindProductByIdUseCase findProductByIdUseCase;

  @Autowired
  private UpdateProductByIdUseCase updateProductByIdUseCase;

  @Autowired
  private DeleteProductUseCase deleteProductUseCase;


    @PostMapping
    public ResponseEntity<ApiResponse<Product>> createProduct(@Valid @RequestBody CreateProductDto createProductDto) {

        Product newProduct = productRestMapper.createProductFromDtoToDomainProduct(createProductDto);

        Product savedProduct = this.createProductUseCase.save(newProduct);

        return ResponseHandler.generateResponse(
                HttpStatus.CREATED,
                null,
                "Successfully created product",
                savedProduct
        );
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> findAll(){

        List<Product> allProducts = this.findAllProductsUseCase.findAll();

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                null,
                allProducts
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> findProductById(@PathVariable Long id){

        Product findProductById = this.findProductByIdUseCase.findById(id);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                null,
                findProductById
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable Long id, @Valid @RequestBody UpdateProductDto updateProductDto){

        Product updateProduct = productRestMapper.updateProductFromDtoToDomainProduct(updateProductDto);

        Product savedUpdateProduct = this.updateProductByIdUseCase.update(id, updateProduct);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                "Successfully update product",
                savedUpdateProduct
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteCategoryById(@PathVariable Long id){

        this.deleteProductUseCase.deleteById(id);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                "Product successfully deleted",
                null
        );

    }


}
