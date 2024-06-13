package org.example.lab8.dao;

import org.example.lab8.dto.PokemonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonDao {
    public String buscarLugarEncuentroPorId(int id){

        String lugar = null;

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://pokeapi.co/api/v2/encounter-method/" + id;

        ResponseEntity<PokemonDto> forEntity = restTemplate.getForEntity(url, PokemonDto.class);

        if(forEntity.getStatusCode().is2xxSuccessful()){
            PokemonDto pokemonDto = forEntity.getBody();
            lugar = pokemonDto.getName();
        }

        return lugar;
    }
}
