package com.treinamento.principal;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ExcluindoVeiculo {
    public static void main(String[] args) {

        EntityManager manager= JPAUtil.getEntityManager();
        EntityTransaction txs= manager.getTransaction();
        txs.begin();

        Veiculo veiculo=manager.find(Veiculo.class,1L);

        manager.remove(veiculo);

        txs.commit();
        manager.close();
        JPAUtil.close();

    }
}
