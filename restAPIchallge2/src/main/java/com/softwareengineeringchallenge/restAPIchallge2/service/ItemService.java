package com.softwareengineeringchallenge.restAPIchallge2.service;

//local
import com.softwareengineeringchallenge.restAPIchallge2.entity.Item;
import com.softwareengineeringchallenge.restAPIchallge2.repository.ItemRepository;
import com.softwareengineeringchallenge.restAPIchallge2.adapter.ItemAdapter;
import com.softwareengineeringchallenge.restAPIchallge2.dto.ItemDto;

//imported
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    // ERROR: Item not found
    private static final String ITEM_NOT_FOUND_MESSAGE = "Item not found";

    private final ItemRepository itemRepository;
    private final ItemAdapter itemAdapter;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemAdapter itemAdapter) {
        this.itemRepository = itemRepository;
        this.itemAdapter = itemAdapter;
    }

    public ItemDto createItem(ItemDto itemDto) {
        Item item = itemAdapter.dtoToEntity(itemDto);
        item = itemRepository.save(item);
        return itemAdapter.entityToDto(item);
    }

    public ItemDto getItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException(ITEM_NOT_FOUND_MESSAGE));
        return itemAdapter.entityToDto(item);
    }

    public ItemDto updateItem(Long id, ItemDto itemDto) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException(ITEM_NOT_FOUND_MESSAGE));
        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
        item = itemRepository.save(item);
        return itemAdapter.entityToDto(item);
    }

    public String deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException(ITEM_NOT_FOUND_MESSAGE));
        itemRepository.delete(item);
        return "Item deleted successfully";
    }

}
