package ch.zli.m223.punchclock.controller;


/***
 * This class was created by Jason Banyer
 * Date: 10.11.2020
 *
 * Description of this class:
 * The purpouse of this class is only to define and return information about the User.
 *
 */
public class Benutzer {

    private final Integer benutzerId;
    private final String benutzerName;

    public Benutzer(Integer benutzerId, String benutzerName){
        this.benutzerId = benutzerId;
        this.benutzerName = benutzerName;
    }

    public Integer getBenutzerId() {
        return benutzerId;
    }

    public String getBenutzerName() {
        return benutzerName;
    }

    @Override
    public String toString(){
        return "Benutzer{" +
                "benutzerId=" + benutzerId + ", benutzerName" +  benutzerName + '\'' + "}";
    }
}
