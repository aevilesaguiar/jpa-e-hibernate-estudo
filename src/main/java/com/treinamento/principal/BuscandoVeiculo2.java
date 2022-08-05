package com.treinamento.principal;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;

public class BuscandoVeiculo2 {
    public static void main(String[] args) {

        EntityManager manager= JPAUtil.getEntityManager();

        Veiculo veiculo= manager.getReference(Veiculo.class,4L);
        System.out.println("Veiculo de Código "+veiculo.getCodigo()+" é um "+veiculo.getModelo());


        manager.close();
        JPAUtil.close();

    }
}
