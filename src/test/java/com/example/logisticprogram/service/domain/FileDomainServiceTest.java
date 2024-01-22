package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.file.FileAddRequest;
import com.example.logisticprogram.dto.response.file.FileResponse;
import com.example.logisticprogram.dto.response.point.PointResponse;
import com.example.logisticprogram.entity.File;
import com.example.logisticprogram.entity.Point;
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
    private FileRepository pointRepository;
    @Mock
    private FileResponseMapper pointResponseMapper;
    @Mock
    private FileMapper pointMapper;
    @InjectMocks
    private FileDomainService service;

    private final FileAddRequest fileAddRequestAdd = new FileAddRequest();
    private final List<File> files = new ArrayList<>();
    private final File fileAdd = new File(1L);
    private final List<FileResponse> pointResponses = new ArrayList<>();
    private final Long ID = 0L;
    private final Long id = 1L;


    @Test
    void getFileTest() {

        when(pointResponseMapper.from((File) any())).thenReturn(getFileResponse());
        when(pointRepository.getReferenceById(anyLong())).thenReturn(getFile());

        var result = service.getFile(ID);

        assertNotNull(result);

        verify(pointRepository).getReferenceById(anyLong());
        verify(pointResponseMapper).from((File) any());
        verifyNoMoreInteractions(pointRepository, pointResponseMapper);
        verifyNoInteractions(pointMapper);
    }

    @Test
    void getAllFilesTest() {
        files.add(new File(1L));
        files.add(new File(2L));
        pointResponses.add(new FileResponse());
        pointResponses.add(new FileResponse());

        when(pointRepository.findAll()).thenReturn(files);
        when(pointResponseMapper.from(files)).thenReturn(pointResponses);

        List<FileResponse> result = service.getAllFiles();

        assertEquals(pointResponses, result);
        assertNotNull(result);
        verify(pointRepository).findAll();
        verify(pointResponseMapper).from(files);

        verifyNoMoreInteractions(pointRepository, pointResponseMapper);
        verifyNoInteractions(pointMapper);
    }

    @Test
    void deleteUserTest() {
        service.deleteFile(id);
        verify(pointRepository).deleteById(id);

        verifyNoMoreInteractions(pointRepository, pointResponseMapper);
        verifyNoInteractions(pointMapper);
    }

    @Test
    void addUserTest() {
        when(pointMapper.from(fileAddRequestAdd)).thenReturn(fileAdd);
        when(pointRepository.save(fileAdd)).thenReturn(fileAdd);
        Long id = service.addFile(fileAddRequestAdd);
        assertEquals(fileAdd.getId(), id.longValue());
        verify(pointMapper).from(fileAddRequestAdd);
        verify(pointRepository).save(fileAdd);
        verifyNoMoreInteractions(pointRepository, pointResponseMapper);
    }

    private FileResponse getFileResponse() {
        return new FileResponse()
                .setId(ID);
    }

    private File getFile() {
        return new File(ID);
    }
}
