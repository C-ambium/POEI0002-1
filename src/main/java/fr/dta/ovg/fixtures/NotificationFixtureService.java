package fr.dta.ovg.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.entities.Notification;
import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.NotificationRepository;
import fr.dta.ovg.services.UserCrudService;
import fr.dta.ovg.services.notification.NotificationCrudService;

/** This class initialize DB with initials fixtures data. */
@Component
@Profile("!prod")
public class NotificationFixtureService extends FixtureCheck<NotificationRepository> {

    private final NotificationCrudService notificationService;

    private final UserCrudService userService;


    public NotificationFixtureService(
            @Autowired  final NotificationCrudService notificationService,
            @Autowired final UserCrudService userService) {
        this.notificationService = notificationService;
        this.userService = userService;
    }

    @Override
    protected void loadIfNoData() throws NotFoundException {

        this.build("Nouveau message de Pamwamba.",      userService.getOne(3));
        this.build("Nouveau message de C-ambium.",      userService.getOne(1));
        this.build("Nouveau message de ListerKred.",    userService.getOne(2));

        for (int i = 1; i < 4; i++) {
            this.build("Paul à accepté votre demande d'ami.",           userService.getOne(i));
            this.build("Jacques vous a envoyé une demande d'ami.",      userService.getOne(i));
            this.build("Votre demande d'inscritption à été validée.",   userService.getOne(i));
            this.build("Nouveau message de Paul.",                      userService.getOne(i));
            this.build("Nouvel évent à proximité",                      userService.getOne(i));
        }
    }

    private void build(final String label, final User user) {

        final Notification notification = new Notification();

        notification.setLabel(label);
        notification.setUser(user);

        notificationService.create(notification);
    }

}