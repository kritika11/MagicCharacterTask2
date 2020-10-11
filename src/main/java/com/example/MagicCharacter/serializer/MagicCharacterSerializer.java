package com.example.MagicCharacter.serializer;

import com.example.MagicCharacter.model.MagicCharacter;
import com.example.MagicCharacter.model.MagicCharacterWrapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MagicCharacterSerializer extends JsonSerializer<MagicCharacterWrapper> {

    @Override
    public void serialize(MagicCharacterWrapper magicCharacters, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        List<MagicCharacter> allCharacters = magicCharacters.getMagicCharacterList();
        Set<String> uniqueCharacters = new HashSet<>();
        jsonGenerator.writeStartArray();
        jsonGenerator.writeRaw('\n');

        for(MagicCharacter mChar1 : allCharacters){

            if(uniqueCharacters.contains(mChar1.getName())){
                continue;
            }else{
                uniqueCharacters.add(mChar1.getName());
            }

            jsonGenerator.writeStartObject();
            jsonGenerator.writeRaw('\n');
            jsonGenerator.writeStringField("Name", mChar1.getName());
            jsonGenerator.writeRaw('\n');
            jsonGenerator.writeFieldName("Sub Classes: ");
            jsonGenerator.writeStartArray();
            jsonGenerator.writeRaw('\n');
            jsonGenerator.writeStartObject();

            for(MagicCharacter mChar2 : allCharacters){

                if(mChar2.getParentId() == mChar1.getId()){
                    uniqueCharacters.add(mChar2.getName());
                    jsonGenerator.writeStringField("Name", mChar2.getName());
                    jsonGenerator.writeRaw('\n');
                }
            }

            jsonGenerator.writeEndObject();
            jsonGenerator.writeEndArray();
            jsonGenerator.writeEndObject();

        }
        jsonGenerator.writeEndArray();
    }
}