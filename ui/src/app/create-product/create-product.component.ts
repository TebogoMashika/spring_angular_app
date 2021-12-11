import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  constructor(private router: Router, private productService: ProductService) { }

  product: Product = new Product();

  ngOnInit(): void {
  }

  onSubmit(){
    this.saveProduct();
  }

  saveProduct(){
    this.productService.createProduct(this.product)
    .subscribe(data =>{console.log(data), error => console.log(error)}); 

    this.product = new Product;
    this.gotoProductList();
  }

  gotoProductList(){
    this.router.navigate(['/products']);
  }


}
