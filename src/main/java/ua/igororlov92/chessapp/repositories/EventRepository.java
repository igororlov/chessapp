package ua.igororlov92.chessapp.repositories;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;

import ua.igororlov92.chessapp.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> { 
	
	public List<Event> findByStartTimeAfterOrderByStartTimeAsc(DateTime time);
	
	public List<Event> findByStartTimeBeforeOrderByStartTimeDesc(DateTime time);
}
