package sn.acodewriter.stockmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.acodewriter.stockmanagement.controller.api.UserApi;
import sn.acodewriter.stockmanagement.dto.UsersDto;
import sn.acodewriter.stockmanagement.service.UsersService;

@RestController
public class UserController implements UserApi {

    private UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public UsersDto save(UsersDto usersDto) {
        return usersService.save(usersDto);
    }

    @Override
    public UsersDto findById(Integer id) {
        return usersService.findById(id);
    }

    @Override
    public List<UsersDto> findAll() {
        return usersService.findAll();
    }

    @Override
    public void delete(Integer id) {
        usersService.delete(id);
    }
}
