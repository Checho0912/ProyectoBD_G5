package com.proyecto.EasyIT.Service.Impl;

import com.proyecto.EasyIT.Dao.TipoTicketDAO;
import com.proyecto.EasyIT.Model.TipoTicket;
import com.proyecto.EasyIT.Service.TipoTicketService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoTicketServiceImpl implements TipoTicketService {

    @Autowired
    TipoTicketDAO tipoTicketDAO;
    @Override
    @Transactional
    public List<TipoTicket> getTipoTickets() {
        return tipoTicketDAO.getAllTipoTickets();
    }
}
