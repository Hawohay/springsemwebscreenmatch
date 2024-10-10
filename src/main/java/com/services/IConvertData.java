package com.services;

public interface IConvertData {
   <T> T getDataTitle(String json, Class<T> TClass);
}
