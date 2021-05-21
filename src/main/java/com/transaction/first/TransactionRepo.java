package com.transaction.first;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	@Override
	List<Transaction> findAll();

	@Query(value = "select count(id) from reposting where DATE(created_date)=?1 and status=?2",nativeQuery = true)
	Integer findByDate(String ss,String suc);


	@Query(value = "SELECT * FROM Users u WHERE u.status = :status and u.name = :name",nativeQuery = true)
	Transaction findUserByStatusAndNameNamedParamsNative(@Param("status") Integer status, @Param("name") String name);


}
