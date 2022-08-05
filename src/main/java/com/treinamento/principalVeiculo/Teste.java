package com.treinamento.principalVeiculo;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Teste {
    public static void main(String[] args) {

        EntityManager manager= JPAUtil.getEntityManager();
       EntityTransaction tx= manager.getTransaction();

        //quando o JPA faz alguma operação que não é uma simples leitura do BD ele precisa de uma transação
        tx.begin();//inicia uma transação com o BD


        //persistir objetos(inserir registros no Bancod e dados)
        Veiculo veiculo10= new Veiculo("Fiat","Fiorino",2015,2015,50000.00);

        manager.persist(veiculo10);

        tx.commit();
 /*
        Veiculo veiculo =manager.find(Veiculo.class, 1L);

        System.out.println("Veiculo de Código "+ veiculo.getCodigo()+" é um "+veiculo.getModelo()+" ano fabricação "+veiculo.getAnoFabricacao());


        Veiculo veiculo= manager.getReference(Veiculo.class,1L);
        System.out.println("Veiculo de Código "+veiculo.getCodigo()+" é um "+veiculo.getModelo());
*/

        manager.close();
        JPAUtil.close();

    }
}
