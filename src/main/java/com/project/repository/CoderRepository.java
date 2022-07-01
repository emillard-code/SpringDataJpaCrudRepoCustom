package com.project.repository;

import com.project.model.Coder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoderRepository extends CrudRepository<Coder, Integer> {

    // Spring Data JPA is able to automatically add functionality to this method.
    // If you use findBy<FieldName> method format, it will return all entries with matching data.
    List<Coder> findByProgLanguage(String progLanguage);

    // Spring Data JPA is also able to filter the returning data to an extent.
    List<Coder> findByIdGreaterThan(int id);

}
