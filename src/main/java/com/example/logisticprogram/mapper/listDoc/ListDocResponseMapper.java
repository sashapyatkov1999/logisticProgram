package com.example.logisticprogram.mapper.listDoc;

import com.example.logisticprogram.dto.response.listdoc.ListDocResponse;
import com.example.logisticprogram.dto.response.role.RoleResponse;
import com.example.logisticprogram.entity.ListDoc;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListDocResponseMapper implements Mapper<ListDocResponse, ListDoc> {
    @Override
    public ListDocResponse from(ListDoc source) {
        return new ListDocResponse()
                .setId(source.getId())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
