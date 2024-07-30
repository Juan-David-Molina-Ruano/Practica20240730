package com.test.Practica20240730JDMR.Servicios.Interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.test.Practica20240730JDMR.Modelos.ProductoJDMR;

import java.util.List;
import java.util.Optional;

public interface IProductoJDMRService {
    Page<ProductoJDMR> buscarTodosPaginados(Pageable pageable);

    List<ProductoJDMR> obtenerTodos();

    Optional<ProductoJDMR> buscarPorId(Long id);

    ProductoJDMR crearOEditar(ProductoJDMR productoJDMR);

    void eliminarPorId(Long id);
}
