package ua.igororlov92.chessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.igororlov92.chessapp.model.EventGroup;

public interface GroupRepository extends JpaRepository<EventGroup, Long> { 
	
}
