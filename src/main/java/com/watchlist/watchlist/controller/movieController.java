package com.watchlist.watchlist.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.watchlist.watchlist.modelLayer.movie;
import com.watchlist.watchlist.serviceLayer.createMovie;

import jakarta.validation.Valid;

@RestController
public class movieController {

    @Autowired
    createMovie service;

    /*
     
    Submit form module which is available on port http://localhost:8080/submit-form
     
     */
    @GetMapping("/submit-form")
    public ModelAndView subbmitFormModule(@RequestParam(required = false) Integer id){
        String viewName="submitform";
        Map<String, Object> model =new HashMap<>();
        if(id==null){
            model.put("variable", new movie());
        }else{
            model.put("variable", service.getMovieById(id));
        }
        return new ModelAndView(viewName, model);
    }


    /*
     
   Data is submitted on on port http://localhost:8080/submit-form
     
     */

    @PostMapping("/submit-form")
    public ModelAndView toCreateMovie(@Valid @ModelAttribute("variable") movie m, BindingResult bindingResult){
       
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.hasErrors());
            return new ModelAndView("submitform");
        }
        // To get id from Hidden field
        Integer id=m.getId();
        if(id==null){

            service.toCreateMovie(m);
        }else{
            service.updateMovie(m,id);
        }

        // to redirect another page
        RedirectView rd=new RedirectView();
        rd.setUrl("/total-list");

        return new ModelAndView(rd);
    }

    /*
        
    All movie list accessible on port http://localhost:8080/total-list
        
        */

    @GetMapping("/total-list")
    public ModelAndView getAllList(){
        String viewName="totallist";
        Map<String, Object> model =new HashMap<>();

        // to extract all Item List
        List<movie> totalItem=service.getAllList();

        model.put("allList", totalItem);
        model.put("sizeOfList",totalItem.size());
        //model.put("AllList",);
        return new ModelAndView(viewName, model);
    }

    /*
     
    delete review module which is available on port http://localhost:8080/delete?id=.....
     
     */
    @GetMapping("/delete")
    public ModelAndView deleteMovie(@RequestParam Integer id){
        service.DeleteById(id);

        // to redirect another page
        RedirectView rd=new RedirectView();
        rd.setUrl("/total-list");
        return new ModelAndView(rd);
    }
}