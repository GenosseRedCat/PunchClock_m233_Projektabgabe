package ch.zli.m223.punchclock.security;


/***
 * This class was created by Jason Banyer
 * Date: 12.11.2020
 *
 * Description of this class:
 * This Class defines the different permissions a User or Admin may acquire or lose.
 *
 * Additionally these permissions are defined by ENUM Names.
 *
 */
public enum ApplicationBenutzerPermission {
    BENUTZER_READ("benutzer:read"),
    BENUTZER_WRITE("benutzer:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");


    private final String permission;

    ApplicationBenutzerPermission(String permission){
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
