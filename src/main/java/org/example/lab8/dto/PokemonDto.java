package org.example.lab8.dto;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class PokemonDto {
    private Integer id;
    private String name;

    private Integer order;
    private List names;
}
