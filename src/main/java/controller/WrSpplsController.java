package controller;

import model.WrSppls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.WrSpplsService;

import java.util.List;

@RestController
public class WrSpplsController {
    private final WrSpplsService wrSpplsService;

    @Autowired
    public WrSpplsController(WrSpplsService wrSpplsService) {
        this.wrSpplsService = wrSpplsService;
    }
    @PostMapping(value = "/writing supplies")
    public ResponseEntity<?> create(@RequestBody WrSppls wrSppls) {
        wrSpplsService.create(wrSppls);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/writing_supplies")
    public ResponseEntity<List<WrSppls>> read() {
        final List<WrSppls> writing_supplies = wrSpplsService.readAll();

        return writing_supplies != null &&  !writing_supplies.isEmpty()
                ? new ResponseEntity<>(writing_supplies, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/writing_supplies/{id}")
    public ResponseEntity<WrSppls> read(@PathVariable(name = "id") int id) {
        final WrSppls wrSppls = wrSpplsService.read(id);

        return wrSppls != null
                ? new ResponseEntity<>(wrSppls, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/writing_supplies/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody WrSppls wrSppls) {
        final boolean updated = wrSpplsService.update(wrSppls, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/writing_supplies/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = wrSpplsService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}


