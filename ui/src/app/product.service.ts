import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/restful-service'

  // perform dependency injection - request dependencies from external sources rather than creating them
  constructor(private http: HttpClient) { }

  // methods: request to get a product by Id
  getProduct(id: number): Observable<any>{
    return this.http.get(this.baseUrl + '/get_product/' + id);
  }

  // method: request to create a product
  createProduct(product: Object): Observable<Object>{
    return this.http.post(this.baseUrl + '/save_product', product);
  }

  // method: request to update a product
  updateProduct(product: Object): Observable<Object>{
    return this.http.put(this.baseUrl + '/update_product', product);
  }

  // method: request to delete a product
  deleteProduct(id: number): Observable<any>{
    return this.http.delete(this.baseUrl + '/delete_product/' + id);
  }

  // method: request to get list of products
  getProductList(): Observable<any>{
    return this.http.get('http://localhost:8080/restful-service/view_products');
  }


}
