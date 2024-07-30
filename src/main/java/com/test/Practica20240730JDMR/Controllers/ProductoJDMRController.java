package com.test.Practica20240730JDMR.Controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.Practica20240730JDMR.Modelos.ProductoJDMR;
import com.test.Practica20240730JDMR.Servicios.Implementaciones.ProductoJDMRService;

@Controller
@RequestMapping("/")
public class ProductoJDMRController {
    @Autowired
    private ProductoJDMRService productoService;

    @GetMapping("/")
    public String index(Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        PageRequest pageable = PageRequest.of(currentPage - 1, pageSize);

        Page<ProductoJDMR> productos = productoService.buscarTodosPaginados(pageable);
        model.addAttribute("productos", productos);

        if (productos.getTotalPages() > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, productos.getTotalPages())
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "productos/index"; 
    }

    @GetMapping("/create")
    public String create(ProductoJDMR productoJDMR) {
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(ProductoJDMR productoJDMR, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(productoJDMR);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "productos/create";
        }

        productoService.crearOEditar(productoJDMR);
        attributes.addFlashAttribute("msg", "Grupo creado correctamente");
        return "redirect:/";
    }

    /*
     * @GetMapping("/details/{id}")
     * public String details(@PathVariable("id") Integer id, Model model){
     * Grupo grupo = grupoService.buscarPorId(id).get();
     * model.addAttribute("grupo", grupo);
     * return "grupo/details";
     * }
     * 
     * @GetMapping("/edit/{id}")
     * public String edit(@PathVariable("id") Integer id, Model model){
     * Grupo grupo = grupoService.buscarPorId(id).get();
     * model.addAttribute("grupo", grupo);
     * return "grupo/edit";
     * }
     * 
     * @GetMapping("/remove/{id}")
     * public String remove(@PathVariable("id") Integer id, Model model){
     * Grupo grupo = grupoService.buscarPorId(id).get();
     * model.addAttribute("grupo", grupo);
     * return "grupo/delete";
     * }
     * 
     * @PostMapping("/delete")
     * public String delete(Grupo grupo, RedirectAttributes attributes){
     * grupoService.eliminarPorId(grupo.getId());
     * attributes.addFlashAttribute("msg", "Grupo eliminado correctamente");
     * return "redirect:/grupos";
     * }
     */
}
