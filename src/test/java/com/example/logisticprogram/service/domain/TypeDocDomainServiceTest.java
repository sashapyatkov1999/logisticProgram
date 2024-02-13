package com.example.logisticprogram.service.domain;


import com.example.logisticprogram.dto.request.typedoc.TypeDocAddRequest;
import com.example.logisticprogram.dto.response.typedoc.TypeDocResponse;
import com.example.logisticprogram.entity.TypeDoc;
import com.example.logisticprogram.mapper.typedoc.TypeDocMapper;
import com.example.logisticprogram.mapper.typedoc.TypeDocMerger;
import com.example.logisticprogram.mapper.typedoc.TypeDocResponseMapper;
import com.example.logisticprogram.repository.TypeDocRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TypeDocDomainServiceTest {


    @Mock
    private TypeDocRepository typeDocRepository;
    @Mock
    private TypeDocMerger typeDocMerger;
    @Mock
    private TypeDocResponseMapper typeDocResponseMapper;
    @Mock
    private TypeDocMapper typeDocMapper;
    @InjectMocks
    private TypeDocDomainService service;

    private final Long ID = 0L;


    @Test
    void getTypeDocStatusTest() {

        when(typeDocResponseMapper.from(any(TypeDoc.class))).thenReturn(getTypeDocResponse());
        when(typeDocRepository.getReferenceById(anyLong())).thenReturn(getTypeDoc());

        var result = service.getTypeDocById(ID);

        assertThat(result).isNotNull();

        verify(typeDocRepository).getReferenceById(anyLong());
        verify(typeDocResponseMapper).from(any(TypeDoc.class));
        verifyNoMoreInteractions(typeDocRepository, typeDocResponseMapper);
        verifyNoInteractions(typeDocMapper);
    }

    @Test
    void getAllTypeDocsTest() {

        when(typeDocRepository.findAll()).thenReturn(Collections.singletonList(getTypeDoc()));
        when(typeDocResponseMapper.from(anyList())).thenReturn(Collections.singletonList(getTypeDocResponse()));

        List<TypeDocResponse> result = service.getAllTypeDocs();


        assertThat(result).isNotNull();
        verify(typeDocRepository).findAll();
        verify(typeDocResponseMapper).from(anyList());

        verifyNoMoreInteractions(typeDocRepository, typeDocResponseMapper);
        verifyNoInteractions(typeDocMapper);
    }

    @Test
    void deleteTypeDoc() {
        service.deleteTypeDoc(ID);
        verify(typeDocRepository).deleteById(ID);

        verifyNoMoreInteractions(typeDocRepository, typeDocResponseMapper);
        verifyNoInteractions(typeDocMapper);
    }

    @Test
    void addTypeDoc() {
        when(typeDocMapper.from(any(TypeDocAddRequest.class))).thenReturn(getTypeDoc());
        when(typeDocRepository.save(any())).thenReturn(getTypeDoc());
        Long id = service.addTypeDoc(getTypeDocAddRequest());

        assertThat(id).isEqualTo(ID);

        verify(typeDocMapper).from(any(TypeDocAddRequest.class));
        verify(typeDocRepository).save(any());
        verifyNoMoreInteractions(typeDocRepository, typeDocResponseMapper);
    }

    @Test
    void editTypeDocTest() {

        when(typeDocRepository.getReferenceById(anyLong())).thenReturn(getTypeDoc());
        when(typeDocMerger.merge(any(), any())).thenReturn(getTypeDoc());
        when(typeDocRepository.save(any())).thenReturn(getTypeDoc());

        Long result = service.editTypeDocs(getTypeDocAddRequest());

        assertThat(result).isEqualTo(ID);

        verify(typeDocRepository).getReferenceById(anyLong());
        verify(typeDocRepository).save(any());
        verify(typeDocMerger).merge(any(), any());
        verifyNoMoreInteractions(typeDocRepository, typeDocMerger);

    }

    private TypeDocResponse getTypeDocResponse() {
        return new TypeDocResponse().setId(ID);
    }

    private TypeDoc getTypeDoc() {
        return new TypeDoc(ID);
    }

    private TypeDocAddRequest getTypeDocAddRequest() {
        return new TypeDocAddRequest()
                .setId(ID);
    }
}

