package com.turkcell.kutuphane_cqrs.features.queries;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetStudentByIdQuery {
    private Long id; // Hangi öğrenciyi arıyoruz? İşte bu bir sorgu parametresidir.
}
