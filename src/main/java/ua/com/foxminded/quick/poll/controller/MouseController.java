package ua.com.foxminded.quick.poll.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ua.com.foxminded.quick.poll.domain.Mouse;
import ua.com.foxminded.quick.poll.repository.MouseRepository;

import javax.inject.Inject;
import java.net.URI;
import java.util.Optional;

@RestController

public class MouseController {

    final
    MouseRepository mouseRepository;

    public MouseController(MouseRepository mouseRepository) {
        this.mouseRepository = mouseRepository;
    }

    @RequestMapping(value = "/mice", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Mouse>> getAllPolls() {
        Iterable<Mouse> allMice = mouseRepository.findAll();
        return new ResponseEntity<>(mouseRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/mice/{mouseid}", method = RequestMethod.GET)
    public ResponseEntity<?> getMouse(@PathVariable Long mouseid) {
        Optional<Mouse> mouse = mouseRepository.findById(mouseid);
        return new ResponseEntity<>(mouse, HttpStatus.OK);
    }

    @RequestMapping(value = "/mice")
    public ResponseEntity<?> createMouseModel(@ModelAttribute("mouse") Mouse mouse) {
        mouse = mouseRepository.save(mouse);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mouse.getId())
                .toUri();
        responseHeaders.setLocation(newPollURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/mice", method = RequestMethod.POST)
    public ResponseEntity<?> createMouse(@RequestBody Mouse mouse) {
        mouse = mouseRepository.save(mouse);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mouse.getId())
                .toUri();
        responseHeaders.setLocation(newPollURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/mice/{mouseid}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMouse(@RequestBody Mouse mouse, @PathVariable Long mouseid) {
        Mouse m = mouseRepository.save(mouse);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/mice/{mouseid}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMouse(@PathVariable Long mouseid) {
        mouseRepository.deleteById(mouseid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
