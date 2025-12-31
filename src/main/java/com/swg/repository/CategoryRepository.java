package com.swg.repository;

import com.swg.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//Repository interface for Category entity(Category Repository)
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> FindByStoreId(long storeId);
}
