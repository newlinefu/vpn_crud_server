package com.example.vpn_crud.controller;


import com.example.vpn_crud.model.VPN;
import com.example.vpn_crud.services.IVPNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class VPNController {

    private IVPNService vpnService;

    @Autowired
    public VPNController(IVPNService vpnService) {
        this.vpnService = vpnService;
    }


    @PutMapping(value = "/vpn", produces = "application/json")
    public ResponseEntity<?> create(
            @Valid @RequestBody VPN vpn
    ) {
        vpnService.put(vpn.getVpnTitle(), vpn.getVpnServer(), vpn.getVpnPassword(), vpn.getVpnExpDate());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/vpn")
    public ResponseEntity< List<VPN> > read() {
        List<VPN> clients = vpnService.findAll();
        return clients != null
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/vpn/{id}")
    public ResponseEntity<VPN> read(@PathVariable(name = "id") Long id) {
        VPN client = vpnService.findById(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/vpn/{id}", produces = "application/json")
    public ResponseEntity<?> update(
            @PathVariable(name = "id") Long id,
            @Valid @RequestBody VPN vpn
    ) {
        boolean updated = vpnService.update(
                id,
                vpn.getVpnTitle(),
                vpn.getVpnServer(),
                vpn.getVpnPassword(),
                vpn.getVpnExpDate()
        );

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/vpn/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = vpnService.deleteById(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
