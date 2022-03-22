package sn.acodewriter.stockmanagement.service.implement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.acodewriter.stockmanagement.dto.UsersDto;
import sn.acodewriter.stockmanagement.exception.EntityNotFoundException;
import sn.acodewriter.stockmanagement.exception.ErrorCodes;
import sn.acodewriter.stockmanagement.exception.InvalidEntityException;
import sn.acodewriter.stockmanagement.repository.UsersRepository;
import sn.acodewriter.stockmanagement.service.UsersService;
import sn.acodewriter.stockmanagement.validator.UserValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UsersServiceImplement implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImplement(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersDto save(UsersDto usersDto) {
        List<String> errors = UserValidator.validate(usersDto);
        if (!errors.isEmpty()){
            log.error("User is not valid {}", usersDto);
            throw new InvalidEntityException("User not valid", ErrorCodes.USER_NOT_VALID);
        }
        return UsersDto.fromEntity(
                usersRepository.save(
                        UsersDto.toEntity(usersDto)) );
    }

    @Override
    public UsersDto findById(Integer id) {
        if (id == null){
            log.error("User ID is null");
            throw new EntityNotFoundException("User ID is null", ErrorCodes.USER_NOT_FOUND);
        }
        return usersRepository.findById(id)
                .map(UsersDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("User not found",ErrorCodes.USER_NOT_FOUND));
    }
    

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(UsersDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("User ID is null");
            throw new EntityNotFoundException("User ID is null", ErrorCodes.USER_NOT_FOUND);
        }
        usersRepository.deleteById(id);
    }
}
