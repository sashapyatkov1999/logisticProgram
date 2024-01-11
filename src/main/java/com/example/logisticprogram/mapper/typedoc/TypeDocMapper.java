package com.example.logisticprogram.mapper.typedoc;

import com.example.logisticprogram.dto.request.typedoc.TypeDocAddRequest;
import com.example.logisticprogram.dto.request.userstatus.UserStatusAddRequest;
import com.example.logisticprogram.entity.TypeDoc;
import com.example.logisticprogram.entity.UserStatus;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TypeDocMapper implements Mapper<TypeDoc, TypeDocAddRequest> {
    @Override
    public TypeDoc from(TypeDocAddRequest source) {
        return new TypeDoc()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
