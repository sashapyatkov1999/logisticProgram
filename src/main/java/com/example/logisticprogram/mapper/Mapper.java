package com.example.logisticprogram.mapper;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<T,S> {

    T from (S source);

    static List<T> from(List<S> sources) {return sources.stream().map(this::from).collect(Collectors.toCollection(LinkedList::new));}
}
