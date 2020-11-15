package ch.zli.m223.punchclock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


/***
 * This class was created by Jason Banyer
 * Date: 08.11.2020
 *
 * Description of this class:
 * This class contains the existing Users, along with their ID.
 * While these Users exist in this list, they do not exist as actual accounts, where one can login.
 *
 */
@RestController
@RequestMapping("/benutzer")
public class BenutzerController {

    private static final List<Benutzer> BENUTZER = Arrays.asList(
            new Benutzer(1, "Thomas"),
            new Benutzer(2, "Stella"),
            new Benutzer(3, "Tobias")
    );
    @GetMapping(path = "/{benutzerId}")
    public Benutzer getBenutzer(@PathVariable("benutzerId") Integer benutzerId){
        return BENUTZER.stream()
                .filter(benutzer -> benutzerId.equals(benutzer.getBenutzerId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Benutzer: " + benutzerId + " existiert nicht"));


    }



}
