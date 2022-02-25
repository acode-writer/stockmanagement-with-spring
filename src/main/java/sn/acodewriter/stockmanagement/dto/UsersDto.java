package sn.acodewriter.stockmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Builder;
import sn.acodewriter.stockmanagement.model.Users;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class UsersDto {

    private Integer id;
    
    private String name;

    private String firstname;

    private String mail;

    private Instant dateOfBirth;

    private String password;

    private AddressDto adderess;

    private String photo;

    private CompanyDto company;

    @JsonIgnore
    private List<RolesDto> roles;

    public static UsersDto fromEntity(Users user){
        if (user == null){
            return null;
        }

        return UsersDto.builder()
                .id(user.getId())
                .name(user.getName())
                .firstname(user.getFirstname())
                .mail(user.getMail())
                .dateOfBirth(user.getDateOfBirth())
                .password(user.getPassword())
                .adderess(AddressDto.fromEntity(user.getAdderess()))
                .photo(user.getPhoto())
                .company(CompanyDto.fromEntity(user.getCompany()))
                .build();
    }

    public static Users toEntity(UsersDto usersDto){
        if (usersDto == null){
            return  null;
        }

        Users user = new Users();
        user.setId(usersDto.getId());
        user.setName(usersDto.getName());
        user.setFirstname(usersDto.getFirstname());
        user.setMail(usersDto.getMail());
        user.setDateOfBirth(usersDto.getDateOfBirth());
        user.setPassword(usersDto.getPassword());
        user.setAdderess(AddressDto.toEntity(usersDto.getAdderess()));
        user.setPhoto(usersDto.getPhoto());
        user.setCompany(CompanyDto.toEntity(usersDto.getCompany()));

        return user;
    }
}
