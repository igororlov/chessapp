package ua.igororlov92.chessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.igororlov92.chessapp.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> { }
