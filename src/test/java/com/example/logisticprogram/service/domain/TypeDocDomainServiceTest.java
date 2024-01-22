package com.example.logisticprogram.service.domain;


import com.example.logisticprogram.dto.request.typedoc.TypeDocAddRequest;
import com.example.logisticprogram.dto.response.typedoc.TypeDocResponse;
import com.example.logisticprogram.entity.TypeDoc;
import com.example.logisticprogram.mapper.typedoc.TypeDocMapper;
import com.example.logisticprogram.mapper.typedoc.TypeDocResponseMapper;
import com.example.logisticprogram.repository.TypeDocRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TypeDocDomainServiceTest {

        @Mock
        private TypeDocRepository typeDocRepository;
        @Mock
        private TypeDocResponseMapper typeDocResponseMapper;
        @Mock
        private TypeDocMapper typeDocMapper;
        @InjectMocks
        private TypeDocDomainService service;

        private final TypeDocAddRequest typeDocAddRequestAdd = new TypeDocAddRequest();
        private final List<TypeDoc> typeDocs = new ArrayList<>();
        private final TypeDoc userStatusAdd = new TypeDoc(1L);
        private final List<TypeDocResponse> typeDocResponses = new ArrayList<>();
        private final Long ID = 0L;
        private final Long id = 1L;

        @Test
        void getUserStatusTest(){

            when(typeDocResponseMapper.from((TypeDoc) any())).thenReturn(getTypeDocResponse());
            when(typeDocRepository.getReferenceById(anyLong())).thenReturn(getUser());

            var result = service.getTypeDocById(ID);

            assertNotNull(result);

            verify(typeDocRepository).getReferenceById(anyLong());
            verify(typeDocResponseMapper).from((TypeDoc) any());
            verifyNoMoreInteractions(typeDocRepository, typeDocResponseMapper);
            verifyNoInteractions(typeDocMapper);
        }

        @Test
        void getAllRolesTest(){
            typeDocs.add(new TypeDoc(1L));
            typeDocs.add(new TypeDoc(2L));
            typeDocResponses.add(new TypeDocResponse());
            typeDocResponses.add(new TypeDocResponse());

            when(typeDocRepository.findAll()).thenReturn(typeDocs);
            when(typeDocResponseMapper.from(typeDocs)).thenReturn(typeDocResponses);

            List<TypeDocResponse> result = service.getAllTypeDocs();

            assertEquals(typeDocResponses, result);
            assertNotNull(result);
            verify(typeDocRepository).findAll();
            verify(typeDocResponseMapper).from(typeDocs);

            verifyNoMoreInteractions(typeDocRepository, typeDocResponseMapper);
            verifyNoInteractions(typeDocMapper);
        }

        @Test
        void  deleteTypeDoc(){
            service.deleteTypeDoc(id);
            verify(typeDocRepository).deleteById(id);

            verifyNoMoreInteractions(typeDocRepository, typeDocResponseMapper);
            verifyNoInteractions(typeDocMapper);
        }

        @Test
        void addTypeDoc(){
            when(typeDocMapper.from(typeDocAddRequestAdd)).thenReturn(userStatusAdd);
            when(typeDocRepository.save(userStatusAdd)).thenReturn(userStatusAdd);
            Long id = service.addTypeDoc(typeDocAddRequestAdd);
            assertEquals(userStatusAdd.getId(),id.longValue());
            verify(typeDocMapper).from(typeDocAddRequestAdd);
            verify(typeDocRepository).save(userStatusAdd);
            verifyNoMoreInteractions(typeDocRepository, typeDocResponseMapper);
        }

        private TypeDocResponse getTypeDocResponse(){
            return new TypeDocResponse().setId(ID);
        }


        private TypeDoc getUser(){return new TypeDoc(ID);}
    }

