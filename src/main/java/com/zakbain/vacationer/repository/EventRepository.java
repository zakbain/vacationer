package com.zakbain.vacationer.repository;

import com.zakbain.vacationer.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
}
