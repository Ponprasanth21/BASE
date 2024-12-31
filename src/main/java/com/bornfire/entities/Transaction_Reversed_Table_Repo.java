package com.bornfire.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Transaction_Reversed_Table_Repo extends JpaRepository<Transaction_Reversed_Table_Entity, String>{

}
