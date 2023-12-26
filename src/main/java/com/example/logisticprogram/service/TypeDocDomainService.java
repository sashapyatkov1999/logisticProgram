package com.example.logisticprogram.service;

import com.example.logisticprogram.dto.request.typedoc.TypeDocAddRequest;
import com.example.logisticprogram.dto.request.userstatus.UserStatusAddRequest;
import com.example.logisticprogram.dto.response.typedoc.TypeDocResponse;
import com.example.logisticprogram.dto.response.userstatus.UserStatusResponse;
import com.example.logisticprogram.mapper.typedoc.TypeDocMapper;
import com.example.logisticprogram.mapper.typedoc.TypeDocResponseMapper;
import com.example.logisticprogram.repository.TypeDocRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeDocDomainService {
    private final TypeDocRepository typeDocRepository;
    private final TypeDocMapper typeDocMapper;
    private final TypeDocResponseMapper typeDocResponseMapper;
    @Transactional
    public TypeDocResponse getTypeDocById(Long id) {
        return typeDocResponseMapper.from(typeDocRepository.getReferenceById(id));
    }


    @Transactional
    public List<TypeDocResponse> getAllTypeDocs() {
        return typeDocResponseMapper.from(typeDocRepository.findAll());

    }

    @Transactional
    public void deleteTypeDoc(Long id) {
        typeDocRepository.deleteById(id);
    }

    @Transactional
    public Long addTypeDoc(TypeDocAddRequest request) {
        return typeDocRepository.save(typeDocMapper.from(request)).getId();

    }
}
