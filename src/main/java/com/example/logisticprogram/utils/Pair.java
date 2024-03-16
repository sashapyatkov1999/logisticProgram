package com.example.logisticprogram.utils;

import lombok.Data;

@Data
public class Pair <L, R>{

    private L l;
    private R r;


    public Pair(L l, R r) {
        this.l = l;
        this.r = r;
    }



}
