package com.proyecto.EasyIT.Service.Impl;

import com.proyecto.EasyIT.Dao.LogTicketDAO;
import com.proyecto.EasyIT.Model.LogTicket;
import com.proyecto.EasyIT.Service.LogTicketService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogTicketServiceImpl implements LogTicketService {

    @Autowired
    private LogTicketDAO logTicketDAO;

    @Override
    @Transactional
    public List<LogTicket> obtenerLogTickets() {
        return logTicketDAO.getAllLog();
    }
}
