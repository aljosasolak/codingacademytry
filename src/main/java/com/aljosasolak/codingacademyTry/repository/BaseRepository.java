package com.aljosasolak.codingacademyTry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, S> extends JpaRepository<T, S> {
}
