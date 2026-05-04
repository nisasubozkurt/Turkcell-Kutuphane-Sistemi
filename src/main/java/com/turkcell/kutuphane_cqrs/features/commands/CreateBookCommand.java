package com.turkcell.kutuphane_cqrs.features.commands;

import lombok.Data;

@Data
public class CreateBookCommand {
    private String baslik;
    private String yazar;
    private String isbn;
    private int sayfaSayisi;
}
