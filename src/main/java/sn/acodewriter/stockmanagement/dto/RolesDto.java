package sn.acodewriter.stockmanagement.dto;


import lombok.Builder;
import lombok.Data;
import sn.acodewriter.stockmanagement.model.Roles;

@Data
@Builder
public class RolesDto {

    private Integer id;

    private String name;

    private Integer companyId;

    public static RolesDto fromEntity(Roles roles){
        if (roles == null){
            return null;
        }

        return RolesDto.builder()
                .id(roles.getId())
                .name(roles.getName())
                .companyId(roles.getCompanyId())
                .build();
    }

    public static Roles toEntity(RolesDto rolesDto){
        if (rolesDto == null){
            return  null;
        }

        Roles role = new Roles();
        role.setId(rolesDto.getId());
        role.setName(rolesDto.getName());
        role.setCompanyId(rolesDto.getCompanyId());
        return role;
    }
}
