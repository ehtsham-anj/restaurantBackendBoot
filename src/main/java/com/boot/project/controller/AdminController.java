package com.boot.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.boot.project.model.Product;
import com.boot.project.model.Reserve;
import com.boot.project.model.StringResponse;
import com.boot.project.model.User;
import com.boot.project.service.ProductService;
import com.boot.project.service.ReserveService;
import com.boot.project.service.TransactionService;
import com.boot.project.service.UserService;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private ReserveService reserveService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TransactionService transactionService;

    @PutMapping("/api/admin/user-update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User existUser = userService.findByUsername(user.getUsername());
        if (existUser != null && !existUser.getId().equals(user.getId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
    }



    //This can be also @DeleteMapping.
    @PostMapping("/api/admin/user-delete")
    public ResponseEntity<?> deleteUser(@RequestBody User user){
        userService.deleteUser(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/api/admin/reserve-update")
    public ResponseEntity<?> updateReserve(@RequestBody Reserve reserve) {
        Reserve existReserve = reserveService.findByEmail(reserve.getEmail());
        if (existReserve != null && !existReserve.getId().equals(reserve.getId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(reserveService.updateReserve(reserve), HttpStatus.CREATED);
    }



   // This can be also @DeleteMapping.
    @PostMapping("/api/admin/reserve-delete")
    public ResponseEntity<?> deleteReserve(@RequestBody Reserve reserve){
        reserveService.deleteReserve(reserve.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/api/admin/reservation-all")
	public Iterable<Reserve> showAllUsers() {
		return reserveService.showAllReservations();
	}
    @GetMapping("api/admin/delete/{email}")
	public Iterable<Reserve> deleteUser(@PathVariable String email){
		return reserveService.deleteUserByEmail(email);
	}

    @GetMapping("/api/admin/user-all")
    public ResponseEntity<?> findAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/user-number")
    public ResponseEntity<?> numberOfUsers(){
        Long number = userService.numberOfUsers();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        //to return it, we will use String Response because long is not a suitable response for rest api
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/api/admin/product-create")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }
//    @GetMapping("api/admin/delete/{email}")
//	public Iterable<Reserve> deleteReserve(@PathVariable String email){
//		return reserveService.deleteUserByEmail(email);
//	}

    @PutMapping("/api/admin/product-update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.CREATED);
    }

    //This can be also @DeleteMapping.
    @PostMapping("/api/admin/product-delete")
    public ResponseEntity<?> deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/product-all")
    public ResponseEntity<?> findAllProducts(){
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/product-number")
    public ResponseEntity<?> numberOfProducts(){
        Long number = productService.numberOfProducts();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/admin/transaction-all")
    public ResponseEntity<?> findAllTransactions(){
        return new ResponseEntity<>(transactionService.findAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("api/admin/transaction-number")
    public ResponseEntity<?> numberOfTransactions(){
        Long number = transactionService.numberOfTransactions();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
