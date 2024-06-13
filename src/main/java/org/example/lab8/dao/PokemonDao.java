package org.example.lab8.dao;

import org.example.lab8.dto.PokemonDto;
import org.example.lab8.entity.Pokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonDao {
    public String buscarLugarPorId(int id){

        String lugar = null;

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://pokeapi.co/api/v2/pokemon/" + id;

        ResponseEntity<PokemonDto> forEntity = restTemplate.getForEntity(url, PokemonDto.class);

        if(forEntity.getStatusCode().is2xxSuccessful()){
            PokemonDto pokemonDto = forEntity.getBody();
            lugar = pokemonDto.getLocation_area_encounters();
        }

        return lugar;
    }

    public String buscarMetodoPorNombre(String nombre){


        return nombre;
    }

}
