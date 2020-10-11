package com.example.MagicCharacter.repository;

import com.example.MagicCharacter.model.MagicCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagicCharacterRepository extends JpaRepository<MagicCharacter, Integer> {
}
