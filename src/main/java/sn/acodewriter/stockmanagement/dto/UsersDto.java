package sn.acodewriter.stockmanagement.dto;

import lombok.Data;
import lombok.Builder;
import sn.acodewriter.stockmanagement.model.Users;

@Data
@Builder
public class UsersDto {

    private Integer id;
    
    private String name;

    public static UsersDto fromEntity(Users user){
        if (user == null){
            return null;
        }

        return UsersDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    public static Users toEntity(UsersDto usersDto){
        if (usersDto == null){
            return  null;
        }

        Users user = new Users();
        user.setId(usersDto.getId());
        user.setName(usersDto.getName());

        return user;
    }
}
