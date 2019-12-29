/* Interface Message Crud Service.
 * @author Colin Cerveaux @C-ambium
 * Genericity of crud service.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.dta.ovg.entities.Message;
import fr.dta.ovg.exceptions.NotFoundException;

/** Message CRUD Service Interface.*/
public interface MessageCrudService {

    /** Get all Message entity.<br>
     * Must be redefined in implemented class.<br>
     * @param pageable : @see Pageable.
     * @param userId : User Id notification.
     * @return List of all Messages.*/
    Page<Message> getAll(Pageable pageable, Long userId);

    /** Get one Message entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id : message id.
     * @return Message : entity.
     * @throws NotFoundException : Message not found.*/
    Message getOne(long id) throws NotFoundException;

    /** Create one Message entity.<br>
     * Must be redefined in implemented class.<br>
     * @param message : @see Message.
     * @return Created Message : entity.*/
    Message create(Message message);

    /** Delete one Message entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id : message id to process delete.
     * @throws NotFoundException : Message not found.*/
    void delete(long id) throws NotFoundException;
}
