package com.todo.backend.controller;

import com.todo.backend.dto.ItemRequest;
import com.todo.backend.dto.ItemResponse;
import com.todo.backend.service.ItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/items")
@AllArgsConstructor
public class ItemController {

    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemResponse>> getAllItems(){

        List<ItemResponse> responses = itemService.getAllItems();

        if(responses.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/completed")
    public ResponseEntity<List<ItemResponse>> getAllCompletedItems(){

        List<ItemResponse> responses = itemService.getAllCompletedItems();

        if(responses.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/incomplete")
    public ResponseEntity<List<ItemResponse>> getAllIncompleteItems(){

        List<ItemResponse> responses = itemService.getAllIncompleteItems();

        if(responses.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getItemById(@PathVariable("id") long id){

        ItemResponse response = itemService.getItemById(id);

        if(response == null){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Not Found!");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ItemResponse> save(@RequestBody ItemRequest request){

        ItemResponse response = itemService.save(request);

        if(response == null){

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please try again in a moment!");
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemResponse> update(@PathVariable("id") long id, @RequestBody ItemRequest request){

        if(itemService.getItemById(id) == null){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Not Found!");
        }
        else{

            ItemResponse response = itemService.update(id, request);

            if(response == null){

                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
    }
}
