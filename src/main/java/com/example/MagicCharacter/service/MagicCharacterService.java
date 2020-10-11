package com.example.MagicCharacter.service;

import com.example.MagicCharacter.model.MagicCharacter;

import java.util.List;

public interface MagicCharacterService {

    public List<MagicCharacter> getAll();
    public void saveMagicCharacter(MagicCharacter magicCharacter);

}
