package com.example.logisticprogram.mapper.listdoc;

import com.example.logisticprogram.dto.response.listdoc.ListDocResponse;
import com.example.logisticprogram.entity.ListDoc;
import com.example.logisticprogram.mapper.Mapper;
import com.example.logisticprogram.mapper.application.ApplicationResponseMapper;
import com.example.logisticprogram.mapper.point.PointResponseMapper;
import com.example.logisticprogram.mapper.typedoc.TypeDocResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListDocResponseMapper implements Mapper<ListDocResponse, ListDoc> {
    private final ApplicationResponseMapper applicationResponseMapper;
    private final TypeDocResponseMapper typeDocResponseMapper;
    private final PointResponseMapper pointResponseMapper;

    @Override
    public ListDocResponse from(ListDoc source) {
        return new ListDocResponse()
                .setId(source.getId())
                .setPoint(pointResponseMapper.from(source.getPoint()))
                .setApplication(applicationResponseMapper.from(source.getApplication()))
                .setTypeDoc(typeDocResponseMapper.from(source.getTypeDoc()))
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
