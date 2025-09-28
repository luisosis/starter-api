package com.starter.api.starterapi.mapper;

import com.starter.api.starterapi.model.UserDto;
import com.starter.api.starterapi.model.UserEntity;
import com.starter.api.starterapi.util.MethodsUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {MethodsUtil.class})
public interface UserMapper {

    UserDto toApi(UserEntity user);

    @Mapping(target = "createdAt", expression = "java(MethodsUtil.getDateByDefault())")
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "active", expression = "java(MethodsUtil.getActiveUser())" )
    UserEntity toEntity(UserDto userDto);
}
