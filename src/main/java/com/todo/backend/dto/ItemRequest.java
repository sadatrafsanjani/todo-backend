package com.todo.backend.dto;

import com.todo.backend.model.Item;
import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class ItemRequest {

    private String itemName;
    private String description;
    private LocalDate date;
    private boolean status;

    public static Item convertToModel(ItemRequest request){

        return Item.builder()
                .itemName(request.getItemName())
                .description(request.getDescription())
                .date(request.getDate())
                .status(request.isStatus())
                .build();
    }
}

