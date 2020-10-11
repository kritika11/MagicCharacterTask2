package com.example.MagicCharacter.model;

import com.example.MagicCharacter.serializer.MagicCharacterSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonSerialize(using = MagicCharacterSerializer.class)
public class MagicCharacterWrapper {

    private List<MagicCharacter> magicCharacterList;

    public MagicCharacterWrapper(List<MagicCharacter> magicCharactersList) {
        this.magicCharacterList = magicCharactersList;
    }

    public List<MagicCharacter> getMagicCharacterList() {
        return magicCharacterList;
    }

    public void setMagicCharacterList(List<MagicCharacter> magicCharacterList) {
        this.magicCharacterList = magicCharacterList;
    }
}
