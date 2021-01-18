package by.savin.comprent.repository;

import by.savin.comprent.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {
   // List findAllBy
}

