package com.mycompany.invoise.invoiceweb.api;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import com.mycompany.invoise.invoiceweb.form.InvoiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {
    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public Invoice create (@RequestBody Invoice invoice) {
        invoiceService.createInvoice(invoice);
        return invoice;
    }

    @GetMapping
    public List<Invoice> list() {
        System.out.println("La méthode display home a était invoqué");
        return invoiceService.getInvoiceList();
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number) {
        System.out.println("La méthode display invoice a était invoqué");
        return invoiceService.getInvoiceByNumber(number);
    }

    /*@GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
        return "invoice-create-form";
    }*/
}
