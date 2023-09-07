package com.softwareengineeringchallenge.restAPIchallge2.service;

/*
 * ItemService.java:
 * It's another interface, but this one is for the service layer. 
 * The service layer generally contains business logic and is a 
 * mediator between the controllers (API endpoints) and the 
 * DAO layer (database interactions).
 */

//local
import com.softwareengineeringchallenge.restAPIchallge2.entity.Item;
import com.softwareengineeringchallenge.restAPIchallge2.repository.ItemRepository;
import com.softwareengineeringchallenge.restAPIchallge2.adapter.ItemAdapter;
import com.softwareengineeringchallenge.restAPIchallge2.dto.ItemDto;
import com.softwareengineeringchallenge.restAPIchallge2.dao.*;
import com.softwareengineeringchallenge.restAPIchallge2.service.*;

public interface ItemService {
    ItemDto createItem(ItemDto item);
    ItemDto getItem(Long id);
    ItemDto updateItem(Long id, ItemDto item);
    boolean deleteItem(Long id);
}
