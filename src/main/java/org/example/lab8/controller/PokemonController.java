package org.example.lab8.controller;

import org.example.lab8.dao.PokemonDao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/pokemon")
public class PokemonController {

    final PokemonDao pokemonDao;

    public PokemonController(PokemonDao pokemonDao) {
        this.pokemonDao = pokemonDao;
    }

    //Obtener el lugar de encuentro de un pokemon de su preferencia
    @GetMapping("/lugarEncuentro/{id}")
    public ResponseEntity<HashMap<String, Object>> mostrarLugarEncuentro(@PathVariable("id") String idStr) {

        HashMap<String, Object> respuesta = new HashMap<>();

        try {
            int id = Integer.parseInt(idStr);
            String lugar = pokemonDao.buscarLugarPorId(id);

            if (lugar != null) {
                respuesta.put("result", "ok");
                respuesta.put("lugar", lugar);
                return ResponseEntity.ok(respuesta);
            } else {
                respuesta.put("msg", "Pokemon no encontrado");
            }

        } catch (NumberFormatException e) {
            respuesta.put("msg", "el ID debe ser un número entero positivo");
        }
        respuesta.put("result", "failure");
        return ResponseEntity.badRequest().body(respuesta);
    }

    //Obtener el método de encuentro o “encounter_method” que tenga la posibilidad más alta de captura
    @GetMapping("/metodoEncuentro/{id}")
    public ResponseEntity<HashMap<String, Object>> mostrarMetodoEncuentro(@PathVariable("id") String idStr) {

        HashMap<String, Object> respuesta1 = new HashMap<>();

        try {
            int id = Integer.parseInt(idStr);
            String lugar = pokemonDao.buscarLugarPorId(id);
            String metodo = pokemonDao.buscarMetodoPorNombre(lugar);

            if (lugar != null) {
                respuesta1.put("result", "ok");
                respuesta1.put("metodo", metodo);
                return ResponseEntity.ok(respuesta1);
            } else {
                respuesta1.put("msg", "Pokemon no encontrado");
            }

        } catch (NumberFormatException e) {
            respuesta1.put("msg", "el ID debe ser un número entero positivo");
        }
        respuesta1.put("result", "failure");
        return ResponseEntity.badRequest().body(respuesta1);
    }







}


