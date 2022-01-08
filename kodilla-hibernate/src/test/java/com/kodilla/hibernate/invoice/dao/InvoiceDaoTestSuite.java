package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;

    private static final int PRICE = 120;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("162538");

        Product product1 = new Product("Product 1");

        Item item1 = new Item(new BigDecimal(PRICE), 2);
        Item item2 = new Item(new BigDecimal(PRICE), 4);
        Item item3 = new Item(new BigDecimal(PRICE), 1);

        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product1);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        product1.getItems().add(item1);
        product1.getItems().add(item2);
        product1.getItems().add(item3);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        //When
        invoiceDao.save(invoice);
        int invoice1Id = invoice.getId();

        productDao.save(product1);
        int product1Id = product1.getId();

        itemDao.save(item1);
        int item1Id = item1.getId();
        itemDao.save(item2);
        int item2Id = item2.getId();
        itemDao.save(item3);
        int item3Id = item3.getId();

        //Then
        assertNotEquals(0, invoice1Id);
        assertNotEquals(0, product1Id);
        assertNotEquals(0, item1Id);
        assertNotEquals(0, item2Id);
        assertNotEquals(0, item3Id);

        //CleanUp
        itemDao.deleteById(item1Id);
        itemDao.deleteById(item2Id);
        itemDao.deleteById(item3Id);
        productDao.deleteById(product1Id);
        invoiceDao.deleteById(invoice1Id);
    }
}
