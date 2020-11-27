package com.example.vpn_crud.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "vpns")
public class VPN {

    @Id
    @Column(name = "vpn_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long vpnId;

    @Column(name = "vpn_title")
    private String vpnTitle;

    @Column(name = "vpn_server")
    private String vpnServer;

    @Column(name = "vpn_password")
    private String vpnPassword;

    @Column(name = "vnp_expiration_date")
    private Date vnpExpirationDate;

    public VPN(){}

    public VPN(String title, String server, String password, Date exp_date) {
        vpnTitle = title;
        vpnServer = server;
        vpnPassword = password;
        vnpExpirationDate = exp_date;
    }

    public Long getVpnId() {
        return vpnId;
    }
    public void setVpnId(Long newId) {
        vpnId = newId;
    }

    public String getVpnTitle() {
        return vpnTitle;
    }
    public void setVpnTitle(String newTitle) {
        vpnTitle = newTitle;
    }

    public String getVpnServer() {
        return vpnServer;
    }
    public void setVpnServer(String newServer) {
        vpnServer = newServer;
    }

    public String getVpnPassword() {
        return vpnPassword;
    }
    public void setVpnPassword(String newPassword) {
        vpnPassword = newPassword;
    }

    public Date getVpnExpDate() {
        return vnpExpirationDate;
    }
    public void setExpDate(Date newExpDate) {
        vnpExpirationDate = newExpDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VPN vpn = (VPN) o;
        return vpnId.equals(vpn.vpnId) &&
                vpnTitle.equals(vpn.vpnTitle) &&
                vpnServer.equals(vpn.vpnServer) &&
                Objects.equals(vpnPassword, vpn.vpnPassword) &&
                vnpExpirationDate.equals(vpn.vnpExpirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vpnId, vpnTitle, vpnServer, vpnPassword, vnpExpirationDate);
    }


    @Override
    public String toString() {
        return "VPN{" +
                "vpn_id=" + vpnId +
                ", vpn_title='" + vpnTitle + '\'' +
                ", vpn_server='" + vpnServer + '\'' +
                ", vpn_password='" + vpnPassword + '\'' +
                ", vnp_expiration_date=" + vnpExpirationDate +
                '}';
    }
}
