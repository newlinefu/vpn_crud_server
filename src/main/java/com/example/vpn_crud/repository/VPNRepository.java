package com.example.vpn_crud.repository;

import com.example.vpn_crud.model.VPN;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VPNRepository extends CrudRepository<VPN, Long> {

}
