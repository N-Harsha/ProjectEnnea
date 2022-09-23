package com.valuemedi.projectenna.Service;

import com.valuemedi.projectenna.Repositories.InventoryRepository;
import com.valuemedi.projectenna.Repositories.ProductRepository;
import com.valuemedi.projectenna.Repositories.SupplierRepository;
import com.valuemedi.projectenna.domain.CsvHelper;
import com.valuemedi.projectenna.domain.Inventory;
import com.valuemedi.projectenna.domain.Product;
import com.valuemedi.projectenna.domain.Supplier;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CSVServiceImpl implements CSVService {

    SupplierRepository supplierRepository;
    ProductRepository productRepository;
    InventoryRepository inventoryRepository;

    public CSVServiceImpl(SupplierRepository supplierRepository, ProductRepository productRepository, InventoryRepository inventoryRepository) {
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public String Save(MultipartFile file) {
        try{
            InputStream is=file.getInputStream();
            BufferedReader fileReader= new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            CSVParser csvParser=new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            List<CSVRecord> csvRecords= csvParser.getRecords();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            List<Product> productList = productRepository.findAll();
            Map<String,Product> productMap = new HashMap<>();
//            List<Supplier> supplierList = supplierRepository.findAll();
            Map<String,Supplier> supplierMap = new HashMap<>();

//            for(Supplier i: supplierList){
//                supplierMap.put(i.getName(),i);
//            }
//
//            for(Product i: productList){
//                productMap.put(i.getCode(),i);
//            }

            for(CSVRecord csvRecord:csvRecords){
                if(csvRecord.get(CsvHelper.HEADERs[10]).equals(""))
                    continue;
                Product product;
                Supplier supplier;
                Inventory inventory;

//                Optional<Product> optionalProduct = productRepository.findByCode(csvRecord.get(CsvHelper.HEADERs[0]));
                if(productMap.containsKey(csvRecord.get(CsvHelper.HEADERs[0]))){
                    product=productMap.get(csvRecord.get(CsvHelper.HEADERs[0]));
                }
                else{
                    product=new Product();
                    product.setCode(csvRecord.get(CsvHelper.HEADERs[0]));
                    product.setName(csvRecord.get(CsvHelper.HEADERs[1]));
                    product.setCompany(csvRecord.get(CsvHelper.HEADERs[9]));
                    product=productRepository.save(product);
                    productMap.put(product.getCode(),product);
                }

//                Optional<Supplier> optionalSupplier = supplierRepository.findByName(csvRecord.get(CsvHelper.HEADERs[10]));
                if(supplierMap.containsKey(csvRecord.get(CsvHelper.HEADERs[10]))){
                    supplier=supplierMap.get(csvRecord.get(CsvHelper.HEADERs[10]));
                }
                else{
                    supplier=new Supplier();
                    supplier.setName(csvRecord.get(CsvHelper.HEADERs[10]));
                    supplierMap.put(supplier.getName(), supplier);
                }
                inventory=new Inventory();
                inventory.setFree(Integer.parseInt(csvRecord.get(CsvHelper.HEADERs[5])));
                inventory.setBatch(csvRecord.get(CsvHelper.HEADERs[2]));
                inventory.setStock(Integer.parseInt(csvRecord.get(CsvHelper.HEADERs[3])));
                inventory.setDeal(Integer.parseInt(csvRecord.get(CsvHelper.HEADERs[4])));
                inventory.setFree(Integer.parseInt(csvRecord.get(CsvHelper.HEADERs[5])));
                inventory.setMrp(Float.parseFloat(csvRecord.get(CsvHelper.HEADERs[6])));
                inventory.setRate(Float.parseFloat(csvRecord.get(CsvHelper.HEADERs[7])));
                try{
                inventory.setExpire(simpleDateFormat.parse(csvRecord.get(CsvHelper.HEADERs[8])));}
                catch (ParseException pe){
                    inventory.setExpire(null);
                }
                inventory.setProduct(product);
                supplier.addInventoryItem(inventory);
                supplierRepository.save(supplier);
            }
        }
        catch(IOException e){
            return "Error Occurred while parsing the file";
        }

        return "added file : "+file.getName()+" Successfully!!!";

    }
}
