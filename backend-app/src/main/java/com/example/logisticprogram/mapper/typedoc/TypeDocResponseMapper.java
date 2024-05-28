package com.example.logisticprogram.mapper.typedoc;

import com.example.logisticprogram.dto.response.typedoc.TypeDocResponse;
import com.example.logisticprogram.dto.response.userstatus.UserStatusResponse;
import com.example.logisticprogram.entity.TypeDoc;
import com.example.logisticprogram.entity.UserStatus;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TypeDocResponseMapper implements Mapper<TypeDocResponse, TypeDoc> {
    @Override
    public  TypeDocResponse from(TypeDoc source) {
        return new TypeDocResponse()
                .setId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
