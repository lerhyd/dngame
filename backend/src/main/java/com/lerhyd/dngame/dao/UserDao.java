package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    @Transactional
    @Modifying
    @Query("update User u set u.password = :passw, u.id = :userId")
    void changePassword(@Param("passw") String passw, @Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query("update User u set u.kira.id=:kiraId")
    void addKira(@Param("kiraId") Long kiraId);

    @Transactional
    @Modifying
    @Query("update User u set u.agent.id=:agentId")
    void addAgent(@Param("agentId") Long agentId);

    Optional<User> findUserByVkId(int id);

    Optional<User> findUserByEmail(String email);

    Optional<User> findById(String login);

    void deleteById(String login);

    boolean existsById(String login);
}
