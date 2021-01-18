package by.savin.comprent.repository;

import by.savin.comprent.entity.UserToItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserToItemRepository extends CrudRepository<UserToItemEntity, Integer> {

}

