package com.hugo.quiz.controller;

import com.hugo.quiz.dto.PlayerDTO;
import com.hugo.quiz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllplayers() {
        List<PlayerDTO> playerDTOList = playerService.getAllplayers();
        return new ResponseEntity<>(playerDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getplayerById(@PathVariable Long id) {
        return new ResponseEntity<>(playerService.getPlayerById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<PlayerDTO> saveplayer(@RequestBody PlayerDTO playerDTO) throws Exception {
        return new ResponseEntity<>(playerService.saveplayer(playerDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PlayerDTO> deleteplayer(@PathVariable Long id) {
        playerService.deleteplayerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PlayerDTO> updateplayer(@RequestBody PlayerDTO playerDTO, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(playerService.updateplayer(playerDTO, id), HttpStatus.OK);
    }

}
