package com.firstSpringBootProject.first.Product.infrastructure.adapters.outputs.persistence.repositories;

import com.firstSpringBootProject.first.Category.infrastructure.adapters.output.persistence.entities.CategoryEntity;
import com.firstSpringBootProject.first.Category.infrastructure.adapters.output.persistence.repositories.JpaCategoryRepositoryAdapter;
import com.firstSpringBootProject.first.Product.domain.exceptions.ErrorProductMessageCode;
import com.firstSpringBootProject.first.Product.domain.exceptions.ProductDomainException;
import com.firstSpringBootProject.first.Product.domain.models.Product;
import com.firstSpringBootProject.first.Product.domain.ports.out.ProductRepositoryPort;
import com.firstSpringBootProject.first.Product.infrastructure.adapters.outputs.persistence.entities.ProductEntity;
import com.firstSpringBootProject.first.Product.infrastructure.adapters.outputs.persistence.mappers.ProductPercistenceMapper;
import com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.entities.UserEntity;
import com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.repositories.JpaUserRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {

    @Autowired
    private JpaProductRepository productPersistence;

    @Autowired
    private JpaCategoryRepositoryAdapter jpaCategoryRepositoryAdapter;

    @Autowired
    private JpaUserRepositoryAdapter jpaUserRepositoryAdapter;

    @Autowired
    private ProductPercistenceMapper productMapper;


    @Override
    public Product save(Product product) {

        if(this.findByName((product.getName())).isPresent()){
            throw new ProductDomainException(
                    ErrorProductMessageCode.PRODUCT_NAME_CONFLICT.getStatus(),
                    ErrorProductMessageCode.PRODUCT_NAME_CONFLICT.getType(),
                    String.format(ErrorProductMessageCode.PRODUCT_NAME_CONFLICT.getMessage() + product.getName()),
                    null
            );
        }

        UserEntity userEntity = jpaUserRepositoryAdapter.findEntityById(product.getUserId());

        CategoryEntity categoryEntity = jpaCategoryRepositoryAdapter.findEntityById(product.getCategoryId());


        Product newProduct = new Product(
                product.getName(),
                product.getCode(),
                product.getDescription(),
                product.getUrlImage(),
                product.getPrice(),
                userEntity.getId(),
                categoryEntity.getId()
        );

        ProductEntity productEntity = productMapper.toProductEntity(newProduct);

        productEntity.setCategory(categoryEntity);
        productEntity.setUser(userEntity);

        productPersistence.save(productEntity);

        return productMapper.toProduct(productEntity);
    }

    @Override
    public List<Product> findAll() {
        return productMapper.toProducts(productPersistence.findAll());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productPersistence.findById(id)
                .map(productMapper::toProduct);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productPersistence.findByName(name)
                .map(productMapper::toProduct);
    }

    @Override
    public Product update(Long id, Product product) {

        ProductEntity existingProductEntity = productPersistence.findById(id)
                .orElseThrow( () -> new ProductDomainException(
                        ErrorProductMessageCode.PRODUCT_NOT_FOUND_ID.getStatus(),
                        ErrorProductMessageCode.PRODUCT_NOT_FOUND_ID.getType(),
                        String.format(ErrorProductMessageCode.PRODUCT_NOT_FOUND_ID.getMessage() + id),
                        null
                        )
                );

        if(product.getName() != null){
            existingProductEntity.setName(product.getName());
        }

        if(product.getCode() != null){
            existingProductEntity.setCode(product.getCode());
        }

        if(product.getDescription() != null){
            existingProductEntity.setDescription(product.getDescription());
        }

        if(product.getUrlImage() != null){
            existingProductEntity.setUrlImage(product.getUrlImage());
        }

        if(product.getPrice() != null){
            existingProductEntity.setPrice(product.getPrice());
        }

//        if(product.getUserId() != null){
//            existingProductEntity.setUser(product.getUserId());
//        }
//
//        if(product.getCategoryId() != null){
//            existingProductEntity.setCategory(product.getCategoryId());
//        }

//        if (product.getUserId() != null) {
//            UserEntity userEntity = userRepository.findById(product.getUserId())
//                    .orElseThrow(() -> new RuntimeException("User not found"));
//            existingProductEntity.setUser(userEntity);
//        }

        if (product.getDateUpdated() != null) {
            LocalDateTime updatedDate = LocalDateTime.parse(product.getDateUpdated());
            existingProductEntity.setDateUpdated(updatedDate);
        }


        ProductEntity updateProductEntity = productPersistence.save(existingProductEntity);
        return productMapper.toProduct(updateProductEntity);
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Product> existingProduct = this.findById(id);

        if(existingProduct.isPresent()){
            productPersistence.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
