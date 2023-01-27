package github.com.jailcomfranssa.service;

import github.com.jailcomfranssa.model.entities.Pedido;

public class NotaFiscalService {

    public void gerar(Pedido pedido){
        System.out.println("Gerando nota para o pedido: " + pedido.getId() + " .");
    }
}
