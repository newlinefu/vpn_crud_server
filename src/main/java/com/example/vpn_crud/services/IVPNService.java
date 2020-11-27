package com.example.vpn_crud.services;


import com.example.vpn_crud.model.VPN;

import java.sql.Date;
import java.util.List;

public interface IVPNService {

    List<VPN> findAll();

    VPN findById(Long id);

    boolean deleteById(Long id);

    void put(String title, String server, String pass, Date date);

    boolean update(Long id, String title, String server, String pass, Date date);

}
