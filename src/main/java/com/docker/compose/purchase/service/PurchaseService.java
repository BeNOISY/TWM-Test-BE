package com.docker.compose.purchase.service;

import com.docker.compose.EmailSenderService;
import com.docker.compose.exception.ResourceNotFoundException;
import com.docker.compose.purchase.persistance.entity.Purchase;
import com.docker.compose.purchase.persistance.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.util.Optional;
import java.util.List;
@Service
public class PurchaseService {

    @Autowired
    private EmailSenderService emailService;

    public PurchaseService(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    @Autowired
    private final PurchaseRepository purchaseRepository;

    public Purchase createPurchase(Purchase purchase){
        String recipientEmail = "dian.pato66@gmail.com";
        String subject = "Hello from Spring Boot";
        String templateName = "email-template";

        Context context = new Context();
        // Add any necessary variables to the context

        emailService.sendEmail(recipientEmail, subject, templateName, context);
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases(){
        return purchaseRepository.findAll();
    }

    public Purchase getPurchaseById(String id){
        Optional<Purchase> cartById = this.purchaseRepository.findById(id);

        if(cartById.isPresent()){
            return cartById.get();
        }
        else{
            throw new ResourceNotFoundException("Cart with id: " + id + " does not exits");
        }
    }

    public List<Purchase> getPurchaseByEmail(String email){
        Optional< List<Purchase>> purchasesByUser = Optional.ofNullable(this.purchaseRepository.findPurchasesByEmail(email));

        if(purchasesByUser.isEmpty()){
            throw new ResourceNotFoundException("User doesn't exist or does not have any purchases");
        }else{
            return purchasesByUser.get();
        }
    }

    public Purchase updatePurchase(Purchase purchase){
        Optional<Purchase> purchaseById = this.purchaseRepository.findById(purchase.getId());

        if (purchaseById.isPresent()){
            Purchase purchaseUpdate = purchaseById.get();

            purchaseUpdate.setId(purchase.getId());
            purchaseUpdate.setEmail(purchase.getEmail());
            purchaseUpdate.setTime(purchase.getTime());
            purchaseUpdate.setProducts(purchase.getProducts());
            purchaseUpdate.setFinalPrice(purchase.getFinalPrice());

            purchaseRepository.save(purchaseUpdate);
            return purchaseUpdate;
        }
        else
        {
            throw new ResourceNotFoundException("Purchase by id: " + purchase.getId() + " does not exits");
        }
    }

    public void deletePurchase(String id){
        Optional<Purchase> purchaseById = this.purchaseRepository.findById(id);

        if(purchaseById.isPresent()){
            purchaseRepository.delete(purchaseById.get());
        }
        else
        {
            throw new ResourceNotFoundException("Purchase with id: " + id + " does not exist");
        }
    }

    public void deleteAllPurchase(){
        this.purchaseRepository.deleteAll();
    }
}
