package com.aljosasolak.codingacademyTry.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public interface Mapper {
    <T, R> R map(T source, Class<R> target);
    <T, R> List<R> mapList(Collection<T> source, Class<R> target);
    <T, R> Page<R> mapPage(Page<T> source, Class<R> target);
    <T, R> Optional<R> mapOptional(Optional<T> source, Class<R> target);

}
