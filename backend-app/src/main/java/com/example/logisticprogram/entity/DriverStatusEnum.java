package com.example.logisticprogram.entity;

public enum DriverStatusEnum {
    SOON_ON_LOADING,
    SOON_ON_UNLOADING,
    START_LOADING,
    FINISH_LOADING,
    START_UNLOADING,
    FINISH_UNLOADING,
    WAIT_DOCS;

    public boolean equalsIsLong(Long id) {
        return this.ordinal() == id.intValue();
    }

    public Long getId (){
        return (long) this.ordinal();
    }


}
