/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.controller;

import com.codegen.model.Person;
import com.codegen.model.PlayerBankDetails;
import com.codegen.model.Tbluser;
import com.codegen.service.PersonService;
import com.codegen.service.PlayerBankDetailsService;
import com.codegen.service.TempUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ishara Dikkumbura
 */
@Controller
public class HomeController {

    @Autowired
    private PersonService personservice;
    @Autowired
    private TempUserService tuservice;
    @Autowired
    private PlayerBankDetailsService playerbankdetailsservice;

    @RequestMapping(value = "/")
    public String landing() {

        return "index";
    }
    
    
    
    
    @RequestMapping(value = "/dashboard")
    public String dashboard() {

        return "dashboard";
    }
    
    @RequestMapping(value = "/broker")
    public String broker() {

        return "broker";
    }

    @RequestMapping(value = "/loss")
    public String loss() {

        return "loss";
    }

    @RequestMapping(value = "/win")
    public String win() {

        return "win";
    }

    @RequestMapping(value = "/machineplayer")
    public String machinePlayer() {

        return "machineplayer";
    }

    @RequestMapping(value = "/transaction")
    public String transaction() {

        return "transaction";
    }

    @RequestMapping(value = "/failss")
    public String showFail() {
        return "fail";
    }

    ////
    @RequestMapping(value = "/sell")
    public String showsell() {
        return "sellstocks";
    }

    @RequestMapping(value = "/buy")
    public String showbuy() {
        return "buystocks";
    }

    @RequestMapping(value = "/analyzers")
    public String showIndex() {
        return "analyser";
    }

    @RequestMapping(value = "/log")
    public String showlogin() {
        return "login";
    }

    @RequestMapping(value = "/sign")
    public String sign() {
        return "signIn";
    }

    @RequestMapping(value = "/home")
    public String naviHome() {

        return "home";
    }

    @RequestMapping(value = "/404Error")
    public String naviDash() {

        return "404";
    }

    @RequestMapping(value = "/successlog")
    public String successlog() {
        return "dashboard";
    }

    @RequestMapping(value = "/add")
    public String addPerson(@RequestBody Person person) {
        //  Person p = new Person();
        // p.setName("Obama");
        // p.setAge(60);
        System.out.println("fired......");
        int id = personservice.addPerson(person);

        if (id != 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/get")
    public @ResponseBody
    List<Person> testGet() {

        System.out.println("aaaaaaaaaaaaaaaaa");
        return personservice.getPersons();
    }
    
    
    //////
    
     @RequestMapping(value="/updateTempUserIsPlayByPId")
    public String updateTempUserIsPlayByPId(){
        
        int isPlay=0;
        String pname="vm1";
        tuservice.updateIsPlayByPId(isPlay,pname);
        return "success";
    }
    
    

}
