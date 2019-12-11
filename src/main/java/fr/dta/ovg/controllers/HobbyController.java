/* Hobby Controller Class.
 * @author Colin Cerveaux @C-ambium.
 * Rest Mapping and SpringBoot mapping hobby controller.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.ovg.entities.Hobby;
import fr.dta.ovg.exceptions.BadRequestException;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.services.HobbyCrudService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("api/v1/hobby")
@Api(value = "Hobby Management System", tags = "Hobby")
public class HobbyController {

    /** Link to Hobby CRUD Service. */
    @Autowired
    private HobbyCrudService service;

    /**
     * Get All function. <br>
     * GET - HTTP.
     * @return List of all Hobbies.
     */
    @GetMapping
    public List<Hobby> getAll() {
        return this.service.getAll();
    }

    /**
     * Get One by ID.<br>
     * GET - HTTP
     * @param id : number of the selected hobby.
     * @return Entity Hobby.
     * @throws NotFoundException
     */
    @GetMapping("{id}")
    public Hobby getOne(@PathVariable final Long id) throws NotFoundException {
        return this.service.getOne(id);
    }

    /**
     * Create an Hobby.<br>
     * POST - HTTP.
     * @param Hobby entity.
     * @return the created object Hobby.
     * @throws BadRequestException
     */
    @PostMapping
    public Hobby create(@Valid @RequestBody final Hobby hobby) throws BadRequestException {
        if (this.service.existsByLabel(hobby)) { // delete test
            throw new BadRequestException("uniq_name");
        }

        return this.service.create(hobby);
    }

    /**
     * Delete one by ID. <br>
     * DELETE - HTTP.
     * @param id : number of the selected Hobby.
     * @throws NotFoundException
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) throws NotFoundException {
        this.service.delete(id);
    }
}
