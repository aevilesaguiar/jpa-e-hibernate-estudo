package com.treinamento.principal;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AtualizandoVeiculos {

    public static void main(String[] args) {

        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx= manager.getTransaction();
        tx.begin();//inicia uma transação com o BD

        Veiculo veiculo=manager.find(Veiculo.class,1L);//método find() busca o objeto imediatamente no BD


        System.out.println("Valor Atual: "+veiculo.getValor());
        veiculo.setValor( 500.00);// veiculo.setValor(veiculo.getValor().add(500.00));
        System.out.println("Novo Valor: "+veiculo.getValor());

        tx.commit();
        manager.close();
        JPAUtil.close();
    }
}
