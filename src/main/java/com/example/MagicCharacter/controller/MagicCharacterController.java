package com.example.MagicCharacter.controller;

import com.example.MagicCharacter.model.MagicCharacter;
import com.example.MagicCharacter.serializer.MagicCharacterSerializer;
import com.example.MagicCharacter.model.MagicCharacterWrapper;
import com.example.MagicCharacter.service.MagicCharacterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/characters")
public class MagicCharacterController {

    @Autowired
    MagicCharacterService magicCharacterService;

    public List<MagicCharacter> getAll(){
        List<MagicCharacter> magicCharactersList = magicCharacterService.getAll();
        return magicCharactersList;
    }

    @GetMapping("/characters")
    public String findAll() throws JsonProcessingException {
        List<MagicCharacter> magicCharactersList = getAll();
        MagicCharacterWrapper mcw = new MagicCharacterWrapper(magicCharactersList);
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(MagicCharacterWrapper.class, new MagicCharacterSerializer());
        mapper.registerModule(module);
        String serialized = mapper.writeValueAsString(mcw);
        return serialized;
    }

    @PostMapping("characters/save")
    public void saveMagicCharacter(@RequestBody MagicCharacter magicCharacter){
        magicCharacterService.saveMagicCharacter(magicCharacter);
    }
}
