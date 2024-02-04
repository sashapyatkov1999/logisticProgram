package com.example.logisticprogram.service;

import com.example.logisticprogram.dto.request.listdoc.ListDocAddRequest;
import com.example.logisticprogram.dto.request.listdoc.ListDocRequest;
import com.example.logisticprogram.dto.request.typedoc.TypeDocAddRequest;
import com.example.logisticprogram.dto.request.typedoc.TypeDocNumberRequest;
import com.example.logisticprogram.dto.response.listdoc.ListDocResponse;
import com.example.logisticprogram.dto.response.typedoc.TypeDocResponse;
import com.example.logisticprogram.service.domain.ListDocDomainService;
import com.example.logisticprogram.service.domain.TypeDocDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeDocService {
    private final TypeDocDomainService typeDocDomainService;
    private final ListDocDomainService listDocDomainService;

    public TypeDocResponse getTypeDoc(TypeDocNumberRequest request) {
        return typeDocDomainService.getTypeDocById(request.getId());
    }

    public void deleteTypeDoc(TypeDocNumberRequest request) {
        typeDocDomainService.deleteTypeDoc(request.getId());
    }

    public TypeDocResponse addTypeDoc(TypeDocAddRequest request) {
        var id = typeDocDomainService.addTypeDoc(request);
        return typeDocDomainService.getTypeDocById(id);
    }

    public List<TypeDocResponse> getAllTypeDocs() {
        return typeDocDomainService.getAllTypeDocs();
    }

    public TypeDocResponse editTypeDoc(TypeDocAddRequest request) {
        typeDocDomainService.editTypeDocs(request);
        return typeDocDomainService.getTypeDocById(request.getId());
    }

    public ListDocResponse getListDoc(ListDocRequest request) {
        return listDocDomainService.getListDocById(request.getId());
    }

    public List<ListDocResponse> getAllListDocs() {
        return listDocDomainService.getAllListDocs();
    }

    public void deleteListDoc(ListDocRequest request) {
        listDocDomainService.deleteListDoc(request.getId());
    }

    public Long editListDoc(ListDocAddRequest request) {
        return listDocDomainService.editListDoc(request);

    }
    public ListDocResponse addListDoc(ListDocAddRequest request) {
        var id = listDocDomainService.addListDoc(request);
        return listDocDomainService.getListDocById(request.getApplicationId());
    }


}
