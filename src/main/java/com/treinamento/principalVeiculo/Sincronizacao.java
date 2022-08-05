package com.treinamento.principalVeiculo;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Sincronizacao {
    public static void main(String[] args) {

        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        Veiculo veiculo = manager.find(Veiculo.class, 2L);

        System.out.println("Valor atual: " + veiculo.getValor());
        veiculo.setValor(1000.00);
        manager.flush();
        System.out.println("Novo valor: "+veiculo.getValor());

        tx.commit();
        manager.close();
        JPAUtil.close();
    }
}
