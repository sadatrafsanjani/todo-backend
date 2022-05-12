package com.todo.backend.dto;

import com.todo.backend.model.Item;
import com.todo.backend.utility.DateFormatter;
import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemResponse {

    private Long id;
    private String itemName;
    private String description;
    private Date date;
    private boolean status;

    public static ItemResponse convertToDto(Item item){

        return ItemResponse.builder()
                .id(item.getId())
                .itemName(item.getItemName())
                .description(item.getDescription())
                .date(DateFormatter.fromInstantToDate(item.getDate()))
                .status(item.isStatus())
                .build();
    }
}

