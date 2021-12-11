import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-show-products',
  templateUrl: './show-products.component.html',
  styleUrls: ['./show-products.component.css']
})
export class ShowProductsComponent implements OnInit {


  products: Observable<Product[]>;

  // inject ProductService and Router on start up
  constructor(private productService: ProductService, private router: Router) { }

  // ngOnInit - is a lifecycle hook and runs after the constructor
  ngOnInit(){
    this.fetchProductList();
  }


  fetchProductList(){
    this.products = this.productService.getProductList();
  }

  deleteProduct(id: number){

    this.productService.deleteProduct(id).subscribe(
      data =>{
        console.log(data);
        this.fetchProductList();
      },
      error => console.log(error)
    )
  }

  productDetails(id: number){
    this.router.navigate(['details', id])
  }

  updateProduct(product: Product){
    this.router.navigate(['update', product])
  }

}
