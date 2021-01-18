package by.savin.comprent.rest;

import by.savin.comprent.entity.UserToItemEntity;
import by.savin.comprent.service.impl.UserToItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")

@RestController
public class UserToItemController {
    @Autowired
    UserToItemService service;


    @PostMapping("/buyItem")
    public void save(@ModelAttribute UserToItemEntity model) {

        service.save(model);
    }
    @DeleteMapping("/remove")
    public void remove(@ModelAttribute UserToItemEntity model) {

        service.remove(model);
    }
}
