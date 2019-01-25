package com.jiujiu.springboot.controller;

import com.jiujiu.springboot.annotation.Timed;
import com.jiujiu.springboot.model.Link;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;

/**
 * @ClassName HomeController
 * @AuThor yanbin.hu
 * @Date 1/18/2019
 * @Description
 **/
@RestController
public class HomeController {

    // Handler methods arguments
    // https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-methods

    @GetMapping("/")
    public String read(){
        return "hello world";
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id){
        System.out.println("updating id =" + id);
        // do update
    }

    @PostMapping("/")
    public List<ObjectError> create(@Valid @RequestBody Link link, Errors errors, BindingResult bindingResult){

        //@Valid annotation do the validation jobs, if any errors occurs, it goes to the Errors object.
        // validation rules is defined in the {@link com.jiujiu.model.Link}

        System.out.println("creating a link "+ link.toString());
        // do create

        if(errors.hasErrors()){
            System.out.println("errors count = "+errors.getErrorCount());
            errors.getAllErrors().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
            return errors.getAllErrors();
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        System.out.println("delete id = " + id);
        // do delete
    }

    @GetMapping("/filter")
    public String filter(){
        return "Filter pages";
    }


    @PostConstruct
    public void postConstruct(){
        System.out.println("home controller post construct");
    }


    /**
     * Add an initBinder to convert trim input Strings
     * remove leading and trailing whitespace
     * pre-process every String form data
     * If String only has whitespace... trim it to null
     * It's called every web request to our controller
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, editor);
    }
}