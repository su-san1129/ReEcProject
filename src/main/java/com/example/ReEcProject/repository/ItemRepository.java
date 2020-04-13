package com.example.ReEcProject.repository;

import com.example.ReEcProject.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
