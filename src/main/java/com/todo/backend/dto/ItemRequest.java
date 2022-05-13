package com.todo.backend.dto;

import com.todo.backend.model.Item;
import com.todo.backend.utility.DateFormatter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ItemRequest {

    private String itemName;
    private String description;
    private Date date;

    public static Item convertToModel(ItemRequest request){

        return Item.builder()
                .itemName(request.getItemName())
                .description(request.getDescription())
                .date(DateFormatter.fromDateToInstant(request.getDate()))
                .status(false)
                .build();
    }
}

