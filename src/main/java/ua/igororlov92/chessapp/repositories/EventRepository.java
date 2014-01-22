package ua.igororlov92.chessapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import ua.igororlov92.chessapp.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	//@Transactional
	//public List<Event> findAll();
}
