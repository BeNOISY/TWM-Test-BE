package com.docker.compose.purchase.contoller;

import com.docker.compose.purchase.persistance.entity.Purchase;
import com.docker.compose.purchase.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PurchaseController {

    @Autowired
    private final PurchaseService purchaseService;

    @GetMapping("/purchase")
    public ResponseEntity<List<Purchase>> getAllPurchases(){
        return ResponseEntity.ok().body(purchaseService.getAllPurchases());
    }

    @GetMapping("purchase/{id}")
    public ResponseEntity <Purchase> getPurchaseById(@PathVariable String id){
        return ResponseEntity.ok().body(purchaseService.getPurchaseById(id));
    }

    @GetMapping("purchase/user/{id}")
    public ResponseEntity <List<Purchase>> getPurchaseByUserID(@PathVariable String userId){
        return ResponseEntity.ok().body(purchaseService.getCartsByUserId(userId));
    }

    @PostMapping("/purchase")
    public ResponseEntity <Purchase> createPurchase(@RequestBody Purchase purchase){
        return ResponseEntity.ok().body(purchaseService.createPurchase(purchase));
    }

    @PutMapping("/purchase/{id}")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable String id, @RequestBody Purchase purchase){
        purchase.setId(id);
        return  ResponseEntity.ok().body(purchaseService.updatePurchase(purchase));
    }

    @DeleteMapping("/purchase/{id}")
    public HttpStatus deletePurchase(@PathVariable String id){
        this.purchaseService.deletePurchase(id);
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping("/purchase")
    public HttpStatus deleteAllPurchases(){
        this.purchaseService.deleteAllPurchase();
        return HttpStatus.OK;
    }

}



