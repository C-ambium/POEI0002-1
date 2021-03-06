/* UserFriend Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */package fr.dta.ovg.fixtures;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.contracts.FixturesContract;
import fr.dta.ovg.entities.User;
import fr.dta.ovg.entities.UserFriend;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.UserFriendRepository;
import fr.dta.ovg.services.UserCrudService;
import fr.dta.ovg.services.UserFriendCrudService;

/** This class initialize DB with initials fixtures data. */
@Component
@Profile("!prod")
public class UserFriendFixtureService extends FixtureCheck<UserFriendRepository> {

    /** Link to entity repository. */
    private final UserFriendCrudService friendService;

    /** Link to User Service. */
    private final UserCrudService userService;

    /** Local Constructor.
     * Link to UserFriend Repository by UserFriendCrudService.
     * @param friendService : @see UserFriendCrudService.
     * @param userService : @see UserCrudService.*/
    public UserFriendFixtureService(
            @Autowired final UserFriendCrudService friendService,
            @Autowired final UserCrudService userService) {
        this.friendService = friendService;
        this.userService = userService;
    }

    /** Fixtures are loaded only if no data.
     * @throws NotFoundException : entity not found.*/
    @Override
    public void loadIfNoData() throws NotFoundException {
        this.loadFriend();
    }

    /** Load Friends fixture function.
     * @throws NotFoundException : Entity User not found.*/
    private void loadFriend() throws NotFoundException {

        final Random rand = new Random();

        for (int i = 1; i < FixturesContract.NB_USERS; i++) {

            this.build(rand.nextBoolean(), userService.getOne(i), userService.getOne(i + 1));

            this.build(
                    rand.nextBoolean(),
                    userService.getOne(rand.nextInt(FixturesContract.NB_RAND) + 1),
                    userService.getOne(rand.nextInt(FixturesContract.NB_RAND) + 1));
        }

        for (int i = 1; i < FixturesContract.NB_REAL; i++) {

            this.build(rand.nextBoolean(), userService.getOne(i), userService.getOne(FixturesContract.US_FRIENDS_1));
            this.build(rand.nextBoolean(), userService.getOne(i), userService.getOne(FixturesContract.US_FRIENDS_2));
            this.build(rand.nextBoolean(), userService.getOne(i), userService.getOne(FixturesContract.US_FRIENDS_3));
            this.build(rand.nextBoolean(), userService.getOne(i), userService.getOne(FixturesContract.US_FRIENDS_4));
        }
    }

    /** UserFriend Builder.
     * @param valid : validation parameter.
     * @param friendAccept : (User) friend accepted.
     * @param friendRequest : (User) friend request.*/
    private void build(final boolean valid, final User friendAccept, final User friendRequest) {

        UserFriend userFriend = new UserFriend();

        userFriend.setValid(valid);
        userFriend.setFriendAccept(friendAccept);
        userFriend.setFriendRequest(friendRequest);

        friendService.create(userFriend);
    }

}
