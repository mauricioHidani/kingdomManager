package com.kingdom.manager.data;

import java.util.List;
import java.util.function.Function;

public interface Page<T> {
    int getNumber();
    int getSize();
    int getNumberOfElements();
    List<T> getContent();
    boolean hasContent();
    <T> Page<T> empty();
    <T> Page<T> empty(PageRequest pageRequest);
    int getTotalPages();
    long getTotalElements();
    <U> Page<U> map(Function<? super T, ? extends U> converter);
}
