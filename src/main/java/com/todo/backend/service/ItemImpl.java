package com.todo.backend.service;

import com.todo.backend.dto.ItemRequest;
import com.todo.backend.dto.ItemResponse;
import com.todo.backend.model.Item;
import com.todo.backend.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ItemImpl implements ItemService {

    private ItemRepository itemRepository;

    @Override
    public List<ItemResponse> getAllItems(){

        List<ItemResponse> responses = new ArrayList<>();

        itemRepository.findAllOrderByIdDesc().forEach(item -> {
            responses.add(ItemResponse.convertToDto(item));
        });

        return responses;
    }

    @Override
    public List<ItemResponse> getAllCompletedItems(){

        List<ItemResponse> responses = new ArrayList<>();

        itemRepository.findAllByStatusTrue().forEach(item -> {
            responses.add(ItemResponse.convertToDto(item));
        });

        return responses;
    }

    @Override
    public List<ItemResponse> getAllIncompleteItems(){

        List<ItemResponse> responses = new ArrayList<>();

        itemRepository.findAllByStatusFalse().forEach(item -> {
            responses.add(ItemResponse.convertToDto(item));
        });

        return responses;
    }

    @Override
    public ItemResponse getItemById(long id){

        Optional<Item> optional = itemRepository.findById(id);

        return optional.isPresent() ? ItemResponse.convertToDto(optional.get()) : null;
    }

    @Override
    public ItemResponse save(ItemRequest request){

        Item item = itemRepository.save(ItemRequest.convertToModel(request));

        return item != null ? ItemResponse.convertToDto(item) : null;
    }

    @Override
    public ItemResponse update(long id, ItemRequest request){

        Item item = itemRepository.getById(id);
        item.setItemName(request.getItemName());
        item.setDescription(request.getDescription());
        item.setDate(request.getDate());
        item.setStatus(request.isStatus());
        item = itemRepository.save(item);

        return item != null ? ItemResponse.convertToDto(item) : null;
    }

}
