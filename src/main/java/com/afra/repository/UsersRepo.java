package com.afra.repository;

import com.afra.entities.UsersEntities;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UsersRepo extends CrudRepository<UsersEntities, Long> {

   UsersEntities findByResourceFk(String resourceFk);

   @Query(value = "select * from users where resource_fk = :id and password = :pwd", nativeQuery = true)
   UsersEntities login(@Param("id") String id, @Param("pwd") String pwd);

   boolean deleteByResourceFk(String resourceFk);

   @Transactional
   @Modifying
   @Query(value = "update users set access_fk = 0 where resource_fk = :id", nativeQuery = true)
   void deactivateById(@Param("id") String id);

   @Transactional
   @Modifying
   @Query(value = "update users set access_fk = :position where resource_fk = :id", nativeQuery = true)
   void activateById(@Param("id") String id, @Param("position") int position);

}
