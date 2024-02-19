package com.example.CVMParams.cvm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface CardLimitRepository extends JpaRepository<CardLimit, Long> {

    List<CardLimit> findAllByCardLimitIdNotIn(Set<Long> cardLimitIds);
    List<CardLimit> findAllByCardLimitIdIsIn(Set<Long> cardLimitIds);
}
