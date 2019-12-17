/* Entity Notification class.
 * @author Colin Cerveaux @C-ambium.
 * Define the entity Notification.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "app_notifications")
@ApiModel(value = "Describes a Notification for our system")
public class Notification extends EntityBase {

    @NotBlank
    @Column(name = "notif_label", length = 255, nullable = false, unique = false)
    @ApiModelProperty(value = "The notification to send.")
    private String label;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

    /**
     * Getter label.
     * @return the label (String).
     */
    public String getLabel() {
        return label;
    }

    /** Setter Label.
     * @param label (String) : the label to set
     */
    public void setLabel(final String label) {
        this.label = label;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        if (this.user != user) {
            this.user = user;
            if (user != null) {
                user.addUserNotification(this);
            }
        }
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Event event) {
        if (this.event != event) {
            this.event = event;
            if (event != null) {
                event.addEventNotification(this);
            }
        }
    }

}
