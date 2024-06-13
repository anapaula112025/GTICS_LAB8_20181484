package org.example.lab8.dto;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class PokemonDto {
    private Integer id;
    private String name;
    private Integer base_experiencia;
    private Integer altura;
    private boolean es_predeterminado;
    private Integer orden;
    private Integer peso;
    private List habilidades;
    private List formas;
    private List juego_indices;
    private List sostenido_elementos;
    private List held_items;
    private String location_area_encounters;
    private List moves;
    private List past_types;
    private List cries;
    private List species;
    private List stats;
    private List types;




}
