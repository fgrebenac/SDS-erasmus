package com.SDS.Erasmus.dao;

import com.SDS.Erasmus.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
