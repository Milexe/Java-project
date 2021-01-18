package by.savin.comprent.service.impl;

import by.savin.comprent.aspect.Loggable;
import by.savin.comprent.entity.ItemEntity;
import by.savin.comprent.entity.User;
import by.savin.comprent.entity.UserToItemEntity;
import by.savin.comprent.repository.ItemRepository;
import by.savin.comprent.repository.UserRepository;
import by.savin.comprent.repository.UserToItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import java.util.Iterator;


@Service
public class UserToItemService {
    @Autowired
    private UserToItemRepository repository;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemEntity> findAllByNameDesc(String name, String desc) {
        return null;//repository.findItemEntitiesByDescriptionOrNameContains(name,desc);
    }

@Loggable
    public void save(UserToItemEntity model) {
    if(model.getEndDate().after(new Timestamp(System.currentTimeMillis()))) {
        repository.save(model);
        User user = userRepository.findById(Long.valueOf(model.getUserId())).get();
        ItemEntity item = itemRepository.findById(model.getItemId()).get();
        String itemName = item.getName();
        String userName = user.getUsername();
        String message = String.format(
                "Hello, you bought some stuff on comprent service: \n" +
                        itemName
        );
        mailSender.send(userName, "You bought some stuff", message);
    }
    }
    public void remove(UserToItemEntity model) {
        repository.delete(model);
    }

}
