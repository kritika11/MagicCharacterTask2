package com.example.MagicCharacter.service;

import com.example.MagicCharacter.model.MagicCharacter;
import com.example.MagicCharacter.repository.MagicCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagicCharacterServiceImpl implements MagicCharacterService{

    @Autowired
    MagicCharacterRepository magicCharacterRepository;

    @Override
    public List<MagicCharacter> getAll() {
        return magicCharacterRepository.findAll();
    }

    @Override
    public void saveMagicCharacter(MagicCharacter magicCharacter) {
        magicCharacterRepository.save(magicCharacter);
    }
}
