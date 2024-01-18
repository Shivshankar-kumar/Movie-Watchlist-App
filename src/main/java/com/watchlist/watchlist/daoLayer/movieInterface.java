package com.watchlist.watchlist.daoLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watchlist.watchlist.modelLayer.movie;

@Repository
public interface movieInterface extends JpaRepository<movie, Integer> {

}
