package by.savin.comprent.service.impl;

import by.savin.comprent.aspect.Loggable;
import by.savin.comprent.entity.ItemEntity;
import by.savin.comprent.entity.UserToItemEntity;
import by.savin.comprent.repository.ItemRepository;
import by.savin.comprent.repository.UserToItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;
    @Autowired
    private UserToItemRepository userToItemRepository;
@Loggable
    public ItemEntity saveItem(ItemEntity entity){
        return repository.save(entity);
    }
    public void deleteItem(ItemEntity entity){
        repository.delete(entity);
    }
    public void updateItem(ItemEntity entity){

    repository.deleteById(entity.getId());
    repository.save(entity);

}

    @Loggable
    public List findAllUnUsed(){
        List<ItemEntity> itemEntities = (List<ItemEntity>) repository.findAll();
        List<ItemEntity> deletedItem = new LinkedList<>();
        List<UserToItemEntity> userToItemEntities = (List<UserToItemEntity>) userToItemRepository.findAll();

        for(ItemEntity item : itemEntities){
             for(UserToItemEntity userToItemEntity : userToItemEntities)
             {
                if (item.getId()==userToItemEntity.getItemId())
                    deletedItem.add(item);
             }
        }
        itemEntities.removeAll(deletedItem);
        return itemEntities;
    }

    public List findAll() {
        return (List) repository.findAll();
    }

}
