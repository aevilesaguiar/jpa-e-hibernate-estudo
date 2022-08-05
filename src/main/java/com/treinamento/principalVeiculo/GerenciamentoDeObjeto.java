package com.treinamento.principalVeiculo;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;

public class GerenciamentoDeObjeto {
    public static void main(String[] args) {

        EntityManager manager = JPAUtil.getEntityManager();

        Veiculo veiculo1 = manager.find(Veiculo.class, 2L);
        System.out.println("Buscou veiculo pela primeira vez...");

        System.out.println("Gerenciado? " + manager.contains(veiculo1));
        manager.detach(veiculo1);
        System.out.println("E agora? " + manager.contains(veiculo1));

        Veiculo veiculo2 = manager.find(Veiculo.class, 2L);
        System.out.println("Buscou veiculo pela segunda vez...");

        System.out.println("Mesmo veículo? " + (veiculo1 == veiculo2));


        manager.close();
        JPAUtil.close();
    }
}
