package com.mm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.entity.ProductEntity;

public interface IProductRepository  extends JpaRepository<ProductEntity, Integer>{												

}
