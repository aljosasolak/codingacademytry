package com.aljosasolak.codingacademyTry.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MapperImpl implements Mapper {

    private final ModelMapper modelMapper;

    public MapperImpl() {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    @Override
    public <T, R> R map(T source, Class<R> target) {
        return modelMapper.map(source, target);
    }

    @Override
    public <T, R> List<R> mapList(Collection<T> source, Class<R> target) {
        return source.stream().map(element ->
                        modelMapper.map(element, target))
                .collect(Collectors.toList()
                );
    }

    @Override
    public <T, R> Page<R> mapPage(Page<T> source, Class<R> target) {
        return source.map(element -> modelMapper.map(element, target));
    }

    @Override
    public <T, R> Optional<R> mapOptional(Optional<T> source, Class<R> target) {
        return source.map(element -> modelMapper.map(element, target));
    }
}
