package chushka.services;

import chushka.entities.Product;
import chushka.repositories.ProductRepository;
import chushka.utils.ModelMapper;

import javax.inject.Inject;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ModelMapper mapper;

    @Inject
    public ProductServiceImpl(ProductRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void saveProduct(Product product) {
    }
}
