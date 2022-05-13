package com.todo.backend.service;

import com.todo.backend.dto.ItemRequest;
import com.todo.backend.dto.ItemResponse;
import java.util.List;

public interface ItemService {

    List<ItemResponse> getAllItems();
    List<ItemResponse> getAllCompletedItems();
    List<ItemResponse> getAllIncompleteItems();
    ItemResponse getItemById(long id);
    ItemResponse save(ItemRequest request);
    ItemResponse update(long id, ItemRequest request);
}
