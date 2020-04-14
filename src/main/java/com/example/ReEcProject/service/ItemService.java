package com.example.ReEcProject.service;

import com.example.ReEcProject.domain.Item;
import com.example.ReEcProject.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getItems(){
        return (List<Item>) itemRepository.findAll();
    }

    public Item getItemById(final Integer id){
        return itemRepository.findById(id).orElseThrow();
    }
}
