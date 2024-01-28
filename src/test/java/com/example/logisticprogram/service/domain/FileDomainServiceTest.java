package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.file.FileAddRequest;
import com.example.logisticprogram.dto.response.file.FileResponse;
import com.example.logisticprogram.entity.File;
import com.example.logisticprogram.mapper.file.FileMapper;
import com.example.logisticprogram.mapper.file.FileResponseMapper;
import com.example.logisticprogram.repository.FileRepository;
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
public class FileDomainServiceTest {

    @Mock
    private FileRepository fileRepository;
    @Mock
    private FileResponseMapper fileResponseMapper;
    @Mock
    private FileMapper fileMapper;
    @InjectMocks
    private FileDomainService service;

    private final FileAddRequest fileAddRequestAdd = new FileAddRequest();
    private final List<File> files = new ArrayList<>();
    private final File fileAdd = new File(1L);
    private final List<FileResponse> fileResponses = new ArrayList<>();
    private final Long ID = 0L;
    private final Long id = 1L;


    @Test
    void getFileTest() {

        when(fileResponseMapper.from((File) any())).thenReturn(getFileResponse());
        when(fileRepository.getReferenceById(anyLong())).thenReturn(getFile());

        var result = service.getFile(ID);

        assertNotNull(result);

        verify(fileRepository).getReferenceById(anyLong());
        verify(fileResponseMapper).from((File) any());
        verifyNoMoreInteractions(fileRepository, fileResponseMapper);
        verifyNoInteractions(fileMapper);
    }

    @Test
    void getAllFilesTest() {
        files.add(new File(1L));
        files.add(new File(2L));
        fileResponses.add(new FileResponse());
        fileResponses.add(new FileResponse());

        when(fileRepository.findAll()).thenReturn(files);
        when(fileResponseMapper.from(files)).thenReturn(fileResponses);

        List<FileResponse> result = service.getAllFiles();

        assertEquals(fileResponses, result);
        assertNotNull(result);
        verify(fileRepository).findAll();
        verify(fileResponseMapper).from(files);

        verifyNoMoreInteractions(fileRepository, fileResponseMapper);
        verifyNoInteractions(fileMapper);
    }

    @Test
    void deleteFileTest() {
        service.deleteFile(id);
        verify(fileRepository).deleteById(id);

        verifyNoMoreInteractions(fileRepository, fileResponseMapper);
        verifyNoInteractions(fileMapper);
    }

    @Test
    void addFileTest() {
        when(fileMapper.from(fileAddRequestAdd)).thenReturn(fileAdd);
        when(fileRepository.save(fileAdd)).thenReturn(fileAdd);
        Long id = service.addFile(fileAddRequestAdd);
        assertEquals(fileAdd.getId(), id.longValue());
        verify(fileMapper).from(fileAddRequestAdd);
        verify(fileRepository).save(fileAdd);
        verifyNoMoreInteractions(fileRepository, fileResponseMapper);
    }

    private FileResponse getFileResponse() {
        return new FileResponse()
                .setId(ID);
    }

    private File getFile() {
        return new File(ID);
    }
}
