package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * This class was not created, but modified by Jason Banyer
 * Date: 10.11.2020
 *
 * Description of this class:
 * This class declares what exactly happens, when /entries is met with an access.
 * Once one of these Mapping-Methods are called, the entryService is used to modify the list of PunchClock entries.
 *
 */

@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping //Gets Entries
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries() {
        return entryService.findAll();
    }

    //Creates new Entry
    @PostMapping //Posts new Entry
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody Entry entry) {
        return entryService.createEntry(entry);
    }

    //Deletes Pre-Existing entries via ID.
    //@RequestMapping(method = RequestMethod.DELETE, value="/entries/{id}")
    @DeleteMapping("/entries/delete/{id}")
    @ResponseBody
    public void deleteEntry(@PathVariable Long id) {
        entryService.deleteEntry(id);
    }


    @PutMapping("/entries/update/{id}")
    @ResponseBody
    public void updateEntry(@PathVariable Long id, @Valid @RequestBody Entry entry) {
        entryService.updateEntry(id, entry);
    }

}

