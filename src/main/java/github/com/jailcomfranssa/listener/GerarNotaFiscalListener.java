package github.com.jailcomfranssa.listener;

import github.com.jailcomfranssa.model.entities.Pedido;
import github.com.jailcomfranssa.service.NotaFiscalService;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class GerarNotaFiscalListener {

    private NotaFiscalService notaFiscalService = new NotaFiscalService();

    @PrePersist
    @PreUpdate
    public void gerar(Pedido pedido){
        if(pedido.isPago() && pedido.getNotaFiscal() == null){
            notaFiscalService.gerar(pedido);

        }



    }
}
