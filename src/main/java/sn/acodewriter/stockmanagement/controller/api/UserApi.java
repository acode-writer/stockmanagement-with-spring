package sn.acodewriter.stockmanagement.controller.api;

import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sn.acodewriter.stockmanagement.dto.UsersDto;


import static sn.acodewriter.stockmanagement.utils.Constants.USER_ENDPOINT;

@Api(value = USER_ENDPOINT, tags = "Users")
public interface UserApi {

    @PostMapping(USER_ENDPOINT + "/create")
    UsersDto save(@RequestBody UsersDto usersDto);

    @GetMapping(USER_ENDPOINT + "/{id}")
    UsersDto findById(@PathVariable Integer id);

    @GetMapping(USER_ENDPOINT + "/all")
    List<UsersDto> findAll();

    @DeleteMapping(USER_ENDPOINT + "/delete/{id}")
    void delete(@PathVariable Integer id);
}
