package com.alunoonline.api.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatchGradesRequestDto {

    private Double nota1;
    private Double nota2;
}
