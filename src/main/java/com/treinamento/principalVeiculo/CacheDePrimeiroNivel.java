package com.treinamento.principalVeiculo;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;

public class CacheDePrimeiroNivel {
    public static void main(String[] args) {
        /**
         * Se uma entidade é pesquisada, mas ela já existe no contexto de persistência,
         * o objeto existente é retornado, sem acessar o banco de dados. Esse recurso é
         * chamado de cache de primeiro nível.
         * */

        EntityManager manager = JPAUtil.getEntityManager();

        Veiculo veiculo1 = manager.find(Veiculo.class, 2L);
        System.out.println("Buscou veiculo pela primeira vez...");

        Veiculo veiculo2 = manager.find(Veiculo.class, 2L);
        System.out.println("Buscou veiculo pela segunda vez...");

        System.out.println("Mesmo veículo? " + (veiculo1 == veiculo2));

        manager.close();
        JPAUtil.close();
    }
}
