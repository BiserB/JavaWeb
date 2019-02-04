package chushka.services;

import chushka.entities.Product;
import chushka.models.binding.ProductBindingModel;
import chushka.models.view.ProductFullViewModel;
import chushka.models.view.ProductLinkViewModel;
import chushka.repositories.ProductRepository;
import chushka.utils.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    @Inject
    public ProductService(ProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public void save(ProductBindingModel productModel) {

        Product product = mapper.map(productModel, Product.class);

        chushka.entities.enums.Type productType = chushka.entities.enums.Type.valueOf(productModel.getType().toUpperCase());

        product.setType(productType);

        this.productRepository.save(product);
    }

    public List<ProductFullViewModel> getAll() {

        List<Product> products = productRepository.findAll();

        Type listType = new TypeToken<List<ProductFullViewModel>>() {}.getType();

        List<ProductFullViewModel> models = mapper.map(products, listType);

        return  models;
    }

    public ProductFullViewModel getById(String id) {

        Product product = productRepository.getById(id);

        ProductFullViewModel model = mapper.map(product, ProductFullViewModel.class);

        return  model;
    }

    public List<ProductLinkViewModel> getProductLinkViewModels() {

        List<ProductFullViewModel> models = getAll();

        List<ProductLinkViewModel> names = models
                .stream()
                .map(mod -> mapper.map(mod, ProductLinkViewModel.class))
                .collect(Collectors.toList());

        return  names;
    }
}
