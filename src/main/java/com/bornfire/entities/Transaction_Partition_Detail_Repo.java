package com.bornfire.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Transaction_Partition_Detail_Repo extends JpaRepository<Transaction_Partition_Detail_Entity, String> {

}
