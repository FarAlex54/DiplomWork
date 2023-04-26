package com.example.products.models;

import com.example.products.enumm.Provider;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;

@Entity(name = "product_site")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Наименование товара обязательно")
    @Column(name = "name", length = 30, nullable = false, columnDefinition = "text",unique = true)
    private String name;

    @Min(value = 1, message = "Цена товара не менее 1руб.")
    @Column(name = "price", length = 20, nullable = false, columnDefinition = "int")
    private int price;

    @Min(value = 1, message = "Вес не менее 1гр.")
    @Column(name = "weight", length = 20, nullable = false, columnDefinition = "int")
    private int weight;
    //@NotEmpty(message = "Обязательно указать поставщика")
    @Column(name = "provider", length = 30, nullable = false, columnDefinition = "text")
    private Provider provider;
    @NotEmpty(message = "Телефон грузчика обязателен к заполнению")
    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$", message = "Номер телефона должен соответствовать маске +7/7/80000000000")
    @Column(name = "phoneRespons", length = 12, nullable = false, columnDefinition = "text")
    private String phoneRespons;
    @NotEmpty(message = "E-mail для формирования заявок обязателен к заполнению")
    @Email(message = "Некорректный e-mail")
    @Column(name = "emailRespons", length = 40, nullable = false, columnDefinition = "text")
    private String emailRespons;

    public Product(int id, String name, int price, int weight, Provider provider, String phoneRespons, String emailRespons) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.provider = provider;
        this.phoneRespons = phoneRespons;
        this.emailRespons = emailRespons;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getPhoneRespons() {
        return phoneRespons;
    }

    public void setPhoneRespons(String phoneRespons) {
        this.phoneRespons = phoneRespons;
    }

    public String getEmailRespons() {
        return emailRespons;
    }

    public void setEmailRespons(String emailRespons) {
        this.emailRespons = emailRespons;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", provider=" + provider +
                ", phoneRespons='" + phoneRespons + '\'' +
                ", emailRespons='" + emailRespons + '\'' +
                '}';
    }
}
