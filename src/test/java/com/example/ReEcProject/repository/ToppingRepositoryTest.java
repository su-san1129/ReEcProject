package com.example.ReEcProject.repository;

import com.example.ReEcProject.domain.Topping;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
class ToppingRepositoryTest {

    @Autowired
    private ToppingRepository repository;

    @Test
    public void findAllTest(){
        List<Topping> all = (List<Topping>) repository.findAll();
        assertEquals(28, all.size());
    }

    @Test
    public void loadTest() throws Exception {
        final var byId = repository.findById(1).orElseThrow(Exception::new);
        assertEquals(1, byId.getId());
    }

}