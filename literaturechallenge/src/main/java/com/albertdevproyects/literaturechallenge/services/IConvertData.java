package com.albertdevproyects.literaturechallenge.services;

public interface IConvertData {
    <T> T convertDataClass(String json, Class<T> type);
}
