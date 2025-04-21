package com.proyecto.EasyIT.Dao;

import com.proyecto.EasyIT.Model.TipoTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface TipoTicketDAO extends JpaRepository<TipoTicket,Long> {

    @Procedure(name = "TipoTicket.getAllTipoTickets")
    List<TipoTicket> getAllTipoTickets();
}
