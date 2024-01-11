package com.example.logisticprogram.mapper;

public interface Merger <T,S>{

    T merge(T target, S source);

}
