package ch.zli.m223.punchclock.security;

import com.google.common.collect.Sets;
import java.util.Set;


/***
 * This class was created by Jason Banyer
 * Date: 12.11.2020
 *
 * Description of this class:
 * This important class defines what permission a User has and what an Admin has.
 *
 * In other words: The Administrator and User become meaningful here and rise up to become more, than just a label.
 *
 */
public enum ApplicationBenutzerRole{
    BENUTZER(Sets.newHashSet()),
    ADMINISTRATOR(Sets.newHashSet(ApplicationBenutzerPermission.COURSE_READ, ApplicationBenutzerPermission.COURSE_WRITE, ApplicationBenutzerPermission.BENUTZER_READ, ApplicationBenutzerPermission.BENUTZER_WRITE));

    private final Set<ApplicationBenutzerPermission> permissions;

    ApplicationBenutzerRole(Set<ApplicationBenutzerPermission> permissions){
        this.permissions = permissions;
    }

    public Set<ApplicationBenutzerPermission> getPermissions() {
        return permissions;
    }
}