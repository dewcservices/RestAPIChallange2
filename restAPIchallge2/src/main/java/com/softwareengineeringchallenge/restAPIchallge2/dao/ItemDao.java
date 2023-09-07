package com.softwareengineeringchallenge.restAPIchallge2.dao;

/*
 * ItemDao.java:
 * This is an interface that defines the contract for data access methods. 
 * Think of it as a blueprint for any class that will interact with the 
 * database (or mock database) for CRUD operations related to Item.
 */

//local
import com.softwareengineeringchallenge.restAPIchallge2.entity.Item;
import com.softwareengineeringchallenge.restAPIchallge2.repository.ItemRepository;

import java.util.Optional;

import com.softwareengineeringchallenge.restAPIchallge2.adapter.ItemAdapter;
import com.softwareengineeringchallenge.restAPIchallge2.dto.ItemDto;
import com.softwareengineeringchallenge.restAPIchallge2.dao.*;
import com.softwareengineeringchallenge.restAPIchallge2.service.*;

public interface ItemDao {
    Item save(Item item);
    Optional<Item> findById(Long id);
    Item update(Item item);
    void deleteById(Long id);
}
