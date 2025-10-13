package com.starter.api.starterapi.mapper;

import com.starter.api.starterapi.model.TaskDto;
import com.starter.api.starterapi.model.TaskEntity;
import com.starter.api.starterapi.model.UserDto;
import com.starter.api.starterapi.model.UserEntity;
import com.starter.api.starterapi.util.MethodsUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {MethodsUtil.class})
public interface TaskMapper {


    @Mapping(target = "userId", source = "user.id")
    TaskDto toApi(TaskEntity entity);
}
