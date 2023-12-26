package com.example.logisticprogram.mapper.listDoc;

import com.example.logisticprogram.dto.request.listdoc.ListDocAddRequest;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListDocMapper implements Mapper<List, ListDocAddRequest> {
    @Override
    public List from(ListDocAddRequest source) {
        return null;
    }
}
