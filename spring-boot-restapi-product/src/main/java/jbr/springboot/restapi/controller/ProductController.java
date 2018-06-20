package jbr.springboot.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jbr.springboot.restapi.model.Product;
import jbr.springboot.restapi.service.ProductService;

/**
 * Product Controller
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @RequestMapping("/products")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @RequestMapping("/products/{id}")
  public Product getProductById(@PathVariable String id) {
    return productService.getProductById(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/products")
  public void addProduct(@RequestBody Product product) {
    productService.addProduct(product);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
  public void updateProduct(@RequestBody Product product, @PathVariable String id) {
    productService.updateProduct(product, id);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
  public void deleteProduct(@PathVariable String id) {
    productService.delete(id);
  }
}
