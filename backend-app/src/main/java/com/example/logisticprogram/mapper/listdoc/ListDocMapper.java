package com.example.logisticprogram.mapper.listdoc;

import com.example.logisticprogram.dto.request.listdoc.ListDocAddRequest;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.ListDoc;
import com.example.logisticprogram.entity.Point;
import com.example.logisticprogram.entity.TypeDoc;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListDocMapper implements Mapper<ListDoc, ListDocAddRequest> {
    @Override
    public ListDoc from(ListDocAddRequest source) {
        return new ListDoc()
                .setPoint(new Point(source.getPointId()))
                .setApplication(new Application(source.getApplicationId()))
                .setTypeDoc(new TypeDoc(source.getTypeDocId()));
    }
}
