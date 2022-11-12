package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

@Service //iş katmanı
public class ProductManager implements ProductService{
	
	private ProductDao  productDao; //sahte geçiçi bir nesne oluşturduk
    
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
	
		return  new SuccessDataResult<List<Product>>
		       (this.productDao.findAll(),"Data Listelendi");
	}

	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("ürün eklendi");
	}

}
