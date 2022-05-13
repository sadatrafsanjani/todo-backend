package com.todo.backend.repository;

import com.todo.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT I FROM Item I ORDER BY I.id DESC")
    List<Item> findAllOrderByIdDesc();
    List<Item> findAllByStatusTrue();
    List<Item> findAllByStatusFalse();
}
