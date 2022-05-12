package com.todo.backend.repository;

import com.todo.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByStatusTrue();
    List<Item> findAllByStatusFalse();
}
