package sn.acodewriter.stockmanagement.service;

import sn.acodewriter.stockmanagement.dto.UsersDto;

import java.util.List;

public interface UsersService {

    UsersDto save(UsersDto usersDto);

    UsersDto findById(Integer id);

    List<UsersDto> findAll();

    void delete(Integer id);
}
