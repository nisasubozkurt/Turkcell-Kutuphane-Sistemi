package com.turkcell.kutuphane_cqrs.features.commands;

import lombok.Data;

@Data
public class CreateBorrowingCommand {
    private Long studentId;
    private Long bookId;
}
