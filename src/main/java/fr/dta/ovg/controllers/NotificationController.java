/* Notification Controller Class.
 * @author Colin Cerveaux @C-ambium.
 * Rest Mapping and SpringBoot mapping notification controller.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.ovg.entities.Notification;
import fr.dta.ovg.exceptions.BadRequestException;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.services.notification.NotificationCrudService;
import io.swagger.annotations.Api;

/** Notification Controller Class.*/
@RestController
@RequestMapping("api/v1/notification")
@Api(value = "Notification Management System", tags = "Notification")
public class NotificationController {

    /** Link to Notification CRUD Service. */
    @Autowired
    private NotificationCrudService service;

    /**
     * Get All function. <br>
     * GET - HTTP.
     * @param page the page number.
     * @param quantity the quantity of return per page.
     * @param userId : User id notifications.
     * @return List of all Notifications.
     */
    @GetMapping
    public Page<Notification> getAll(final int page, final int quantity, final long userId) {

        Pageable pageable = PageRequest.of(page, quantity);

        return this.service.getAll(pageable, userId);
    }

    /**
     * Get One by ID.<br>
     * GET - HTTP
     * @param id : number of the selected Notification.
     * @return Entity Notification.
     * @throws NotFoundException :  Notification entity not found.
     */
    @GetMapping("{id}")
    public  Notification getOne(@PathVariable final Long id) throws NotFoundException {
        return this.service.getOne(id);
    }

    /**
     * Create an Notification.<br>
     * POST - HTTP.
     * @param notification : Notification entity.
     * @return the created object Notification.
     * @throws BadRequestException : Incorrect request (ie Json Body{}).
     */
    @PostMapping
    public  Notification create(@Valid @RequestBody final  Notification  notification) throws BadRequestException {

        return this.service.create(notification);
    }

    /**
     * Delete one by ID. <br>
     * DELETE - HTTP.
     * @param id : number of the selected Notification.
     * @throws NotFoundException : Notification entity not found.
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) throws NotFoundException {
        this.service.delete(id);
    }
}
