package com.example.ReEcProject.controller;

import com.example.ReEcProject.domain.Item;
import com.example.ReEcProject.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( RequestPath.ITEM_PATH )
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/getItems")
    public List<Item> getItems(){
        return itemService.getItems();
    }




}
