package com.turkcell.kutuphane_cqrs.features.commands;

import lombok.Data;

@Data
public class CreateStudentCommand {
    private String ad;
    private String soyad;
    private String studentNo;
}
