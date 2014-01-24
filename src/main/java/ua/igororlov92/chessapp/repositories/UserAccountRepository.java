package ua.igororlov92.chessapp.repositories;

import org.springframework.data.repository.CrudRepository;

import ua.igororlov92.chessapp.model.Event;
import ua.igororlov92.chessapp.model.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> { }
