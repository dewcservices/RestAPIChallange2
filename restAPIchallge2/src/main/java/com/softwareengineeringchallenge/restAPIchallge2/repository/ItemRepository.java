package com.softwareengineeringchallenge.restAPIchallge2.repository;

//local
import com.softwareengineeringchallenge.restAPIchallge2.entity.Item;

//imported
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
