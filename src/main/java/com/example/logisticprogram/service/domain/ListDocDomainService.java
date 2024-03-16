package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.listdoc.ListDocAddRequest;
import com.example.logisticprogram.dto.response.listdoc.ListDocResponse;
import com.example.logisticprogram.mapper.listdoc.ListDocMapper;
import com.example.logisticprogram.mapper.listdoc.ListDocMerger;
import com.example.logisticprogram.mapper.listdoc.ListDocResponseMapper;
import com.example.logisticprogram.repository.ListDocRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ListDocDomainService {
    private final ListDocRepository listDocRepository;
    private final ListDocMapper listDocMapper;
    private final ListDocResponseMapper listDocResponseMapper;
    private final ListDocMerger listDocMerger;
    @Transactional
    public ListDocResponse getListDocById(Long id) {
        return listDocResponseMapper.from(listDocRepository.getReferenceById(id));
    }


    @Transactional
    public List<ListDocResponse> getAllListDocs() {
        return listDocResponseMapper.from(listDocRepository.findAll());

    }

    @Transactional
    public void deleteListDoc(Long id) {
        listDocRepository.deleteById(id);
    }

    @Transactional
    public Long addListDoc(ListDocAddRequest request) {
        return listDocRepository.save(listDocMapper.from(request)).getId();

    }

    @Transactional
    public Long editListDoc(ListDocAddRequest request) {
        var listDoc = listDocRepository.getReferenceById(request.getId());
        return listDocRepository.save(listDocMerger.merge(listDoc, request)).getId();

    }
}
