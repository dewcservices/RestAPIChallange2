package com.softwareengineeringchallenge.restAPIchallge2.dao;

/* 
 * MockedItemDaoImpl.java:
 * This class provides a mock implementation of the ItemDao interface. 
 * Instead of interacting with a real database, it returns predefined/mock data.
 */

//local
import com.softwareengineeringchallenge.restAPIchallge2.entity.Item;
import com.softwareengineeringchallenge.restAPIchallge2.repository.ItemRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.softwareengineeringchallenge.restAPIchallge2.adapter.ItemAdapter;
import com.softwareengineeringchallenge.restAPIchallge2.dto.ItemDto;
import com.softwareengineeringchallenge.restAPIchallge2.dao.*;
import com.softwareengineeringchallenge.restAPIchallge2.service.*;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


@Repository
//drink prime?
@Qualifier("mockedItemDao")
public class MockedItemDaoImpl implements ItemDao {
    // Here, we can mock the responses for demonstration/testing purposes
    @Override
    public Item save(Item item) {
        // Mock an item save
        // the L suffix indicates it's a Long literal in Java
        return new Item(1L, "MockedName", "MockedDescription");
    }

    @Override
    public Optional<Item> findById(Long id) {
        // Mock finding an item
        return Optional.of(new Item(id, "MockedName", "MockedDescription"));
    }

    @Override
    public Item update(Item item) {
        // Mock updating an item
        return item;
    }

    @Override
    public void deleteById(Long id) {
        // Mock deleting an item
        // Do nothing
    }
}
