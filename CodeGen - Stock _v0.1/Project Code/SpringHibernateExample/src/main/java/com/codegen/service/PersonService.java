/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.service;

import com.codegen.model.Person;
import java.util.List;

/**
 *
 * @author Ishara Dikkumbura
 */
public interface PersonService {
    public int addPerson(Person person);
    public List<Person> getPersons();
}
