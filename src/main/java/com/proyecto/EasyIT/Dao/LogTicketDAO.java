package com.proyecto.EasyIT.Dao;

import com.proyecto.EasyIT.Model.LogTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface LogTicketDAO extends JpaRepository<LogTicket,Long> {
    @Procedure(name = "LogTicket.getAllLog")
    List<LogTicket> getAllLog();
}
