package com.example.logisticprogram.entity;

public enum UserStatusEnum {

    ENABLE,
    DISABLE;

    public boolean equalsIsLong(Long id) {
        return this.ordinal() == id.intValue();
    }

    public Long getId (){
        return (long) this.ordinal();
    }

}
