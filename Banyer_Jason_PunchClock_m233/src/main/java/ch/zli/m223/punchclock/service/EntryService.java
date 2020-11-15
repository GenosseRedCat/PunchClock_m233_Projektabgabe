package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/***
 * This class was not created, but modified by Jason Banyer
 * Date: 05.11.2020
 *
 * Description of this class:
 * This class is the one, which is responsible for creating the entry Repository and making it publicly available.
 * Additionally this class does the part of modifying the entries in the entry Repository.
 *
 * It is designated as a "Service", so Spring knows, that it has to create an instance of this.
 * To be precise: Spring learns that this is a company application, which may only be instated once. (Singleton pattern)
 */

@Service
public class EntryService {
    private EntryRepository entryRepository;

    //Makes the Entryrepository public.
    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    //Creates new Entry
    public Entry createEntry(Entry entry) {
        return entryRepository.saveAndFlush(entry);
    }

    //Finds the List of Entries and returns it.
    public List<Entry> findAll() {
        return entryRepository.findAll();
    }


    //Should delete Entry, however doesn't check if it exists. May crash.
    public void deleteEntry(Long id) {
        entryRepository.deleteById(id);
    }

    //Overwrites the pre-existing by actually deleting it and making a new one
    public void updateEntry(Long id, Entry entry) {
        if(entryRepository.equals(id)){
            entryRepository.deleteById(id);

            entryRepository.saveAndFlush(entry);
        }
    }

}






