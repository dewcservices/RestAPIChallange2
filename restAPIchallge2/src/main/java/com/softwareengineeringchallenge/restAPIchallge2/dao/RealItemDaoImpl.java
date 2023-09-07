package com.softwareengineeringchallenge.restAPIchallge2.dao;

/* 
 * RealItemDaoImpl.java
 * This class provides the actual implementation of the ItemDao interface, 
 * interacting with the real database to perform CRUD operations.
 */

//local
import com.softwareengineeringchallenge.restAPIchallge2.entity.Item;
import com.softwareengineeringchallenge.restAPIchallge2.repository.ItemRepository;

import com.softwareengineeringchallenge.restAPIchallge2.adapter.ItemAdapter;
import com.softwareengineeringchallenge.restAPIchallge2.dto.ItemDto;
import com.softwareengineeringchallenge.restAPIchallge2.dao.*;
import com.softwareengineeringchallenge.restAPIchallge2.service.*;

//imported
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("realItemDao")
public class RealItemDaoImpl implements ItemDao {

    @Autowired
    private ItemRepository repository;

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Item update(Item item) {
        if (repository.existsById(item.getId())) {
            return repository.save(item);
        }
        return null; // or handle it accordingly.
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
