package com.test.Practica20240730JDMR.Servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.test.Practica20240730JDMR.Modelos.ProductoJDMR;
import com.test.Practica20240730JDMR.Repositorios.IProductoRepository;
import com.test.Practica20240730JDMR.Servicios.Interfaces.IProductoJDMRService;

@Service
public class ProductoJDMRService implements IProductoJDMRService {
    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public Page<ProductoJDMR> buscarTodosPaginados(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    @Override
    public List<ProductoJDMR> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<ProductoJDMR> buscarPorId(Long id) {
        return productoRepository.findById(id.intValue());
    }

    @Override
    public ProductoJDMR crearOEditar(ProductoJDMR productoJDMR) {
        return productoRepository.save(productoJDMR);
    }

    @Override
    public void eliminarPorId(Long id) {
        productoRepository.deleteById(id.intValue());
    }
}
