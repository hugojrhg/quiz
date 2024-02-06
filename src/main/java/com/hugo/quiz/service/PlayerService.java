package com.hugo.quiz.service;

import com.hugo.quiz.builder.PlayerMapper;
import com.hugo.quiz.builder.UserMapper;
import com.hugo.quiz.dto.PlayerDTO;
import com.hugo.quiz.model.Player;
import com.hugo.quiz.repository.PlayerRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserService userService;

    @Autowired
    PlayerMapper playerMapper;

    @Autowired
    UserMapper userMapper;

    public PlayerDTO getPlayerById(Long id) {
        return playerMapper.toDTO(playerRepository.findById(id).orElseThrow());
    }

    public List<PlayerDTO> getAllplayers() {
        return playerMapper.toListDTO(playerRepository.findAll());
    }

    public PlayerDTO saveplayer(PlayerDTO playerDTO) throws Exception {
        return playerMapper.toDTO(playerRepository.save(playerMapper.toEntity(playerDTO)));
    }

    public void deleteplayerById(long id) {
        playerRepository.deleteById(id);
    }

    public PlayerDTO updateplayer(PlayerDTO newPlayer, Long id) throws Exception {
        Player oldplayer = playerMapper.toEntity(getPlayerById(id));
        oldplayer.setNickName(newPlayer.getNickName());
        oldplayer.setUser(userMapper.toEntity(newPlayer.getUserDTO()));

        return playerMapper.toDTO(playerRepository.save(oldplayer));
    }

}
