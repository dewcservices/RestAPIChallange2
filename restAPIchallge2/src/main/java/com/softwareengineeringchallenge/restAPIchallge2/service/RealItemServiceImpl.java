package com.softwareengineeringchallenge.restAPIchallge2.service;

/*
 * RealItemServiceImpl.java:
 * This class provides the real implementation of the ItemService 
 * interface and uses RealItemDaoImpl for actual database interactions.
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
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RealItemServiceImpl implements ItemService {

    @Autowired
    @Qualifier("realItemDao")
    private ItemDao itemDao;

    @Override
    public ItemDto createItem(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
        Item savedItem = itemDao.save(item);
        System.out.println("RealItemServiceImpl: create");
        return new ItemDto(savedItem.getId(), savedItem.getName(), savedItem.getDescription());
    }

    @Override
    public ItemDto getItem(Long id) {
        Optional<Item> item = itemDao.findById(id);
        if (item.isPresent()) {
            System.out.println("RealItemServiceImpl: create");
            return new ItemDto(item.get().getId(), item.get().getName(), item.get().getDescription());
        }
        System.out.println("RealItemServiceImpl: get; null");
        return null; // or handle it accordingly.
    }

    @Override
    public ItemDto updateItem(Long id, ItemDto itemDto) {
        Item item = new Item();
        item.setId(id);
        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
        Item updatedItem = itemDao.update(item);
        System.out.println("RealItemServiceImpl: updat");
        return new ItemDto(updatedItem.getId(), updatedItem.getName(), updatedItem.getDescription());
    }

    @Override
    public boolean deleteItem(Long id) {
        System.out.println("RealItemServiceImpl: delete");
        itemDao.deleteById(id);
        return true;
    }
}
