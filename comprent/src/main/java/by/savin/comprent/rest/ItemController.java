package by.savin.comprent.rest;

import by.savin.comprent.entity.ItemEntity;
import by.savin.comprent.entity.UserToItemEntity;
import by.savin.comprent.service.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService service;

    @GetMapping("/item")
    public List findByString() {
        return service.findAllUnUsed();
    }

    @PostMapping("/item")
    public ItemEntity save(@RequestBody ItemEntity itemEntity) {
        return service.saveItem(itemEntity);
    }
    @DeleteMapping("/item")
    public void delete(@RequestBody ItemEntity itemEntity) {
        service.deleteItem(itemEntity);
    }
    @PutMapping("/item")
    public void update(@RequestBody ItemEntity itemEntity) {
        service.updateItem(itemEntity);
    }

}
