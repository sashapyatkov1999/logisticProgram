package com.example.logisticprogram.controller;

import com.example.logisticprogram.dto.request.listdoc.ListDocAddRequest;
import com.example.logisticprogram.dto.request.listdoc.ListDocRequest;
import com.example.logisticprogram.dto.request.typedoc.TypeDocAddRequest;
import com.example.logisticprogram.dto.request.typedoc.TypeDocNumberRequest;
import com.example.logisticprogram.dto.response.listdoc.ListDocResponse;
import com.example.logisticprogram.dto.response.typedoc.TypeDocResponse;
import com.example.logisticprogram.service.TypeDocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class TypeDocController {
    private final TypeDocService service;
    public static final String TYPE_DOC_GET_BY_NUMBER = "/api/v1/type-doc/find-by-number";
    public static final String TYPE_DOC_DELETE = "/api/v1/type-doc/delete";
    public static final String TYPE_DOC_ADD = "/api/v1/type-doc/add";
    public static final String TYPE_DOCS_GET_ALL = "/api/v1/type-docs/get-all";
    public static final String TYPE_DOC_EDIT = "/api/v1/type-doc/edit";
    public static final String LIST_DOC_GET = "/api/v1/list-doc/get";
    public static final String LIST_DOC_DELETE = "/api/v1/list-doc/delete";
    public static final String LIST_DOCS_GET_ALL = "/api/v1/list-doc/get-all";
    public static final String LIST_DOC_EDIT = "/api/v1/list-doc/edit";
    public static final String LIST_DOC_ADD = "/api/v1/list-doc/add";
    @PostMapping(
            value = TYPE_DOC_GET_BY_NUMBER,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public TypeDocResponse findByNumber(@RequestBody TypeDocNumberRequest request) {
        return service.getTypeDoc(request);
    }
    @PostMapping(
            value = TYPE_DOC_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void deleteTypeDoc(@RequestBody TypeDocNumberRequest request) {
        service.deleteTypeDoc(request);
    }
    @PostMapping(
            value = TYPE_DOC_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public TypeDocResponse addTypeDoc(@RequestBody TypeDocAddRequest request) {
        return service.addTypeDoc(request);
    }

    @PostMapping(
            value = TYPE_DOCS_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<TypeDocResponse> getAllTypeDocs() {
        return service.getAllTypeDocs();
    }

    @PostMapping(
            value = TYPE_DOC_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public TypeDocResponse editTypeDoc(@RequestBody TypeDocAddRequest request) {
        return service.editTypeDoc(request);
    }
    @PostMapping(
            value = LIST_DOC_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ListDocResponse findByNumber(@RequestBody ListDocRequest request) {
        return service.getListDoc(request);
    }
    @PostMapping(
            value = LIST_DOC_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void deleteListDoc(@RequestBody ListDocRequest request) {
        service.deleteListDoc(request);
    }
    @PostMapping(
            value = LIST_DOC_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ListDocResponse addListDoc(@RequestBody ListDocAddRequest request) {
        return service.addListDoc(request);
    }

    @PostMapping(
            value = LIST_DOCS_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<ListDocResponse> getAllListDocs() {
        return service.getAllListDocs();
    }

    @PostMapping(
            value = LIST_DOC_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public Long editListDoc(@RequestBody ListDocAddRequest request) {
        return service.editListDoc(request);
    }
}
