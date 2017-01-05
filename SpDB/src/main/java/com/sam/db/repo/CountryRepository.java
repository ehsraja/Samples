package com.sam.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.sam.db.domain.Country;


public interface CountryRepository extends JpaRepository<Country, Integer> {
	    
	    //------------------------------------------- equality
	    
	    public Country findByName(String countryName);
	    
	    @Query("select c from Country c where c.name = ?1")
	    public Country findByNameQueryPositionalParam(String countryName);
	    
	    @Query("select c from Country c where c.name = :countryName")
	    public Country findByNameQueryNamedParam(@Param("countryName") String countryName);
	    

}
