package com.softwareengineeringchallenge.restAPIchallge2.service;

/*
 * MockedItemServiceImpl.java:
 * This class provides a mock implementation of the ItemService interface. 
 * It uses MockedItemDaoImpl to perform operations, meaning that no real 
 * database interactions occur; it all returns mock data.
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

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Qualifier("mockedItemService")
public class MockedItemServiceImpl implements ItemService {

    // Using a map to store our mocked items and an AtomicLong to simulate auto-increment IDs
    private final Map<Long, ItemDto> items = new HashMap<>();
    private AtomicLong currentId = new AtomicLong(1); // Starting our ID from 1

    @Override
    public ItemDto createItem(ItemDto itemDto) {
        long newId = currentId.getAndIncrement(); // Get the next ID
        itemDto.setId(newId);
        items.put(newId, itemDto);
        return itemDto;
    }

    @Override
    public ItemDto getItem(Long id) {
        return items.get(id);  // Returns null if the item doesn't exist
    }

    @Override
    public ItemDto updateItem(Long id, ItemDto itemDto) {
        if (!items.containsKey(id)) {
            return null;  // Returning null for a non-existing item (In real-world scenarios, you'd throw an exception or handle this case differently)
        }
        itemDto.setId(id);  // Ensure the ID remains unchanged
        items.put(id, itemDto);
        return itemDto;
    }

    @Override
    public boolean deleteItem(Long id) {
        if (!items.containsKey(id)) {
            return false;  // Indicates the item wasn't found and therefore not deleted
        }
        items.remove(id);
        return true;  // Indicates successful deletion
    }
}




// @Service
// // @Primary
// @Qualifier("mockedItemService")
// public class MockedItemServiceImpl implements ItemService {

//     @Autowired
//     @Qualifier("mockedItemDao")
//     private ItemDao itemDao;

//     @Override
//     public ItemDto createItem(ItemDto itemDto) {
//         // Mocking logic
//         System.out.println("MockedItemServiceImpl: create");
//         return new ItemDto(1L, "MockedName", "MockedDescription");
//     }

//     @Override
//     public ItemDto getItem(Long id) {
//         // Mocking logic
//         System.out.println("MockedItemServiceImpl: get");
//         return new ItemDto(id, "MockedName", "MockedDescription");
//     }

//     @Override
//     public ItemDto updateItem(Long id, ItemDto itemDto) {
//         // Mocking logic
//         System.out.println("MockedItemServiceImpl: update");
//         return itemDto;
//     }

//     @Override
//     public boolean deleteItem(Long id) {
//         // Mocking logic, do nothing
//         System.out.println("MockedItemServiceImpl: delete");
//         return true;
//     }
// }
