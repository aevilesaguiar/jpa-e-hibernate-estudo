package com.treinamento.principal;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ListandoVeiculos {
    public static void main(String[] args) {

        EntityManager manager= JPAUtil.getEntityManager();

        Query query = manager.createQuery("from Veiculo");
        List<Veiculo>veiculos=query.getResultList();

        for (Veiculo veiculo:veiculos
             ) {
            System.out.println(veiculo.getCodigo()+"-"
            +veiculo.getFabricante()+", ano"
            + veiculo.getAnoFabricacao()+"/"
            + veiculo.getAnoModelo()+" por "
            +"R$"+ veiculo.getValor());

        }

        manager.close();
        JPAUtil.close();

    }
}
