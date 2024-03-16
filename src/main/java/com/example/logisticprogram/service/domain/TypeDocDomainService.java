package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.typedoc.TypeDocAddRequest;
import com.example.logisticprogram.dto.response.typedoc.TypeDocResponse;
import com.example.logisticprogram.mapper.typedoc.TypeDocMapper;
import com.example.logisticprogram.mapper.typedoc.TypeDocMerger;
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
    private final TypeDocMerger typeDocMerger;
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

    @Transactional
    public void editTypeDocs(TypeDocAddRequest request){
        var typeDoc = typeDocRepository.getReferenceById(request.getId());
        typeDocRepository.save(typeDocMerger.merge(typeDoc,request)).getId();
    }
}
