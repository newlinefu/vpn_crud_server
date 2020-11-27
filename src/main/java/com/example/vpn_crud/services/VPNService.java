package com.example.vpn_crud.services;


import com.example.vpn_crud.model.VPN;
import com.example.vpn_crud.repository.VPNRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VPNService implements IVPNService {

    @Autowired
    private VPNRepository repository;

    @Override
    public List<VPN> findAll() {
        return (List<VPN>) repository.findAll();
    }

    @Override
    public VPN findById(Long id) {
        Optional<VPN> foundedValue = repository.findById(id);
        if(foundedValue.isEmpty())
            return null;
        else
            return foundedValue.get();
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public void put(String title, String server, String pass, Date date) {
        repository.save(new VPN(title, server, pass, date));
    }

    @Override
    public boolean update(Long id, String title, String server, String pass, Date date) {
        Optional<VPN> foundedValue = repository.findById(id);
        if(foundedValue.isEmpty()) {
            System.out.println("VPN is not found");
            return false;
        }
        else {
            VPN foundedVPN = foundedValue.get();
            foundedVPN.setVpnTitle(title);
            foundedVPN.setVpnServer(server);
            foundedVPN.setVpnPassword(pass);
            foundedVPN.setExpDate(date);

            repository.save(foundedVPN);
            return true;
        }
    }
}
