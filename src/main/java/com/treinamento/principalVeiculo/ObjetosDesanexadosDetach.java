package com.treinamento.principalVeiculo;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ObjetosDesanexadosDetach {
    public static void main(String[] args) {

        EntityManager manager= JPAUtil.getEntityManager();
        EntityTransaction tx= manager.getTransaction();
        tx.begin();//inicia uma transação com o BD

        Veiculo veiculo=manager.find(Veiculo.class,2L);

        tx.commit();
        manager.close();

        veiculo.setValor(99.00);

        manager=JPAUtil.getEntityManager();
        tx= manager.getTransaction();
        tx.begin();

        // reanexamos o objeto ao novo EntityManager
        veiculo = manager.merge(veiculo);

        tx.commit();
        manager.close();
        JPAUtil.close();



    }
}
