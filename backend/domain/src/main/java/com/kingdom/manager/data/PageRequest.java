package com.kingdom.manager.data;

public interface PageRequest {
    <T> T of(int pageNumber, int pageSize);
    <U> U of(int pageNumber, int pageSize, U sort);
    <T> T next();
    <U> U getSort();
}
