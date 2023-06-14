package com.foodfinder.oseek.repository;

import com.foodfinder.oseek.domain.code.Code;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodeRepository extends JpaRepository<Code, Long> {
    List<Code> findAllByCodeGroup(String codeGroup, Sort sort);

}
