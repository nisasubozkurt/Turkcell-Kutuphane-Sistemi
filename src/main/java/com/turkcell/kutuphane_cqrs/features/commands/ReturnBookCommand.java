package com.turkcell.kutuphane_cqrs.features.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnBookCommand {
    private Long borrowingId;
}