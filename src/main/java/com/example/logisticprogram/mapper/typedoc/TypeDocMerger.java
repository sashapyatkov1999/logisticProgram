package com.example.logisticprogram.mapper.typedoc;

import com.example.logisticprogram.dto.request.typedoc.TypeDocAddRequest;
import com.example.logisticprogram.entity.TypeDoc;
import com.example.logisticprogram.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TypeDocMerger implements Merger<TypeDoc, TypeDocAddRequest> {

    @Override
    public TypeDoc merge(TypeDoc target, TypeDocAddRequest source) {
        return target
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
