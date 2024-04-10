package com.formularservice_backend.Controller;

import com.formularservice_backend.Model.Auftrag;
import com.formularservice_backend.Service.AuftragService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auftrag")

public class AuftragController {

    private final AuftragService auftragService;

    @Autowired
    public AuftragController(AuftragService auftragService) {
        this.auftragService = auftragService;
    }

    @PostMapping("/neu")
    public ResponseEntity<Auftrag> createAuftrag(@RequestBody Auftrag auftrag) {
        System.out.println("auftragtermin: "+auftrag.getTermin());
        auftragService.saveAuftrag(auftrag);
        return new ResponseEntity<>(auftrag, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Auftrag>> getAll() {
        List<Auftrag> auftraege = auftragService.getallAuftraege();
        return new ResponseEntity<>(auftraege, HttpStatus.OK);
    }
}
