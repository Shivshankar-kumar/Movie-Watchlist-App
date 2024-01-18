package com.watchlist.watchlist.serviceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.watchlist.watchlist.daoLayer.movieInterface;
import com.watchlist.watchlist.modelLayer.movie;

@Service
public class createMovie {
    @Autowired
    movieInterface movi;

    /*
    
    1. Create/Insert Module
     
     */
    public void toCreateMovie(movie ziddi){
        movi.save(ziddi);
    }

    /*
     
    2. Fetch All Movie List Item
     
     */
    public List<movie> getAllList() {
    return movi.findAll();    
    }

    public movie getMovieById(Integer id) {
    return movi.findById(id).get();    
    }

    /*
     
    3. Update By Id
     
     */
    public void updateMovie(movie m,Integer id){
        movie toBeUpdated=getMovieById(id);
        toBeUpdated.setTitle(m.getTitle());
        toBeUpdated.setRating(m.getRating());
        toBeUpdated.setPriority(m.getPriority());
        toBeUpdated.setComment(m.getComment());
        movi.save(toBeUpdated);
    }


    /*
     
    4. Delete By Id
     
     */
    public void DeleteById(Integer id){
        movi.deleteById(id);
    }
}
