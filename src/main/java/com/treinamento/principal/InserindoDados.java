package com.treinamento.principal;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class InserindoDados {
    public static void main(String[] args) {

        EntityManager manager= JPAUtil.getEntityManager();
        EntityTransaction tx= manager.getTransaction();

        //quando o JPA faz alguma operação que não é uma simples leitura do BD ele precisa de uma transação
        tx.begin();//inicia uma transação com o BD


        //persistir objetos(inserir registros no Bancod e dados)
        Veiculo veiculo= new Veiculo("Honda","Civic",2012,2013,90000.00);
        Veiculo veiculo1= new Veiculo("Corsa ","Sedan",2022,2022,110000.00);
        Veiculo veiculo2= new Veiculo("VW","Gol",2019,2019,70000.00);

        manager.persist(veiculo);
        manager.persist(veiculo1);
        manager.persist(veiculo2);

        tx.commit();


        manager.close();
        JPAUtil.close();

    }
}
