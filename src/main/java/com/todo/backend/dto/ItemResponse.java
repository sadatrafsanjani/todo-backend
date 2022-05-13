package com.todo.backend.dto;

import com.todo.backend.model.Item;
import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemResponse {

    private Long id;
    private String itemName;
    private String description;
    private LocalDate date;
    private boolean status;

    public static ItemResponse convertToDto(Item item){

        return ItemResponse.builder()
                .id(item.getId())
                .itemName(item.getItemName())
                .description(item.getDescription())
                .date(item.getDate())
                .status(item.isStatus())
                .build();
    }
}

