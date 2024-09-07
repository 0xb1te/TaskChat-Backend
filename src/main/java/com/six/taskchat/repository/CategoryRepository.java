package com.six.taskchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.six.taskchat.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
