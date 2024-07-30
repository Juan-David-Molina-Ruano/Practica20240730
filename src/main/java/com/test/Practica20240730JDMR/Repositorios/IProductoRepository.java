package com.test.Practica20240730JDMR.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.Practica20240730JDMR.Modelos.ProductoJDMR;

public interface IProductoRepository extends JpaRepository<ProductoJDMR, Integer>   {

}
