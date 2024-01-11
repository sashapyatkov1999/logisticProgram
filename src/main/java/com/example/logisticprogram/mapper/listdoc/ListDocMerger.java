package com.example.logisticprogram.mapper.listdoc;

import com.example.logisticprogram.dto.request.listdoc.ListDocAddRequest;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.ListDoc;
import com.example.logisticprogram.entity.Point;
import com.example.logisticprogram.entity.TypeDoc;
import com.example.logisticprogram.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListDocMerger implements Merger<ListDoc, ListDocAddRequest> {
    @Override
    public ListDoc merge(ListDoc target, ListDocAddRequest source) {
        return target
                .setPoint(new Point(source.getPointId()))
                .setApplication(new Application(source.getApplicationId()))
                .setTypeDoc(new TypeDoc(source.getTypeDocId()));
    }
}
