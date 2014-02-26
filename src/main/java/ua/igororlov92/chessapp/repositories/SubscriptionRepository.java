package ua.igororlov92.chessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.igororlov92.chessapp.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> { 
	
}
